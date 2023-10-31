import LEDs.*;

public class LedDisplay extends ClockDisplay
{
    private static boolean withAmPm = false;
    private LEDClockDisplay leds;
    private NumberDisplay ampm;
    private NumberDisplay hours;
    private NumberDisplay minutes;
 
    public LedDisplay(){
        super();
    }

    public LedDisplay(int hours, int minutes){
        super(hours, minutes);
    }

    public void initRealDisplay(int hour, int minute)
    {
        leds = new LEDClockDisplay(withAmPm);
        hours = new NumberDisplay(); 
        minutes = new NumberDisplay();

        leds.add(hours,minutes);

    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void updateRealDisplay()
    {
        int currentMinutes = getMinutesInDay();
        int valueMinutes = currentMinutes % MINUTES_IN_HOUR;
        int hour_limit = HOURS_IN_DAY;
        int valueHours = (currentMinutes % (hour_limit*MINUTES_IN_HOUR)) / MINUTES_IN_HOUR;

        hours.updateDisplay(valueHours);
        minutes.updateDisplay(valueMinutes);

    }

}
