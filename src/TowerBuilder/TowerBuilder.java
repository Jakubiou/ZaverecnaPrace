package TowerBuilder;

import TicTacToe.Buttons;
import TicTacToe.GameMenu;

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
    private boolean blockPlaced = false;

    private TowerBuilderScore towerBuilderScore;
    private Timer timer;
    private DifficultyMenu difficultyMenu;
    private List<Block> towerBlocks;
    private JFrame frame;
    private int difficultyLevel = NORMAL_SPEED;
    private int speedUpTimer = 0;
    private int slowDownTimer = 0;
    private int SCORE_TO_SPEED_UP = 10;
    private GradientBackground gradientBackground;
    private JButton playAgainButton;

    public TowerBuilder(JFrame frame){
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        gradientBackground = new GradientBackground(Color.BLUE,Color.CYAN);

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

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(difficultyMenu);
        frame.setJMenuBar(menuBar);
        Buttons buttons = new Buttons();

        JButton menuButton = buttons.createButton("Menu",100,30);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GameMenu();
            }
        });
        playAgainButton = buttons.createButton("Play Again",180,20);
        playAgainButton.setVisible(false);
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JFrame newFrame = new JFrame("Tower Builder");
                new TowerBuilder(newFrame);
            }
        });
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.add(playAgainButton,BorderLayout.EAST);
        menuPanel.add(menuButton,BorderLayout.WEST);
        frame.getContentPane().add(menuPanel,BorderLayout.NORTH);

        frame.getContentPane().add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE && !gameOver && !blockPlaced){
                    isSpacePressed = true;
                    blockPlaced = true;
                    towerBlocks.add(new Block(baseBlockX,baseBlockY,BASE_BLOCK_WIDTH,BLOCK_HEIGHT));
                    int widthDifference = Math.abs(movingBlockX - baseBlockX);
                    BASE_BLOCK_WIDTH -= widthDifference;
                    baseBlockY -= 40;
                    if(movingBlockX + BASE_BLOCK_WIDTH / 2 >= baseBlockX + BASE_BLOCK_WIDTH / 2) {
                        baseBlockX = baseBlockX + widthDifference;
                        movingBlockX = baseBlockX;
                        movingBlockY -= BLOCK_HEIGHT;
                        TowerBuilderScore.increaseScore();
                        repaint();
                    }else if(movingBlockX + BASE_BLOCK_WIDTH / 2 < baseBlockX + BASE_BLOCK_WIDTH /2){
                        movingBlockX = baseBlockX;
                        movingBlockY -= BLOCK_HEIGHT;
                        TowerBuilderScore.increaseScore();
                        repaint();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    isSpacePressed = false;
                    blockPlaced = false;
                }
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gradientBackground.drawBackground(g,PANEL_WIDTH,PANEL_HEIGHT);
        for(Block block : towerBlocks){
            g.setColor(block.getColor());
            g.fillRect(block.x,block.y,block.width,block.height);
        }
        g.setColor(Color.GREEN);
        g.fillRect(baseBlockX,baseBlockY,BASE_BLOCK_WIDTH,BLOCK_HEIGHT);

        g.setColor(Color.BLUE);
        g.fillRect(movingBlockX,movingBlockY,BASE_BLOCK_WIDTH,BLOCK_HEIGHT);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.BOLD,50));
        g.drawString("Score: " + TowerBuilderScore.getScore(),40,70);

        if(gameOver){
            g.setFont(new Font("Arial",Font.BOLD,50));
            String gameOverText = "Game Over";
            int textWidth = g.getFontMetrics().stringWidth(gameOverText);
            int x = (PANEL_WIDTH - textWidth) / 2;
            int y = PANEL_HEIGHT / 2 - 100;
            g.drawString(gameOverText,x,y);
            drawHighScores(g);
        }
    }

    private void drawHighScores(Graphics g){
        List<HighScore> highScores = HighScoreManager.getHighScores();
        g.setFont(new Font("Arial",Font.PLAIN,20));
        int y = PANEL_HEIGHT / 2 + 40;
        for (HighScore highScore : highScores){
            g.drawString(highScore.getName() + ": " + highScore.getScore(),PANEL_WIDTH / 2 - 50,y);
            y += 30;
        }
        g.setFont(new Font("Arial",Font.BOLD,40));
        g.drawString("High Scores",PANEL_WIDTH / 2 - 120,PANEL_HEIGHT / 2);

        g.setColor(new Color(190,195,45));
        g.fillOval(PANEL_WIDTH / 2 - 100,PANEL_HEIGHT / 2 + 22,25,25);
        g.setColor(new Color(170,170,170));
        g.fillOval(PANEL_WIDTH / 2 - 100,PANEL_HEIGHT / 2 + 55,25,25);
        g.setColor(new Color(155,120,50));
        g.fillOval(PANEL_WIDTH / 2 - 100,PANEL_HEIGHT / 2 + 88,25,25);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.PLAIN,18));
        g.drawString(" 1",PANEL_WIDTH / 2 - 98,PANEL_HEIGHT / 2 + 41);
        g.drawString(" 2",PANEL_WIDTH / 2 - 98,PANEL_HEIGHT / 2 + 74);
        g.drawString(" 3",PANEL_WIDTH / 2 - 98,PANEL_HEIGHT / 2 + 107);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(!isSpacePressed && !gameOver){
            if(isMovingRight){
                movingBlockX += BLOCK_STEP * difficultyLevel;
                if(movingBlockX + BASE_BLOCK_WIDTH >= PANEL_WIDTH){
                    isMovingRight = false;
                }
            }else {
                movingBlockX -= BLOCK_STEP * difficultyLevel;
                if (movingBlockX <= 0){
                    isMovingRight = true;
                }
            }
        }
        checkGameOver();
        updateDifficulty();

        if(movingBlockY <= PANEL_HEIGHT / 2){
            baseBlockY += BLOCK_FALL_STEP;
            movingBlockY += BLOCK_FALL_STEP;
            for (Block block : towerBlocks){
                block.y += BLOCK_FALL_STEP;
            }
        }
        repaint();
    }
    private void updateDifficulty() {
        if (TowerBuilderScore.getScore() >= SCORE_TO_SPEED_UP) {
            timer.setDelay(5);
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
    public void checkGameOver(){
        if(isSpacePressed && !gameOver){
            if(movingBlockX + BASE_BLOCK_WIDTH < baseBlockX || movingBlockX > baseBlockX + BASE_BLOCK_WIDTH){
                gameOver = true;
                playAgainButton.setVisible(true);
                timer.stop();
                if(HighScoreManager.isHighScore(TowerBuilderScore.getScore())){
                    String name;
                    do{
                        name = JOptionPane.showInputDialog(frame,"New High Score! Enter your name (max 10 characters):");
                        if(name != null && name.length() > 10){
                            JOptionPane.showMessageDialog(frame,"Name must be 10 characters or less. Please try again");
                        }
                    }while (name != null && name.length() > 10);
                    if(name != null && !name.isEmpty()){
                        HighScoreManager.addHighScore(name,TowerBuilderScore.getScore());
                    }
                }
                repaint();
            }
        }
    }
}
