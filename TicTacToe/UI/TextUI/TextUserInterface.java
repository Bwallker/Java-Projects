package TicTacToe.UI.TextUI;

import TicTacToe.BasicComponents.Board.Board;
import TicTacToe.BasicComponents.Player;
import TicTacToe.BasicComponents.Symbol;

import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Board board;
    private Symbol symbol;
    private Symbol notSymbol;
    private Player playerOne;
    private Player playerTwo;
    private boolean breaker;
    public TextUserInterface() {
        this.reader = new Scanner(System.in);
        this.board = null;
        this.symbol = null;
        this.playerOne = null;
        this.playerTwo = null;
        this.breaker = false;
    }

    public void run() {
        setup();
        multiPlayer();
    }

    private void setup() {
        System.out.print("Tic Tac Toe");
        System.out.println("\n\n");
        setSymbol();
        this.playerOne = new Player(this.symbol, true);
        this.playerTwo = new Player(this.notSymbol, false);
        this.board = new Board(this.symbol);

    }

    private void setSymbol() {
        System.out.print("Type x to set first players symbol to x and o to set it to o  ");
        String input = reader.nextLine();
        input = input.toLowerCase();
        if (input.contains("x")) {
            this.symbol = Symbol.CROSS;
            this.notSymbol = Symbol.DOT;
        } else {
            this.symbol = Symbol.DOT;
            this.notSymbol = Symbol.CROSS;
        }
    }

    private void multiPlayer() {
        System.out.print(this.board);
        System.out.println();
        System.out.println("Please specify target location for your next move");
        System.out.println("Use the syntax X,Y");
        System.out.println("So to place a symbol in the second row and the first column type 2, 1");
        System.out.println();
        playerMoves(playerOne);
        if (this.breaker) {
            return;
        }
        checkIfWinner();
        if (this.board.GameOver()) {
            return;
        }
        playerMoves(playerTwo);
        if (this.breaker) {
            return;
        }
        checkIfWinner();
        if (this.board.GameOver()) {
            return;
        }
        multiPlayer();
    }

    private void playerMoves(Player player) {
        System.out.println("Type coordinates");
        System.out.println();
        String input = this.reader.nextLine();
        if (input.equals("exit") || input.equals("quit")) {
            this.breaker = true;
            return;
        }
        String[] parts = input.split(",");
        if (parts.length != 2) {
            System.out.println("Invalid input, please try again");
            playerMoves(player);
        }
        String part1 = parts[0];
        String part2 = parts[1];

        if ((!part1.equals("1") && !part1.equals("2") && !part1.equals("3")) || (!part2.equals("1") && !part2.equals("2") && !part2.equals("3"))) {
            System.out.println("Invalid input, please try again");
            playerMoves(player);
        }

        Integer intPart1 = Integer.parseInt(part1);
        Integer intPart2 = Integer.parseInt(part2);

        intPart1--;
        intPart2--;

        this.board.playerMoves(intPart1, intPart2, player);
        if (!this.board.playerMoveSuccessful(player)) {
            System.out.println("Spot already taken, please try again");
            playerMoves(player);
        }
    }

    private void checkIfWinner() {
        this.board.checkIfGameOver();
        if (this.board.GameOver()) {
            if (this.board.getWinner().getSymbol() == this.playerOne.getSymbol()) {
                System.out.println("Player One Wins!");
                return;
            } else {
                System.out.println("Player Two Wins!");
                return;
            }
        }
    }
}
