package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel {
    private int PANEL_WIDTH = 900;
    private int PANEL_HEIGHT = 700;
    private int PADDLE_WIDTH = 15;
    private int PADDLE_HEIGHT = 100;
    private int PADDLE_SPEED = 7;
    private int BALL_SIZE = 20;
    private int BALL_SPEED = 3;

    private int MAX_BALL_SPEED = 10;
    private int paddle1Y = PANEL_HEIGHT / 2 - PADDLE_HEIGHT / 2;
    private int paddle2Y = PANEL_HEIGHT / 2 - PADDLE_HEIGHT / 2;
    private int ballX = PANEL_WIDTH / 2 - BALL_SIZE / 2;
    private int ballY = PANEL_HEIGHT / 2 - BALL_SIZE / 2;
    private int ballXSpeed = BALL_SPEED;
    private int ballYSpeed = BALL_SPEED;
    private boolean up1Pressed = false;
    private boolean down1Pressed = false;
    private boolean up2Pressed = false;
    private boolean down2Pressed = false;
    private ScorePanel scorePanel;

    public GamePanel(ScorePanel scorePanel){
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocusInWindow();
        this.scorePanel = scorePanel;

        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
                repaint();
            }
        });
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_W){
                    up1Pressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    down1Pressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    up2Pressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    down2Pressed = true;
                }
            }
            public void keyReleased(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_W){
                    up1Pressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    down1Pressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    up2Pressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    down2Pressed = false;
                }
            }
        });
    }

    public void movePaddles(){
        if(up1Pressed && paddle1Y > 0){
            paddle1Y -= PADDLE_SPEED;
        }
        if(down1Pressed && paddle1Y < PANEL_HEIGHT - PADDLE_HEIGHT){
            paddle1Y += PADDLE_SPEED;
        }
        if(up2Pressed && paddle2Y > 0){
            paddle2Y -= PADDLE_SPEED;
        }
        if(down2Pressed && paddle2Y < PANEL_HEIGHT - PADDLE_HEIGHT){
            paddle2Y += PADDLE_SPEED;
        }
    }

    public void update(){
        movePaddles();
        ballX += ballXSpeed;
        ballY += ballYSpeed;
        if(ballY <= 0 || ballY >= PANEL_HEIGHT - BALL_SIZE){
            ballYSpeed *= -1;
        }
        if(ballX <= PADDLE_WIDTH && ballY + BALL_SIZE >= paddle1Y && ballY <= paddle1Y + PADDLE_HEIGHT){
            ballXSpeed *= -1;
            ballXSpeed = Math.min(ballXSpeed + 1, MAX_BALL_SPEED);
            ballYSpeed = Math.min(ballYSpeed + 1, MAX_BALL_SPEED);
        }
        if(ballX >= PANEL_WIDTH - PADDLE_WIDTH - BALL_SIZE && ballY + BALL_SIZE >= paddle2Y && ballY <= paddle2Y + PADDLE_HEIGHT){
            ballXSpeed *= -1;
            ballXSpeed = Math.max(ballXSpeed - 1, -MAX_BALL_SPEED);
            ballYSpeed = Math.max(ballYSpeed - 1, -MAX_BALL_SPEED);
        }
        if(ballX < 0){
            scorePanel.incrementPlayer2Score();
            ballReset();
        } else if (ballX > PANEL_WIDTH - BALL_SIZE) {
            scorePanel.incrementPlayer1Score();
            ballReset();
        }

    }

    public void ballReset(){
        ballX = PANEL_WIDTH / 2 - BALL_SIZE / 2;
        ballY = PANEL_HEIGHT / 2 - BALL_SIZE / 2;
        Random random = new Random();
        int i = random.nextInt(5);
        if(i == 1){
            ballXSpeed = BALL_SPEED;
            ballYSpeed = BALL_SPEED;
        } else if (i == 2) {
            ballXSpeed = -BALL_SPEED;
            ballYSpeed = BALL_SPEED;
        } else if (i == 3) {
            ballXSpeed = BALL_SPEED;
            ballYSpeed = -BALL_SPEED;
        } else if(i == 4){
            ballXSpeed = -BALL_SPEED;
            ballYSpeed = -BALL_SPEED;
        }


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, paddle1Y, PADDLE_WIDTH,PADDLE_HEIGHT);
        g.fillRect(PANEL_WIDTH - PADDLE_WIDTH, paddle2Y, PADDLE_WIDTH,PADDLE_HEIGHT);
        g.fillOval(ballX,ballY,BALL_SIZE,BALL_SIZE);

        g.setColor(Color.WHITE);
        for (int i = 0; i < PANEL_HEIGHT; i += 30) {
            g.fillRect(PANEL_WIDTH / 2 - 1, i, 2, 15);
        }

        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial",Font.BOLD,12));
        g.drawString("Ball Speed: " + Math.abs(ballXSpeed),PANEL_WIDTH / 2 - 30,PANEL_HEIGHT - 12);
    }
}
