
/**
 * Represents a Fraction.
 * 
 * @author Barne Kleinen
 */
public class Fraction
{
    private int num;
    private int den;

    /**
     * Constructor for objects of class Rational
     */
    public Fraction(int numerator,int denominator)
    {
        this.num = numerator;
        this.den = denominator;
    }

    public Fraction add(Fraction other){
        return new Fraction(
            this.num * other.den + other.num * this.den,
            this.den* other.den);
    }
    public String toString(){
        return ""+ num+"/" + den;
    }

}
