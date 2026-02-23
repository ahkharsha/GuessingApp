/**
 * GuessValidator
 * This utility class is responsible for comparing the user's guess with the target number.
 * It does not handle any input or output directly.
 * @author Developer
 */
public class GuessValidator {

    // Compares guess with target and returns the comparison result as a String
    public static String validateGuess(int guess, int target) {
        if (guess == target) {
            return "CORRECT";
        } else if (guess < target) {
            return "LOW";
        }
        return "HIGH";
    }
}