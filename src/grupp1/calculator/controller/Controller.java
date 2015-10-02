package grupp1.calculator.controller;

import grupp1.calculator.CalculatorConfig;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.exceptions.*;
import grupp1.calculator.view.IOHelper;
import grupp1.calculator.model.expression.*;

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
    String fmt = "%." + Integer.toString(config.getPrecision()) + "f";
    
    IOHelper io = config.getIO();
    while (true) {
        String s = io.readLine();

        if (s == null || s.equals(""))
            break; // ...and we're done!

        try {
            double result = evaluateExpression(s);

            io.writeLine(String.format(fmt, result));
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


    Expression expression = new ExpressionStack();
    for (String str : s.split(" ")) {
        Token token = config.getTokenFactory().getToken(str);

        if (token == null)
            throw new InvalidTokenException(str);
        
        expression.addToken(token);
    }

    double r = expression.getNextToken().evaluate(expression);

    if (!expression.isEmptyExpression())
        throw new InvalidOperationException("Stack was not evaluated properly.");

    return (r);

}

}
