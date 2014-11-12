
/**
 * Write a description of class TestRational here.
 * 
 * @author B. Kleinen 
 */
public class TestRational
{
    public static void testWith2Instances(){
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 3);
        Rational sum = a.add(b);
        System.out.println(a + " + " + b +" = " + sum);
    }

    public static void testWith3Instances(){
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 3);
        Rational c = new Rational(1, 6);
        Rational sum = a.add(b).add(c);
        System.out.println(a + " + " + b + " + " + c + " = " + sum);
    }

    
}
