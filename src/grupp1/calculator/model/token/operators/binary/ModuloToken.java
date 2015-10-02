package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.exceptions.DivisionByZeroException;
import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.expression.Expression;

/**
 * Provides a token for performing modulo.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "%")
public class ModuloToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public ModuloToken(String op) {
    super(op);
}

/**
 * Evaluates the specified token sequence to produce an arithmetic result.
 * @param expression The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Martin Bergqvist (S141564)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double evaluate(Expression expression) throws Exception {
    // There's no commutativity here so care must be take with regards to
    // order of operands.

    double b = expression.getNextToken().evaluate(expression);
    double a = expression.getNextToken().evaluate(expression);
    if (Math.abs(b) < 0.000000001) {
        throw new DivisionByZeroException(
                String.format("%f / %f", a, b));
    }
    return (a % b);
}

}
