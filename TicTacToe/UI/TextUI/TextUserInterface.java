package TicTacToe.UI.TextUI;

import java.util.*;
import TicTacToe.BasicComponents.*;
import TicTacToe.BasicComponents.Board.*;

public class TextUserInterface {
    private Scanner reader;
    private Board board;
    private GameMode gameMode;
    private Type type;
    private boolean playerGoesFirst;

    public TextUserInterface() throws IllegalAccessException {
        this.reader = new Scanner(System.in);
        this.board = null;
        this.gameMode = null;
        this.type = null;
        this.playerGoesFirst = true;
    }

    public void run() throws IllegalAccessException {
        setup();
        if (this.gameMode == GameMode.SINGLE_PLAYER) {
            goFirst();
            singlePlayer();
        } else if (this.gameMode == GameMode.MULTI_PLAYER) {
            multiPlayer();
        } else {
            throw new IllegalStateException("Game mode cannot be neither single or multi player");
        }
    }

    private void setup() {
        System.out.println("Tic Tac Toe");
        setGameMode();
        setType();

    }

    private void setGameMode() {
        System.out.println("do you want to play against the computer or against a person in hotseat?");
        System.out.println("type s to play single player and m to play multi player");
        String input = reader.nextLine();
        input = input.toLowerCase();
        if (input.contains("s")) {
            this.gameMode = GameMode.SINGLE_PLAYER;
        } else if (input.contains("m")) {
            this.gameMode = GameMode.MULTI_PLAYER;
        } else {
            System.out.println("input invalid");
            setGameMode();
        }
    }

    private void setType() {
        if (this.gameMode == GameMode.SINGLE_PLAYER) {
            System.out.println("type x to set your symbol to x and o to set it to o");
        } else {
            System.out.println("type x to the first players symbol to x and o to set it to o");
        }
        String input = reader.nextLine();
        input = input.toLowerCase();
        if (input.contains("x")) {
            this.type = Type.CROSS;
        } else if (input.contains("o")) {
            this.type = Type.DOT;
        } else {
            System.out.println("input invalid");
            setType();
        }
    }

    private void goFirst() {
        System.out.println("do you want to go first? (Y/N)");
        String input = reader.nextLine();
        input = input.toLowerCase();
        if (input.contains("y")) {
            this.playerGoesFirst = true;
        } else if (input.contains("n")) {
            this.playerGoesFirst = false;
        } else {
            System.out.println("input invalid");
            goFirst();
        }
    }

    private void singlePlayer() throws IllegalAccessException {
    if (playerGoesFirst) {
        this.board = new Board(this.type);
    } else {
        if (this.type == Type.CROSS) {
            this.board = new Board(Type.DOT);
        } else {
            this.board = new Board(Type.CROSS);
        }
    }

    }

    private void multiPlayer() {

    }

    public boolean doesPlayerGoesFirst() {
        return this.playerGoesFirst;
    }
}
