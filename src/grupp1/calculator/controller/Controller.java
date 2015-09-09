/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.controller;

import grupp1.calculator.exceptions.InvalidTokenException;
import java.util.Scanner;

/**
 *
 * @author Philip
 */
public class Controller {
    private void printIntroMsg() {
        System.out.println("helloooo");
    }
    
    public void run() {
        printIntroMsg();

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                String s = scanner.next();
                System.out.println("nu skrev du " + s);
                throw new InvalidTokenException();
                //tokenizer.createTokenFromString(s);
            }
            catch (InvalidTokenException e) {
                System.out.println("InvalidTokenException: " + e.toString());
            }
        }
    }
}
