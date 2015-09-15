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
        Stack tokenStack = new Stack();
        while (true) {
            try {
                String s = scanner.next();
                Token token = new Token(s);
                tokenStack.push(token);
                if (false) throw new DivisionByZeroException(null);
                if (false) throw new InvalidOperationException(null);
                if (false) throw new InvalidTokenException(null);
                Token poppedToken;
                poppedToken = (Token) tokenStack.pop();
                if(poppedToken.value !=null)
                    System.out.println("nu skrev du " +poppedToken.tokenString);
                else System.out.println("nu skrev du " +poppedToken.tokenString);
                // nyttjar ännu ej subklasser, men fungerar iaf.
            }
            catch (DivisionByZeroException e) {
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
        }
    }
}
