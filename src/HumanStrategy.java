import java.util.Scanner;

public class HumanStrategy implements PlayerStrategy
{
    private Scanner input;

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
        return player.getCard(index);
    }
}