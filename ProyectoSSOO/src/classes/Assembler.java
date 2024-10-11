<<<<<<< Updated upstream
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author orveodiluca
 */
public class Assembler extends Thread{
    private int salaryperhour; //Salario del ensamblador. 
    private int workday; //Días en lo que tarda. 
    private Semaphore mutex;
    private int motherboard; //placa base
    private int cpu; 
    private int ram; 
    private int powersupplies; //fuente de alimentacion. 
    
    public Assembler(int salaryperhour, int workday,Semaphore mutex){
        this.salaryperhour = salaryperhour; 
        this.workday = workday; 
        this.mutex = mutex; 
    }

    public int getSalaryperhour() {
        return salaryperhour;
    }

    public void setSalaryperhour(int salaryperhour) {
        this.salaryperhour = salaryperhour;
    }

    public int getWorkday() {
        return workday;
    }

    public void setWorkday(int workday) {
        this.workday = workday;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class Assembler extends Employee {
    
    //Constructor
    public Assembler(int ID, Wharehouse wh, Semaphore mutex) {
        super(ID, wh, mutex);
    }
    
    //===============Metodos=================
    public void run(){        
        int computers = 0;
        while(true){            
            try {
                collectSalary();
                
                getMutex().acquire();
                if(canAssemble()){    
                    System.out.println(getWh().getComputers()[0] + " " + getWh().getComputersToCreateGPUComputer());
                    if((computers % getWh().getComputersToCreateGPUComputer()) == 0 && computers != 0){
                        storeGPUComputer();                        
                        computers = 0;
                    }
                    else{
                        storeComputer();                    
                        computers = getWh().getComputers()[0];
                    }                    
                }
                getMutex().release();
                
                Thread.sleep(Company.dayDuration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    public void storeComputer(){ 
        int[] components = getWh().getComponents();
        int[] requeriments = getWh().getRequirements();
        
        if(canAssemble()){
            for (int i = 0; i < components.length - 1; i++) {
                components[i] -= requeriments[i];              
            }
            
            int[] computers = getWh().getComputers();
            computers[0]++;
            
            getWh().setComponents(components);
            getWh().setComputers(computers);
        }
    }
    
    public void storeGPUComputer(){
        int[] components = getWh().getComponents();
        int[] requeriments = getWh().getRequirements();

        if(canAssemble()){
            for (int i = 0; i < components.length - 1; i++) {
                components[i] -= requeriments[i];              
            }
            
            int[] computers = getWh().getComputers();
            computers[1]++;
            
            getWh().setComponents(components);
            getWh().setComputers(computers);
        }
    }
    
    public boolean canAssemble(){
        int[] components = getWh().getComponents();
        int[] requeriments = getWh().getRequirements();
        
        boolean canAssemble = true;
        for (int i = 0; i < components.length; i++) {
            if(components[i] < requeriments[i]){
                canAssemble = false;
            }
        }
        
        return canAssemble;
    }
    
    //===================Getters and Setters===================

    @Override
    public String toString() {
        return "Assembler" + getID();
    }
    
    
    
    
    
    
}
>>>>>>> Stashed changes
