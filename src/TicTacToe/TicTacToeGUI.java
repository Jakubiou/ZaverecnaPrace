package TicTacToe;

import javax.swing.*;

/**
 * The TicTacToeGUI class is used to create and run a Tic-Tac-Toe game.
 */
public class TicTacToeGUI {

    /**
     * Launches a new Tic-Tac-Toe game window.
     */
    public void startTicTacToe(){
        TicTacToeFrame frame = new TicTacToeFrame();
        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
