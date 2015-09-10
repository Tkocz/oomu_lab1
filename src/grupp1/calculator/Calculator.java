/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp1.calculator;

import grupp1.calculator.controller.Controller;

/**
 *
 * @author Philip
 */
public class Calculator {
    /**
     * Skriver ut ett introduktionsmeddelande.
     */
    private static void printIntroMsg() {
        System.out.println("nu körde du igång en polsk kalkylator som aldrig räknar rätt. dom där polackerna alltså...");
    }
    
    /**
     * Det här är den bästa funktionen i hela programmet.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printIntroMsg();
        
        new Controller().run();
    }
    
}
