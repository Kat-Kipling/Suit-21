import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Deck
{
    public Stack<Card> deck = new Stack<>();

    public Deck()
    {
        this.deck = newShuffledDeck();
    }

    private Stack<Card> newShuffledDeck()
    {
        ArrayList<Card> tempArray = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            tempArray.add(new Card(
                    Suit.values()[(i / 13)],
                    Rank.values()[(i % 13)])
            );
        }

        Stack<Card> tempStack = new Stack<>();
        for(int i = 0; i < 52; i++)
        {
            Card tempCard = tempArray.get(rand.nextInt(tempArray.size()));
            tempArray.remove(tempCard);
            tempStack.push(tempCard);
        }
        return tempStack;
    }

    public String toString()
    {
        StringBuilder deckString = new StringBuilder();
        for(Card card : this.deck)
        {
            deckString.append(card).append("\n");
        }
        return deckString.toString();
    }
}
