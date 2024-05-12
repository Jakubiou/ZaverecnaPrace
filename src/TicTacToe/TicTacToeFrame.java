package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    private TicTacToeBoard board;
    private JLabel statusLabel;


    public TicTacToeFrame(){
        board = new TicTacToeBoard(this::handleGameEnd);
        statusLabel = new JLabel("Player X's turn", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial",Font.PLAIN,24));
        statusLabel.setPreferredSize(new Dimension(500,50));
        setLayout(new BorderLayout());
        add(board,BorderLayout.CENTER);
        add(statusLabel,BorderLayout.SOUTH);
        board.setTicTacToeFrame(this);
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
    public void setCurrentPlayer(char currentPlayer){
        statusLabel.setText("Player " + currentPlayer + "'s turn");
    }
}
