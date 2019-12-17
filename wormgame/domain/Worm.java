package wormgame.domain;

import java.util.*;
import wormgame.*;

public class Worm {
    private int y;
    private int x;
    private Direction direction;
    private int length;
    private final List<Piece> pieces;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(originalX, originalY));
        this.length = this.pieces.size();
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public int getLength() {
        return this.pieces.size();
    }

    public List<Piece> getPieces() {
        return this.pieces;
    }

    public void move() {
        if (this.length >= 3) {
            this.pieces.remove(0);
        }
        if (this.direction == Direction.DOWN) {
            this.pieces.add(new Piece(this.x, this.y + 1));
            this.y++;
        } else if (this.direction == Direction.UP) {
            this.pieces.add(new Piece(this.x, this.y - 1));
            this.y--;
        } else if (this.direction == Direction.LEFT) {
            this.pieces.add(new Piece(this.x - 1, this.y));
            this.x--;
        } else if (this.direction == Direction.RIGHT) {
            this.pieces.add(new Piece(this.x + 1, this.y));
            this.x++;
        }
        this.length = this.pieces.size();
    }
    public void grow() {
        this.length = 2;
    }
    public boolean runsInto(Piece piece) {
        for (Piece p : this.pieces) {
            if (p.getX() == piece.getX() && p.getY() == piece.getY()) {
                return true;
            }
        }
        return false;
    }
    public boolean runsIntoItself() {
        int i = 0;
        Iterator<Piece> iterator = this.pieces.iterator();
        while(iterator.hasNext()) {
            if(i >= this.pieces.size()) {
                break;
            }
            Piece piece = this.pieces.get(i);
            Iterator<Piece> internalIterator = this.pieces.iterator();
            int count = 0;
            while (internalIterator.hasNext()) {
                if (count >= this.pieces.size()) {
                    break;
                }
                if (count == i) {
                    count++;
                    continue;
                }
                Piece p = this.pieces.get(count);
                if(piece.getX() == p.getX() && piece.getY() == p.getY()) {
                    return true;
                }
                count++;
                
            }
            i++;
        }
        return false;
    }
}
