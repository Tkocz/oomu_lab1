package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import java.util.Stack;

/**
 * Provides a token for performing subtraction.
 * @author Philip Arvidsson (S133686)
 */
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
 * @param seq The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Martin Bergqvist (S141564)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double eval(Stack<Token> seq) throws Exception {
    // There's no commutativity here so care must be take with regards to
    // order of operands.

    double b = seq.pop().eval(seq);
    double a = seq.pop().eval(seq);

    return (a - b);
}

}
