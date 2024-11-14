public class Card
{
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString()
    {
        return rank + " OF " + suit;
    }
}
