package grupp1.calculator.model.token.operators.unary;

import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.model.expression.Expression;

/**
 * Provides a token for performing conversions from degrees to radians.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "rad")
public class RadToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public RadToken(String op) {
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
    return (expression.getNextToken().evaluate(expression) * Math.PI / 180.0f);
}

}
