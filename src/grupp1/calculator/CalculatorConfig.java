package grupp1.calculator;

import grupp1.calculator.model.token.TokenFactory;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Represents the calculator configuration.
 * @author Philip Arvidsson (S133686)
 */
public class CalculatorConfig {

/**
 * The prompt string to display, or null to not display any prompt.
 */
public String prompt = "> ";

/**
 * The input stream where expressions are to be read from by the calculator. The
 * default is System.in.
 */
public InputStream input = System.in;

/**
 * The output stream where results are to be written to by the calculator. The
 * default is System.out.
 */
public PrintStream output = System.out;

/**
 * The precision, in number of decimals, to display in results. The default
 * value is 4.
 */
public int precision = 4;

/**
 * The token factory to use for acquiring tokens (operators, etc.).
 */
public TokenFactory token_factory = new TokenFactory();

}
