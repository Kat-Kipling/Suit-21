import java.util.Scanner;

public class GameSetup
{
    private Scanner input;

    public GameSetup(Scanner input)
    {
        this.input = input;
    }

    public int getNumberOfPlayers()
    {
        int numberOfPlayers = -1;
        while (numberOfPlayers < 2 || numberOfPlayers > 6)
        {
            System.out.println("How many players (2 - 6)?");
            numberOfPlayers = input.nextInt();
            input.nextLine(); // Clear input buffer
            if (numberOfPlayers < 2 || numberOfPlayers > 6)
            {
                System.out.println("Invalid number of players! Please enter a number between 2 and 6.");
            }
        }
        return numberOfPlayers;
    }

    public int getNumberOfGames()
    {
        System.out.print("Enter number of games to play: ");
        return input.nextInt();
    }
}
