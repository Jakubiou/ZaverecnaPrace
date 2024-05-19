package TowerBulder;

import java.awt.*;

public class GradientBackground {

    private Color startColor;
    private Color endColor;

    public GradientBackground(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    public void drawBackground(Graphics g, int width, int height){
        Graphics2D graphics2D = (Graphics2D) g;
        GradientPaint gradientPaint = new GradientPaint(0,0,startColor,0,height,endColor);
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRect(0,0,width,height);
    }
}
