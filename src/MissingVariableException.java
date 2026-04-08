/**
 * MissingVariableException — thrown when expression evaluation
 * encounters a variable that has no value in the supplied assignment.
 *
 * @author [Author Name]
 * © [YYYY]
 */
public class MissingVariableException extends Exception {
    /**
     * Construct with a descriptive message.
     *
     * @param message the detail message
     */
    public MissingVariableException(String message) {
        super(message);
    }
}
