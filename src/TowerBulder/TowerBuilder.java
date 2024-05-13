package TowerBulder;

import javax.swing.*;

public class TowerBuilder extends JPanel{

    private int PANEL_WIDTH = 600;
    private int PANEL_HEIGHT = 750;
    private int BASE_BLOCK_wIDTH = 200;
    private int BLOCK_HEIGHT = 40;
    private int baseBlockX;
    private int baseBlockY;
    private int movingBlockX;
    private int movingBlockY;
    private boolean isMovingRight = true;
    private boolean isSpacePressed = false;
    private  boolean gameOver = false;
}
