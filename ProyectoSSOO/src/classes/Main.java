/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package classes;

import GUI.MainView;
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
//        int[] requeriments = {2, 1, 4, 4, 2};
//        Wharehouse wh = new Wharehouse(5, requeriments);
//        Semaphore companyMutex = new Semaphore(1);
//        Semaphore employeeMutex = new Semaphore(1);
//        Company apple = new Company("Apple", 19, wh, 7, 2000, 30, 100, 150, companyMutex, employeeMutex);
//        
//        int[] arrayWorkers = {3, 3, 3, 3, 3};
//        apple.createWorkers(arrayWorkers);
//        apple.createAssemblers(3);
//        
//        apple.start();
                        

        MainView mv = new MainView();
        mv.setVisible(true);
        
    }
    
}
