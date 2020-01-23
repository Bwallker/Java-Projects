package TicTacToe.BasicComponents;

public class Scoordinate extends Coordinate {
    private PlayerType favouredPlayer;
    public Scoordinate(int x, int y, PlayerType favouredPlayer) {
        super(x, y);
        this.favouredPlayer = favouredPlayer;
    }

    public PlayerType getfavouredPlayer() {
        return this.favouredPlayer;
    }
    public void setFavouredPlayer(PlayerType favouredPlayer) {this.favouredPlayer = favouredPlayer;}
}
