package grupp1.calculator.model.expression;

import grupp1.calculator.model.token.Token;


/**
 * Interface Expression
 * Signatures for addToken, getNextToken, isEmptyExpression and clearExpression
 * @author Martin Bergqvist (S141564)
 */
public interface Expression {
    
    public void addToken(Token token);
    
    public Token getNextToken();
    
    public Boolean isEmptyExpression();
    
    public void clearExpression();
}
