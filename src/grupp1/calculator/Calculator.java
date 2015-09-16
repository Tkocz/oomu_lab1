package grupp1.calculator;

import grupp1.calculator.controller.Controller;
import grupp1.calculator.model.token.Token;

/**
 * Program main class.
 * @author Philip Arvidsson (S133686)
 */
public class Calculator {
    /**
     * @private
     * The program authors.
     */
    private static final String[] authors = { "Martin Bergqvist",
                                              "Philip Arvidsson" };
    
    /**
     * Prints out an introductory message.
     */
    private static void printIntroMsg() {
        System.out.println("nu körde du igång en polsk kalkylator som aldrig räknar rätt. dom där grekerna alltså...");
    }
    
    /**
     * Program main method. Do not call this method - it is done automatically
     * by the Java VM.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printIntroMsg();
        
        new Controller().run();
    }
}
