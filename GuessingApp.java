import java.util.Scanner;

/**
 * GuessingApp UC4 – Error Handling & Validation
 * This main class coordinates the game execution while ensuring user inputs are validated.
 * @author Developer
 * @version 4.0
 */
public class GuessingApp {
    
    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Welcome to the Guessing App");
        
        GameConfig config = new GameConfig();
        config.showRules();
        
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintsUsed = 0;
        
        // Game loop runs until the player exhausts the maximum attempts
        while (attempts < config.getMaxAttempts()) {
            System.out.print("Enter your guess: ");
            
            // User input is captured as a string and validated before being used in the game logic
            String input = scanner.nextLine();
            int guess = ValidationService.validateInput(input);
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