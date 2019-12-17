package wormgame.gui;
import java.awt.Color;
import java.awt.Graphics;
import wormgame.gui.*;
import java.util.*;
import javax.swing.JPanel;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

/**
 *
 * @author bwallker
 */
public class DrawingBoard extends JPanel implements Updatable {
    private WormGame wormGame;
    private int pieceLength;
    public DrawingBoard (WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.black);
        graphics.fill3DRect(0, 0, this.pieceLength, this.pieceLength, true);
        graphics.setColor(Color.red);
        graphics.fillOval(wormGame.getApple().getX(), wormGame.getApple().getY(), 1, 1);
    }

    @Override
    public void update() {
        JPanel panel = new JPanel();
        panel.repaint();
    }
}
