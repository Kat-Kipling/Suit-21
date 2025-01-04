import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class PlayerStrategyTest {

    @Test
    void testComputerStrategyChooseCardToPlay() {
        Player player = new Player("AI Player", new ConsoleDisplayStrategy(), new ComputerStrategy());
        Hand hand = new Hand();
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.KING));
        player.setHand(hand);

        Card chosenCard = player.playCard();
        assertNotNull(chosenCard, "AI should choose a card to play");
    }

    @Test
    void testHumanStrategyChooseCardToPlay() {
        Scanner input = new Scanner("1\n");  // Simulating player input
        Player player = new Player("Human Player", new ConsoleDisplayStrategy(), new HumanStrategy(input));
        Hand hand = new Hand();
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.CLUBS, Rank.KING));
        player.setHand(hand);

        Card chosenCard = player.playCard();
        assertNotNull(chosenCard, "Human player should choose a card to play");
    }
}
