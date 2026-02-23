import java.util.Scanner;

/**
 * GuessingApp UC2 – User Guess Submission
 * This main class coordinates the game execution, taking user input and validating it.
 * @author Developer
 * @version 2.0
 */
public class GuessingApp {
    
    public static void main(String[] args) {
        // Initialize the game configuration
        GameConfig config = new GameConfig();
        config.showRules();
        
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        
        // Game loop runs until the player exhausts the maximum attempts
        while (attempts < config.getMaxAttempts()) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            
            // Validate guess using the static utility method
            String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
            System.out.println(result);
            
            // Stop the loop immediately if the correct number is guessed
            if ("CORRECT".equals(result)) {
                break;
            }
        }
        
        scanner.close();
    }
}