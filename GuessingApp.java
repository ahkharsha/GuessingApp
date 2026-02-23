import java.util.Scanner;

/**
 * GuessingApp UC3 – Hint Generation
 * This main class coordinates the game execution and introduces progressive hints.
 * @author Developer
 * @version 3.0
 */
public class GuessingApp {
    
    public static void main(String[] args) {
        GameConfig config = new GameConfig();
        config.showRules();
        
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintsUsed = 0;
        
        // Game loop runs until the player exhausts the maximum attempts
        while (attempts < config.getMaxAttempts()) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            
            String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
            
            // A hint is generated only after an incorrect guess and within the allowed hint limit
            if (!"CORRECT".equals(result) && hintsUsed < config.getMaxHints()) {
                hintsUsed++;
                System.out.println(HintService.generateHint(config.getTargetNumber(), hintsUsed));
            }
            
            System.out.println(result);
            
            // Stop the loop immediately if the correct number is guessed
            if ("CORRECT".equals(result)) {
                break;
            }
        }
        
        scanner.close();
    }
}