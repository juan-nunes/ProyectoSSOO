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
        int[] necessities = {2, 1, 4, 1, 1, 3};
        Semaphore sem = new Semaphore(1); 
        Company company = new Company("Tech Corp", 10, 0, 0, 0, 0, 0, 0, sem);
        Wharehouse warehouse = new Wharehouse(necessities, company);
        warehouse.setMotherboardComponent(10);
        warehouse.setCpuComponent(10);
        warehouse.setRamComponent(10);
        warehouse.setPowerSupplyComponent(10);
        warehouse.setGpuComponent(10);
        warehouse.setPcGPU(10);
        warehouse.setCounterGPU(10);
        printWarehouseState(warehouse);
        warehouse.addPC(5); 
        printWarehouseState(warehouse);
        Worker[] workers = new Worker[5]; // Create 5 workers
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker(i % 5, 1000, 2, warehouse, sem, 3); // Each worker works on a different component type
            workers[i].start(); // Start the worker thread
        }
        
        // Wait for all workers to finish (optional)
        for (Worker worker : workers) {
            try {
                worker.join(); // Wait for worker threads to complete
            } catch (InterruptedException e) {
                System.err.println("Worker interrupted: " + e.getMessage());
            }
        }
    }

    private static void printWarehouseState(Wharehouse warehouse) {
        System.out.println("Current Warehouse State:");
        System.out.println("Motherboards: " + warehouse.getMotherboardComponent());
        System.out.println("CPUs: " + warehouse.getCpuComponent());
        System.out.println("RAM: " + warehouse.getRamComponent());
        System.out.println("Power Supplies: " + warehouse.getPowerSupplyComponent());
        System.out.println("GPUs: " + warehouse.getGpuComponent());
        System.out.println("PC GPUs: " + warehouse.getPcGPU());
        System.out.println("Total Computers Produced: " + warehouse.getComputers());
        System.out.println("------------------------------");
    }
        
        
        /*MainView mv = new MainView();
        mv.setVisible(true);*/
        
    }

    
    
