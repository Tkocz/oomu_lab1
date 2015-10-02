/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model.expression;

import grupp1.calculator.model.token.Token;
import java.util.Stack;

/**
 *
 * @author Martin
 */
public class ExpressionStack implements Expression{
    Stack<Token> stack = new Stack<>();
    
@Override
    public void addToken(Token token){
        stack.push(token);
    }
    
@Override
    public Token getNextToken(){
        return(stack.pop());
    }
    
@Override
    public Boolean isEmptyExpression(){
        return(stack.isEmpty());
    }
    
@Override
    public void clearExpression(){
        stack.clear();
    }
    
}
