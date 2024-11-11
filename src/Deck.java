import java.util.ArrayList;

public class Deck
{
    public ArrayList<Card> deck = new ArrayList<>();

    public Deck()
    {
        for (int i = 0; i < 52; i++)
        {
            this.deck.add(new Card(Suit.fromValue((i / 13) + 1), Rank.fromValue((i % 13) + 1)));
        }
    }

    public String toString()
    {
        StringBuilder results = new StringBuilder("\n");
        for(Card card : deck)
        {
            results.append(card.toString()).append("\n");
        }
        return results.toString();
    }
}
