
/**
 * A class for handling player data
 * player's position and name are saved in this class.
 * 
 * @author (Stefan Derian Hartono) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
   
    
    private int position;
    
    private String name;
    
    

    /**
     * Constructor for objects of class Player
     */
    public Player (String name)
    {
        // initialise instance variables
        this.position = 0;
        this.name = name;
    }
    
     /**
     *a function for returning the current position of the player
     *@return: position of the player
     */
    
    public int getPosition()
    {
        return this.position;
    }
     /**
     *a function for returning the name of the player
     *@return: this.name, the name of the player
     */
    public String getName()
    {
        return this.name;
    }
     /**
     *reset player's location by 0
     */
    public void resetPosition ()
    {
        this.position = 0;
        
    }
     /**
     * a function to increment or decrement player position by dice parameter
     * @params: dice, the number of position the player will move can be either positive or negative if the player get a penalthy ,if addPosition is true then the position will be incremented otherwise decremented
     */
    
    public void updatePosition(int dice){
            this.position += dice;
    }
   
}
