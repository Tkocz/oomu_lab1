package grupp1.calculator.exceptions;

/**
 * Representerar ett fel som genererats av en ogiltig token.
 * @author Philip Arvidsson (S133686)
 */
public class InvalidTokenException extends Exception {
    /**
     * @private
     * Den token som genererade felet.
     */
    private Object token;
    
    /**
     * Konstruktor.
     * @param token Den token som genererade felet.
     */
    public InvalidTokenException(Object token) {
        this.token = token;
    }
    
    /**
     * Hämtar en sträng som beskriver felet.
     * @return En sträng som beskriver felet.
     */
    @Override public String toString() {
        // @To-do: Använd token för att skriva ut namnet på den token som
        //         genererade felet.
        return ("sån här skit vill jag inte veta av");
    }
}
