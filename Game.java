
/**
 * A class for handling the game operation
 * player registration, gameplay, and game result are handled here.
 * 
 * @author (Stefan Derian Hartono) 
 * @version (10th April 2017)
 */
import java.util.Scanner;
public class Game
{
    // instance variables - replace the example below with your own

    private Dice dice;
    private Player player1;
    private Player player2;
    private int penalthy; // default value of the penalthy

    /**
     * Constructor which initialize dice only
     */
    public Game()
    {
        this.penalthy = -5;
        this.dice = new Dice();
        setPlayer1("");
        setPlayer2("");
    }

    /**
     * Constructor which initialize dice and penalthy value
     */
    public Game(int penalthy)
    {
        // initialise instance variables
        this.dice = new Dice();
        this.penalthy = -1 * penalthy;
        setPlayer1("");
        setPlayer2("");
    }

    /**
     * Constructor which initialize both players and dice
     */
    public Game(String player1,String player2)
    {
        // initialise instance variables
        this.penalthy = -5;
        this.dice = new Dice();
        setPlayer1(player1);
        setPlayer2(player2);
    }    

    /**
     * Constructor which initialize dice, both players and penalthy
     */
    public Game(String player1,String player2, int penalthy)
    {
        // initialise instance variables
        this.dice = new Dice();
        setPlayer1(player1);
        setPlayer2(player2);
        this.penalthy = -1 * penalthy;
    }

    /**
     * method to set player 1 object
     * @params player1 name 
     */
    public void setPlayer1(String player1){
        this.player1 = new Player(player1);
    }

    /**
     * method to set player 2 object
     * @params player2 name 
     */
    public void setPlayer2(String player2){

        this.player2 = new Player(player2);

    }

    /**
     * method to get player 1 object
     * @return player1 object
     */
    public Player getPlayer1()
    {
        return this.player1;
    }

    /**
     * method to get player 2 object
     * @return player2 object
     */
    public Player getPlayer2(){
        return this.player2;
    }

    /**
     * Constructor which initialize dice, both players and penalthy
     */
    public void setPenalthy(int penalthy)
    {
        this.penalthy = penalthy;
    }

    /**
     * Constructor which initialize dice, both players and penalthy
     */
    public int getPenalthy()
    {
        return this.penalthy;
    }

    /**
     * a method for displaying menu throughout the game 
     * and asking user output in the form of number
     */

    public void displayMenu()
    {
        // I set this as an infinite loop because it is required to run as long as the game is running
        //or in other word it will not terminate until players close X button on the right corner
        while(true){
            int option ;
            option = 0;
            System.out.println ("Welcome to the Simple Board Game");
            System.out.println ("(1) Start/Restart a Game");
            System.out.println ("(2) Play One Round");
            System.out.println ("(3) Display Player's Position");
            System.out.println ("(4) Display Game Help");
            System.out.println ("(5) Exit game");
            System.out.print ("Choose an option : ");

            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            switch (option){

                case 1 :
                restartStartGame();
                break;

                case 2 :
                playOneRound();
                if (checkState()){
                    if(getPlayer1().getPosition() >= 50 || getPlayer2().getPosition() >= 50){
                        finishGame();
                        exitGame();
                    }
                }
                break;

                case 3 :
                displayPosition();
                break;

                case 4 :
                gameHelp();
                break;

                case 5 :
                exitGame();
                System.out.println("Game is exiting, if you want to play again please enter your name again ");
                break;

                default:
                displayError ("no option available for this, Please select only the available option");
                break;
            }
            System.out.println ("");
            

        }

        
    }
    /**
     * exit the game by making player 1 and player 2's name become "".
     */
    public void exitGame ()
    {
        setPlayer1("");
        setPlayer2("");

    }

