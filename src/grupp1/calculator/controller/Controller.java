package grupp1.calculator.controller;

import grupp1.calculator.model.token.*;
import grupp1.calculator.model.eval.*;
import grupp1.calculator.exceptions.*;

import java.util.Scanner;
import java.util.Stack;

/**
 * This class ties together the model and view packages to create a functioning
 * program.
 * @author Philip Arvidsson (S133686)
 */
public class Controller {
    /**
     * Calculator main method.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Stack<Token> tokenStack = new <Token>Stack();
        //Eval eval = new Eval();
        Token token;
        while (true) {

                String s = scanner.next();
                if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%")){    
                    token = new OperatorToken(s);
                }
                else{
                    token = new OperandToken(s);
                }
                tokenStack.push(token);
                if(s.equals("\n"))
                    System.out.println("Result: " + Eval(tokenStack));
        }
    }
}
