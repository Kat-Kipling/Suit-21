import java.util.Scanner;

public class HumanStrategy implements PlayerStrategy
{
    private final Scanner input;

    public HumanStrategy(Scanner input)
    {
        this.input = input;
    }

    @Override
    public Card chooseCardToPlay(Player player, Hand hand)
    {
        player.displayHand();
        System.out.println("Choose a card to play (enter index 1-5):");
        int index = input.nextInt() - 1;
        input.nextLine(); // Clear buffer
        return player.getCard(index);
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