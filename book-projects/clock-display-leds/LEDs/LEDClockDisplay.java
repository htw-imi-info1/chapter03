package LEDs;
import java.awt.Color;

/**
 * class LEDClockDisplay hides as much of the display complexity
 * as possible to keep the example of ClockDisplay and NumberDisplay as simple as possible.
 *
 * @author Barne Kleinen
 */
public class LEDClockDisplay
{
    public static final Color BACKGROUND_COLOR = new Color(53, 9, 9);
    public static final String COLOR = "led"; // color strings are defined in canvas - from the figures project

    public static final int BORDER_TOP = 30;
    public static final int BORDER_LEFT = 20;
    private Canvas canvas;
    private Dots dots;
    private int displayDistance = 2*LEDDigit.WIDTH+80;

    public LEDClockDisplay()
    {
        this(true);
    }
    
    public LEDClockDisplay(boolean withAmPm)
    {
        int width = withAmPm ? 700 : 450;
        canvas = new Canvas("The Info1 Lab Clock", width, 200, 
            BACKGROUND_COLOR);
    }

    public LEDClockDisplay(Canvas canvas){
        this.canvas = canvas;
    }

    public void add(DisplayInterface hours, DisplayInterface minutes){
        hours.initDisplay(BORDER_LEFT, BORDER_TOP, this);
        new Dots(BORDER_LEFT+2*LEDDigit.WIDTH+49,BORDER_TOP+32, "led", canvas);
        minutes.initDisplay(BORDER_LEFT+2*LEDDigit.WIDTH+80, BORDER_TOP,this);
    }
    public void add(DisplayInterface ampm){
        ampm.initDisplay(BORDER_LEFT+2*displayDistance, BORDER_TOP,this);
    }
    
    public LEDDigit createLEDDigit(int x, int y){
        return new LEDDigit(x, y, canvas);
    }
    

    public void showWindow(){
        canvas.setVisible(true);
    }

    public Canvas getCanvas(){
        return canvas;
    }

    
    
    
    /**
     * test stuff
     */
    public static LEDClockDisplay testInstance(String title){
        LEDClockDisplay testInstance = new LEDClockDisplay(
                new Canvas(title, 470, 200, 
                    BACKGROUND_COLOR));
        return testInstance;
    }

    public static Canvas getTestCanvas(String title){
        return new Canvas(title, 470, 200, 
            BACKGROUND_COLOR);}

}
