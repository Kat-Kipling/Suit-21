import java.util.EnumMap;

public class ConsoleDisplayStrategy implements DisplayStrategy
{
    @Override
    public void displayHand(Player player)
    {
        System.out.println(player.getName() + "'s Hand:");
        for (int i = 0; i < player.getHand().getCurrentSize(); i++) {
            System.out.printf("%d. %s%n", i + 1, player.getHand().get(i));
        }

        // Display the scores for the hand
        EnumMap<Suit, Integer> scores = player.getSuitScores();
        for (Suit suit : Suit.values())
        {
            System.out.printf("%-8s: %d%n", suit, scores.getOrDefault(suit, 0));
        }
    }
}
