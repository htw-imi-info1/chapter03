
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
        num = numerator;
        den = denominator;
    }

    public Rational add(Rational r){
        return new Rational(
            num*r.den + r.num*den,
            den*r.den);
    }
    public String toString(){
        return ""+ num + "/" + den;
    }

}
