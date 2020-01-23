package TicTacToe.BasicComponents;

public enum PlayerType {
    HUMAN(-1), BLANK(0), COMPUTER(1);

    private int playerValue;

    private PlayerType(int playerValue) {
        this.playerValue = playerValue;
    }
    public int getPlayerValue() {
        return this.playerValue;
    }
}
