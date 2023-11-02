public class Bicycle
{
    Wheel wheel;
    Gear gear;

    public Bicycle(){
        this.wheel = new Wheel(622, 25);
        this.gear = new Gear(48,24);
    }
    public Bicycle(Wheel wheel, Gear gear)
    {
        this.wheel = wheel;
        this.gear = gear;
    }

    /**
     * Gear inches express gear ratios in terms of the diameter of an equivalent directly driven wheel, and is calculated as follows:

     * gear inches = wheel diameter in inches × (teeth in front chainring /teeth in rear sprocket)
     * see https://en.wikipedia.org/wiki/Gear_inches
     */
    public double gearInches(){
        return wheel.getDiameterInches() * gear.gearRatio();
    }

    /**
     * Metres of development or roll-out: 
     * 
     * Metres of development = Circumference of drive wheel in metres × 
     * (number of teeth in front chainring / number of teeth in rear sprocket).
     *https://en.wikipedia.org/wiki/Bicycle_gearing
     */
    public double rollOut(){
        return wheel.getCircumference() * gear.gearRatio();
    }

}
