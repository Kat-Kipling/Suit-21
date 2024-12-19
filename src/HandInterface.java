import java.util.EnumMap;

public interface HandInterface
{
    public int getCurrentSize();

    public boolean add(Card newCard);

    public boolean exchange(Card oldCard, Card newCard);

    public void clear();
  
    public Card get(int index);

    public Card get(Card card);

    Card getLowestValueCardInSuit(Suit targetSuit);
}
