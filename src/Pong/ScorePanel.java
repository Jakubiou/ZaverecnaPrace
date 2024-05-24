package Pong;

import javax.swing.*;
import java.awt.*;

/**
 * The ScorePanel class represents a panel displaying player scores.
 * Extends the JPanel class to provide player score rendering.
 */
public class ScorePanel extends JPanel {
    private int PANEL_WIDTH = 900;
    private int PANEL_HEIGHT = 50;
    private int FONT_SIZE = 20;
    private Color BACKGROUND_COLOR = Color.DARK_GRAY;
    private Color TEXT_COLOR = Color.WHITE;
    private int player1Score = 0;
    private int player2Score = 0;
    private Font font = new Font("Arial",Font.BOLD,FONT_SIZE);

    /**
     * Constructor for the ScorePanel class.
     * Sets the dimensions and background color of the panel.
     */
    public ScorePanel(){
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        setBackground(BACKGROUND_COLOR);
    }

    /**
     * Increases player 1's score by 1 point and redraws the panel.
     */
    public void incrementPlayer1Score(){
        player1Score++;
        repaint();
    }

    /**
     * Increases player 2's score by 1 point and redraws the panel.
     */
    public void incrementPlayer2Score(){
        player2Score++;
        repaint();
    }

    /**
     * Plots player scores on a panel.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(TEXT_COLOR);
        g.setFont(font);
        g.drawString("Score: " + player1Score,30,30);
        g.drawString("Score: " + player2Score, PANEL_WIDTH - 200, 30);
    }
}
