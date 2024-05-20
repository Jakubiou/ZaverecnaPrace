package TicTacToe;

import Pong.StartPong;
import TicTacToe.TicTacToeGUI;
import TowerBuilder.TowerBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {

    Buttons buttons = new Buttons();

    public GameMenu() {
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,700);
        setLocationRelativeTo(null);
        setResizable(false);
    JPanel panel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            Color color1 = new Color(85, 170, 255);
            Color color2 = new Color(0, 85, 170);
            GradientPaint gradientPaint = new GradientPaint(0, 0, color1, 0, height, color2);
            graphics2D.setPaint(gradientPaint);
            graphics2D.fillRect(0, 0, width, height);
        }
    };
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    panel.setBorder(new EmptyBorder(50,50,50,50));

    JLabel jLabel = new JLabel("Game Menu");
    jLabel.setFont(new Font("Arial",Font.BOLD,35));
    jLabel.setForeground(Color.WHITE);
    jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(jLabel);
    panel.add(Box.createRigidArea(new Dimension(0,50)));

        JButton pongButton = buttons.createButton("Play Pong",400,100);
        pongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartPong startPong = new StartPong();
                startPong.startPong();
                dispose();
            }
        });
        panel.add(pongButton);

        JButton towerBuilderButton = buttons.createButton("Play Tower Builder",400,100);
        towerBuilderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("Tower Builder");
                new TowerBuilder(newFrame);
                dispose();
            }
        });
        panel.add(towerBuilderButton);

        JButton ticTacToeButton = buttons.createButton("Play Tic-Tac-Toe",400,100);
        ticTacToeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicTacToeGUI ticTacToeGUI = new TicTacToeGUI();
                ticTacToeGUI.startTicTacToe();
                dispose();
            }
        });
        panel.add(ticTacToeButton);

        panel.add(Box.createRigidArea(new Dimension(0,20)));

        JButton exitButton = buttons.createButton("Exit Menu",400,100);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }
}
