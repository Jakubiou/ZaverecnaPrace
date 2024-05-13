package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame {
    private TicTacToeBoard board;
    private JLabel statusLabel;
    private JLabel winnerLabel;


    public TicTacToeFrame(){
        board = new TicTacToeBoard(this::handleGameEnd);
        statusLabel = new JLabel("Player X's turn", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial",Font.PLAIN,24));
        statusLabel.setPreferredSize(new Dimension(500,50));

        winnerLabel = new JLabel("",JLabel.CENTER);
        winnerLabel.setFont(new Font("Arial",Font.PLAIN,24));
        winnerLabel.setPreferredSize(new Dimension(500,50));

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameMenu gameMenu = new GameMenu();
                setVisible(false);
            }
        });
        topPanel.add(menuButton,BorderLayout.WEST);
        topPanel.add(winnerLabel,BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);
        add(board,BorderLayout.CENTER);
        add(statusLabel,BorderLayout.SOUTH);
        board.setTicTacToeFrame(this);
    }


    public void handleGameEnd(char winner){
        if(winner == ' '){
            winnerLabel.setText("No winner");
        }else {
            winnerLabel.setText("Winner: " + winner);
        }
    }
    public void setCurrentPlayer(char currentPlayer){
        statusLabel.setText("Player " + currentPlayer + "'s turn");
    }
}
