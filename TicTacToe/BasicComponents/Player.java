package TicTacToe.BasicComponents;
public class Player {
    private boolean hasWon;
    private Symbol symbol;
    private boolean isFirstPlayer;

    public boolean isFirstPlayer() {
        return isFirstPlayer;
    }

    /**
     * @param symbol Enum of type Symbol, used to store which symbol the player uses.
     */

    public Player(Symbol symbol, boolean isFirstPlayer) {
        this.symbol = symbol;
        this.hasWon = false;
        this.isFirstPlayer = isFirstPlayer;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public boolean hasWon() {
        return this.hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }
}