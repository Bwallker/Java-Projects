package dungeon;
public interface Mover {
    void setCoordinates(int x, int y);
    void move(int dx, int dy);
    int getXCoordinate();
    int getYCoordinate();
}
