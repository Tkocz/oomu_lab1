package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import java.util.Stack;

/**
 * Provides a token for performing subtraction.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "-")
public class SubtractToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public SubtractToken(String op) {
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
public double eval(Stack<Token> stack) throws Exception {
    // There's no commutativity here so care must be take with regards to
    // order of operands.

    double b = stack.pop().eval(stack);
    double a = stack.pop().eval(stack);

    return (a - b);
}

}
