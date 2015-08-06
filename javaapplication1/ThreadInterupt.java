/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;


class MyThread extends Thread{
    
   private volatile boolean running = true; 
    @Override
    public void run()
    {
        while(running)
        {
            System.err.println("Running");
        }
    }
    
    public void shutDown()
    {
        running = false;
    }
}
public class ThreadInterupt {
    
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        
        Scanner input = new Scanner(System.in);
        input.nextLine();
        
        t1.shutDown();
    }
}
