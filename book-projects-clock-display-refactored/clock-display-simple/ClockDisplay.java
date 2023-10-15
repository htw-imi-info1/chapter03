
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay
{
    public final static int HOURS = 24;
    public final static int MINUTES = 60;
    public final static int TICK_LIMIT = HOURS * MINUTES;
    
    private int ticks = 0;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        ticks = (ticks + 1) % TICK_LIMIT;
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        if (!(hour < HOURS && minute < MINUTES))
            return;
        
        ticks = MINUTES*hour + minute;
        updateDisplay();
    }
    

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        int hours = ticks / MINUTES;
        int minutes = ticks % MINUTES;
        displayString = getDisplayValue(hours) + ":" + 
                        getDisplayValue(minutes);
    }
    /** 
     * moved from NumberDisplay
     */
    private String getDisplayValue(int value)
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }
}
