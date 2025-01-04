import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

public class ScoreCalculator
{
    public boolean hasScored21(EnumMap<Suit, Integer> suitScores)
    {
        for (EnumMap.Entry<Suit, Integer> entry : suitScores.entrySet())
        {
            if (entry.getValue() == 21) {
                return true; // If score 21 is found for any suit, return true
            }
        }
        return false; // If no suit has scored 21, return false
    }

    public int scoreSuit(Suit suitToScore, Hand hand) {
        int suitScore = 0;
        int aceCount = 0;

        // Calculate the score for the given suit and count aces
        for (int i = 0; i < hand.getCurrentSize(); i++) {
            Card card = hand.get(i);
            if (card.getSuit() == suitToScore) {
                if (card.getRank() == Rank.ACE) {
                    aceCount++;
                    suitScore += 11;  // Initially count all Aces as 11
                } else {
                    suitScore += card.getRank().getValue();
                }
            }
        }

        // Adjust score for aces if it exceeds 21
        while (suitScore > 21 && aceCount > 0) {
            suitScore -= 10;  // Convert one Ace from 11 to 1
            aceCount--;
        }

        return suitScore;
    }

    public EnumMap<Suit, Integer> scoreHand(Hand hand)
    {
        EnumMap<Suit, Integer> scores = new EnumMap<>(Suit.class);

        for (Suit suit : Suit.values())
        {
            scores.put(suit, scoreSuit(suit, hand));
        }

        return scores;
    }

    public HashMap<Player, Double> calculateScores(ArrayList<Player> winningPlayers, Player[] allPlayers, int pointPerRound)
    {
        HashMap<Player, Double> playerScores = new HashMap<>();

        if (!winningPlayers.isEmpty())
        {
            double pointsPerWinner = (double) pointPerRound / winningPlayers.size();
            for (Player player : allPlayers)
            {
                if (winningPlayers.contains(player))
                {
                    playerScores.put(player, pointsPerWinner);
                }
                else
                {
                    playerScores.put(player, 0.0);
                }
            }
        }
        else
        {
            for (Player player : allPlayers)
            {
                playerScores.put(player, 0.0); // No winners, everyone gets 0 points
            }
        }
        return playerScores;
    }
}
