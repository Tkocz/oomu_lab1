package grupp1.calculator.controller;

import grupp1.calculator.CalculatorConfig;
import grupp1.calculator.model.RPNCalculator;
import grupp1.calculator.model.expression.*;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.exceptions.*;
import grupp1.calculator.view.IOHelper;

import java.io.IOException;


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
    RPNCalculator calc = new RPNCalculator(config.getExpression(), config.getTokenFactory());
    String fmt = "%." + Integer.toString(config.getPrecision()) + "f";

    IOHelper io = config.getIO();
    while (true) {
        String s = io.readLine();

        if (s == null || s.equals(""))
            break; // ...and we're done!

        try {
            double result = calc.evaluateExpression(s);

            io.writeLine(String.format(fmt, result));
        }
        catch (Exception e) {
            String msg = e.toString() + " @ " + e.getStackTrace()[0].toString();

            io.writeLine("[ERROR] " + msg);
        }
    }

    // -
}

}
