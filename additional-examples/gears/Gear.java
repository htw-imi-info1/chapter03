/**
 * Represents a single Gear for a Bicycle
 * 
 * https://en.wikipedia.org/wiki/Bicycle_gearing
 *
 */
public class Gear
{
    int chainring; 
    int sprocket;
    public Gear(int chainring, int sprocket)
    {
        this.chainring = chainring;
        this.sprocket = sprocket;
    }
    
    public double gearRatio(){
        return chainring/sprocket;
    }

}
