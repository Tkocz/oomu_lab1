package grupp1.calculator.view;

import java.util.Scanner;

/**
 * Provides an implementation of IOHelper that uses stdin/stdout for input and
 * output.
 * @author Philip Arvidsson (S133686)
 */
public class StdIO implements IOHelper {

/**
 * The prompt string to display, or null to not display any prompt.
 */
private String prompt = "> ";

/**
 * The scanner used to read from System.in in a simple manner.
*/
private final Scanner scanner = new Scanner(System.in);

/**
 * Gets the prompt string.
 * @return The prompt string.
 */
public String getPrompt() {
    return (prompt);
}

/**
 * Sets the prompt string.
 * @param value The prompt string.
 */
public void setPrompt(String value) {
    prompt = value;
}

/**
 * Reads a line from the input.
 * @return The line of text read from the input, or null.
 */
public String readLine() {
    System.out.print(prompt);
    return scanner.nextLine();
}

/**
 * Writes a line of text to the output.
 * @param s The line of text to write.
 */
public void writeLine(String s) {
    System.out.println(s);
}

}
