package grupp1.calculator.exceptions;

/**
 * Represents the exception that is thrown when an attempt is made to solve an
 * expression that contains a division-by-zero error.
 * @author Philip Arvidsson (S133686)
 */
public class DivisionByZeroException extends CalculatorException {
    
/**
 * The expression that generated the exception.
 */
private String expr;

/**
 * Constructor.
 * @param expr The expression that generated the exception.
 */
public DivisionByZeroException(String expr) {
    this.expr = expr;
}

/**
 * Gets the expression that generated the exception.
 * @return The expression that generated the exception.
 */
public String getExpression() {
    return (expr);
}

/**
 * Retrieves a string that describes the exception.
 * @return A string that describes the exception.
 */
@Override public String toString() {
    return ("Exception: Divide by zero: " + expr);
}

}
