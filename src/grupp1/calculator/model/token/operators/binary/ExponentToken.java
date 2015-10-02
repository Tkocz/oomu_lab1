package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.model.expression.Expression;

/**
 * Provides a token for performing exponentiation.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "^")
public class ExponentToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public ExponentToken(String op) {
    super(op);
}

/**
 * Evaluates the specified token sequence to produce an arithmetic result.
 * @param expression The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Philip Arvidsson (S133686)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double evaluate(Expression expression) throws Exception {
    double exponent = expression.getNextToken().evaluate(expression);
    double base     = expression.getNextToken().evaluate(expression);

    return (Math.pow(base, exponent));
}

}
