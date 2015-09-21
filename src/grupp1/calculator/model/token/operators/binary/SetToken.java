package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.exceptions.InvalidOperationException;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.model.token.operators.unary.VarToken;
import java.util.Stack;

/**
 * Provides a token for setting variable values.
 * @author Philip Arvidsson (S133686)
 */
public class SetToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public SetToken(String op) {
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
    Token token = seq.pop();
    
    if (!(token instanceof VarToken))
        throw new InvalidOperationException();
    
    double val = seq.pop().eval(seq);
    
    VarToken.setVar(token.GetString(), val);
    
    return (val);
}

}
