/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model.token;

import grupp1.calculator.exceptions.InvalidTokenException;
import grupp1.calculator.model.token.operators.binary.AddToken;
import grupp1.calculator.model.token.operators.binary.DivideToken;
import grupp1.calculator.model.token.operators.binary.ExponentToken;
import grupp1.calculator.model.token.operators.binary.ModuloToken;
import grupp1.calculator.model.token.operators.binary.MultiplyToken;
import grupp1.calculator.model.token.operators.binary.SubtractToken;
import grupp1.calculator.model.token.operators.unary.AcosToken;
import grupp1.calculator.model.token.operators.unary.AsinToken;
import grupp1.calculator.model.token.operators.unary.AtanToken;
import grupp1.calculator.model.token.operators.unary.CosToken;
import grupp1.calculator.model.token.operators.unary.PiToken;
import grupp1.calculator.model.token.operators.unary.RadToken;
import grupp1.calculator.model.token.operators.unary.SinToken;
import grupp1.calculator.model.token.operators.unary.TanToken;

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
    // Preferably, this should be done with RTTI; reflections and annotations.
    
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
        
    }
    
    try                             { Double.parseDouble(s); }
    catch (NumberFormatException e) { return null;           }
    
    return new OperandToken(s);
}

}
