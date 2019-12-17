package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.*;
import wormgame.domain.*;
import wormgame.gui.*;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        Random random = new Random();
        int appleWidth = random.nextInt(width);
        int appleHeight = random.nextInt(height);
        this.apple = new Apple(appleWidth, appleHeight);
        while (this.worm.runsInto(this.apple)) {
            appleWidth = random.nextInt(width);
            appleHeight = random.nextInt(height);
            this.apple = new Apple(appleWidth, appleHeight);
        }
        addActionListener(this);
        setInitialDelay(2000);

    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public Worm getWorm() {
        return this.worm;
    }
    
    public void setWorm(Worm worm) {
        this.worm = worm;
    }
    
    public Apple getApple() {
        return this.apple;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!this.continues) {
            return;
        }
        this.worm.move();
        if (this.worm.runsInto(this.apple)) {
            this.worm.grow();
            Random random = new Random();
            int appleWidth = random.nextInt(this.width);
            int appleHeight = random.nextInt(this.height);
            this.apple = new Apple(appleWidth, appleHeight);
        }
        if (this.worm.runsIntoItself()) {
            this.continues = false;
        }
        for (Piece piece : this.worm.getPieces()) {
            if(piece.getX() >= this.width || piece.getY() >= this.height || piece.getX() < 0 || piece.getY() < 0) {
                this.continues = false;
            }
        }
        this.updatable.update();
        this.setDelay(1000 / this.worm.getLength());

    }

}
