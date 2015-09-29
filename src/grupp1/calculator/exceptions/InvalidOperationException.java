package grupp1.calculator.exceptions;

/*
------------------------------------------------------
grupp1.calculator.exceptions.InvalidOperationException
------------------------------------------------------
Här kan man fundera på om en InvalidOperationException "är" en
EmptyStackException. Det är inte semantiskt korrekt. Det hade varit bättre att
ärva från CalculatorException.

KOMMENTAR:

    Mystisk miss av mig. Måste ha slarvat och skrivit fel. Fixar. // Philip
*/

/**
 * Represents the exception that is thrown when an attempt is made to solve an
 * expression that contains an invalid operation.
 * @author Philip Arvidsson (S133686)
 */
public class InvalidOperationException extends CalculatorException {

/**
 * Constructor.
 * @param message Exception message text.
 */
public InvalidOperationException(String message) {
    super(message);
}

}
