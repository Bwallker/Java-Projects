package TicTacToe.BasicComponents;

public class Player {
    private boolean hasWon;
    private Symbol symbol;
    private PlayerType turn;
    private boolean isMyPlayerType;
    public Player(Symbol symbol, PlayerType turn) {
        this.symbol = symbol;
        this.hasWon = false;
        this.turn = turn;
        this.isMyPlayerType = false;
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

    public PlayerType getPlayerType() {
        return this.turn;
    }
    public void myPlayerType() {
        this.isMyPlayerType = true;
    }
    public void notMyPlayerType() {
        this.isMyPlayerType = false;
    }
    public boolean isItMyPlayerType() {
        return this.isMyPlayerType;
    }
    public void changePlayerType() {
        if (!this.isMyPlayerType) this.isMyPlayerType = true;
        else this.isMyPlayerType = false;
    }
}
