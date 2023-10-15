

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ClockDisplayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClockDisplayTest
{
    private ClockDisplay clockDisplay;

    /**
     * Default constructor for test class ClockDisplayTest
     */
    public ClockDisplayTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        clockDisplay = new ClockDisplay();  
    }
    

    @Test
    public void testSetTime()
    {
        clockDisplay.setTime(13, 45);
        assertEquals("13:45", clockDisplay.getTime());
    }

    @Test
    public void testConstructorWithParams()
    {
        ClockDisplay clockDisplayInitialized = new ClockDisplay(17, 15);
        java.lang.String string1 = clockDisplayInitialized.getTime();
        assertEquals("17:15", string1);
    }
    
    @Test
    public void testTick()
    {
        clockDisplay.setTime(13, 45);
        clockDisplay.timeTick();
        assertEquals("13:46", clockDisplay.getTime());
    }
    
    @Test
    public void testTickRollOver()
    {
        clockDisplay.setTime(23, 59);
        clockDisplay.timeTick();
        assertEquals("00:00", clockDisplay.getTime());
    }
    
    @Test
    public void testTickMinuteRollOver()
    {
        clockDisplay.setTime(13, 59);
        clockDisplay.timeTick();
        assertEquals("14:00", clockDisplay.getTime());
    }
    
    @Test
    public void testMultiTick()
    {
        clockDisplay.setTime(23, 50);
        clockDisplay.timeTick();
        clockDisplay.timeTick();
        clockDisplay.timeTick();
        clockDisplay.timeTick();
        clockDisplay.timeTick();
        assertEquals("23:55", clockDisplay.getTime());
    }
    
    
}


