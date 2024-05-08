package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class TicTacToeBoard extends JPanel {
    private JButton[][] buttons;
    private char currentPlayer;

    public TicTacToeBoard(){
        setLayout(new GridLayout(3,3,10,10));
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(300,300));
    }
}
