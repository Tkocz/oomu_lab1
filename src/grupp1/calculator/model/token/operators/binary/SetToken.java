package grupp1.calculator.model.token.operators.binary;

import grupp1.calculator.exceptions.InvalidOperationException;
import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.model.token.operators.unary.VarToken;
import java.util.Stack;

/**
 * Provides a token for setting variable values.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "=")
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
 * @param stack The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Philip Arvidsson (S133686)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double eval(Stack<Token> stack) throws Exception {
    Token token = stack.pop();
    
    if (!(token instanceof VarToken))
        throw new InvalidOperationException();
    
    double val = stack.pop().eval(stack);
    
    VarToken.setVar(token.GetString(), val);
    
    return (val);
}

}
