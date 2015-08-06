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
public class ThreadSynchronisation {

    private int count = 0;
    public synchronized void incriment()
    {
        count++;
    }
    public static void main(String[] args) {
     ThreadSynchronisation obj = new ThreadSynchronisation();
        obj.process();
    }
    
    public void process()
    {
           Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0;i<1000;i++)
                {
                    incriment();
                }
            }
        });
              Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0;i<1000;i++)
                {
                    incriment();
                }
            }
        });
           t1.start();
           t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadSynchronisation.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
           System.out.println("Count is"+ count);
    }
}
