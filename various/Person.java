
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String  name;

    /**
     * Constructor for objects of class Person
     */
    public Person(String name)
    {
        // initialise instance variables
       this.name = name;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void changeName(String name)
    {
        this.name = name;
    }
    public String getName(){return name;}
}
