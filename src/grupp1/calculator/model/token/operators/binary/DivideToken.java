package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.exceptions.DivisionByZeroException;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import java.util.Stack;

/**
 * Provides a token for performing division.
 * @author Philip Arvidsson (S133686)
 */
public class DivideToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public DivideToken(String op) {
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
    double divisor  = seq.pop().eval(seq);
    double dividend = seq.pop().eval(seq);

    if (Math.abs(divisor) < 0.000000001) {
        throw new DivisionByZeroException(
                String.format("%f / %f", dividend, divisor));
    }

    return (dividend / divisor);
}

}