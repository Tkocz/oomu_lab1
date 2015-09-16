package grupp1.calculator.controller;

import grupp1.calculator.CalculatorConfig;
import grupp1.calculator.model.token.*;
import grupp1.calculator.exceptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

/**
 * This class ties together the model and view packages to create a functioning
 * program.
 * @author Philip Arvidsson (S133686)
 */
public class Controller {

/**
 * The calculator configuration.
 */
private final CalculatorConfig config;

/**
 * Constructor.
 * @param config The configuration to use.
 */
public Controller(CalculatorConfig config) {
    this.config = config;
}

/**
 * Calculator main method.
 * @throws java.io.IOException
 */
public void run() throws IOException {
    // Auto-closeables.
    try (InputStreamReader isr = new InputStreamReader(config.input)) {
    try (BufferedReader    br  = new BufferedReader   (isr)      ) {

    while (true) {
        // The prompt is only useful for System.out, really.
        if ((config.output == System.out) && (config.prompt != null))
            config.output.print(config.prompt);

        String s = br.readLine();
        
        if (config.output != System.out) {
            // When not using System.out, we might want to output the
            // expressions as well.
            config.output.println(s);
        }
        
        try {
            double r = evaluateExpr(s);
            String result = String.format("\t= %." + config.precision + "f", r);
            config.output.println(result);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            
            if (config.output != System.out)
                config.output.println(e.toString());   
        }
    }

    }} // -
}

/**
 * Evaluates the specified expression string.
 * @param s The expression string.
 * @return The result of the expression.
 * @throws InvalidTokenException An invalid token was encountered.
 */
private double evaluateExpr(String s) throws InvalidTokenException {
    Stack<Token> tokens = new Stack<>();

    for (String str : s.split(" "))
        tokens.push(stringToToken(str));

    return (config.evaluator.Eval(tokens));
}

/**
 * Returns a value indicating whether the specified string represents a
 * mathematical operator understood by the calculator.
 * @param str The string to check.
 * @return True if the specified string contains a known, mathematical
 *         operator, otherwise false.
 */
private boolean isOperator(String str) {
    boolean is_operator = false;
    
    for (String op : config.evaluator.getKnownOperators())
        is_operator = is_operator || str.equals(op);
    
    return (is_operator);
}

/**
 * Creates a token from the specified string.
 * @param str The string to create a token from.
 * @return A token representing the contents of the string.
 * @throws InvalidTokenException A token could not be created from the specified
 *         string.
 */
private Token stringToToken(String str) throws InvalidTokenException {
    if (isOperator(str))
        return (new OperatorToken(str));

    // Make sure we'll be able to construct an instance of OperandToken...
    try                             { Double.parseDouble(str);              }
    catch (NumberFormatException e) { throw new InvalidTokenException(str); }

    return (new OperandToken(str));
}
    
}
