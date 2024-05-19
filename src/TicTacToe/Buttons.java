package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class Buttons {

    public Buttons() {
    }

    public JButton createButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setFocusPainted(false);
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(0, 85, 170));
        button.setPreferredSize(new Dimension(width, height));
        button.setMaximumSize(new Dimension(width, height));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt){
                button.setBackground(new Color(0,85,170));
                button.setForeground(new Color(255,255,255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt){
                button.setBackground(new Color(255,255,255));
                button.setForeground(new Color(0,85,170));
            }
        });
        return button;
    }
}
