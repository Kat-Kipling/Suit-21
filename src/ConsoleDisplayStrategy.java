import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public void printFinalScores(Player[] players, HashMap<Player, Double> playerTotalScores, int numberOfGames) {
        // Sort players by score in descending order
        List<HashMap.Entry<Player, Double>> sortedScores = playerTotalScores.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
                .collect(Collectors.toList());

        // Print the table header
        System.out.println("Final Scores after " + numberOfGames + " games:");
        System.out.printf("%-20s %-10s%n", "Player", "Score");
        System.out.println("-------------------------------");

        // Print players and their scores in descending order
        for (HashMap.Entry<Player, Double> entry : sortedScores)
        {
            System.out.printf("%-20s %-10.2f%n", entry.getKey().getName(), entry.getValue());
        }

        // Determine the overall winner
        double maxScore = sortedScores.get(0).getValue();
        for (HashMap.Entry<Player, Double> entry : sortedScores)
        {
            if (entry.getValue() == maxScore)
            {
                System.out.println(entry.getKey().getName() + " is the overall winner!");
                break; // Only need to announce one winner
            }
        }
    }
}
