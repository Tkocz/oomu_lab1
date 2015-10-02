package grupp1.calculator.model.token.operators.unary;

import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.model.expression.Expression;

/**
 * Provides a token for performing tangent calculations.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "tan")
public class TanToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public TanToken(String op) {
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
    return (Math.tan(expression.getNextToken().evaluate(expression)));
}

}
