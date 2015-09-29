package grupp1.calculator.exceptions;

/*
----------------------------------------------------
grupp1.calculator.exceptions.DivisionByZeroException
----------------------------------------------------
Enligt "best practice" för egendefinierade undantag i java skulle konstruktorn
för eran DivisionByZeroException se ut enligt nedan:

public DivisionByZeroException(String message)
{
   super(message);
}

... alternativt ...

public DivisionByZeroException(String expression)
{
   super("Exception: Divide by zero: " + expression);
}

Detta är allt ni behöver i eran klass och innebär att meddelendet kan hämtas via
samma publika interface som alla andra Exception-klasser, dvs genom getMessage() metoden.

KOMMENTAR:

    Ok, fixar. // Philip
*/

/**
 * Represents the exception that is thrown when an attempt is made to solve an
 * expression that contains a division-by-zero error.
 * @author Philip Arvidsson (S133686)
 */
public class DivisionByZeroException extends CalculatorException {

/**
 * Constructor.
 * @param message Exception message text.
 */
public DivisionByZeroException(String message) {
    super("Division by zero: " + message);
}

}
