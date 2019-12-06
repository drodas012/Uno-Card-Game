/**
 * The Card class has a Color representing the card color and a Value representing
 * the card value.
 */
public class UnoCard 
{
  enum Color 
  {
    Red, Blue, Green, Yellow, Wild;
	 
    private static final Color[] colors = Color.values();
    public static Color getCardColor(int i)
    {
    	return Color.colors[i];
    }
  }

  enum Value 
  {
    Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, DrawTwo, Skip, Reverse, Wild, Wild_Four;
    private static final Value[] values = Value.values();
    
    public static Value getValue(int i) 
    {
      return values[i];
    }
  }

  private final Color color;
  private final Value value; 
 
    /**
     *
     * @param color
     * @param value
     */
    public UnoCard(final Color color, final Value value) 
  {
    this.color = color;
    this.value = value;
  }

    /**
     * pre-condition: none
     * post-condition: Color
     * activity: returns color of the Uno card.
     */
    public Color getColor() 
  {
    return this.color;
  }

    /**
     * pre-condition: none
     * post-condition: Value
     * activity: returns value of the Uno card.
     */
    public Value getValue() 
  {
    return this.value;
  }

  public String toString() 
  {
    return  color + "_" + value;
  }
}