package grupp1.calculator.exceptions;

import grupp1.calculator.model.token.Token;

/**
 * Represents the exception that is thrown when an attempt is made to solve an
 * expression that contains an invalid operation.
 * @author Philip Arvidsson (S133686)
 */
public class InvalidOperationException extends CalculatorException {

/**
 * The token that generated the exception.
 */
private Token token;

/**
 * Constructor.
 * @param token The token that generated the exception.
 */
public InvalidOperationException(Token token) {
    this.token = token;
}

/**
 * Gets the token that generated the exception.
 * @return The token that generated the exception.
 */
public Token getToken() {
    return (token);
}

/**
 * Retrieves a string that describes the exception.
 * @return A string that describes the exception.
 */
@Override public String toString() {
    return ("Unknown operator: '" + token.toString() + "'");
}

}
