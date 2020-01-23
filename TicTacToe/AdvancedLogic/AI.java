package TicTacToe.AdvancedLogic;

import TicTacToe.BasicComponents.Board.Board;
import TicTacToe.BasicComponents.*;

import java.util.*;
public class AI {
    private Player player;
    private Player computer;
    private PlayerType turn;
    private static Difficulty difficulty;
    private Board board;
    private List<Coordinate> allPossibleMove;
    private Figure[][] boardGrid;
    private static boolean playerGoesFirst;

    public AI(Difficulty difficulty, Player player, Player computer, Board board, boolean playerGoesFirst) {
        this.player = player;
        this.computer = computer;
        this.difficulty = difficulty;
        if (playerGoesFirst) {
            this.turn = PlayerType.HUMAN;
        } else {
            this.turn = PlayerType.COMPUTER;
        }
        this.board = board;
        this.boardGrid = this.board.getBoard();
        this.allPossibleMove = new ArrayList<Coordinate>();
        this.playerGoesFirst = playerGoesFirst;
        calculatePossibleMoves();
    }

    public AI(Player player, Player computer, Board board, boolean playerGoesFirst, double percent) {
        this(Difficulty.CUSTOM, player, computer, board, playerGoesFirst);
        if (percent < 0 || percent > 1) {
            throw new IllegalArgumentException("difficulty rating must be between 0 and 1");
        }
        this.difficulty.setDifficulty(percent);
    }

    public PlayerType evaluateMove(Coordinate coordinate) {
        this.calculatePossibleMoves();
        if (this.board.GameOver() || this.allPossibleMove.isEmpty() || !this.allPossibleMove.contains(coordinate)) {
            return PlayerType.BLANK;
        }
        Board testBoard = this.board.clone();
        makeAMove(this.turn, coordinate, testBoard);
        return null;

    }
    private void makeAMove(PlayerType playerWhomMoves, Coordinate coordinate, Board board) {
        if (this.playerGoesFirst) {
            if (this.turn == PlayerType.COMPUTER) {
                board.secondPlayerMoves(coordinate.getX(), coordinate.getY());
            } else if (this.turn == PlayerType.HUMAN) {
                board.firstPlayerMoves(coordinate.getX(), coordinate.getY());
            }
        } else {
            if (this.turn == PlayerType.COMPUTER) {
                board.firstPlayerMoves(coordinate.getX(), coordinate.getY());
            } else if (this.turn == PlayerType.HUMAN) {
                board.secondPlayerMoves(coordinate.getX(), coordinate.getY());
            }
        }
    }
    private void calculatePossibleMoves() {
        for (int i = 0; i < this.boardGrid.length; i++) {
            for (int j = 0; j < this.boardGrid[0].length; j++) {
                if (this.boardGrid[i][j] == null) {
                    if (this.allPossibleMove.contains(new Coordinate(i, j)) || this.allPossibleMove.contains(new Scoordinate(i, j, PlayerType.HUMAN)) || this.allPossibleMove.contains(new Scoordinate(i, j, PlayerType.COMPUTER)) || this.allPossibleMove.contains(new Scoordinate(i, j, PlayerType.BLANK))) {
                        continue;
                    }
                    this.allPossibleMove.add(new Coordinate(i, j));
                } else {
                    this.allPossibleMove.remove(new Coordinate(i, j));
                    this.allPossibleMove.remove(new Scoordinate(i, j, PlayerType.COMPUTER));
                    this.allPossibleMove.remove(new Scoordinate(i, j, PlayerType.HUMAN));
                    this.allPossibleMove.remove(new Scoordinate(i, j, PlayerType.BLANK));
                }
            }
        }
    }
}
