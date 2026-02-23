/**
 * HintService
 * This class is responsible for generating controlled hints based on the number of incorrect attempts.
 * @author Developer
 * @version 1.0
 */
public class HintService {

    // Generates a hint based on how many hints have already been used
    public static String generateHint(int target, int hintCount) {
        if (hintCount == 1) {
            return (target % 2 == 0) 
                ? "Hint: Number is EVEN" 
                : "Hint: Number is ODD";
        } else if (hintCount == 2) {
            return (target > 50) 
                ? "Hint: Number is greater than 50" 
                : "Hint: Number is 50 or less";
        }
        return "No more hints available";
    }
}