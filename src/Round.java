import java.util.Scanner;

/**
 * Class to handle individual rounds of the game. To be used with another class
 * to handle the overall gameflow (e.g. amount of rounds)
 */
public class Round
{
    private Deck deck;
    private Player[] players;
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
            player.displayHand();

            System.out.print("Choose a card to swap (1 - 5): ");
            Card cardToSwap = player.getCard(input.nextInt() - 1);  // -1 for 0-based index
            Card newCard = deck.deal();
            input.nextLine(); // Clear input buffer

            if (player.exchange(cardToSwap, newCard))
            {
                System.out.println(cardToSwap + " swapped with " + newCard);
            }

            player.displayHand();

            if (player.hasScored21())
            {
                System.out.println("21!!! YOU WIN. GAME WILL FINISH AFTER THIS ROUND.");
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
}
