import java.util.Scanner;

/**
 * GuessingApp UC5 – Game Result Storage
 * This class coordinates the complete game flow and saves the final result after completion.
 * @author Developer
 * @version 5.0
 */
public class GuessingApp {
    
    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Welcome to the Guessing App");
        System.out.println("===========================\n");
        
        Scanner scanner = new Scanner(System.in);
        
        // Capture player name once before the game starts
        System.out.print("Enter Player Name: ");
        String player = scanner.nextLine();
        
        GameConfig config = new GameConfig();
        config.showRules();
        
        int attempts = 0;
        int hintsUsed = 0;
        boolean win = false; // Tracks if the player guessed correctly
        
        // Game loop
        while (attempts < config.getMaxAttempts()) {
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();
            int guess = ValidationService.validateInput(input);
            attempts++;
            
            String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
            
            if (!"CORRECT".equals(result) && hintsUsed < config.getMaxHints()) {
                hintsUsed++;
                System.out.println(HintService.generateHint(config.getTargetNumber(), hintsUsed));
            }
            
            System.out.println(result);
            
            if ("CORRECT".equals(result)) {
                win = true;
                break;
            }
        }
        
        // Save the final game result to the text file
        StorageService.saveResult(player, attempts, win);
        
        scanner.close();
    }
}