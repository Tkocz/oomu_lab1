package grupp1.calculator.exceptions;

/**
 * Represents the exception that is thrown when an attempt is made to solve an
 * expression that contains an invalid token.
 * @author Philip Arvidsson (S133686)
 */
public class InvalidTokenException extends CalculatorException {

/**
 * The token string that generated the exception.
 */
private String token;

/**
 * Constructor.
 * @param token The token string that generated the exception.
 */
public InvalidTokenException(String token) {
    this.token = token;
}

/**
 * Gets the token string that generated the exception.
 * @return The token string that generated the exception.
 */
public String getToken() {
    return (token);
}

/**
 * Retrieves a string that describes the exception.
 * @return A string that describes the exception.
 */
@Override public String toString() {
    return ("Invalid token encountered: '" + token + "'");
}

}
