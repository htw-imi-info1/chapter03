import java.time.LocalDateTime;

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
    public final static int HOURS_IN_DAY = 24;
    public final static int MINUTES_IN_HOUR = 60;
    public final static int MINUTES_LIMIT = HOURS_IN_DAY * MINUTES_IN_HOUR;

    private int minutesInDay = 0;
    private String displayString;    // simulates the actual display

    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        this(12,0);
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        initRealDisplay(hour, minute);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public synchronized void timeTick()
    {
        modCount++; // addition for time sync, ignore
        minutesInDay = (minutesInDay + 1) % MINUTES_LIMIT;
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        if (!(hour < HOURS_IN_DAY && minute < MINUTES_IN_HOUR))
            return;

        minutesInDay = MINUTES_IN_HOUR*hour + minute;
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
        int hours = minutesInDay / MINUTES_IN_HOUR;
        int minutes = minutesInDay % MINUTES_IN_HOUR;
        displayString = getDisplayValue(hours) + ":" + 
        getDisplayValue(minutes);
        updateRealDisplay();
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

    /**
     * called from constructor, override this to initialize the display
     */

    public void initRealDisplay(int hour, int minute){}

    /**
     * provide a hook methods where other display types can be implemented.
     */
    public void updateRealDisplay(){

    }

    /**
     * make time available for subclasses
     */
    public int getMinutesInDay(){
        return minutesInDay;
    }

    /*
     * Ignore the code below.
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * It is just a thread updating the ClockDisplay.
     * 
     * and the start() & stop() methods.
     * 
     * 
     */

    public void start(){
        clockRunning = true;
        clockThread = new ClockThread(this);
        clockThread.setInitialTime();
        clockThread.start();

    }

    public void stop(){
        clockRunning = false;
        try
        {
            clockThread.join();
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        clockThread = null;
    }

    /**
     * toggles between system time and a fast 
     * ticker.
     */
    public void toggleTicker(){
        useSystemTime = !useSystemTime;
        if (useSystemTime && clockThread != null)
            clockThread.pause = 300;
    }
    
    /**
     * sets the ticker speed in ms.
     * the ticker speed will be reset for system time.
     */
    public void setTickerSpeed(int pauseInMs){
        if (clockThread != null)
            clockThread.pause = pauseInMs;
    }


    private int modCount = 0;
    private ClockThread clockThread;
    private boolean clockRunning = false;
    private boolean useSystemTime = true;

    class ClockThread extends Thread{

        int pause = 300;
        private int lastMinutes = -1;
        private int clockModCount = -1;
        private ClockDisplay clockDisplay;

        public ClockThread(ClockDisplay kara){
            clockDisplay = kara;
        }

        protected void pause()
        {
            try {
                Thread.sleep(pause);   
            }
            catch (InterruptedException exc) {
            }
        }

        @Override
        public void run()
        {
            while (clockRunning) {
                step();
                pause();
            }
        }

        public void step()
        {
            synchronized(clockDisplay){

                int diff = updateLastMinutes();

                if (diff < 0){
                    setInitialTime();
                    return;
                }
                if (diff > 0)
                    if (checkModCount())
                        for (int i=0;i<diff;i++){
                            clockDisplay.timeTick();
                            clockModCount++;
                        }
            }
        }

        public void setInitialTime(){
            synchronized(clockDisplay){
                LocalDateTime now = LocalDateTime.now();
                int minutes = now.getMinute();
                int hours = now.getHour();
                setLastMinutes(hours,minutes);
                clockDisplay.setTime(hours, minutes);
                clockModCount = clockDisplay.modCount;
            }
        }

        public int updateLastMinutes(){
            int diff = useSystemTime ? getTimeDiff() : 1;
            lastMinutes = lastMinutes + diff;
            return diff;
        }

        private int getTimeDiff(){
            LocalDateTime now = LocalDateTime.now();
            int minutes = now.getMinute();
            int hours = now.getHour();
            int newLastMinutes = hours*60+minutes;
            if (lastMinutes == newLastMinutes)
                return 0;
            return newLastMinutes-lastMinutes;
        }

        public void setLastMinutes(int hours,int minutes){
            lastMinutes = hours*60+minutes;
        }

        /**
         * this method checks wether all modifications
         * to the clock have been made by this thread 
         * to achive this, modifications made here are counted
         * and are counted in the methods setTime or timeTick in ClockDisplay.
         * if the count differs, clock is reset.
         */
        boolean checkModCount(){
            if (clockModCount == clockDisplay.modCount)
                return true;
            setInitialTime();
            return false;
        }
    }
}
