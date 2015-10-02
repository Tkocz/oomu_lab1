package grupp1.calculator.model.token;

import grupp1.calculator.model.token.Token;

/**
 * Provides the interface for implementing a token factory.
 * @author Philip Arvidsson (S133686)
 */
public interface TokenFactory {

/**
 * Gets an appropriate token for the specified string containing, for
 * example, an operator ('+') or a number (9.0).
 * @param s The string to create a token for.
 * @return A token representing the specfied string.
 */
Token getToken(String s);

}
