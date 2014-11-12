
/**
 * Write a description of class PrimitiveVSReference here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrimitiveVSReference
{
   public static void showInt(){

        int a;
        int b;
        a = 32;
        b = a;
        a = a + 1;
        System.out.println(b);}
    public static void showPerson(){
 
        Person a;
        Person b;a = new Person("Everett");
        b = a;a.changeName("Delmar");
        System.out.println(b.getName());

    }
}
