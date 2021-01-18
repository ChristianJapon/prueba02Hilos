/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.Random;

/**
 *
 * @author japch
 */
public class Controlador {
    
       
    public void tColaAEstante() throws InterruptedException{
       Random r = new Random();
    int Low = 200;
    int High = 500;
    int Result = r.nextInt(High-Low) + Low;
    
        Thread.sleep(Result);
   
        
        
    }
   public void tatencion() throws InterruptedException{
       Random r = new Random();
   // int Low = 1500;
   //int High = 20000;
    int Low = 7;
    int High = 10;
    int Result = r.nextInt(High-Low) + Low;
        System.out.println("Empiesza la transaccion");
        Thread.sleep(Result*100);
        
        
        
    }
    
    
}
