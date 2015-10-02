package grupp1.calculator.view;

import java.util.Scanner;

public class StdIO implements IOHelper {

/**
 * The prompt string to display, or null to not display any prompt.
 */
private String prompt = "> ";

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

public void writeLine(String s) {
    System.out.println(s);
}

public String readLine() {
    System.out.print(prompt);
    return scanner.nextLine();
}

}
