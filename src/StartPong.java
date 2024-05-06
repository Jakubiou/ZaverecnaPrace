import javax.swing.*;
import java.awt.*;

public class StartPong {
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

        frame.pack();
        frame.setVisible(true);
    }
}
