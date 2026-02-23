import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * StorageService
 * This class is responsible for saving the final game result into a file.
 * This ensures the game history is not lost after exiting.
 * @author Developer
 * @version 1.0
 */
public class StorageService {

    // Saves the final outcome of the game including player name, attempts, and result
    public static void saveResult(String player, int attempts, boolean win) {
        // Try-with-resources ensures the writer closes automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game_results.txt", true))) {
            writer.write("Player: " + player + ", Attempts: " + attempts + ", Result: " + (win ? "WIN" : "LOSE"));
            writer.newLine();  
        } catch (IOException e) {
            System.out.println("Unable to save game result.");
        }
    }
}