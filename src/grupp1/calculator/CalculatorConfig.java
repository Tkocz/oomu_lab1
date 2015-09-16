package grupp1.calculator;

import grupp1.calculator.model.eval.Eval;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Represents the calculator configuration.
 * @author Philip Arvidss (S133686)
 */
public class CalculatorConfig {

/**
 * The prompt string to display, or null to not display any prompt. Default is
 * '> '.
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
 * The evaluator to use for evaluating expressions.
 */
public Eval evaluator = new Eval();

/**
 * The precision, in number of decimals, to display in results. The default
 * value is 4.
 */
public int precision = 4;

}
