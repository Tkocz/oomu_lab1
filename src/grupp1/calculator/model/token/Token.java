package grupp1.calculator.model.token;

import java.util.Stack;

/**
 * Contains the superclass Token, as well as 
 * the Subclasses OperandToken and OperatorToken, needed to create a full 
 * mathematical expression.
 * @author Martin Bergqvist (S141564)
 */
public abstract class Token {
    private String tokenString;

    /**
    * @param sString The string to create a token from.
    */
    public Token(String sString){
        tokenString = sString;
    }
  
    /**
     * 
     */
    public Token(){
        tokenString = "";
    }
    
    /**
    * @param sString The string to set the Token to
    */
    public void SetString(String sString){
        tokenString = sString;
    }
    
    /**
    * @return sString The string the Token is set to
    */
    public String GetString(){
        return tokenString;
    }
    
    /**
     * Evaluates the specified token sequence to produce an arithmetic result.
     * @param seq The sequence to evaluate.
     * @return The result of evaluating the sequence.
     * @author Philip Arvidsson (S133686)
     * @throws java.lang.Exception Evaluation exception.
     */
    public abstract double eval(Stack<Token> seq)
            // We have to add this to allow exceptions in subclasses.
            throws Exception;
 
@Override
    public String toString(){
        String s = "This is a Token with the StringValue of: " +tokenString;
        return s;
    }
}