package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    private TicTacToeBoard board;
    private JLabel statusLabel;


    public TicTacToeFrame(){
        board = new TicTacToeBoard();
        setLayout(new BorderLayout());
        add(board,BorderLayout.CENTER);
    }

    public void updateStatus(String message){
        statusLabel.setText(message);
    }

    public void handleGameEnd(char winner){
        if(winner == ' '){
            updateStatus("It's a tie!");
        }else {
            updateStatus("Player " + winner + " wins!");
        }
    }
}
