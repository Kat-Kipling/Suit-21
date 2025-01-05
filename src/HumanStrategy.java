import java.util.Scanner;

public class HumanStrategy implements PlayerStrategy
{
    private final Scanner input;

    public HumanStrategy(Scanner input)
    {
        this.input = input;
    }

    @Override
    public Card chooseCardToPlay(Player player, Hand hand) {
        while (true) {
            player.displayHand();
            System.out.println("Choose a card to play (enter index 1-5):");

            try {
                String inputLine = input.nextLine().trim();

                // Check for empty input
                if (inputLine.isEmpty()) {
                    System.out.println("Error: Input cannot be empty. Please enter a number between 1 and 5.");
                    continue;
                }

                // Parse input to integer
                int index;
                try {
                    index = Integer.parseInt(inputLine) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid number between 1 and 5.");
                    continue;
                }

                // Check if index is within valid range
                if (index < 0 || index >= hand.getCurrentSize()) {
                    System.out.println("Error: Please enter a number between 1 and " + hand.getCurrentSize() + ".");
                    continue;
                }

                // Valid input received, return the card
                return player.getCard(index);

            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                // Clear the scanner buffer if needed
                if (input.hasNextLine()) {
                    input.nextLine();
                }
            }
        }
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