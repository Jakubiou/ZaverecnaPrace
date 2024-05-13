package TowerBulder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TowerBuilder extends JPanel{

    private int PANEL_WIDTH = 600;
    private int PANEL_HEIGHT = 750;
    private int BASE_BLOCK_WIDTH = 200;
    private int BLOCK_HEIGHT = 40;

    private int baseBlockX;
    private int baseBlockY;
    private int movingBlockX;
    private int movingBlockY;
    private boolean isMovingRight = true;
    private boolean isSpacePressed = false;
    private  boolean gameOver = false;

    private List<Block> towerBlocks;
    private JFrame frame;

    public TowerBuilder(){
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        setBackground(Color.WHITE);

        towerBlocks = new ArrayList<>();

        baseBlockX = PANEL_WIDTH / 2 - BASE_BLOCK_WIDTH / 2;
        baseBlockY = PANEL_HEIGHT - BLOCK_HEIGHT;
        movingBlockX = baseBlockX;
        movingBlockY = PANEL_HEIGHT - 2 * BLOCK_HEIGHT;

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
}