    /**

     * showing game help

     */
    public void gameHelp()
    {
        System.out.println("Rules and Guide for the game: ");
        System.out.println("1.Enter the player name before starting the game");
        System.out.println("2.Both players' position is 0 ");
        System.out.println("3.Press 2 to roll a dice, it will move your location up to 6 ");
        System.out.println("4.If a player steps on special location with the number of 11, 22, 33, and 44 , the players' location will be subtracted by 5  ");
        System.out.println("5.The first player reach location 50 or more will be the winner and the game will be ended");
        System.out.println("6.If a player reach 50 or more at the same location number and time, the result will be draw and the game is ended");
        System.out.println("7.After the game is ended, If you want to play again, enter your name again and all players' locations are set to 0");
        System.out.println("");
    }

    /**

     * finish the game if one or two player(s) has reached 50

     */
    public void finishGame()
    {
        if (getPlayer1().getPosition() > getPlayer2().getPosition()){
            System.out.println("*** CONGRATULATIONS!!! "+player1.getName() +" have WON this game ***");

        }else if (player1.getPosition() < player2.getPosition()){
            System.out.println("*** CONGRATULATIONS!!! "+player2.getName() +" have WON this game ***");

        }else{
            System.out.println("DRAW, both of you are doing great");

        }
        System.out.println("It is fun isn't it? Want to play again? enter your name again to play again");
        System.out.println("");
    }

    /**

     * Playing one round if game state is 1, otherwise error displayed

     */
    public void playOneRound()
    {
        if (!checkState()){
            displayError("Error : Players have not been set up !");
        }else{
            movePlayer(getPlayer1());
            movePlayer(getPlayer2());
        }
    }

    /**
     * Displaying player position if game state is 1, otherwise error displayed

     */
    public void displayPosition()
    {
        if (!checkState()){
            displayError("Error : Players have not been set up !");
        }else{
            System.out.println("Player "+getPlayer1().getName()+" is on "+getPlayer1().getPosition());
            System.out.println("Player "+getPlayer2().getName()+" is on "+getPlayer2().getPosition());
        }

    }

    /**
     * method for starting or restarting game
     * check the state of the game
     * if the game is running, the game will restart
     * if the game is not running, the game will ask for player's name before starting

     */
    public void restartStartGame()
    {
        if (!checkState())
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter player 1 name: ");
            String name1 = sc.next();
            System.out.print("Enter player 2 name: ");
            String name2 = sc.next();
            setPlayer1(name1);
            setPlayer2(name2);

        }else{
            getPlayer1().resetPosition();
            getPlayer2().resetPosition();
            System.out.println("Game is restarting");
        }

    }

    /**
     * method for displaying error message
     * @params: error, an error message to be displayed

     */

    public void displayError (String error)
    {
        System.out.println(error);
        System.out.println ("");
    }

    /**
     * method for handling the character movement
     * @params: player, a player object which will be altered in term of position

     */
    public void movePlayer (Player player)
    {
        int diceNumber;
        diceNumber = dice.rollDice();
        int previousPosition;
        previousPosition = player.getPosition();
        player.updatePosition(diceNumber);
        System.out.println(player.getName() + " just rolled  "+diceNumber+" and moves from position " + previousPosition +" to "+player.getPosition());
        //if player is reaching special position which results 0 if it is modulated by 11, the player's location reduced by 5
        if (player.getPosition() % 11 == 0){
            System.out.println(" Special position at" + player.getPosition());
            player.updatePosition(getPenalthy());

            if (player.getPosition() < 0){
                player.resetPosition();
            }
            System.out.println(" reducing" + player.getName() + " position by 5 ");
        }
        System.out.println("current " + player.getName() + " position is " + player.getPosition());
    }

    /**
     * method for checking the state of the game by detecting the presence of the player
     * @return: a boolean value which indicate the presence of 2 players
     */
    public boolean checkState(){

        if(getPlayer1().getName().equals("") || getPlayer2().getName().equals(""))
        {
            return false;
        }
        return true;
    }

}
