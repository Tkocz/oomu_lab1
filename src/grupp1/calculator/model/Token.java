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
    public Token(){
    }
    public Token(String token){
        
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%")){
            operator = token.charAt(0);
        }
        else{
            try{
            value = Double.valueOf(token);
            }
            catch(NumberFormatException e){
                System.out.println("Illegal Token format: " + e.toString());
            }
        }
    }
}