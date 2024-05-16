package TicTacToe;

import Pong.StartPong;
import TicTacToe.TicTacToeGUI;
import TowerBulder.TowerBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {

    public GameMenu() {
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        JButton pongButton = new JButton("Play Pong");
        pongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartPong startPong = new StartPong();
                startPong.startPong();
                setVisible(false);
            }
        });
        panel.add(pongButton);

        JButton towerBuilderButton = new JButton("Play Tower Builder");
        towerBuilderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TowerBuilder towerBuilder = new TowerBuilder();
                setVisible(false);
            }
        });
        panel.add(towerBuilderButton);

        JButton ticTacToeButton = new JButton("Play Tic-Tac-Toe");
        ticTacToeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicTacToeGUI ticTacToeGUI = new TicTacToeGUI();
                ticTacToeGUI.startTicTacToe();
                setVisible(false);
            }
        });
        panel.add(ticTacToeButton);

        add(panel);
        setVisible(true);
    }
}
