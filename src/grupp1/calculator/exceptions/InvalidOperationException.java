package grupp1.calculator.exceptions;

/**
 * Represents the exception that is thrown when an attempt is made to solve an
 * expression that contains an invalid operation.
 * @author Philip Arvidsson (S133686)
 */
public class InvalidOperationException extends CalculatorException {
    /**
     * @private
     * The token that generated the exception.
     */
    private Object token;
    
    /**
     * Constructor.
     * @param token The token that generated the exception.
     */
    public InvalidOperationException(Object token) {
        this.token = token;
    }
    
    /**
     * Retrieves a string that describes the exception.
     * @return A string that describes the exception.
     */
    @Override public String toString() {
        // @To-do: Use the token field to create a more descriptive string.
        return ("sån här skit vill jag inte veta av");
    }
}
