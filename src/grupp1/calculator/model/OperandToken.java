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
public class OperandToken extends Token{
    public OperandToken(String token) {
        super(token);
        value = super.value;
    }
    
}
