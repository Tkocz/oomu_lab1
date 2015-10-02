package grupp1.calculator.view;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Provides an implementation of IOHelper that reads and writes from and to
 * files.
 * @author Philip Arvidsson (S133686)
 */
public class StreamIO implements IOHelper {

/**
 * The input reader.
 */
private final BufferedReader input;

/**
 * The output stream.
 */
private final PrintStream output;

/**
 * Constructor.
 * @param input The input stream to read from.
 * @param output The output stream to write to.
 */
public StreamIO(InputStream input, OutputStream output) {
    this.input  = new BufferedReader(new InputStreamReader(input));
    this.output = new PrintStream(output);
}

/**
 * Reads a line from the input.
 * @return The line of text read from the input, or null.
 */
public String readLine() {
    try {
        return input.readLine();
    }
    catch (Exception e) {
        return (null);
    }
}

/**
 * Writes a line of text to the output.
 * @param s The line of text to write.
 */
public void writeLine(String s) {
    output.println(s);
}

}
