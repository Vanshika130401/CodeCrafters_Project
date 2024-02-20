package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * A class representing a human player in a card game.
 *
 * @author Pawanpreet Kaur
 * @author Vanshika Vanshika Feb 2024
 */
public class HumanPlayer extends Player {
    // Constructor for HumanPlayer class
    public HumanPlayer(String name) {
        super(name);
    }

    /**
     * Overrides the play method in the Player class for a HumanPlayer.
     * This method prompts the human player to make a move during their turn.
     * asking the next card will be higher, lower, or equal. The player should type
     * 'higher' or 'lower'.
     */

    @Override
    public void play() {
        // Add logic for human player's turn in the card game
        Scanner scanner = new Scanner(System.in);
        System.out.print("It's your turn, " + getName() + "! will the next card be higher or lower or equal? (Type 'higher' or 'lower' or 'equal'): ");
    }
}
