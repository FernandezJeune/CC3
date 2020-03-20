
package item;
import java.util.Random;

/**
 * This is the blue print of the dice that gives a random number from 1 to 6.
 * @author Fernandez, Jeune Vincent D.
 */
public class Dice {
    
    Random r;
    
    /**
     * This method instantiate a Random object defaultly as it is constructed.
     */
    public Dice() {
        r = new Random();
    }
    
    /**
     * This method returns a random number ranging from 1 to 6.
     * @return random number ranging number of 1 to 6.
     */
    public int roll() {
        return  r.nextInt(6) + 1;
    }
}
