# Suit 21

Suit 21 is a console-based card game where players compete to achieve a score of 21 in a single suit. This project was developed as part of a university assignment and demonstrates basic programming concepts, game logic, and player interaction.

## Game Rules

### Card Scoring
- Numeric cards score as their face value (e.g., a Two of Hearts scores 2, a Three of Spades scores 3, etc.).
- All picture cards (Jack, Queen, King) are worth 10 points.
- An Ace can be worth either 1 or 11 points, depending on what benefits the player more.

### Gameplay
1. Each player is dealt five cards at the start of the game.
2. Players take turns in a clockwise order, choosing a card to drop from their hand and replacing it with a new card from the deck.
3. The goal is to achieve a score of 21 in any single suit (e.g., 21 total in Hearts, 21 total in Clubs, etc.).
4. When a player scores 21, the rest of the players have until the end of the round to also score 21.
5. If no player scores 21 by the time the deck runs out, the round ends with no winner.
6. Points are awarded as follows:
   - If one player scores 21, they win the round and gain 1 point.
   - If multiple players score 21, the point is divided equally among them.

### Player Limits
- The game supports 2 to 6 players.

## Features
- Console-based gameplay
- Dynamic card scoring logic (Ace flexibility included)
- Turn-based gameplay for multiple players
- Victory condition handling

## How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/Kat-Kipling/Suit-21.git
   ```
2. Navigate to the project directory:
   ```bash
   cd suit-21
   ```
3. Compile and run the program:
     ```bash
     javac Suit21.java
     java Suit21
     ```

(Adjust the instructions above based on the language of your implementation.)

## Repository Structure
- `src/`: Contains the source code for the game
- `docs/`: Documentation and assignment requirements
- `tests/`: Unit tests for validating game logic

## Contribution
Contributions are welcome! If you have suggestions or improvements, feel free to open an issue or submit a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments
- Developed as part of a university assignment on game development and programming concepts.
