package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeBoard extends JPanel {
    private JButton[][] buttons;
    private char currentPlayer;
    private boolean gameEnded;
    private boolean isTie = true;
    private GameEndListener gameEndListener;
    private TicTacToeFrame ticTacToeFrame;

    public TicTacToeBoard(GameEndListener gameEndListener){
        this.gameEndListener = gameEndListener;
        setLayout(new GridLayout(3,3,10,10));
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(300,300));
        buttons = new JButton[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        initializeBoard();
    }
    public void initializeBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                JButton button = new JButton();
                button.setFont(new Font("Arial",Font.BOLD,40));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int row = -1;
                        int col = -1;
                        for(int i  = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                if(buttons[i][j] == button){
                                    row = i;
                                    col = j;
                                    break;
                                }
                            }
                        }
                        if(row == -1 || col == -1){
                            return;
                        }
                        if(!gameEnded && buttons[row][col].getText().isEmpty()){
                            buttons[row][col].setText(Character.toString(currentPlayer));
                            buttons[row][col].setHorizontalAlignment(SwingConstants.CENTER);
                            buttons[row][col].setVerticalAlignment(SwingConstants.CENTER);
                            checkWinner();
                            switchPlayer();
                        }
                    }
                });
                buttons[i][j] = button;
                add(button);
            }
        }
    }
    public void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][0].getText().equals(buttons[i][2].getText()) && !buttons[i][0].getText().isEmpty()) {
                gameEnded = true;
                gameEndListener.onGameEnd(currentPlayer);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[0][i].getText().equals(buttons[2][i].getText()) && !buttons[0][i].getText().isEmpty()) {
                gameEnded = true;
                gameEndListener.onGameEnd(currentPlayer);
            }
        }
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[0][0].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().isEmpty()) {
            gameEnded = true;
            gameEndListener.onGameEnd(currentPlayer);
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[0][2].getText().equals(buttons[2][0].getText()) && !buttons[0][2].getText().isEmpty()) {
            gameEnded = true;
            gameEndListener.onGameEnd(currentPlayer);
        }
        if(gameEnded){
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    isTie = false;
                    break;
                }
            }
            if (!isTie) {
                break;
            }
        }
        if (isTie) {
            gameEnded = true;
            gameEndListener.onGameEnd(' ');
        }
    }
    public void switchPlayer(){
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        ticTacToeFrame.setCurrentPlayer(currentPlayer);
    }
    public void setTicTacToeFrame(TicTacToeFrame ticTacToeFrame){
        this.ticTacToeFrame = ticTacToeFrame;
    }
}
