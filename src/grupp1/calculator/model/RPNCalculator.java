package grupp1.calculator.model;

import grupp1.calculator.exceptions.InvalidTokenException;
import grupp1.calculator.exceptions.InvalidOperationException;
import grupp1.calculator.model.expression.Expression;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.model.token.TokenFactory;

/**
 * Provides the actual calculator class.
 * @author Philip Arvidsson (S133686)
 */
public class RPNCalculator {

/**
 * The expression container object.
 */
private final Expression expression;

/**
 * The token factory used for token construction.
 */
private final TokenFactory token_factory;

/**
 * Constructor.
 * @param expression The expression container object.
 * @param token_factory The token factory to use for token construction.
 */
public RPNCalculator(Expression expression, TokenFactory token_factory) {
    this.expression    = expression;
    this.token_factory = token_factory;
}

/**
 * Evaluates the specified expression string.
 * @param s The expression string.
 * @return The result of the expression.
 * @throws InvalidTokenException An invalid token was encountered.
 * @throws DivisionByZeroException An attempt to divide by zero was encountered.
 */
public double evaluateExpression(String s) throws Exception {
    /*
    En annan "best practice" är att använda meningsfulla, fullständiga (ej
    förkortningar) namn på variabler, metoder, mm.

    KOMMENTAR:

        Njaha. Konsensus måste väl ändå vara att koden ska gå att förstå.
        Namnet evaluateExpr() är uppenbart för alla som har programmerat över
        huvud taget. Men ok, jag förstår vad du syftar på, så jag ändrar. Jag
        har i övrigt ganska svårt för Javas "super verbose" stil.

        // Philip
    */

    expression.clearExpression();

    for (String str : s.split(" ")) {
        Token tok = token_factory.getToken(str);

        if (tok == null)
            throw new InvalidTokenException(str);

        expression.addToken(tok);
    }

    double r = expression.getNextToken().evaluate(expression);

    if (!expression.isEmptyExpression())
        throw new InvalidOperationException("Expression was not evaluated properly.");

    return (r);

}

}
