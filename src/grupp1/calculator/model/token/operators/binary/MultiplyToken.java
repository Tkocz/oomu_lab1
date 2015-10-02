package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.model.expression.Expression;

/**
 * Provides a token for performing multiplication.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "*")
public class MultiplyToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public MultiplyToken(String op) {
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
    // Multiplication is commutative so order doesn't matter.
    return (expression.getNextToken().evaluate(expression) * expression.getNextToken().evaluate(expression));
}

}
