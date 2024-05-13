package TowerBulder;

import java.awt.*;
import java.util.Random;

public class Block extends Rectangle {

    private Color color;

    public Block(int x, int y, int width,int height){
        super(x,y,width,height);
        Random random = new Random();
        this.color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
    }
    public Color getColor(){
        return color;
    }
}
