package TowerBulder;

import javax.swing.*;
import java.awt.*;
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

    }
}
