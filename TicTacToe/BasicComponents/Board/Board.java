package TicTacToe.BasicComponents.Board;

import TicTacToe.BasicComponents.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static Figure[][] board;
    private boolean gameOver;
    private Player winner;
    private Player playerOne;
    private Player playerTwo;
    private Symbol firstPlayersymbol;
    private Symbol secondPlayersymbol;
    private boolean firstPlayerHasMoved;
    private boolean secondPlayerHasMoved;
    private boolean firstPlayerMoveSuccessful;
    private boolean secondPlayerMoveSuccessful;
    private Figure[][] allThrees;

    public Board(Symbol firstPlayersymbol, boolean humanGoesFirst) throws IllegalStateException {
        this.board = new Figure[3][3];
        this.gameOver = false;

        this.firstPlayersymbol = firstPlayersymbol;
        if (firstPlayersymbol == Symbol.CROSS) {
            secondPlayersymbol = Symbol.DOT;
        } else if (firstPlayersymbol == Symbol.DOT) {
            secondPlayersymbol = Symbol.CROSS;
        } else {
            throw new IllegalStateException("player symbol cannot be null");
        }
        Figure[] horizontal1 = this.addEntriesToArray(this.board[0][0], this.board[1][1], this.board[2][2]);
        Figure[] horizontal2 = this.addEntriesToArray(this.board[2][0], this.board[1][1], this.board[0][2]);
        Figure[] column1 = this.addEntriesToArray(this.board[0][0], this.board[0][1], this.board[0][2]);
        Figure[] column2 = this.addEntriesToArray(this.board[1][0], this.board[1][1], this.board[1][2]);
        Figure[] column3 = this.addEntriesToArray(this.board[2][0], this.board[2][1], this.board[2][2]);
        Figure[] row1 = this.addEntriesToArray(this.board[0][0], this.board[1][0], this.board[2][0]);
        Figure[] row2 = this.addEntriesToArray(this.board[0][1], this.board[1][1], this.board[2][1]);
        Figure[] row3 = this.addEntriesToArray(this.board[0][2], this.board[1][2], this.board[2][2]);

        this.allThrees = new Figure[][]{horizontal1, horizontal2, column1, column2, column3, row1, row2, row3};
        if (humanGoesFirst) {
            this.playerOne = new Player(firstPlayersymbol, PlayerType.HUMAN);
            this.playerTwo = new Player(secondPlayersymbol, PlayerType.COMPUTER);
        } else {
            this.playerOne = new Player(firstPlayersymbol, PlayerType.COMPUTER);
            this.playerTwo = new Player(secondPlayersymbol, PlayerType.HUMAN);
        }
        this.winner = null;
    }
    public void firstPlayerMoves(int moveWidth, int moveLength) {
        if (this.board[moveWidth][moveLength] == null) {
            this.board[moveWidth][moveLength] = new Figure(firstPlayersymbol);
            this.firstPlayerHasMoved = true;
            this.firstPlayerMoveSuccessful = true;
        } else {
            this.firstPlayerMoveSuccessful = false;
        }
    }
    public void secondPlayerMoves(int moveWidth, int moveLength) {
        if (this.board[moveWidth][moveLength] == null) {
            this.board[moveWidth][moveLength] = new Figure(secondPlayersymbol);
            this.secondPlayerHasMoved = true;
            this.secondPlayerMoveSuccessful = true;
        } else {
            this.secondPlayerMoveSuccessful = false;
        }
    }

    public boolean checkIfGameOver() {
        this.firstPlayerHasMoved = false;
        this.secondPlayerHasMoved = false;
        if (gameOver) {
            return true;
        }

        for (Figure[] Figures : allThrees) {
            int crossAmount = 0;
            int dotAmount = 0;
            for (Figure figure : Figures) {
                if (figure.getSymbol() == Symbol.CROSS) {
                    crossAmount++;
                }
                if (figure.getSymbol() == Symbol.DOT) {
                    dotAmount++;
                }
            }
            if (crossAmount == 3) {
                this.winner = this.findWinner(Symbol.CROSS);
                this.gameOver = true;
                return true;
            }
            else if (dotAmount == 3) {
                this.winner = this.findWinner(Symbol.DOT);
                this.gameOver = true;
                return true;
            }
        }
        return false;
    }
    private Player findWinner(Symbol symbol) {
        this.gameOver = true;
        if (this.playerOne.getSymbol() == symbol) {
            return this.playerOne;
        } else if (this.playerTwo.getSymbol() == symbol) {
            return this.playerTwo;
        } else {
            throw new IllegalArgumentException("There cannot be three of the same symbol in a row without either player winning, and thus something has gone terribly wrong");
        }
    }
    private Figure[] addEntriesToArray(Figure... figures) {
        return figures;
    }
    public Player getWinner() {
        return this.winner;
    }

    public boolean GameOver() {
        return gameOver;
    }

    public boolean FirstPlayerHasMoved() {
        return this.firstPlayerHasMoved;
    }
    public boolean SecondPlayerHasMoved() {
        return this.secondPlayerHasMoved;
    }
    public boolean bothPlayerHaveMoved() {
        return this.firstPlayerHasMoved && this.secondPlayerHasMoved;
    }

    public boolean FirstPlayerMoveSuccessful() {
        return firstPlayerMoveSuccessful;
    }
    public boolean SecondPlayerMoveSuccessful() {
        return secondPlayerMoveSuccessful;
    }
    public boolean bothPlayerMovesSuccessful() {
        return this.firstPlayerMoveSuccessful && this.secondPlayerMoveSuccessful;
    }
    public Board clone() {
        return this;
    }

    public Figure[][] getAllThrees() {
        return allThrees;
    }

    public Figure[][] getBoard() {
        return this.board;
    }
}
