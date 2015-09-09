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
     * Det här är den bästa funktionen i hela programmet.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        
        controller.run();
    }
    
}
