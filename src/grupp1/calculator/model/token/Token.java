/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model.token;

/**
 * This class contains the superclass Token, as well as 
 * the Subclasses OperandToken & OperatorToken, needed to create a full 
 * mathematical expression.
 * @author Martin Bergqvist (S141564)
 */
public abstract class Token {

    private String tokenString;

    /**
    * @param sString The string to create a token from.
    */
    public Token(String sString) {
        tokenString = sString;
    }
  
    /**
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
@Override
    /**
    * 
    * @return s returns a string explaining the type of Class
    * and the stored string
    */
    public String toString(){
        String s = "This is a Token with the StringValue of: " +tokenString;
        return s;
    }
}