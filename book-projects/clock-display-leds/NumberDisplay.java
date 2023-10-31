import LEDs.*;

public class NumberDisplay implements DisplayInterface
{
    private LEDDigit upper, lower;

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    public NumberDisplay()
    {

    }

    public void initDisplay(int x, int y, LEDClockDisplay leds){
        upper = leds.createLEDDigit(x, y);
        lower = leds.createLEDDigit(x + LEDDigit.WIDTH+20, y);
    }

  
    /**
     * Addition for LED-Display: update the single digits
     */
    public void updateDisplay(int value){
        if (lower != null)
            lower.display(value % 10);
        if (upper != null)
            upper.display(value / 10);
    }
    
    /**
     * Addition for LED-Display: update am/pm
     */
    public void updateDisplay(String twoChars){
        if (lower != null)
            lower.displayChar(twoChars.charAt(1));
        if (upper != null)
            upper.displayChar(twoChars.charAt(0));
    }

}
