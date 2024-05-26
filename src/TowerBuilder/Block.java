package TowerBuilder;

import java.awt.*;
import java.util.Random;

/**
 * The Block class represents a single block in the Tower Builder game.
 */
public class Block extends Rectangle {

    private Color color;

    /**
     * Creates a new block with a random color.
     * @param x X coordinate of the block.
     * @param y Y coordinate of the block.
     * @param width Block width.
     * @param height Block height.
     */
    public Block(int x, int y, int width,int height){
        super(x,y,width,height);
        Random random = new Random();
        this.color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
    }

    /**
     * Returns the color of the block.
     * @return Block color.
     */
    public Color getColor(){
        return color;
    }
}
