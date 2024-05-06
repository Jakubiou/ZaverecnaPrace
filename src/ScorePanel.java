import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private int PANEL_WIDTH = 900;
    private int PANEL_HEIGHT = 50;
    private int FONT_SIZE = 20;
    private Color BACKGROUND_COLOR = Color.DARK_GRAY;
    private Color TEXT_COLOR = Color.WHITE;
    private int player1Score = 0;
    private int player2Score = 0;
    private Font font = new Font("Arial",Font.BOLD,FONT_SIZE);

    public ScorePanel(){
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        setBackground(BACKGROUND_COLOR);
    }

    public void incrementPlayer1Score(){
        player1Score++;
        repaint();
    }
    public void incrementPlayer2Score(){
        player2Score++;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(TEXT_COLOR);
        g.setFont(font);
        g.drawString("Score" + player1Score,30,30);
        g.drawString("Score" + player2Score, PANEL_WIDTH - 200, 30);
    }
}
