
/**
 * 
 * @author Barne Kleinen
 */
public class VariableScopePlayground
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class VariableScopePlayground
     */
    public VariableScopePlayground()
    {
        // initialise instance variables
        x = 0;
    }

    public void methodWithLocalParameter()
    {
        System.out.println("1. x is  now and here "+x);
        x = x + 2;
        { // this is an internal block
            System.out.println("2. x is now and here "+x);
            int x = 5;
            System.out.println("3. x is  now and here "+x);
            x = x + 13;
            System.out.println("4. x is  now and here "+x);
        }
        System.out.println("5. x is  now and here "+x);
    }

    public void methodWithLocalComplexDeclaration()
    {
        System.out.println("1. x is  now and here "+x);
        x = x + 2;
        { // this is an internal block
            System.out.println("2. x is now and here "+x);
            int x = 5, y = x + 5, z = y*2;
            System.out.println("3. x is "+x + " y is "+y + " z is "+z);
            x = x + 13;
            System.out.println("4. x is "+x + " y is "+y + " z is "+z);
        }
        System.out.println("5. x is  now and here "+x);
    }
}
