import java.util.Collections;
import java.util.Stack;
import java.util.ArrayList;

public class Deck
{
    private static final int NUM_CARDS_IN_DECK = 52;

    public Stack<Card> getDeck() {
        return deck;
    }

    private Stack<Card> deck;

    public Deck()
    {
        this.deck = newShuffledDeck();
    }

    private Stack<Card> newShuffledDeck()
    {
        ArrayList<Card> tempArray = new ArrayList<>();
        for (int i = 0; i < NUM_CARDS_IN_DECK; i++) {
            tempArray.add(new Card(
                    Suit.values()[(i / 13)],
                    Rank.values()[(i % 13)])
            );
        }

        Collections.shuffle(tempArray); // Shuffle the cards using Collections.shuffle
        Stack<Card> tempStack = new Stack<>();
        tempStack.addAll(tempArray); // Add all shuffled cards to the stack
        return tempStack;
    }

    public Card deal()
    {
        if (deck.isEmpty()) {
            throw new IllegalStateException("No cards left in the deck");
        }
        return deck.pop(); // Pop a card from the deck
    }

    public String toString()
    {
        StringBuilder deckString = new StringBuilder();
        for (Card card : this.deck)
        {
            deckString.append(card).append("\n");
        }
        return deckString.toString();
    }

    public int getCardCount() {
        return deck.size(); // Use the stack's built-in size method
    }
}
