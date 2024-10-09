/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] requeriments = {2, 1, 4, 4, 2};
        Wharehouse wh = new Wharehouse(5, requeriments);
        Semaphore companyMutex = new Semaphore(1);
        Semaphore employeeMutex = new Semaphore(1);
        Company apple = new Company("Apple", 19, wh, 7, 2000, 30, 100, 150, companyMutex, employeeMutex);
        
        
        ProyectManager pm = new ProyectManager(1, wh, employeeMutex);
        Worker w1 = new Worker(1, Worker.MOTHERBOARD_WORKER, 4, wh, employeeMutex);
        Worker w2 = new Worker(2, Worker.CPU_WORKER, 4, wh, employeeMutex);
        Worker w3 = new Worker(3, Worker.RAM_WORKER, 1, wh, employeeMutex);
        Worker w4 = new Worker(4, Worker.POWERSUPPLY_WORKER, (float) 1/5, wh, employeeMutex);
        Worker w5 = new Worker(5, Worker.GPU_WORKER, 2, wh, employeeMutex);
        
        Assembler a1 = new Assembler(1, wh, employeeMutex);
        
        Director d1 = new Director(0, wh, employeeMutex, pm, apple); 
        
        pm.start();
        d1.start();
        w1.start();
        w2.start();
        w3.start();
        w4.start();
        w5.start();
        a1.start();
        
    }
    
}
