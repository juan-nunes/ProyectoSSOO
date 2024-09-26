package classes;

import java.util.concurrent.Semaphore;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author orveodiluca
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Semaphore semaphore = new Semaphore(3);
        
        Worker worker1 = new Worker(0, 1, semaphore);
        Worker worker2 = new Worker(0, 1, semaphore);
        Worker worker3 = new Worker(0, 1, semaphore);
        
        worker1.start();
        worker2.start();
        worker3.start();
        
    }
    
}
