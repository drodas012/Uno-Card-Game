import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * The Game class contains the game logic and behaviors necessary to play the game.
 */
public class Game
{
    private int currentPlayer;
    private String[] playerIds;

    private UnoDeck deck;
    private ArrayList<ArrayList<UnoCard>> playerHand;
    private ArrayList<UnoCard> stockPile;
	
    private UnoCard.Color validColor;
    private UnoCard.Value validValue;
    
    boolean gameDirection;
    
    /**
     *
     * @param pids
     */
    public Game(String[] pids)
    {
        deck = new UnoDeck();
        deck.shuffle();		//the deck must be shuffled at the beginning of each game
        stockPile = new ArrayList<UnoCard>();

        playerIds = pids;
        currentPlayer = 0;
        gameDirection = false;
        
        playerHand = new ArrayList<ArrayList<UnoCard>>(); //playerhand is an arraylist of arraylists because there are mulitple players with different hands(their own arraylists)
        
        for(int i = 0; i < pids.length; i++)
        {
        	ArrayList<UnoCard> hand = new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7))); //the hand is an arraylist of 7 uno cards
        	playerHand.add(hand);
        }
    }
    
    /**
     *
     * @param game
     * pre-condition: Game game
     * post-condition: none
     * activity: places the first card of the deck in the stockpile and handles any outliers
     */
    public void start(Game game)
    {
    	//places the first card of the deck in the stockpile
    	UnoCard card = deck.drawCard();
    	validColor = card.getColor();
    	validValue = card.getValue();
    	
    	//Below are the outlier cases for when an action card is the first card placed in the stockpile when the game starts.
    	
    	/*outlier case... if the first card is a wild card then the game starts over*/
            if(card.getValue() == UnoCard.Value.Wild)
    	{
                    start(game); //principal of recursion... a method calling itself
    	}
    	
    	/*outlier case... if the first card is a draw four card or draw two card then the game
    	  will restart itself because the first player should not have to draw cards when the game starts*/
    	if(card.getValue() == UnoCard.Value.Wild_Four || card.getValue() == UnoCard.Value.DrawTwo)
    	{
                    start(game);
    	}
    	
    	//outlier case... if the first card is a skip then the first player will be skipped
    	if(card.getValue() == UnoCard.Value.Skip)
    	{
                              JLabel message = new JLabel(playerIds[currentPlayer] + " was skipped!");  //must be before the logic bc we change the current player.
                              message.setFont(new Font("Arial", Font.BOLD, 48));
                              JOptionPane.showMessageDialog(null, message);
        	if(gameDirection == false)
        	currentPlayer = (currentPlayer + 1) % playerIds.length;
        	
        	else if(gameDirection == true)
        	{
        		currentPlayer = (currentPlayer - 1) % playerIds.length;
        		if(currentPlayer == -1)
        		{
        			currentPlayer = playerIds.length - 1;
        		}
        	}
    	}
    	
    	//outlier case... if the first card is a reverse then the last player will start the game
    	if(card.getValue() == UnoCard.Value.Reverse)
        {
                JLabel message = new JLabel("The game direction changed!"); //must be before the logic bc we change the current player.
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message); 
        	gameDirection ^= true; //xor-equals true, which will flip it every time, and without any branching or temporary variables.
        	currentPlayer = playerIds.length - 1; //it has to be the last player bc its the first turn of the game.
        }
    	
        stockPile.add(card);
    }

    /**
     * pre-condition: none
     * post-condition: UnoCard card
     * activity: returns the top card in the stockpile
     */
    public UnoCard getTopCard()
    {
    	return new UnoCard(validColor, validValue);
    }
    
    /**
     * pre-condition: none
     * post-condition: returns an ImageIcon of the top card in the stockpile
     * activity: returns an image of the top card in the stockpile
     */
    public ImageIcon getTopCardImage()
    {
        return new ImageIcon(validColor + "_" + validValue + ".png");
    }
    
    /**
     * pre-condition: none
     * post-condition: boolean
     * activity: returns true if any of the players have no cards
     */
    public boolean isGameOver() 
    {
        for (String player : this.playerIds) 
        {
            if (hasEmptyHand(player)) 
            {
                return true;
            }
        }

        return false;
    }

    /**
     * pre-condition: none
     * post-condition: String
     * activity: returns the current player
     */
    public String getCurrentPlayer()
    {
        return this.playerIds[this.currentPlayer];
    }
    
    /**
     *
     * @param i
     * pre-condition: int i
     * post-condition: String
     * activity: returns the name of the player i turns before the current player
     */
    public String getPreviousPlayer(int i)
    {
        int index = this.currentPlayer - i;
        if(index == -1)
        {
            index = playerIds.length - 1;
        }
        return this.playerIds[index];
    }
     
    /**
     *
     * pre-condition: none
     * post-condition: String[]
     * activity: returns the names of all the players
     */
    public String[] getPlayers()
    {
        return playerIds;
    }

    /**
     *
     * @param pid
     * pre-condition: String
     * post-condition: ArrayList<UnoCard> 
     * activity: returns the hand of the pid (player) that is sent in the arguments
     */
    public ArrayList<UnoCard> getPlayerHand(String pid)
    {
    	//returns the hand of the player that is called
    	int idIdx = Arrays.asList(playerIds).indexOf(pid); //Turns the String array playerIds into a list and finds the first index of playerid and returns the index
    	return playerHand.get(idIdx);
    }

    /**
     *
     * @param pid
     * pre-condition: String
     * post-condition: int
     * activity: returns the size of pid's (the player's) hand
     */
    public int getPlayerHandSize(String pid) 
    {
        return getPlayerHand(pid).size();
    }
    
    /**
     *
     * @param pid
     * @param choice
     * pre-condition: String, int
     * post-condition: UnoCard
     * activity: returns the Uno card at the index of the pid (players) arraylist
     */
    public UnoCard getPlayerCard(String pid, int choice) 
    {
        ArrayList<UnoCard> hand = getPlayerHand(pid);
        assert choice >= 0 || choice < hand.size();
        return hand.get(choice);
    }

    /**
     *
     * @param pid
     * pre-condition: String
     * post-condition: boolean
     * activity: returns true if the pid (player) has an empty hand
     */
    public boolean hasEmptyHand(String pid)
    {
    	return getPlayerHand(pid).isEmpty();
    }

    /**
     * 
     * @param card
     * pre-condition: UnoCard
     * post-condition: boolean
     * activity: returns true if the card matches the color or value of the top card in the stockpile
     */
    private boolean validCardPlay(UnoCard card) 
    {
        return card.getColor() == validColor || card.getValue() == validValue;
    }

    /**
     * 
     * @param pid
     * pre-condition: String
     * post-condition: none
     * activity: checks to see if the player that is playing is the current player
     * @throws InvalidPlayerTurnException 
     */
    private void checkPlayerTurn(String pid) throws InvalidPlayerTurnException 
    {
        if (this.playerIds[this.currentPlayer] != pid) 
        {
            throw new InvalidPlayerTurnException("It is not " + pid + "'s turn'", pid);
        }
    }

    /**
     *
     * @param pid
     * pre-condition: String
     * post-condition: none
     * activity: the pid (player) try to draw a card.
     * @throws InvalidPlayerTurnException
     */
    public void submitDraw(String pid) throws InvalidPlayerTurnException 
    {
        checkPlayerTurn(pid);

        if (deck.isEmpty()) 
        {
            deck.replaceDeckWith(stockPile);
            deck.shuffle();
        }

        getPlayerHand(pid).add(deck.drawCard());
        if(gameDirection == false)
        currentPlayer = (currentPlayer + 1) % playerIds.length;
        
        else if(gameDirection == true)
        {
        	currentPlayer = (currentPlayer - 1) % playerIds.length;
        	if(currentPlayer == -1)
        	{
        		currentPlayer = playerIds.length -1;
        	}
        }
    }

    /**
     *
     * @param color
     * pre-condition: UnoCard.Color
     * post-condition: none
     * activity: sets the color of the validColor ( the color of the top card in the stockpile)
     */
    public void setCardColor(UnoCard.Color color){
        validColor = color;
    }
    
    /**
     *
     * @param pid
     * @param card
     * @param declaredColor
     * pre-condition: String, UnoCard, UnoCard.Color
     * post-condition: none
     * activity: the pid (player) will attempt to submit a card. If the card is not valid the game will throw an exception.
     * @throws InvalidColorSubmissionException
     * @throws InvalidValueSubmissionException
     * @throws InvalidPlayerTurnException
     */
    public void submitPlayerCard(String pid, UnoCard card, UnoCard.Color declaredColor) 
        throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException
    {
        checkPlayerTurn(pid);

        ArrayList<UnoCard> pHand = getPlayerHand(pid);

        if (!validCardPlay(card))
        {
        	if(card.getColor() == UnoCard.Color.Wild)
        	{
        		validColor = card.getColor();
        		validValue = card.getValue();
        	}
            if (card.getColor() != validColor)
            {
               JLabel message = new JLabel("Invalid player move, expected color: " + validColor + "\t but got color: " + card.getColor());
               message.setFont(new Font("Arial", Font.BOLD, 48));
               JOptionPane.showMessageDialog(null, message);
            	throw new InvalidColorSubmissionException(
                        "Invalid player move, excpeted color: " + validColor 
                        + " but got color: " + card.getColor(), 
                        card.getColor(), validColor);
            }
            else if (card.getValue() != validValue) 
            {
            	throw new InvalidValueSubmissionException(
                        "Invalid player move: expected value: " + validValue
                        + " but got value: " + card.getValue(), 
                        card.getValue(), validValue);
            }
        }

        pHand.remove(card);
             if(hasEmptyHand(this.playerIds[currentPlayer]) == true)
            {
                JLabel message = new JLabel(this.playerIds[currentPlayer] +  " won the game!  Thank you for playing!");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                System.exit(0);
            }
        validColor = card.getColor();
        validValue = card.getValue();
        stockPile.add(card);
        if(gameDirection == false) //reverse hasn't been played yet or this is the even number of times its been played
        currentPlayer = (currentPlayer + 1) % playerIds.length;
        else if(gameDirection = true) //reverse has been played
        {
        	currentPlayer = (currentPlayer - 1) % playerIds.length;
        	if(currentPlayer == -1)
        	{
        		currentPlayer = playerIds.length - 1;
        	}
        }

        if (card.getColor() == UnoCard.Color.Wild) 
        {
            validColor = declaredColor;
        }
        
        if(card.getValue() == UnoCard.Value.DrawTwo)
        {
        	pid = playerIds[currentPlayer];
        	getPlayerHand(pid).add(deck.drawCard());
        	getPlayerHand(pid).add(deck.drawCard());
        	JLabel message = new JLabel(pid + " drew 2 cards!");
               message.setFont(new Font("Arial", Font.BOLD, 48));
               JOptionPane.showMessageDialog(null, message);
        }
        
        if(card.getValue() == UnoCard.Value.Wild_Four)
        {
        	pid = playerIds[currentPlayer];
        	getPlayerHand(pid).add(deck.drawCard());
        	getPlayerHand(pid).add(deck.drawCard());
        	getPlayerHand(pid).add(deck.drawCard());
        	getPlayerHand(pid).add(deck.drawCard());
        	JLabel message = new JLabel(pid + " drew 4 cards!");
               message.setFont(new Font("Arial", Font.BOLD, 48));
               JOptionPane.showMessageDialog(null, message);
        }

        if(card.getValue() == UnoCard.Value.Skip)
        {
        	JLabel message = new JLabel(playerIds[currentPlayer] + " was skipped!");
               message.setFont(new Font("Arial", Font.BOLD, 48));
               JOptionPane.showMessageDialog(null, message);
        	if(gameDirection == false)
        	currentPlayer = (currentPlayer + 1) % playerIds.length;
        	
        	else if(gameDirection == true)
        	{
        		currentPlayer = (currentPlayer - 1) % playerIds.length;
        		if(currentPlayer == -1)
        		{
        			currentPlayer = playerIds.length - 1;
        		}
        	}
        }
        
        if(card.getValue() == UnoCard.Value.Reverse)
        {
        	JLabel message = new JLabel(pid + " changed the game direction!");
               message.setFont(new Font("Arial", Font.BOLD, 48));
               JOptionPane.showMessageDialog(null, message);
        	gameDirection ^= true; //xor-equals true, which will flip it every time, and without any branching or temporary variables.
        	if(gameDirection == true)
        	{
        		currentPlayer = (currentPlayer - 2) % playerIds.length;
            	if(currentPlayer == -1)
            	{
            		currentPlayer = playerIds.length - 1;
            	}
            	
            	else if(currentPlayer == -2)
            	{
            		currentPlayer = playerIds.length - 2;
            	}
        	}
        	else if(gameDirection == false)
        	{
        		currentPlayer = (currentPlayer + 2) % playerIds.length;
        	}
        }
    }
}

class InvalidPlayerTurnException extends Exception 
{
    String playerId;

    public InvalidPlayerTurnException(String message, String pid) 
    {
        super(message);
        playerId = pid;
    }

    public String getPid() 
    {
        return playerId;
    }
}

class InvalidColorSubmissionException extends Exception 
{
    private UnoCard.Color expected;
    private UnoCard.Color actual;

    public InvalidColorSubmissionException(String message, UnoCard.Color actual, UnoCard.Color expected) 
    {
        this.actual = actual;
        this.expected = expected;
    }
}

class InvalidValueSubmissionException extends Exception 
{
    private UnoCard.Value expected;
    private UnoCard.Value actual;                

    public InvalidValueSubmissionException(String message, UnoCard.Value actual, UnoCard.Value expected) 
    {
        this.actual = actual;
        this.expected = expected;
    }
}