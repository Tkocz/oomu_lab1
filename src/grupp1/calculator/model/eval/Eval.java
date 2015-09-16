/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model.eval;

import grupp1.calculator.model.token.*;
import java.util.Stack;

/**
 * This class is used to set up and evaluate the expressions created 
 * from the tokens stored
 * @author Martin Bergqvist (S141564)
 */
public class Eval {
    
    public Eval(){
    }
    
    /**
     * Retrieves an array containing all known operators.
     * @return An array containing all known operators.
     * @author Philip Arvidsson (S133686)
     */
    public String[] getKnownOperators() {
        return (new String[] {"+", "-", "*", "/", "%" });
    }
    
    /**
     * @param tokenStack A Stack contaioning all the Tokens of
     * the expression.
     * @return The calculated value of the expression
     * @author Martin Bergqvist (S141564)
     */
    public double Eval(Stack<Token> tokenStack){
        Token node = (Token)tokenStack.pop();
        double rightNode;
        double leftNode;
        char operator;
        
        if(node instanceof OperatorToken){
            leftNode = Eval(tokenStack);
            rightNode = Eval(tokenStack);
            
            operator = ((OperatorToken)node).GetOperator(); 
            
            switch (operator) {
                case '+':
                    return(rightNode + leftNode);
                case '-':
                    return(rightNode - leftNode);
                case '*':
                    return(rightNode * leftNode);
                case '/':
                    return(rightNode / leftNode);
                case '%':
                    return(rightNode % leftNode);
            }
        }
    return (((OperandToken)node).GetOperand());
    }
}