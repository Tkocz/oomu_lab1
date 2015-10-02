package grupp1.calculator.model.token;

import grupp1.calculator.model.expression.Expression;

/**
 * Contains the Subclass OperandToken, 
 * and it's operation GetOperand, as well as the 
 * override function for toString.
 * @author Martin Bergqvist (S141564)
 */
public class OperandToken extends Token{
    private double value;

    /**
    * Creates an OperandToken from the specified string.
    * @param sString The string to create a token from.
    */
    public OperandToken(String sString){
        super(sString);
        value = Double.valueOf(sString);
    }
    
    /**
    * 
    * @return value returns the stored value from the token
    */
    public double GetOperand(){
        return value;
    }
    
    /**
     * Evaluates the specified token sequence to produce an arithmetic result.
     * @param expression The sequence to evaluate.
     * @return The result of evaluating the sequence.
     * @author Philip Arvidsson (S133686)
     */
    @Override
    public double evaluate(Expression expression){
        return (value);
    }

@Override
    public String toString(){
        String s = "This is a OperandToken with the Value of: " +value;
        return s;
    }
}