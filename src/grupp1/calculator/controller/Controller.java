package grupp1.calculator.controller;

import grupp1.calculator.CalculatorConfig;
import grupp1.calculator.model.token.*;
import grupp1.calculator.exceptions.*;
import grupp1.calculator.view.ResultPrinter;

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
 * @throws java.io.IOException In the event of Input/Output madness
 */
public void run() throws IOException {
    // Optimally, this should be passed in to this class so that the output
    // format can be modified more easily.
    ResultPrinter result_printer = new ResultPrinter(config.output,
                                                     config.precision);
    
    // Auto-closeables.
    try (InputStreamReader isr = new InputStreamReader(config.input)) {
    try (BufferedReader    br  = new BufferedReader   (isr)      ) {

    while (true) {
        // The prompt is only useful for System.out, really.
        if ((config.output == System.out) && (config.prompt != null))
            config.output.print(config.prompt);

        String s = br.readLine();
        
        if (s == null || s.equals(""))
            break; // ...and we're done!
        
        // When not using System.out, we might want to output the
        // expressions as well.
        if (config.output != System.out)
            config.output.println(s);
        
        try {
            double r = evaluateExpr(s);
            result_printer.printResult(r);
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
 * @throws DivisionByZeroException An attempt to divide by zero was encountered.
 */
private double evaluateExpr(String s) throws Exception {
    Stack<Token> seq = new Stack<>();

    for (String str : s.split(" ")) {
        Token tok = config.token_factory.getToken(str);
        
        if (tok == null)
            throw new InvalidTokenException(str);
        
        seq.push(tok);
    }
    
    double r = seq.pop().eval(seq);
        
    if (!seq.isEmpty())
        throw new InvalidOperationException();
    
    return (r);
        
}

}
