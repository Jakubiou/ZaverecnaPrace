package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeBoard extends JPanel {
    private JButton[][] buttons;
    private char currentPlayer;

    public TicTacToeBoard(){
        setLayout(new GridLayout(3,3,10,10));
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(300,300));
        buttons = new JButton[3][3];
        currentPlayer = 'X';
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
                        if(buttons[row][col].getText().isEmpty()){
                            buttons[row][col].setText(Character.toString(currentPlayer));
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        }
                    }
                });
                buttons[i][j] = button;
                add(button);
            }
        }
    }
}
