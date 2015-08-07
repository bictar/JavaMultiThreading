/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/* Only One Intrinsic LOCK for a worker object One thread will release then only 
othe can acquire*/
/**
 *
 * @author 28080
 */
public class ThreaadWorkingTime {

    private final Random randome;
    private final List<Integer> l1;
    private final List<Integer> l2 ;

    @SuppressWarnings("empty-statement")
    public ThreaadWorkingTime() {
     randome= new Random();
     l1 = new ArrayList<>();
     l2 = new ArrayList<>();
    }
    
    

    public synchronized void stageOne()
    {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreaadWorkingTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        l1.add(randome.nextInt(100));
    }
    public synchronized void stageTwo()
    {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreaadWorkingTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        l2.add(randome.nextInt(100));
    }
    
    public void process()
    {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
            
        }
         System.out.println("Length of List One: "+ l1.size() +" Length of list two :" + l2.size());
    }
    public static void main( String[] args)
    {
        ThreaadWorkingTime obj = new ThreaadWorkingTime();
        long start = System.currentTimeMillis();
         
         
         Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                obj.process();
            }
        });
         Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                obj.process();
            }
        });
         
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreaadWorkingTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        long end = System.currentTimeMillis();
        
        System.out.println("Time taken : "+(end - start));
       
    }
}
