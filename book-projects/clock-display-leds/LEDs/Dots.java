package LEDs;
import java.awt.Color;

/**
 * Two litte circles representing the colon in HH:mm
 *
 * @author Barne Kleinen
 */
public class Dots
{
    Canvas canvas;
    public static int DOT_SIZE = 8;
    public static int DOT_GAP = 60;
    public static int NO_OF_SEGMENTS = 2;
    private Segment[] segments = new Segment[NO_OF_SEGMENTS];
 

    public Dots(int x, int y, String color, Canvas canvas){
        segments[0] = new Segment(DOT_SIZE, DOT_SIZE,x,y,color, canvas);
        segments[1] = new Segment(DOT_SIZE, DOT_SIZE,x,y+DOT_GAP,color, canvas);
        display();
    }

    public void display(){
        for (int segment = 0; segment < NO_OF_SEGMENTS; segment ++){
            segments[segment].makeVisible();
        }
        //  segments[segment].makeInvisible();
    }

    //public static void main(String[] args){ show();}
    public static Dots getTestInstance(){
        Dots dd = new Dots(20,20, "led",new Canvas("Dots Test", 470, 200, 
                new Color(53, 9, 9)));
        dd.display();
        return dd;
    }

}
