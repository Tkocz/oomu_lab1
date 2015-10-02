package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.model.expression.Expression;

/**
 * Provides a token for performing addition.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "+")
public class AddToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public AddToken(String op) {
    super(op);
}

/**
 * Evaluates the specified token sequence to produce an arithmetic result.
 * @return The result of evaluating the sequence.
 * @author Martin Bergqvist (S141564)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double evaluate(Expression expression) throws Exception {
    // Addition is commutative so order doesn't matter.
    return (expression.getNextToken().evaluate(expression) + expression.getNextToken().evaluate(expression));
}

}
