import java.util.Scanner;

/**
 * GuessingApp UC6 – Game Restart & Exit
 * This class coordinates the complete game lifecycle, allowing the player to replay or exit gracefully.
 * @author Developer
 * @version 6.0
 */
public class GuessingApp {
    
    public static void main(String[] args) throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        boolean restart;
        
        System.out.println("Welcome to the Guessing App");
        System.out.println("===========================\n");
        
        // Outer loop controls whether a new game session should start
        do {
            System.out.print("Enter Player Name: ");
            String player = scanner.nextLine();
            
            GameConfig config = new GameConfig();
            config.showRules();
            
            int attempts = 0;
            int hintsUsed = 0;
            boolean win = false;
            
            // Inner loop handles the guessing logic for a single game session
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
            
            // Persist the result after the current session ends
            StorageService.saveResult(player, attempts, win);
            
            // Player decides whether to restart or exit
            restart = GameController.restartGame(scanner);
            
        } while (restart);
        
        scanner.close();
    }
}