/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator.model;

/**
 *
 * @author Martin Bergqvist (S141564)
 */
public class Token {
    public Double value = null;
    public char operator = '\0';
    public String tokenString;
    
    public void CreateToken(String tokenString){
        
        if(tokenString.equals("+") || tokenString.equals("-") || tokenString.equals("*") || tokenString.equals("/") || tokenString.equals("%")){    
            Token token = new OperatorToken(tokenString);
        }
        else{
            try{
                Token token = new OperandToken(tokenString);
            }
            catch(NumberFormatException e){
                System.out.println("Illegal Token format: " + e.toString());
            }
        }
    }
    
    public Token(){
    }
    public Token(String tokenString){
        this.tokenString = tokenString;
    }
}