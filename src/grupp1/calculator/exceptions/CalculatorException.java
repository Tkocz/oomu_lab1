package grupp1.calculator.exceptions;

/**
 * Represents an exception thrown by the RPN calculator.
 * @author Philip Arvidsson (S133686)
 */
public abstract class CalculatorException extends Exception {
    
/**
 * Retrieves a string that describes the exception.
 * @return A string that describes the exception.
 */
@Override public String toString() {
    return ("A generic calculator exception has occurred.");
}

}
