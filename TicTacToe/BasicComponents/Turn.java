package TicTacToe.BasicComponents;

public enum Turn {
    HUMAN(-1), BLANK(0), COMPUTER(1);

    private int type;

    private Turn(int type) {
        this.type = type;
    }
    public int getType() {
        return this.type;
    }
}
