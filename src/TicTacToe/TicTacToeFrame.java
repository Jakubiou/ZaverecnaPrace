package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The TicTacToeFrame class represents the main window for the Tic-Tac-Toe game
 */
public class TicTacToeFrame extends JFrame {
    private TicTacToeBoard board;
    private JLabel statusLabel;
    private JLabel winnerLabel;
    private JButton playAgainButton;
    TicTacToeGUI ticTacToeGUI = new TicTacToeGUI();
    Buttons buttons = new Buttons();

    /**
     * Creates a new Tic-Tac-Toe game window with a game surface and controls.
     */
    public TicTacToeFrame(){
        board = new TicTacToeBoard(this::handleGameEnd);
        statusLabel = new JLabel("Player X's turn", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial",Font.PLAIN,24));
        statusLabel.setPreferredSize(new Dimension(500,50));

        winnerLabel = new JLabel("",JLabel.CENTER);
        winnerLabel.setFont(new Font("Arial",Font.PLAIN,24));
        winnerLabel.setPreferredSize(new Dimension(350,50));

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton menuButton = buttons.createButton("Menu",100,20);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameMenu();
                dispose();
            }
        });
        playAgainButton = buttons.createButton("Play Again",180,20);
        playAgainButton.setVisible(false);
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ticTacToeGUI.startTicTacToe();
            }
        });
        topPanel.add(playAgainButton,BorderLayout.EAST);
        topPanel.add(menuButton,BorderLayout.WEST);
        topPanel.add(winnerLabel,BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);
        add(board,BorderLayout.CENTER);
        add(statusLabel,BorderLayout.SOUTH);
        board.setTicTacToeFrame(this);
    }

    /**
     * Handles game termination and sets up a winner report.
     * @param winner Winner sign ('X', 'O' or ' ' for a tie).
     */
    public void handleGameEnd(char winner){
        if(winner == ' '){
            winnerLabel.setText("No winner");
        }else {
            winnerLabel.setText("Winner: " + winner);
        }
        showPlayAgainButton();
    }

    /**
     * Sets the current player and updates the label status.
     * @param currentPlayer Current player character ('X' or 'O').
     */
    public void setCurrentPlayer(char currentPlayer){
        statusLabel.setText("Player " + currentPlayer + "'s turn");
    }

    /**
     * Shows a play again button.
     */
    public void showPlayAgainButton(){
        playAgainButton.setVisible(true);
    }
}
