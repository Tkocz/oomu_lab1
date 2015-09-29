package grupp1.calculator;

import grupp1.calculator.model.token.TokenFactory;
import java.io.InputStream;
import java.io.PrintStream;

/*
----------------------------------
grupp1.calculator.CalculatorConfig
----------------------------------
Här behöver ni använda inkapsling på ett korrekt sätt. Skriv om eran kod så att
ni kapslar in eran data (privata attribut) i CalculatorConfig klassen. Era
attribut skall endast accessas via "getter" och "setter" metoder. Ni kanske vill
testa på att använda "java.util.Properties" istället.

KOMMENTAR:

    Accepterar kritiken då den är relevant för labbens infallsvinkel, men det
    finns ingen poäng alls med inkappsling av en POD-typ som bara ska bära
    data. Ändrar.

    // Philip
*/

/**
 * Represents the calculator configuration.
 * @author Philip Arvidsson (S133686)
 */
public class CalculatorConfig {

/**
 * The prompt string to display, or null to not display any prompt.
 */
private String prompt = "> ";

/**
 * The input stream where expressions are to be read from by the calculator. The
 * default is System.in.
 */
private InputStream input = System.in;

/**
 * The output stream where results are to be written to by the calculator. The
 * default is System.out.
 */
private PrintStream output = System.out;

/**
 * The precision, in number of decimals, to display in results. The default
 * value is 4.
 */
private int precision = 4;

/**
 * The token factory to use for acquiring tokens (operators, etc.).
 */
private TokenFactory token_factory = new TokenFactory();

public String getPrompt()             { return (prompt); }
public void   setPrompt(String value) { prompt = value;  }

public void        setInput(InputStream value) { input = value;  }
public InputStream getInput()                  { return (input); }

public void        setOutput(PrintStream value) { output = value;  }
public PrintStream getOutput()                  { return (output); }

public void setPrecision(int value) { precision = value;  }
public int  getPrecision()          { return (precision); }

}
