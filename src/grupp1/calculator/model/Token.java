/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model;

/**
 *
 * @author Martin Bergqvist (S141564)
*/
public abstract class Token {

    private String tokenString;

    public Token(String sString) {
        tokenString = sString;
    }
  
    public Token(){
        tokenString = "";
    }

    public void SetString(String sString){
        tokenString = sString;
    }

    public String GetString(){
        return tokenString;
    }
@Override
    public String toString(){
        String s = "This is a Token with the StringValue of: " +tokenString;
        return s;
    }
}