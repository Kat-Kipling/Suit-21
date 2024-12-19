import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to handle individual rounds of the game. To be used with another class
 * to handle the overall gameflow.
 */
public class Round
{
    private Deck deck;
    private Player[] players;
    private ArrayList<Player> winningPlayers = new ArrayList<>();
    private boolean roundWon;

    public Round(Deck deck, Player[] players)
    {
        this.deck = deck;
        this.players = players;
        this.roundWon = false;
    }

    public void playRound(Scanner input)
    {
        // Players take turns
        for (Player player : players)
        {
            Card cardToSwap = player.playCard();
            Card newCard = deck.deal();
            input.nextLine(); // Clear input buffer

            if (player.exchange(cardToSwap, newCard))
            {
                System.out.println(cardToSwap + " swapped with " + newCard);
            }

            player.displayHand();

            if (player.hasScored21())
            {
                System.out.println("21! You will win after this round.");
                winningPlayers.add(player);
                roundWon = true;
            }

            System.out.println("Press enter to end round for " + player.getName());
            input.nextLine();
        }
    }

    public boolean isRoundWon()
    {
        return roundWon;
    }

    public ArrayList<Player> getWinningPlayers()
    {
        return this.winningPlayers;
    }
}
