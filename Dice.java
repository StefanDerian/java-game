
/**
 * A class for handling dice object
 * the dice only perform as a random number generator between 1 to 6.
 * 
 * @author (Stefan Derian Hartono) 
 * @version (a version number or a date)
 */

import java.util.Random;

public class Dice
{
    // instance variables - replace the example below with your own
    
    
    /**
     * Constructor for objects of class Dice
     */
    public Dice()
    {
        // initialise instance variables
    }
    
     /**
     * a method for rolling a dice randomly
     * @return value between 1 to 6
     */
    public int rollDice()
    {
        Random rand = new Random();

        return rand.nextInt(6) + 1; // incremented by 1 because the minimum number generated is 0
    }
   
    
    
}
