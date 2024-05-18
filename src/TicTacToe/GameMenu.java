package TicTacToe;

import Pong.StartPong;
import TicTacToe.TicTacToeGUI;
import TowerBulder.TowerBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {

    public GameMenu() {
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setLocationRelativeTo(null);
    JPanel panel = new JPanel() {
        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);
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

        JButton pongButton = new JButton("Play Pong");
        pongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartPong startPong = new StartPong();
                startPong.startPong();
                dispose();
            }
        });
        panel.add(pongButton);

        JButton towerBuilderButton = new JButton("Play Tower Builder");
        towerBuilderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TowerBuilder towerBuilder = new TowerBuilder();
                dispose();
            }
        });
        panel.add(towerBuilderButton);

        JButton ticTacToeButton = new JButton("Play Tic-Tac-Toe");
        ticTacToeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicTacToeGUI ticTacToeGUI = new TicTacToeGUI();
                ticTacToeGUI.startTicTacToe();
                dispose();
            }
        });
        panel.add(ticTacToeButton);

        add(panel);
        setVisible(true);
    }
}
