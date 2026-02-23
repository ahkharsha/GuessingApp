import java.util.Scanner;

/**
 * GameController
 * Asks the player if they want to restart the game after completion.
 * @author Developer
 * @version 1.0
 */
public class GameController {
    
    // Returns true if the game should restart, false to exit
    public static boolean restartGame(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }
}