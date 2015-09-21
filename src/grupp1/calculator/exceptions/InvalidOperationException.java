package grupp1.calculator.exceptions;

import java.util.EmptyStackException;

/**
 * Represents the exception that is thrown when an attempt is made to solve an
 * expression that contains an invalid operation.
 * @author Philip Arvidsson (S133686)
 */
public class InvalidOperationException extends EmptyStackException {

/**
 * Constructor.
 */
public InvalidOperationException() {
}


/**
 * Retrieves a string that describes the exception.
 * @return A string that describes the exception.
 */
@Override public String toString() {
    return ("Exception: Invalid Operation.");
}

}
