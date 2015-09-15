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

public class OperatorToken extends Token{
    private char operator;
  
    public OperatorToken(String sString){
        super(sString);
        this.operator=sString.charAt(0);
    }

    public char GetOperator(){
        return operator;
}
@Override
    public String toString(){
        String s = "This is OperatorToken: " +operator;
        return s;
    }
}
