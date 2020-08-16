package TicTacToe.BasicComponents;
public class Player {
    private boolean hasWon;
    private Symbol symbol;

    /**
     * @param symbol Enum of type Symbol, used to store which symbol the player uses.
     */

    public Player(Symbol symbol) {
        this.symbol = symbol;
        this.hasWon = false;
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