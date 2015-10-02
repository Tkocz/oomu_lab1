/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model.expression;

import grupp1.calculator.model.token.Token;

/**
 *
 * @author Martin
 */
public interface Expression {
    
    public void addToken(Token token);
    
    public Token getNextToken();
    
    public Boolean isEmptyExpression();
    
    public void clearExpression();
}
