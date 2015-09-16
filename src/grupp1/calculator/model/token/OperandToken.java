/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model.token;

/**
 * This class contains the Subclass OperandToken, 
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

@Override
    public String toString(){
        String s = "This is a OperandToken with the Value of: " +value;
        return s;
    }
}