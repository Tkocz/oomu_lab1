package grupp1.calculator.view;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StreamIO implements IOHelper {

private final BufferedReader input;
private final PrintStream output;

public StreamIO(InputStream input, OutputStream output) {
    this.input  = new BufferedReader(new InputStreamReader(input));
    this.output = new PrintStream(output);
}

public void writeLine(String s) {
    output.println(s);
}

public String readLine() {
    try {
        return input.readLine();
    }
    catch (Exception e) {
        return (null);
    }
}

}
