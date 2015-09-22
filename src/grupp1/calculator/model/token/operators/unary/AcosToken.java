package grupp1.calculator.model.token.operators.unary;

import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import java.util.Stack;

/**
 * Provides a token for performing inverse cosine calculations.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "acos")
public class AcosToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public AcosToken(String op) {
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
    return (Math.acos(seq.pop().eval(seq)));
}

}
