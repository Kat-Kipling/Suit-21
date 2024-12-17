import java.util.Scanner;
import java.util.EnumMap;

public class Game
{
    private Player[] players;
    private Deck deck;
    private int pointPerRound;

    public Game(int pointPerRound, int numberOfPlayers)
    {
        this.pointPerRound = pointPerRound;
        this.deck = new Deck();
        this.players = new Player[numberOfPlayers];
    }

    public void startGame()
    {
        Scanner input = new Scanner(System.in);
        boolean gameWon = false;
        DisplayStrategy consoleDisplay = new ConsoleDisplayStrategy();

        // Setup players
        for (int i = 0; i < players.length; i++)
        {
            System.out.printf("Player %d Name: ", i + 1);
            String name = input.nextLine();
            players[i] = new Player(name, i + 1, consoleDisplay, this.deck);
        }

        // Main game loop
        while (deck.getCardCount() > players.length && !gameWon)
        {
            Round round = new Round(deck, players);
            round.playRound(input); // Start a round

            // Check if the round has a winner
            if (round.isRoundWon())
            {
                gameWon = true;  // If any player wins, the game is won
            }
        }

        // After the game ends, you can calculate the score or do any other game-end logic
        if (gameWon)
        {
            System.out.println("Game over! There is a winner.");

        }
        else
        {
            System.out.println("Nobody scored 21 before deck ran out. Game over.");
        }
    }
}
