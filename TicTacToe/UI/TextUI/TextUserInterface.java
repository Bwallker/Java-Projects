package TicTacToe.UI.TextUI;

import java.util.*;
import TicTacToe.BasicComponents.*;
import TicTacToe.BasicComponents.Board.*;

public class TextUserInterface {
    private Scanner reader;
    private Board board;
    private Symbol symbol;

    public TextUserInterface() {
        this.reader = new Scanner(System.in);
        this.board = null;
        this.symbol = null;
    }

    public void run() {
        setup();
        multiPlayer();
    }

    private void setup() {
        System.out.print("Tic Tac Toe");
        System.out.println("\n\n");
        setSymbol();
        this.board = new Board(this.symbol);

    }

    private void setSymbol() {
        System.out.print("Type x to set first players symbol to x and o to set it to o  ");
        String input = reader.nextLine();
        input = input.toLowerCase();
        if (input.contains("x")) {
            this.symbol = Symbol.CROSS;
        } else {
            this.symbol = Symbol.DOT;
        }
    }

    private void multiPlayer() {
        System.out.print(this.board);
    }
}
