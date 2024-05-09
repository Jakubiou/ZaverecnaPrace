package TicTacToe;

import javax.swing.*;

public class TicTacToeGUI {

    public void startTicTacToe(){
        TicTacToeFrame frame = new TicTacToeFrame();
        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
