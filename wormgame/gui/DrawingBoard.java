package wormgame.gui;
import java.awt.Color;
import java.awt.Graphics;
import wormgame.gui.*;
import java.util.*;
import javax.swing.JPanel;
import wormgame.domain.*;
import wormgame.game.*;

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
        for (Piece piece : this.wormGame.getWorm().getPieces()) {
            graphics.fill3DRect(piece.getX()*this.pieceLength, piece.getY()*this.pieceLength, this.pieceLength, this.pieceLength, true);
        }
        
        graphics.setColor(Color.red);
        graphics.fillOval(wormGame.getApple().getX()*this.pieceLength, wormGame.getApple().getY()*this.pieceLength, this.pieceLength, this.pieceLength);
    }

    @Override
    public void update() {
        JPanel panel = new JPanel();
        panel.repaint();
    }
}
