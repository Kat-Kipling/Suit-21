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
            System.out.println("Game is being played...");
            System.out.println("Dealing cards...");
            for(Player player : players)
            {
                System.out.println("Dealing....");
                for(int i = 0; i < 5; i++)
                {
                    player.addCard(deck.deal());
                }
            }
        }
    }
}
