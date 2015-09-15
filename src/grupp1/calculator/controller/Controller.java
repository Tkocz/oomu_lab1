package grupp1.calculator.controller;

import grupp1.calculator.exceptions.DivisionByZeroException;
import grupp1.calculator.exceptions.InvalidOperationException;
import grupp1.calculator.exceptions.InvalidTokenException;
import grupp1.calculator.model.*;

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
                //if (false) throw new DivisionByZeroException(null);
                //if (false) throw new InvalidOperationException(null);
                //if (false) throw new InvalidTokenException(null);
                Token poppedToken = tokenStack.pop();
                if(poppedToken instanceof OperatorToken){
                    System.out.println("" +((OperatorToken)poppedToken).GetOperator());
                }
                else 
                    System.out.println("" +((OperandToken)poppedToken).GetOperand());
                // nyttjar ännu ej subklasser, men fungerar iaf.
            }
            /*catch (DivisionByZeroException e) {
               System.out.println("DivsionByZeroException: " + e.toString());
            }
            catch (InvalidOperationException e) {
                System.out.println("InvalidOperationException: " + e.toString());
            }
            catch (InvalidTokenException e) {
                System.out.println("InvalidTokenException: " + e.toString());
            }
            catch (Exception e) {
                System.out.println("Exception: " + e.toString());
            }
        }*/
    }
}
