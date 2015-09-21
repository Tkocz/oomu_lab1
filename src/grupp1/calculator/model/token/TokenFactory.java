/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model.token;

import grupp1.calculator.model.token.operators.binary.*;
import grupp1.calculator.model.token.operators.constants.*;
import grupp1.calculator.model.token.operators.unary.*;

/**
 * Provides a factory class that creates appropriate tokens from strings.
 * @author Philip Arvidsson (S133686)
 */
public class TokenFactory {

/**
 * Creates a token from the specified string. Returns null if a token could
 * not be created.
 * @param s String to create token from.
 * @return A token representing the specified string.
 */
public Token getToken(String s) {
    // Preferably, this should be done with RTTI; reflection and annotations.
    
    switch (s) {
        
    // Binary operators.
    case "+": return new AddToken     (s);
    case "-": return new SubtractToken(s);
    case "/": return new DivideToken  (s);
    case "*": return new MultiplyToken(s);
    case "%": return new ModuloToken  (s);
    case "^": return new ExponentToken(s);
        
    // Unary operators.
    case "acos": return new AcosToken(s);
    case "asin": return new AsinToken(s);
    case "atan": return new AtanToken(s);
    case "cos":  return new CosToken (s);
    case "sin":  return new SinToken (s);
    case "tan":  return new TanToken (s);
    case "rad":  return new RadToken (s);
        
    // Constants.
    case "pi": return new PiToken(s);
        
    // Special.
        
    case "=": // Alias for 'set'.
    case "set": return new SetToken(s);
        
    }
    
    if (s.charAt(0) == '$')
        return new VarToken(s);
    
    try                             { Double.parseDouble(s); }
    catch (NumberFormatException e) { return null;           }
    
    return new OperandToken(s);
}

}
