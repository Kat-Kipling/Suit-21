import java.util.Objects;

public class Card
{
    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public boolean equals(Card cardToCompare)
    {
        return cardToCompare.toString().equals(this.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}
