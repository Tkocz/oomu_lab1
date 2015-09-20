package grupp1.calculator.view;

import java.io.PrintStream;

/**
 * The most useless class in history of Java. It exists solely on the basis of
 * a technicality in the lab specification which requires us to implement this
 * absolutely useless module.
 * 
 * @author Philip Arvidsson (S133686)
 */
public class ResultPrinter {
    /**
     * Output stream.
     */
    private PrintStream output;
    
    /**
     * Result string format.
     */
    private String result_format;
    
    /**
     * Constructor.
     * @param output Output stream.
     * @param precision Precision; number of decimals.
     */
    public ResultPrinter(PrintStream output, int precision) {
        this(output, "\t= %." + precision + "f");
    }
    
    /**
     * Constructor.
     * @param output Output stream.
     * @param result_format Result string format.
     */
    public ResultPrinter(PrintStream output, String result_format) {
        this.output        = output;
        this.result_format = result_format;
    }
    
    /**
     * The most amazing method in the entire program.
     * @param r I'm not going to tell you what this is. Assignment: Figure it
     *          out.
     */
    public void printResult(double r) {
        output.println(String.format(result_format, r));
    }
}
