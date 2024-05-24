package Pong;

import Pong.GamePanel;
import Pong.ScorePanel;
import TicTacToe.Buttons;
import TicTacToe.GameMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPong {
    Buttons buttons = new Buttons();
    public StartPong() {
    }

    public void startPong(){
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ScorePanel scorePanel = new ScorePanel();
        GamePanel gamePanel = new GamePanel(scorePanel);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
        frame.getContentPane().add(scorePanel,BorderLayout.NORTH);

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.DARK_GRAY);
        JButton menuButton = buttons.createButton("Menu",100,30);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameMenu();
                frame.dispose();
            }
        });
        menuPanel.add(menuButton);
        frame.getContentPane().add(menuPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
