package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeBoard extends JPanel {
    private JButton[][] buttons;
    private char currentPlayer;
    private boolean gameEnded;
    private GameEndListener gameEndListener;
    private TicTacToeFrame ticTacToeFrame;

    public TicTacToeBoard(GameEndListener gameEndListener){
        this.gameEndListener = gameEndListener;
        setLayout(new GridLayout(3,3,20,20));
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(600,600));
        buttons = new JButton[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        initializeBoard();
    }
    public void initializeBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                JButton button = new JButton();
                button.setFont(new Font("Arial",Font.BOLD,100));
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
                highlightWinningCells(i,0,i,1,i,2);
                gameEndListener.onGameEnd(currentPlayer);
                return;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[0][i].getText().equals(buttons[2][i].getText()) && !buttons[0][i].getText().isEmpty()) {
                gameEnded = true;
                highlightWinningCells(0,i,1,i,2,i);
                gameEndListener.onGameEnd(currentPlayer);
                return;
            }
        }
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[0][0].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().isEmpty()) {
            gameEnded = true;
            highlightWinningCells(0,0,1,1,2,2);
            gameEndListener.onGameEnd(currentPlayer);
            return;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[0][2].getText().equals(buttons[2][0].getText()) && !buttons[0][2].getText().isEmpty()) {
            gameEnded = true;
            highlightWinningCells(0,2,1,1,2,0);
            gameEndListener.onGameEnd(currentPlayer);
            return;
        }
        if(gameEnded){
            return;
        }
        boolean isTie = true;
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
            highlightTieCells(0,0,0,1,0,2,1,0,1,1,1,2,2,0,2,1,2,2);
            gameEndListener.onGameEnd(' ');
        }
    }

    public void highlightWinningCells(int... indexes){
        for(int i = 0; i < indexes.length;i += 2){
            int row = indexes[i];
            int col = indexes[i + 1];
            buttons[row][col].setBackground(Color.GREEN);
        }
    }
    public void highlightTieCells(int... indexes){
        for(int i = 0; i < indexes.length;i += 2){
            int row = indexes[i];
            int col = indexes[i + 1];
            buttons[row][col].setBackground(Color.YELLOW);
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
