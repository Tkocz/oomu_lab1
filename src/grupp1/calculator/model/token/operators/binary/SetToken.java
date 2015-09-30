package grupp1.calculator.model.token.operators.binary;

/*
Ni vill undvika att använda "instanceof" i eran kod, om möjligt (ni använder
detta i SetToken). Detta är oftast en tecken på att den objektorienterade
designen behöver ses över.

KOMMENTAR:

    Jag förstår inte kritiken. Då parametern stack bara är en stack med bas-
    klass token så kan vi inte garantera typen av nästkommande token. Skriver
    man ex. '1 =' så kommer vi få en OperandToken efter SetToken eftersom dessa
    skapas i TokenFactory. Det finns inget sätt att komma runt detta med hjälp
    av objektorienterade paradigmer - mig veterligen. Ett sätt är möjligtvis att
    ha någon form av kontext när tokens instansieras i TokenFactory, men detta
    vore i sig ett brott mot OO-principer. Ytterligare en tänkbar lösning är att
    bygga ett syntaxträd och därutöver en lexer som verifierar att syntaxen är
    korrekt. Detta är överkurs gånger hundra för labbens ändamål. instanceof är
    en adekvat lösning.

    // Philip
*/

import grupp1.calculator.exceptions.InvalidOperationException;
import grupp1.calculator.model.token.OperatorInfo;
import grupp1.calculator.model.token.OperatorToken;
import grupp1.calculator.model.token.Token;
import grupp1.calculator.model.token.operators.unary.VarToken;
import java.util.Stack;

/**
 * Provides a token for setting variable values.
 * @author Philip Arvidsson (S133686)
 */
@OperatorInfo(op = "=")
public class SetToken extends OperatorToken {

/**
 * Constructor.
 * @param op Operator string.
 */
public SetToken(String op) {
    super(op);
}

/**
 * Evaluates the specified token sequence to produce an arithmetic result.
 * @param stack The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Philip Arvidsson (S133686)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double eval(Stack<Token> stack) throws Exception {
    Token token = stack.pop();

    if (!(token instanceof VarToken))
        throw new InvalidOperationException("Expected variable name.");

    double val = stack.pop().eval(stack);

    VarToken.setVar(token.GetString(), val);

    return (val);
}

}
