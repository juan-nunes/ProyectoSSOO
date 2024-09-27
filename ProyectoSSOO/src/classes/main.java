package classes;

import GUI.MainView;
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
        
        Semaphore sem = new Semaphore(1);
        Wharehouse wh = new Wharehouse();
        
        Worker worker = new Worker(0, 2000, 3, wh, sem, 4);
        worker.start();
        
    }
    
}
