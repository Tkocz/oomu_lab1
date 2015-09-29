package grupp1.calculator.exceptions;

/*
--------------------------------------------------
grupp1.calculator.exceptions.InvalidTokenException
--------------------------------------------------
Samma sak gäller här som för DivisionByZeroException; det enda ni behöver är en
konstruktor som ser ut enligt nedan:

public InvalidTokenException(String token)
{
   super("Invalid token exception: " + token);
}

KOMMENTAR:

    Ok, fixar. // Philip
*/

/**
 * Represents the exception that is thrown when an attempt is made to solve an
 * expression that contains an invalid token.
 * @author Philip Arvidsson (S133686)
 */
public class InvalidTokenException extends CalculatorException {

/**
 * Constructor.
 * @param message Exception message text.
 */
public InvalidTokenException(String message) {
    super(message);
}

}
