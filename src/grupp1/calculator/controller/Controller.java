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
 * @throws java.io.IOException In the event of Input/Output madness
 */
public void run() throws IOException {
    IOHelper io; // @To-do: Make a class for this crap.

    while (true) {
        String s = io.readLine();

        if (s == null || s.equals(""))
            break; // ...and we're done!

        try {
            double result = evaluateExpression(s);

            io.writeLine(result);
        }
        catch (Exception e) {
            String msg = e.toString() + " @ " + e.getStackTrace()[0].toString();
            System.out.println(msg);

            io.writeLine(msg);
        }
    }

    // -
}

/**
 * Evaluates the specified expression string.
 * @param s The expression string.
 * @return The result of the expression.
 * @throws InvalidTokenException An invalid token was encountered.
 * @throws DivisionByZeroException An attempt to divide by zero was encountered.
 */
private double evaluateExpression(String s) throws Exception {
    /*
    En annan "best practice" är att använda meningsfulla, fullständiga (ej
    förkortningar) namn på variabler, metoder, mm.

    KOMMENTAR:

        Njaha. Konsensus måste väl ändå vara att koden ska gå att förstå.
        Namnet evaluateExpr() är uppenbart för alla som har programmerat över
        huvud taget. Men ok, jag förstår vad du syftar på, så jag ändrar. Jag
        har i övrigt ganska svårt för Javas "super verbose" stil.

        // Philip
    */

    Stack<Token> stack = new Stack<>();

    for (String str : s.split(" ")) {
        Token tok = config.getTokenFactory().getToken(str);

        if (tok == null)
            throw new InvalidTokenException(str);

        stack.push(tok);
    }

    double r = stack.pop().eval(stack);

    if (!stack.isEmpty())
        throw new InvalidOperationException("Stack was not evaluated properly.");

    return (r);

}

}
