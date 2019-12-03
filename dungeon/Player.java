package dungeon;
import java.util.*;
public class Player implements Mover {
    private int x;
    private int y;
    public Player () {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public int getXCoordinate() {
        return this.x;
    }

    @Override
    public int getYCoordinate() {
        return this.y;
    }
}
