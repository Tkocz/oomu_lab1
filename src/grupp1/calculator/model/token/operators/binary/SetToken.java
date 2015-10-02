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
import grupp1.calculator.model.expression.Expression;;

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
 * @param expression The sequence to evaluate.
 * @return The result of evaluating the sequence.
 * @author Philip Arvidsson (S133686)
 * @throws java.lang.Exception Evaluation exception.
 */
@Override
public double evaluate(Expression expression) throws Exception {
    Token token = expression.getNextToken();

    /**
     * Ni vill undvika att använda "instanceof" i eran kod, om möjligt (ni
     * använder detta i SetToken). Detta är oftast en tecken på att den
     * objektorienterade designen behöver ses över.
     *
     * KOMMENTAR:
     *   Nja, nu är du ute och cyklar. ;-) Variabler kan användas på två vis:
     *   Antingen läser man ut en variabels värde, eller så skriver man ett
     *   värde till en variabel. När vi bara har en variabel-token ($x) så läser
     *   vi ut variabelns värde. Ex: 4 $x + som ju i annan notation är x+4. När
     *   vi däremot vill skriva till en variabel så använder vi följande
     *   uttryck: 4 $x = (eller x=4 i mer reguljär form). När vi är i denna
     *   metod (SetToken.evaluate()) så vet vi alltå att en variabel ska till-
     *   delas. Däremot inte vilken! Därför måste vi läsa ut namnet på den
     *   (vilket ju är nästkommande token!). Det kan vi göra genom att anropa
     *   getNextToken(). MEN! Vi måste försäkra oss om att den token vi får
     *   tillbaka är en VarToken. Något annat vore ett syntaxfel (ex. skulle
     *   uttryck som 4 0 = tillåtas, dvs till dela värdet noll värdet fyra.)
     *   För att omöjliggöra det använder vi instanceof. INGEN annan lösning
     *   finns med arkiktektur vi byggt vår kalkylator kring. Om du ändå anser
     *   att vi har fel uttamanar jag dig att presentera en alternativ lösning!
     *
     *   // Philip  :-)
     */

    if (!(token instanceof VarToken))
        throw new InvalidOperationException("Expected variable name.");

    double val = expression.getNextToken().evaluate(expression);

    VarToken.setVar(token.GetString(), val);

    return (val);
}

}
