import javax.swing.*;
import java.awt.*;

public class StartPong {
    public StartPong() {
    }

    public void startPong(){
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gamePanel = new GamePanel();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(gamePanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
