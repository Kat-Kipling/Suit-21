import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        int numberOfPlayers = -1;
        Scanner input = new Scanner(System.in);

        while(numberOfPlayers < 2 || numberOfPlayers > 6)
        {
            System.out.println("How many players (2 - 6)?");
            numberOfPlayers = input.nextInt();
            input.nextLine(); // Clear input buffer
            if(numberOfPlayers < 2 || numberOfPlayers > 6)
            {
                System.out.println("Invalid amount of players!");
            }
        }

        Player[] players = new Player[numberOfPlayers];

        for(int i = 0; i < numberOfPlayers; i++)
        {
            System.out.printf("Player %d Name: ", i+1);
            String tempName = input.nextLine();
            players[i] = new Player(tempName,  i+1);
        }

        System.out.println(deck);

        while(deck.getCardCount() > (5 * numberOfPlayers))
        {
            // Main game logic loop
            for(Player player : players)
            {
                // Logic for dealing player hand
                for(int i = 0; i < 5; i++)
                {
                    player.addCard(deck.deal());
                }
            }

            // General gameplay logic per player
            for(Player player : players)
            {
                System.out.println(player.getName() + "'s hand");

                displayHand(player.getHand());
                Card cardToSwap = player.getCard(input.nextInt() - 1); // -1 to allow for 0 based indexing
                Card newCard = deck.deal();
                input.nextLine(); // Clear buffer
                if(player.exchange(cardToSwap, newCard))
                {
                    System.out.println(cardToSwap.toString() + " swapped with " + newCard.toString());
                }
            }

            // Clear hand for next round
            for(Player player : players)
            {
                player.clearHand();
            }
        }
    }

    public static void displayHand(Hand hand)
    {
        System.out.println("Your Hand:");
        for(int i = 0; i < hand.getCurrentSize(); i++)
        {
            System.out.printf("%d. %s%n", i + 1, hand.get(i));
        }
        System.out.print("Choose a card to swap (1 - " + hand.getCurrentSize() + "): ");
    }
}
