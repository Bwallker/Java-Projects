package TicTacToe.BasicComponents;

public class Player {
    private boolean hasWon;
    private Type type;
    private Turn turn;
    private boolean isMyTurn;
    public Player(Type type, Turn turn) {
        this.type = type;
        this.hasWon = false;
        this.turn = turn;
        this.isMyTurn = false;
    }

    public Type getType() {
        return type;
    }

    public boolean hasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public Turn getTurn() {
        return this.turn;
    }
    public void myTurn() {
        this.isMyTurn = true;
    }
    public void notMyTurn() {
        this.isMyTurn = false;
    }
    public boolean isItMyTurn() {
        return this.isMyTurn;
    }
    public void changeTurn() {
        if (!this.isMyTurn) this.isMyTurn = true;
        else this.isMyTurn = false;
    }
}
