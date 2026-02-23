/**
 * InvalidInputException
 * Custom exception used when user input fails validation.
 * This allows the game to fail gracefully with a meaningful message.
 * @author Developer
 * @version 1.0
 */
public class InvalidInputException extends Exception {
    
    public InvalidInputException(String message) {
        super(message);
    }
}