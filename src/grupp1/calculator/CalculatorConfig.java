package grupp1.calculator;

import grupp1.calculator.model.expression.Expression;
import grupp1.calculator.model.expression.ExpressionStack;
import grupp1.calculator.model.token.TokenFactory;
import grupp1.calculator.model.token.ReflectingTokenFactory;
import grupp1.calculator.view.IOHelper;
import grupp1.calculator.view.StdIO;

/*
----------------------------------
grupp1.calculator.CalculatorConfig
----------------------------------
Här behöver ni använda inkapsling på ett korrekt sätt. Skriv om eran kod så att
ni kapslar in eran data (privata attribut) i CalculatorConfig klassen. Era
attribut skall endast accessas via "getter" och "setter" metoder. Ni kanske vill
testa på att använda "java.util.Properties" istället.

KOMMENTAR:

    Accepterar kritiken då den är relevant för labbens infallsvinkel, men det
    finns ingen poäng alls med inkapsling av en POD-typ som bara ska bära
    data. Ändrar.

    // Philip
*/

/**
 * Represents the calculator configuration.
 * @author Philip Arvidsson (S133686)
 */
public class CalculatorConfig {

/**
 * Expression container object.
 */
private Expression expression;

/**
 * I/O-helper object for easier IO.
 */
private IOHelper io;

/**
 * The precision, in number of decimals, to display in results. The default
 * value is 4.
 */
private int precision;

/**
 * The token factory to use for acquiring tokens (operators, etc.).
 */
private TokenFactory token_factory;

/**
 * Gets the expression container object.
 * @return The expression container object.
 */
public Expression getExpression() {
    return (expression);
}

/**
 * Sets the expression container object.
 * @param value The expression cntainer object.
 */
public void setExpression(Expression value) {
    expression = value;
}

/**
 * Gets the output stream.
 * @return The output stream.
 */
public IOHelper getIO() {
    return (io);
}

/**
 * Sets the output stream.
 * @param value The output stream.
 */
public void setIO(IOHelper value) {
    io = value;
}
/**
 * Gets the precision
 * @return The precision, in number of decimals.
 */
public int  getPrecision() {
    return (precision);
}

/**
 * Sets the precision.
 * @param value The precision, in number of decimals.
 */
public void setPrecision(int value) {
    precision = value;
}

/**
 * Gets the token factory.
 * @return The token factory.
 */
public TokenFactory getTokenFactory() {
    return (token_factory);
}

/**
 * Sets the token factory.
 * @param value The token factory.
 */
public void setTokenFactory(TokenFactory value) {
    token_factory = value;
}

/**
 * Retrieves a default configuration for the calculator. This default precision
 * has a precision of four decimals, enables all of the calculators
 * functionality (variables, etc.) and reads and writes to the standard
 * input/output
 * @return The default calculator configuration.z
 */
public static CalculatorConfig defaultConfig() {
    CalculatorConfig conf = new CalculatorConfig();

    conf.setExpression(new ExpressionStack());
    conf.setIO(new StdIO());
    conf.setPrecision(4);
    conf.setTokenFactory(new ReflectingTokenFactory());

    return (conf);
}

}
