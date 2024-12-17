import java.util.EnumMap;

public interface HandInterface
{
    public int getCurrentSize();

    public Card add(Card newCard);

    public boolean exchange(Card oldCard, Card newCard);

    public void clear();

    public int scoreSuit(Suit suitToScore);
  
    public EnumMap<Suit, Integer> scoreHand();
  
    public Card get(int index);

    public Card get(Card card);
}
