package grupp1.calculator.model.expression;

import grupp1.calculator.model.token.Token;
import java.util.Stack;

/**
 * Containing overrides for implementation of Stack-interface
 * @author Martin Bergqvist (S141564)
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
