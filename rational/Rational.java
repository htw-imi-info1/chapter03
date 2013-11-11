
/**
 * Represents a Rational Number.
 * 
 * @author Barbara Kleinen
 * @version 04.11.2013
 */
public class Rational
{
    private int num;
    private int den;

    /**
     * Constructor for objects of class Rational
     */
    public Rational(int numerator,int denominator)
    {
        this.num = numerator;
        this.den = denominator;
    }

    public Rational add(Rational r){
        return new Rational(
            this.num*r.den + r.num*this.den,
            this.den*r.den);
    }

}
