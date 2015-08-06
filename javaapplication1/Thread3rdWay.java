/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 28080
 */
public class Thread3rdWay {
    
    public static void main(String[] args) {
        Thread T1;
        T1 = new Thread(() -> {
            for(int i=0;i<10;i++)
            {
                System.out.println("Hello " + i);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        T1.start();
    }
}
