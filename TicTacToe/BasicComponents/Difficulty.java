package TicTacToe.BasicComponents;

public enum Difficulty {
    EASY(0.1, 1), MEDIUM(0.3, 2), HARD(0.6, 2), VERY_HARD(0.8, 3), IMPOSSIBLE(1, Integer.MAX_VALUE), CUSTOM(0, 0);

    private double difficulty;
    private int searchDepth;
    private int difficultyMutabilityLimiter;
    private int searchDepthMutabilityLimiter;

    private Difficulty(double difficulty, int searchDepth) {
        this.difficulty = difficulty;
        this.searchDepth = searchDepth;
        this.difficultyMutabilityLimiter = 0;
        this.searchDepthMutabilityLimiter = 0;
    }
    public void setDifficulty(double difficulty) {
        difficultyMutabilityLimiter++;
        if (difficultyMutabilityLimiter > 1 || this != Difficulty.CUSTOM) {
            return;
        }
        this.difficulty = difficulty;
    }
    public void setSearchDepth(int searchDepth) {
        searchDepthMutabilityLimiter++;
        if (searchDepthMutabilityLimiter > 1 || this != Difficulty.CUSTOM) {
            return;
        }
        this.searchDepth = searchDepth;
    }
    public void setSearchDeptAndDiff(double difficulty, int searchDepth) {
        setDifficulty(difficulty);
        setSearchDepth(searchDepth);
    }
}
