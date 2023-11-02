
public class Wheel
{
    public static final double MM_INCHES = 25.4;

    private int rim;
    private int tire;

    /**
     * @param rim  - rim size in mm
     * @param tire - tire size in mm
     */
    public Wheel(int rim, int tire)
    {
        this.tire = tire;
        this.rim = rim;
    }

    public double getCircumference(){
        return getDiameterMM() * Math.PI;
    }
    public double getDiameterMM(){
        return rim + 2 * tire;
    }
    public double getDiameterInches(){
        return (double)rim/MM_INCHES + 2 * (double)tire/MM_INCHES;
    }
}
