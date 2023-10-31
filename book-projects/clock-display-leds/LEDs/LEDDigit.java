package LEDs;
import java.awt.Color;
import java.util.Map;
import java.util.HashMap;

/**
 * Write a description of class DigitDisplay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LEDDigit
{
    // instance variables - replace the example below with your own

    public static int SEG_H = 8;
    public static int SEG_W = 60;
    private static int NO_OF_SEGMENTS_DIGIT = 7;
    private static int NO_OF_SEGMENTS = NO_OF_SEGMENTS_DIGIT+2; // for the "M"
    private Segment[] segments = new Segment[NO_OF_SEGMENTS];

    private static final int default_top = 20;
    private int top = default_top;
    private static final int default_left = 20;
    private int left = default_left;
    public static int GAP = 5;
    public static final int WIDTH = SEG_W+2*GAP;
    public static final int VERTICAL_MIDDLE = GAP+SEG_W;
    /*      4
     *    -----
     *  0 |   | 2
     *    | 5 |
     *    -----
     *  1 |   | 3
     *    | 6 |
     *    -----
     */
    private static byte[] bits;
    static{
        bits = new byte[10];
        bits[0] = 0B001011111;
        bits[1] = 0B000001100;
        bits[2] = 0B001110110;
        bits[3] = 0B001111100;
        bits[4] = 0B000101101;
        bits[5] = 0B001111001;
        bits[6] = 0B001111011;
        bits[7] = 0B000011100;
        bits[8] = 0B001111111;
        bits[9] = 0B001111101;

    }
    private static Map<Character, Integer>  bitsMapCharacters = new HashMap<>();
    /*      
     *   -------
     *   |\   /| 
     *   |8\ /9| 
     *   |     |
     *   -------
     *   |     | 
     *   |     |
     *   -------
     */
    /*      4
     *    -----
     *  0 |   | 2
     *    | 5 |
     *    -----
     *  1 |   | 3
     *    | 6 |
     *    -----
     */

    static{
        bitsMapCharacters.put('P',0B000110111);
        bitsMapCharacters.put('p',0B000110111);
        bitsMapCharacters.put('A',0B000111111);
        bitsMapCharacters.put('a',0B000111111);
        bitsMapCharacters.put('M',0B110001111);
        bitsMapCharacters.put('m',0B110001111);
    }
    // these strings need to be defined in Canvas!
    //private String[] colors = {"black","blue","yellow","green", "magenta","orange","red"};
    private String[] colors = {"led","led","led","led","led","led","led"};
    protected Canvas canvas;
    int[][] coords;
    public int getUpperVerticalsTop(){
        return top+GAP;
    }

    public LEDDigit(int left, int top, Canvas canvas){
        this.left = left;
        this.top = top;
        int HORIZONTALS_LEFT = left+2*GAP;
        int VERTICALS_ON_RIGHT_X = left+SEG_W+2*GAP;
        int UPPER_VERTICALS_TOP = getUpperVerticalsTop();
        int LOWER_VERTICALS_TOP = top+SEG_W+3*GAP;
        int[][] coords_constructor = {{left,UPPER_VERTICALS_TOP}, //
                {left,LOWER_VERTICALS_TOP},
                {VERTICALS_ON_RIGHT_X,UPPER_VERTICALS_TOP}, //
                {VERTICALS_ON_RIGHT_X,LOWER_VERTICALS_TOP},

                //{LEFT+GAP,TOP+GAP+SEG_W},
                {HORIZONTALS_LEFT,top},
                {HORIZONTALS_LEFT,top+VERTICAL_MIDDLE},
                {HORIZONTALS_LEFT,top+VERTICAL_MIDDLE* 2 + GAP},
            };
        coords = coords_constructor; // necessary due to Java array literals restrictions
        setCanvas(canvas);
    }

    public void setCanvas(Canvas canvas){
        this.canvas = canvas;

        int width = 60, height = 8; 
        int i = 0;
        for (; i<4; i++)
            segments[i] = new Segment(SEG_H, SEG_W,coords[i][0],coords[i][1],colors[i], canvas);
        for (; i<NO_OF_SEGMENTS_DIGIT; i++)
            segments[i] = new Segment(SEG_W, SEG_H,coords[i][0],coords[i][1],colors[i], canvas);

        initMDiagonals();
    }
    private void initMDiagonals(){
        int TOP = getUpperVerticalsTop();
        int width = (int)(0.8 * SEG_W);
        segments[7] = new Segment(width, SEG_H,getLeft()+3*GAP,TOP,LEDClockDisplay.COLOR,canvas);
        segments[7].setAngle(60);
        segments[8] = new Segment(width, SEG_H,getLeft()+2*GAP+SEG_W,TOP+5,LEDClockDisplay.COLOR,canvas);
        segments[8].setAngle(120);
    }

    public void display(byte bits){
        for (int segment = 0; segment < NO_OF_SEGMENTS; segment ++){
            if ((bits >> segment & 1) == 1){
                segments[segment].makeVisible();
            }
            else {
                segments[segment].makeInvisible();
            }
        }
    }

    public void display(int n){ 
        display(bits[n]);
    }

    public void displayChar(char c){
        int bits= bitsMapCharacters.get(c);
        display((byte)bits);
    }

    //public static void main(String[] args){ show();}
    public static LEDDigit getTestInstance(){

        Canvas canvas = LEDClockDisplay.testInstance("DigitDisplay Tester").getCanvas();
        LEDDigit dd = new LEDDigit(default_left,default_top, canvas);

        dd.display(8);
        return dd;
    }

    public static LEDDigit testAll(){

        Canvas canvas = LEDClockDisplay.testInstance("DigitDisplay Tester").getCanvas();
        LEDDigit ndd = new LEDDigit(default_left,default_top, canvas);
        for (int i = 0;i<10;i++){
            ndd.display(i);
            canvas.wait(1000);
        }
        return ndd;
    }

    public static LEDDigit testAllAMPM(){
        Canvas canvas = LEDClockDisplay.testInstance("APMDisplay Tester").getCanvas();
        LEDDigit ndd = new LEDDigit(20,20,
                canvas);

        // for (int i = 0;i<10;i++){
        // ndd.display(i);
        // Canvas.getCanvas().wait(1000);
        // }
        char[] all = {'A','P','M'};
        //{'M'};
        for (int i = 0;i<all.length;i++){
            ndd.displayChar(all[i]);
            canvas.wait(1000);
        }
        return ndd;
    }

    public int getLeft(){return left;}

    public int getTop(){return top;}

}
