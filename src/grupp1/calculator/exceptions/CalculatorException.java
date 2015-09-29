package grupp1.calculator.exceptions;

/**
 * Represents an exception thrown by the RPN calculator.
 * @author Philip Arvidsson (S133686)
 */
public abstract class CalculatorException extends Exception {

    /**
     * Constructor.
     * @param message Exception message text.
     */
    public CalculatorException(String message) {
        super(message);
    }

}
