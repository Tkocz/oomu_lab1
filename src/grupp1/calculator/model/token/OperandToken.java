/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model.token;

/**
 *
 * @author Martin Bergqvist (S141564)
*/

public class OperandToken extends Token{
    private double value;

    public OperandToken(String sString){
        super(sString);
        try{
            value = Double.valueOf(sString);
        }catch(NumberFormatException e){
            System.out.println("Illegal Token format: " + e.toString());
        }
    }

    public double GetOperand(){
        return value;
    }
@Override
    public String toString(){
        String s = "This is a OperandToken with the Value of: " +value;
        return s;
    }
@Override
    public boolean equals(Object obj){
        return (this == obj);
    }

@Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
}
