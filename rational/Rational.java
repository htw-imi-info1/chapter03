
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

    public Rational add(Rational otto){
        return new Rational(
            num*otto.den + otto.num*den,
            den*otto.den);
    }
    
    public String toString(){
        return ""+ num + "/" + den;
    }

}
