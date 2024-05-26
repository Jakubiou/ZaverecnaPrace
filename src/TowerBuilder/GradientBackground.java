package TowerBuilder;

import java.awt.*;

/**
 * The Gradient Background class represents a gradient background in Tower Builder.
 */
public class GradientBackground {

    private Color startColor;
    private Color endColor;

    /**
     * Creates a new gradient background with the given start and end colors.
     * @param startColor The starting color of the gradient.
     * @param endColor The end color of the gradient.
     */
    public GradientBackground(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    /**
     * Draws a gradient background on the specified graphic with the given width and height.
     * @param g The graphics context to draw on.
     * @param width Background width.
     * @param height Background height.
     */
    public void drawBackground(Graphics g, int width, int height){
        Graphics2D graphics2D = (Graphics2D) g;
        GradientPaint gradientPaint = new GradientPaint(0,0,startColor,0,height,endColor);
        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRect(0,0,width,height);
    }
}
