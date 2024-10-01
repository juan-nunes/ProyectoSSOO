package classes;

import DataStructures.List;
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
        int[] necessities = {2, 1, 4, 4};
        Wharehouse wh = new Wharehouse(necessities, 12, 3000);
        Company company = new Company(
                "Apple", 
                19, 
                wh,
                3000, 
                10, 
                necessities,
                12,
                40,
                60
        );
        
        Semaphore sem1 = new Semaphore(1);
        Semaphore sem2 = new Semaphore(1);
    
        Worker motherboard = new Worker(0, 3, wh, sem1);
        Worker cpu = new Worker(1, 3, wh, sem1);
        Worker ram = new Worker(2, 3, wh, sem1);
        Worker powerSupply = new Worker(3, 3, wh, sem1);
        Worker gpu = new Worker(4, 3, wh, sem1);
        
        Assembler assembler1 = new Assembler(wh, 2, 3, 1, 1, sem2);
        Assembler assembler2 = new Assembler(wh, 1, 2, 3, 2, sem2);
        
        List workers = company.getWorkers();
        workers.append(motherboard);
        workers.append(cpu);
        workers.append(ram);
        workers.append(powerSupply);
        workers.append(gpu);
        
        List assemblers = company.getEmployeesAssemblers();
        assemblers.append(assembler1);
        assemblers.append(assembler2);
        
        company.startSimulation();
        
    }
}

    
    
