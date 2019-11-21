/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angrykombat
 */
public class MultithreadingDemo extends MyMap implements Runnable{
    public void run() 
    { 
        try
        { 
            // Displaying the thread that is running 
            Thread.sleep(1000);
            System.out.println ("Thread " + 
                                Thread.currentThread().getId() + 
                                " is running"); 
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
    
}
