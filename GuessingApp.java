/**
 * GuessingApp UC1 – Game Initialization
 * This is the main class that serves as the entry point to start the game.
 * @author Developer
 * @version 1.0
 */
public class GuessingApp {
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing App");
        
        // Initialize the game configuration
        GameConfig config = new GameConfig();
        config.showRules();
    }
}