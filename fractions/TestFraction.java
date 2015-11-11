
/**
 * Demonstrates the Fraction Class.
 * 
 * @author B. Kleinen 
 */
public class TestFraction
{
    public void testWith2Fractions(){
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(1, 3);
        Fraction sum = a.add(b);
        System.out.println(a + " + " + b +" = " + sum);
    }

    public void testWith3Fractions(){
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(1, 3);
        Fraction c = new Fraction(1, 6);
        Fraction sum = a.add(b).add(c);
         System.out.println(a + " + " + b + " + " + c + " = " + sum);
    }

}
