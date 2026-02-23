import java.util.Random;

/**
 * GameConfig
 * This class stores the configuration and initializes the game boundaries for the Number Guessing App.
 * @author Developer
 * @version 1.0
 */
public class GameConfig {
    
    // Constants for game boundaries and limits
    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;
    private final int MAX_HINTS = 3;
    
    // Encapsulated game variable
    int targetNumber;

    // Constructor initializes the random target number
    public GameConfig() {
        Random random = new Random();
        this.targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
    }

    // Getters for encapsulation
    public int getTargetNumber() { 
        return targetNumber; 
    }
    
    public int getMaxAttempts() { 
        return MAX_ATTEMPTS; 
    }
    
    public int getMaxHints() { 
        return MAX_HINTS; 
    }

    // Method to display game rules
    public void showRules() {
        System.out.println("\nWelcome to the Number Guessing Game");
        System.out.println("=========================================");
        System.out.println("A secret number between " + MIN + " and " + MAX + " has been generated.");
        System.out.println("You get " + MAX_ATTEMPTS + " attempts to find it.");
        System.out.println("Helpful hints will appear after incorrect guesses.\n");
    }
}