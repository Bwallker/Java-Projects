package TicTacToe.BasicComponents;

public class Scoordinate extends Coordinate {
    private Turn favouredPlayer;
    public Scoordinate(int x, int y, Turn favouredPlayer) {
        super(x, y);
        this.favouredPlayer = favouredPlayer;
    }

    public Turn getfavouredPlayer() {
        return this.favouredPlayer;
    }
}
