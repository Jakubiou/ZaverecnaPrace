package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    public TicTacToeBoard board;

    public TicTacToeFrame(){
        board = new TicTacToeBoard();
        setLayout(new BorderLayout());
        add(board,BorderLayout.CENTER);
    }
}
