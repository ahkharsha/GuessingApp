/**
 * ValidationService
 * Handles validation of user input before it is used in game logic.
 * All input checks are centralized here to keep the main flow clean.
 * @author Developer
 * @version 1.0
 */
public class ValidationService {
    
    // Converts input to integer, checks the allowed range, and throws custom exceptions if invalid
    public static int validateInput(String input) throws InvalidInputException {
        try {
            int value = Integer.parseInt(input.trim());
            
            if (value < 1 || value > 100) {
                throw new InvalidInputException("Number must be between 1 and 100.");
            }
            return value;
            
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input. Please enter numbers only.");
        }
    }
}