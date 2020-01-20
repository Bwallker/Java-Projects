package TicTacToe.BasicComponents;

public enum Difficulty {
    EASY(0.1), MEDIUM(0.3), HARD(0.6), VERY_HARD(0.8), IMPOSSIBLE(1), CUSTOM(0);

    private double diff;
    private int i;

    private Difficulty(double diff) {
        this.diff = diff;
        this.i = 0;
    }
    public void setDiff(double diff) {
        i++;
        if (i > 1 || this != Difficulty.CUSTOM) {
            return;
        }
        this.diff = diff;
    }
}
