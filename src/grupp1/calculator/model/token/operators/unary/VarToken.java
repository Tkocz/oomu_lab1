package grupp1.calculator.model.token.operators.unary;

import grupp1.calculator.exceptions.InvalidOperationException;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import java.util.HashMap;
import java.util.Map;
import grupp1.calculator.model.expression.Expression;

/**
 * Provides a token for loading variable values.
 * @author Philip Arvidsson (S133686)
 */
public class VarToken extends OperatorToken {
   
/**
 * All variables. This is super hacky, but who cares... It works.
 */
private static final Map<String, Double> vars = new HashMap<>();

/**
 * Constructor.
 * @param name Variable name.
 */
public VarToken(String name) {
    super(name);
}

/**
 * Mega hacky and ugly way of setting variable values.
 * @param name Var name,
 * @param val  Var value.
 */
public static void setVar(String name, double val) {
    vars.put(name, val);
}

/**
 * Evaluates the specified token sequence to produce an arithmetic result.
 * @param stack The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Philip Arvidsson (S133686)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double evaluate(Expression expression) throws Exception {
    String var = this.GetString();
    
    if (!vars.containsKey(var))
        throw new InvalidOperationException("No such variable exists: " + var);
    
    return (vars.get(this.GetString()));
}

}
