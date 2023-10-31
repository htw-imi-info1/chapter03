package LEDs;


/**
 * Provide an interface the clients can depend on.
 * Tried to avoid it; but cannot depend on default package.
 *
 * @author Barne Kleinen
 */
public interface DisplayInterface
{
    /** 
     * NumberDisplay has to implement this as it "knows" which segments need to be added.
     */
    public void initDisplay(int x, int y, LEDClockDisplay leds);
    
}
