package TicTacToe.BasicComponents;

public class Player {
    private boolean hasWon;
    private Type type;

    public Player(Type type) {
        this.type = type;
        this.hasWon = false;
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
}
