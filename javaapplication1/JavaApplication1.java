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
class Runner extends Thread
{
    
    @Override
    public void run(){
        for(int i=0;i<10;i++)
        {
            System.out.println("Hello " + i);
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World");
        Runner T1= new Runner();
        T1.start();
        Runner T2= new Runner();
        T2.start();
    }
    
}
