package ca.sheridancollege.project;

import java.util.List;
import java.util.Scanner;

/**
 * A class having main method that begins the game
 * 
 * This class represents the starting point of the card game and extends the
 * Game class.
 * It contains the main game loop, player interactions, and declares the winner.
 *
 * @author Pawanpreet Kaur
 * @author Vanshika Vanshika Feb 2024
 */
public class StartGame extends Game {

    private final HumanPlayer player1;
    private final HumanPlayer player2;
    private int roundsWonByPlayer1;
    private int roundsWonByPlayer2;

    public StartGame(HumanPlayer p1, HumanPlayer p2, String name) {
        super(name);
        this.player1 = p1;
        this.player2 = p2;
        this.roundsWonByPlayer1 = 0;
        this.roundsWonByPlayer2 = 0;
    }

   @Override
   public void play() {
       Scanner scanner = new Scanner(System.in);

       int roundsToPlay = 5;

       for (int round = 1; round <= roundsToPlay; round++) {
           System.out.println("\nRound " + round);

           List<Card> deck = createDeck();

           Card currentCard = deck.remove(deck.size() - 1);
           System.out.println("Card: " + currentCard.rank + " of " + currentCard.suit);

           // Get guesses from both players
           System.out
                   .print(player1.getName()
                           + ", will the next card be higher or lower or equal? (Type 'higher' or 'lower' or 'equal'): ");
           
           String guessP1 = scanner.nextLine().toLowerCase();

           player2.play();
           String guessP2 = scanner.nextLine().toLowerCase();

           // Get the next card
           Card nextCard = deck.remove(deck.size() - 1);
           System.out.println("Next card is: " + nextCard.rank + " of " + nextCard.suit);

           String result = compareCards(currentCard, nextCard);
           System.out.println(result);
           System.out.println(guessP1);
           System.out.println(guessP2);

           // Compare each player's guess with the result
           if (result.equals(guessP1) && result.equals(guessP2)) {
               System.out.println("Correct! indeed, card is " + result + " ,you both wins this round.\n");
               roundsWonByPlayer1++;
               roundsWonByPlayer2++;

           } else if (result.equals(guessP1)) {
               System.out.println("Correct! " + player1.getName() + " wins this round.\n");
               roundsWonByPlayer1++;
           } else if (result.equals(guessP2)) {
               System.out.println("Correct! " + player2.getName() + " wins this round.\n");
               roundsWonByPlayer2++;
           } else {
               System.out.println(
                       "Incorrect! drawn card is " + result + " than previous card. You both loss this round.\n");

           }
       }
       declareWinner();
   }
        
   /**
    * Declares and displays the winner of the card game based on the number of
    * correct guesses.
    * It compares the number of correct guesses made by Player 1 and Player 2, and
    * announces
    * the overall winner or declares a tie.
    */
    @Override
    public void declareWinner() {
        if (roundsWonByPlayer1 > roundsWonByPlayer2) {
            System.out.println("Congratulations! " + player1.getName() + " is the overall winner, with "
                    + roundsWonByPlayer1 + " correct gusses!" + player2.getName() + ", you loss at "
                    + (5 - roundsWonByPlayer2) + " gusses");
        } else if (roundsWonByPlayer1 < roundsWonByPlayer2) {
            System.out.println("Congratulations! " + player2.getName() + " is the overall winner, with "
                    + roundsWonByPlayer2 + " correct gusses!" + player1.getName() + ", you loss at "
                    + (5 - roundsWonByPlayer1) + " gusses");
        } else {
            System.out.println("It's a tie! The game is drawn, you both have " + roundsWonByPlayer1
                    + " correct gusses!");
        }
    }
    
    /**
     * The main method that initializes and starts the card game.
     * It prompts the user to enter names for Player 1 and Player 2, creates
     * instances
     * of HumanPlayer for both players, and then starts the game using the StartGame
     * class.
     *
     * @param args command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name for Player 1: ");
        String playerName1 = scanner.nextLine();
        HumanPlayer player1 = new HumanPlayer(playerName1);

        System.out.print("Enter the name for Player 2: ");
        String playerName2 = scanner.nextLine();
        HumanPlayer player2 = new HumanPlayer(playerName2);
       
        StartGame startGame = new StartGame(player1,player2,"HigherOrLower");
        startGame.play();
    }

    private List<Card> createDeck() {
        GroupOfCards groupOfCards = new GroupOfCards(52);
        return groupOfCards.getCards();
    }
}
