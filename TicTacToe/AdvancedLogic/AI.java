package TicTacToe.AdvancedLogic;

import TicTacToe.BasicComponents.Board.Board;
import TicTacToe.BasicComponents.*;
import java.util.*;
public class AI {
    private Player player;
    private Player computer;
    private Turn turn;
    private Difficulty difficulty;
    private Board board;
    private List<Coordinate> allPossibleMove;
    private Figure[][] boardGrid;
    private Map<Coordinate, Integer> move;
    private boolean playerGoesFirst;

    public AI(Difficulty diff, Player player, Player computer, Board board, boolean playerGoesFirst) {
        this.player = player;
        this.computer = computer;
        this.difficulty = diff;
        if (playerGoesFirst) {
            this.turn = Turn.HUMAN;
        } else {
            this.turn = Turn.COMPUTER;
        }
        this.board = board;
        this.boardGrid = this.board.getBoard();
        this.move = new HashMap<Coordinate, Integer>();
        this.allPossibleMove = new ArrayList<Coordinate>();
        this.playerGoesFirst = playerGoesFirst;
        calculatePossibleMoves();
    }

    public AI(Player player, Player computer, Board board, boolean playerGoesFirst, double percent) {
        this(Difficulty.CUSTOM, player, computer, board, playerGoesFirst);
        if (percent < 0 || percent > 1) {
            throw new IllegalArgumentException("difficulty rating must be between 0 and 1");
        }
        this.difficulty.setDiff(percent);
    }

    public Scoordinate evaluateBoard() {
        if (this.board.GameOver()) {
            return null;
        }
        Board testBoard = this.board;
        Iterator iterator = this.allPossibleMove.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getClass() == Scoordinate)
            Coordinate coordinate = (Coordinate)iterator.next();
            computerMoves(coordinate, testBoard);
            testBoard.checkIfGameOver();
            Player winner = testBoard.getWinner();
            if (winner.getTurn() == Turn.COMPUTER) {
                computerMoves(coordinate, this.board);
                return null;
            } else {
                Scoordinate scoordinate = new Scoordinate(coordinate.getX(), coordinate.getY(), Turn.HUMAN);
                iterator.remove();
                this.allPossibleMove.add(scoordinate);
            }
        }
        this.player.changeTurn();
        this.computer.changeTurn();
        if (player.isItMyTurn()) {
            this.turn = Turn.HUMAN;
        } else {
            this.turn = Turn.COMPUTER;
        }
    }
    private void computerMoves(Coordinate coordinate, Board board) {
        if (this.playerGoesFirst) {
            if (this.turn == Turn.COMPUTER) {
                board.secondPlayerMoves(coordinate.getX(), coordinate.getY());
            } else if (this.turn == Turn.HUMAN) {
                board.firstPlayerMoves(coordinate.getX(), coordinate.getY());
            }
        } else {
            if (this.turn == Turn.COMPUTER) {
                board.firstPlayerMoves(coordinate.getX(), coordinate.getY());
            } else if (this.turn == Turn.HUMAN) {
                board.secondPlayerMoves(coordinate.getX(), coordinate.getY());
            }
        }
    }
    private void calculatePossibleMoves() {
        for (int i = 0; i < this.boardGrid.length; i++) {
            for (int j = 0; j < this.boardGrid[0].length; j++) {
                if (this.boardGrid[i][j] == null) {
                    this.allPossibleMove.add(new Coordinate(i, j));
                } else {
                    this.allPossibleMove.remove(new Coordinate(i, j));
                }
            }
        }
    }
}
