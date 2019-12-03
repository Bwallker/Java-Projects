package dungeon;
import java.util.*;
public class Dungeon {
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    public Dungeon (int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
    }
    public int getHeight() {
        return this.height;
    }
    public int getLenght(){
        return this.length;
    }
    public void run() {
        
    }
}
