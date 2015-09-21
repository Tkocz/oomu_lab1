package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import java.util.Stack;

/**
 * Provides a token for performing addition.
 * @author Philip Arvidsson (S133686)
 */
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
 * @param seq The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Philip Arvidsson (S133686)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double eval(Stack<Token> seq) throws Exception {
    // Addition is commutative so order doesn't matter.
    return (seq.pop().eval(seq) + seq.pop().eval(seq));
}

}
