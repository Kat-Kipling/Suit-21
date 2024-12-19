import java.util.Scanner;

public class PlayerFactory
{
    private Scanner input;

    public PlayerFactory(Scanner input)
    {
        this.input = input;
    }

    public Player[] createPlayers(int numberOfPlayers, ConsoleDisplayStrategy consoleDisplay)
    {
        Player[] players = new Player[numberOfPlayers];

        for (int i = 0; i < players.length; i++)
        {
            System.out.printf("Enter name for Player %d (type 'Computer' for an AI player): ", i + 1);
            String name = input.nextLine().trim();

            // Determine the strategy based on the name
            PlayerStrategy playerStrategy = name.equalsIgnoreCase("Computer")
                    ? new ComputerStrategy()  // Assign AI strategy
                    : new HumanStrategy(input); // Assign human strategy

            players[i] = new Player(name, consoleDisplay, playerStrategy);
        }

        return players;
    }
}
