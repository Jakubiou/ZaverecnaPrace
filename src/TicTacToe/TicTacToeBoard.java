package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The TicTacToeBoard class represents the playing board for the Tic-Tac-Toe game.
 */
public class TicTacToeBoard extends JPanel {
    protected JButton[][] buttons;
    protected char currentPlayer;
    protected boolean gameEnded;
    private GameEndListener gameEndListener;
    private TicTacToeFrame ticTacToeFrame;

    /**
     * Creates a new Tic-Tac-Toe game surface.
     * @param gameEndListener Listener to end the game.
     */
    public TicTacToeBoard(GameEndListener gameEndListener){
        this.gameEndListener = gameEndListener;
        setLayout(new GridLayout(3,3,20,20));
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(600,600));
        buttons = new JButton[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        initializeBoard();
    }

    /**
     * Sets the game surface with buttons.
     */
    public void initializeBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                JButton button = new JButton();
                button.setBackground(new Color(20,180,230));
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
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(!gameEnded && button.getText().isEmpty()){
                            button.setBackground(new Color(0,130,200));
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if(!gameEnded && button.getText().isEmpty()){
                            button.setBackground(new Color(20,180,230));
                        }
                    }
                });
                buttons[i][j] = button;
                add(button);
            }
        }
    }

    /**
     * Checks if a player has not won or if there is a tie.
     */
    public void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][0].getText().equals(buttons[i][2].getText()) && !buttons[i][0].getText().isEmpty()) {
                gameEnded = true;
                highlightCells(Color.GREEN,i,0,i,1,i,2);
                gameEndListener.onGameEnd(currentPlayer);
                return;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[0][i].getText().equals(buttons[2][i].getText()) && !buttons[0][i].getText().isEmpty()) {
                gameEnded = true;
                highlightCells(Color.GREEN,0,i,1,i,2,i);
                gameEndListener.onGameEnd(currentPlayer);
                return;
            }
        }
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[0][0].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().isEmpty()) {
            gameEnded = true;
            highlightCells(Color.GREEN,0,0,1,1,2,2);
            gameEndListener.onGameEnd(currentPlayer);
            return;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[0][2].getText().equals(buttons[2][0].getText()) && !buttons[0][2].getText().isEmpty()) {
            gameEnded = true;
            highlightCells(Color.GREEN,0,2,1,1,2,0);
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
            highlightCells(Color.YELLOW,0,0,0,1,0,2,1,0,1,1,1,2,2,0,2,1,2,2);
            gameEndListener.onGameEnd(' ');
        }
    }

    /**
     * Highlights the specified cells with the given color.
     * @param color Highlight color.
     * @param indexes Cell indices to highlight.
     */
    public void highlightCells(Color color,int... indexes){
        for(int i = 0; i < indexes.length;i += 2){
            int row = indexes[i];
            int col = indexes[i + 1];
            buttons[row][col].setBackground(color);
        }
    }

    /**
     * Switches players.
     */
    public void switchPlayer(){
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        ticTacToeFrame.setCurrentPlayer(currentPlayer);
    }

    /**
     * Set reference to Tic Tac Toe Frame.
     * @param ticTacToeFrame An instance of TicTacToeFrame.
     */
    public void setTicTacToeFrame(TicTacToeFrame ticTacToeFrame){
        this.ticTacToeFrame = ticTacToeFrame;
    }
}
