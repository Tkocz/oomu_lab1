package grupp1.calculator.model.token.operators.unary;

import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import java.util.Stack;

/**
 * Provides a token for performing cosine calculations.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "cos")
public class CosToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public CosToken(String op) {
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
    return (Math.cos(stack.pop().eval(stack)));
}

}
