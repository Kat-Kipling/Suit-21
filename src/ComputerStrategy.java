public class ComputerStrategy implements PlayerStrategy
{
    private ScoreCalculator scoreCalculator = new ScoreCalculator();

    @Override
    public Card chooseCardToPlay(Player player, Hand hand) {
        Card cardToRemove = null;
        int maxSuitScore = 0;
        Suit targetSuit = null;

        // Determine the target suit (closest to 21 without exceeding it)
        for (Suit suit : Suit.values()) {
            int suitScore = scoreCalculator.scoreSuit(suit, hand);
            if (suitScore <= 21 && suitScore > maxSuitScore) {
                maxSuitScore = suitScore;
                targetSuit = suit;
            }
        }

        // Find a card that is the least useful
        for (Card card : hand.getHand()) {
            if (!card.getSuit().equals(targetSuit)) {
                cardToRemove = card;
                break;
            }
        }

        // If all cards are in the target suit, remove the lowest value card
        if (cardToRemove == null && targetSuit != null)
        {
            cardToRemove = hand.getLowestValueCardInSuit(targetSuit);
        }

        return cardToRemove;
    }

    @Override
    public boolean exchange(Card cardToExchange, Card newCard, Hand hand, Player player)
    {
        if (hand.exchange(cardToExchange, newCard))
        {
            player.setSuitScores(player.scoreHand());
            return true;
        }
        else return false;
    }
}


