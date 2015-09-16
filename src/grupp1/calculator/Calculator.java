package grupp1.calculator;

import grupp1.calculator.controller.Controller;

/**
 * Program main class.
 * @author Philip Arvidsson (S133686)
 */
public class Calculator {
    
/**
 * @private
 * The program authors.
 */
private static final String[] authors = { "Martin Bergqvist (S141564)",
                                          "Philip Arvidsson (S133686)" };

/**
 * Prints out an introductory message.
 */
private static void printIntroMsg() {
    System.out.println("oomj-lab1, implemented in Java by:");

    for (String author : authors)
        System.out.println("\t" + author);

    System.out.println("");
    System.out.println("Welcome. Enter an RPN expression below to");
    System.out.println("  calculate its result...");
    System.out.println("");
}

/**
 * Program main method. Do not call this method - it is done automatically
 * by the Java VM.
 * 
 * @param args the command line arguments
 */
public static void main(String[] args) {
    printIntroMsg();
    
    CalculatorConfig config = new CalculatorConfig();

    try {
        new Controller(config).run();   
    }
    catch (Exception e) {
        System.out.println("The calculator has crashed fatally.");
        System.out.println("Exception:");
        System.out.println("");
        System.out.println(e.toString());
    }
}

}
