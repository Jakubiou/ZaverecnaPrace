package TowerBulder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TowerBuilder extends JPanel implements ActionListener {

    private int PANEL_WIDTH = 600;
    private int PANEL_HEIGHT = 750;
    private int BASE_BLOCK_WIDTH = 200;
    private int BLOCK_HEIGHT = 40;
    private int BLOCK_STEP = 3;
    private int BLOCK_FALL_STEP = 20;

    private int EASY_SPEED = 1;
    private int NORMAL_SPEED = 2;
    private int HARD_SPEED = 4;

    private int baseBlockX;
    private int baseBlockY;
    private int movingBlockX;
    private int movingBlockY;
    private boolean isMovingRight = true;
    private boolean isSpacePressed = false;
    private  boolean gameOver = false;

    private TowerBuilderScore towerBuilderScore;
    private Timer timer;
    private DifficultyMenu difficultyMenu;
    private List<Block> towerBlocks;
    private JFrame frame;
    private int difficultyLevel = NORMAL_SPEED;
    private int speedUpTimer;
    private int slowDownTimer;
    private int SCORE_TO_SPEED_UP;

    public TowerBuilder(){
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        setBackground(Color.WHITE);

        towerBuilderScore = new TowerBuilderScore();
        timer = new Timer(10,this);
        timer.start();
        towerBlocks = new ArrayList<>();

        baseBlockX = PANEL_WIDTH / 2 - BASE_BLOCK_WIDTH / 2;
        baseBlockY = PANEL_HEIGHT - BLOCK_HEIGHT;
        movingBlockX = baseBlockX;
        movingBlockY = PANEL_HEIGHT - 2 * BLOCK_HEIGHT;

        difficultyMenu = new DifficultyMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedDifficulty = difficultyMenu.getSelectedDifficulty();
                if(selectedDifficulty == 1){
                    difficultyLevel = EASY_SPEED;
                } else if (selectedDifficulty == 2) {
                    difficultyLevel = NORMAL_SPEED;
                } else if (selectedDifficulty == 3) {
                    difficultyLevel = HARD_SPEED;
                }
                updateDifficulty();
            }
        });

        frame = new JFrame("Tower Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE && !gameOver){
                    isSpacePressed = true;
                    towerBlocks.add(new Block(baseBlockX,baseBlockY,BASE_BLOCK_WIDTH,BLOCK_HEIGHT));
                    int widthDifference = Math.abs(movingBlockX - baseBlockX);
                    BASE_BLOCK_WIDTH -= widthDifference;
                    movingBlockX = baseBlockX;
                    repaint();

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    isSpacePressed = false;
                }
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        for(Block block : towerBlocks){
            g.setColor(block.getColor());
            g.fillRect(block.x,block.y,block.width,block.height);
        }
        g.setColor(Color.GREEN);
        g.fillRect(baseBlockX,baseBlockY,BASE_BLOCK_WIDTH,BLOCK_HEIGHT);

        g.setColor(Color.BLUE);
        g.fillRect(movingBlockX,movingBlockY,BASE_BLOCK_WIDTH,BLOCK_HEIGHT);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(!isSpacePressed && !gameOver){
            if(isMovingRight){
                movingBlockX += BLOCK_STEP;
                if(movingBlockX + BASE_BLOCK_WIDTH >= PANEL_WIDTH){
                    isMovingRight = false;
                }
            }else {
                movingBlockX -= BLOCK_STEP;
                if (movingBlockX <= 0){
                    isMovingRight = true;
                }
            }
        }
        repaint();
    }
    private void updateDifficulty() {
        if (TowerBuilderScore.getScore() >= SCORE_TO_SPEED_UP) {
            timer.setDelay(5); // Zvýšení rychlosti hry
        }

        if (speedUpTimer > 0) {
            speedUpTimer--;
            if (speedUpTimer == 0) {
                timer.setDelay(10);
            }
        }

        if (slowDownTimer > 0) {
            slowDownTimer--;
            if (slowDownTimer == 0) {
                timer.setDelay(10);
            }
        }
    }
}
