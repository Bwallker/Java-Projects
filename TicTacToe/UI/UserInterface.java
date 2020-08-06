package TicTacToe.UI;
import javax.swing.*;
public interface UserInterface extends Runnable {
    public void run();
    public boolean doesPlayerGoFirst();
}