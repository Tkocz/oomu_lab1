package grupp1.calculator.model.token;

/**
 * Contains the Subclass OperatorToken, 
 * and it's operation GetOperator, as well as the 
 * override function for toString.
 * @author Martin Bergqvist (S141564)
 */
public abstract class OperatorToken extends Token{
    private char operator;
  
    /**
    * Creates an OperatorToken from the specified string.
    * @param sString The string to create a token from.
    */
    public OperatorToken(String sString){
        super(sString);
        operator=sString.charAt(0);
    }
    /**
    * 
    * @return operator returns the stored operator from the token
    */
    public char GetOperator(){
        return operator;
}
    
@Override
    public String toString(){
        String s = "This is OperatorToken: " +operator;
        return s;
    }
}
