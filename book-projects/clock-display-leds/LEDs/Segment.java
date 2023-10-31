package LEDs;
import java.awt.*;
import java.awt.geom.*;

/**
 * Segment is one oval segment within the Led Display -
 * the "LED" that can be lit.
 * It is based on Circle from the Figures project.
 * 
 * @author Barne Kleinen, based on figures example by:
 * @author Michael Kölling and David J. Barnes
 */

public class Segment {

    private int width;
    private int height;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private int angle = 0;
    private Canvas canvas;

    /**
     * Create a new circle at default position with default color.
     */
    
    public Segment(int width, int heigth, int xPosition, int yPosition, String color, Canvas canvas)
    {
        this.canvas = canvas;
        this.width = width;
        this.height = heigth;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move the circle a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the circle horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the circle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the circle vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int width, int height)
    {
        erase();
        this.width = width;
        this.height = height;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    public void setAngle(int angle){this.angle = angle;}

    /**
     * Draw the circle with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            //Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, rotate(new Ellipse2D.Double(xPosition, yPosition, 
                    width, height)));
            canvas.wait(10);
        }
    }

    private Shape rotate(Shape shape){
        if (angle == 0) return shape;
        AffineTransform af = AffineTransform.getRotateInstance(Math.toRadians(angle),
                xPosition,
                yPosition);
        return af.createTransformedShape(shape);
    }

    /**
     * Erase the circle on screen.
     */
    private void erase()
    {
        if(isVisible) {
            //Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
