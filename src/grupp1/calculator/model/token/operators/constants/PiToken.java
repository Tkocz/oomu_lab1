package grupp1.calculator.model.token.operators.constants;

import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import java.util.Stack;

/**
 * Provides a token for retrieve the value of pi. Easier to treat this as a
 * unary operator.
 * @author Philip Arvidsson (S133686)
 */
public class PiToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public PiToken(String op) {
    super(op);
}

/**
 * Evaluates the specified token sequence to produce an arithmetic result.
 * @param seq The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Philip Arvidsson (S133686)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double eval(Stack<Token> seq) throws Exception {
    return (Math.PI);
}

}
