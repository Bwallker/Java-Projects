package TicTacToe.BasicComponents.Board;

import TicTacToe.BasicComponents.*;
import java.util.*;
public class Board {
    private static Figure[][] board;
    private boolean gameOver;
    private Player winner;
    private Player playerOne;
    private Player playerTwo;
    private Symbol firstPlayerSymbol;
    private Symbol secondPlayerSymbol;
    private boolean firstPlayerHasMoved;
    private boolean secondPlayerHasMoved;
    private boolean firstPlayerMoveSuccessful;
    private boolean secondPlayerMoveSuccessful;
    private List<Coordinate> allPossibleMoves;
    private Figure[][] allThrees;

    /**
     * @param firstPlayerSymbol Defines which symbol the player that makes the first move should use. Symbol can be either CROSS or DOT
     */
    public Board(Symbol firstPlayerSymbol) {
        this.board = new Figure[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = new Figure(Symbol.NULL);
            }
        }
        this.gameOver = false;
        this.allPossibleMoves = new ArrayList<Coordinate>();
        this.firstPlayerSymbol = firstPlayerSymbol;
        if (firstPlayerSymbol == Symbol.CROSS) {
            this.secondPlayerSymbol = Symbol.DOT;
        } else {
            this.firstPlayerSymbol = Symbol.DOT;
            this.secondPlayerSymbol = Symbol.CROSS;
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
        this.playerOne = new Player(this.firstPlayerSymbol);
        this.playerTwo = new Player(this.secondPlayerSymbol);
        this.winner = null;
    }
    public void firstPlayerMoves(int moveWidth, int moveLength) {
        if (this.board[moveWidth][moveLength] == null) {
            this.board[moveWidth][moveLength] = new Figure(firstPlayerSymbol);
            this.firstPlayerHasMoved = true;
            this.firstPlayerMoveSuccessful = true;
        } else {
            this.firstPlayerMoveSuccessful = false;
        }
    }
    public void secondPlayerMoves(int moveWidth, int moveLength) {
        if (this.board[moveWidth][moveLength] == null) {
            this.board[moveWidth][moveLength] = new Figure(secondPlayerSymbol);
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

    public Board clone() {
        return this;
    }

    public Figure[][] getAllThrees() {
        return allThrees;
    }

    public Figure[][] getBoard() {
        return this.board;
    }

    @Override
    public String toString() {
        String string = null;
        for(Figure[] figures : this.board) {
            for (Figure figure : figures) {
                if (figure.getSymbol() == Symbol.CROSS) {
                    string += "x  ";
                } else if (figure.getSymbol() == Symbol.DOT) {
                    string += "o  ";
                } else {
                    string += "null  ";
                }
            }
            string += "\n";
        }
        return string;
    }
}
