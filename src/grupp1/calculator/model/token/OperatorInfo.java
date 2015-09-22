package grupp1.calculator.model.token;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for marking operator tokens.
 * @author Philip Arvidsson (S133686)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target   (ElementType.TYPE)
public @interface OperatorInfo {
    /**
     * Gets the operator string.
     * @return The operator string.
     */
    String op();
}
