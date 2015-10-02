package grupp1.calculator.view;

/**
 * Provides a simple interface for implementing a calculator in/out helper
 * object.
 * @author Philip Arvidsson (S133686)
 */
public interface IOHelper {

/**
 * Reads a line from the input.
 * @return The line of text read from the input, or null.
 */
String readLine();

/**
 * Writes a line of text to the output.
 * @param s The line of text to write.
 */
void writeLine(String s);

}
