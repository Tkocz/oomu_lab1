package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.exceptions.DivisionByZeroException;
import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.model.expression.Expression;

/**
 * Provides a token for performing division.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "/")
public class DivideToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public DivideToken(String op) {
    super(op);
}

/**
 * Evaluates the specified token sequence to produce an arithmetic result.
 * @param stack The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Martin Bergqvist (S141564)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double evaluate(Expression expression) throws Exception {
    double divisor  = expression.getNextToken().evaluate(expression);
    double dividend = expression.getNextToken().evaluate(expression);
    
    // Might as well use an epsilon value here since equality testing for floats
    // and doubles is unsafe anyway.
    if (Math.abs(divisor) < 0.000000001) {
        throw new DivisionByZeroException(
                String.format("%f / %f", dividend, divisor));
    }

    return (dividend / divisor);
}

}
