import java.util.Dictionary;

public interface HandInterface
{
    public int getCurrentSize();

    public Card add(Card newCard);

    public Card exchange(Card oldCard, Card newCard);

    public void clear();

    public int scoreSuit(Suit suitToScore);
}
