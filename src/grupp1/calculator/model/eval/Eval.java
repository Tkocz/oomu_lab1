/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model.eval;

/**
 *
 * @author Martin
 */
import grupp1.calculator.model.token.*;
import java.util.Stack;

public class Eval {
    
    public Eval(){
        
    }
    
    public double Eval(Stack<Token> tokenStack){
        Token node = (Token)tokenStack.pop();
        double rightNode;
        double leftNode;
        char operator;
        
        if(node instanceof OperatorToken){
            rightNode = Eval(tokenStack);
            leftNode = Eval(tokenStack);
            
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