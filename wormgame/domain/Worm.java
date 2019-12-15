
package wormgame.domain;
import java.util.*;
import wormgame.*;
public class Worm {
    private int x;
    private int y;
    private Direction direction;
    private int length;
    private List<Piece> pieces;
    public Worm (int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        this.length = 1;
        this.pieces = new ArrayList<Piece>();
    }
    public Direction getDirection() {
        return this.direction;
    }
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
    public int getLength() {
        return this.length;
    }
    public List<Piece> getPieces() {
        return this.pieces;
    }
    public void move() {
        if (this.direction == Direction.DOWN) {
            this.y--;
        } else if (this.direction == Direction.UP) {
            this.y++;
        } else if (this.direction == Direction.LEFT) {
            this.x--;
        } else if (this.direction == Direction.RIGHT) {
            this.x++;
        }
    }
}
