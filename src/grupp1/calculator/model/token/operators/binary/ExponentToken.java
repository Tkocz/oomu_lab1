package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import java.util.Stack;

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
 * @param stack The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Philip Arvidsson (S133686)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double eval(Stack<Token> stack) throws Exception {
    double exponent = stack.pop().eval(stack);
    double base     = stack.pop().eval(stack);

    return (Math.pow(base, exponent));
}

}
