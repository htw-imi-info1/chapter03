
/**
 * Write a description of class Editor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Editor
{
 class Rechteck{
    public Rechteck(int laenge, int breite){}}

    /**
     * Constructor for objects of class Editor
     */
    public Editor(){}
    public Editor(String x, int y)
    {
       
    }
    /**
     3.26 Schreiben Sie die Signatur eines Konstruktors, 
    der zu folgender Objekterzeugung passt:  
    
    new Editor (“readme.txt”, -1)
    **/
    public static void test(){
        new Editor ("readme.txt", -1);
    }
/**
 *     
    3.27 Schreiben Sie Java-Anweisungen, die eine Variable 
    fenster vom Typ Rechteck definieren, anschließend ein 
    Rechteck-Objekt erzeugen und es dann dieser Variablen 
    zuweisen. Der Konstruktor der Klasse Rechteck hat zwei 
    int-Parameter.
 */
    public void test2(){
        //deklaration:
        Rechteck fenster;
        fenster = new Rechteck(5,4);
    }
  
}
