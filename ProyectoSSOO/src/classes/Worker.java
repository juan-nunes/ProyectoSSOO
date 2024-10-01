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
 * @author orveodiluca
 */
public class Worker extends Thread {
    
    //Constantes
    public final int MOTHERBOARD_WORKER = 0;
    public final int CPU_WORKER = 1;
    public final int RAM_WORKER = 2;
    public final int POWERSUPPLY_WORKER = 3;
    public final int GPU_WORKER = 4;
    
    //Atributos
    private int type;
    private int salaryPerHour;  
    private int daysPerComponent;
    private Wharehouse wharehouse;
    private int profit;   
    private Semaphore mutex;
    
    //Constructor
    public Worker(int type, int daysPerComponent, Wharehouse wharehouse, Semaphore mutex){
        this.type = type; 
        switch (type) {
            case MOTHERBOARD_WORKER: 
                this.salaryPerHour = 20;
                break;
                
            case CPU_WORKER: 
                this.salaryPerHour = 26;
                break;
                
            case RAM_WORKER: 
                this.salaryPerHour = 40;
                break;
                
            case POWERSUPPLY_WORKER: 
                this.salaryPerHour = 16;
                break;
                
            case GPU_WORKER: 
                this.salaryPerHour = 34;
                break;            
                
            default:
                this.salaryPerHour = 0;
                break;
        } 
        this.daysPerComponent = daysPerComponent;
        this.wharehouse = wharehouse;
        this.profit = 0;  
        this.mutex = mutex;
    }
    
    
    
    //==============================Metodos============================
    public void charge(){
        this.profit += this.salaryPerHour;
    }
    
    
    @Override
    public void run(){
        boolean run = true;
        while(run){
            try {
                Thread.sleep(wharehouse.getDaysDuration()/24);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.charge();
            if(wharehouse.getDaysCounter() % this.daysPerComponent == 0){
                this.storeComponent();
            }
            System.out.println("Dias -> " + wharehouse.getDaysCounter());
            System.out.println("Motherboards -> " + wharehouse.getMotherboards());
            System.out.println("Cpu -> " + wharehouse.getCpus());
            System.out.println("Ram -> " + wharehouse.getRams());
            System.out.println("Power Supply -> " + wharehouse.getPowerSupplys());
            System.out.println("GPU -> " + wharehouse.getGpus() + "\n");
            
        }
    }
    
    
    public void storeComponent(){
        switch (type) {
            case MOTHERBOARD_WORKER -> this.wharehouse.addMotherboard();
                
            case CPU_WORKER -> this.wharehouse.addCpu();
                
            case RAM_WORKER -> this.wharehouse.addRam();
                
            case POWERSUPPLY_WORKER -> this.wharehouse.addPowerSupply();
                
            case GPU_WORKER -> this.wharehouse.addGpu();                            
        }
    }
    
    
        
    //======================Getters y Setters=======================
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public int getDaysPerComponent() {
        return daysPerComponent;
    }

    public void setDaysPerComponent(int daysPerComponent) {
        this.daysPerComponent = daysPerComponent;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Wharehouse getWharehouse() {
        return wharehouse;
    }

    public void setWharehouse(Wharehouse wharehouse) {
        this.wharehouse = wharehouse;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    
    
    


    
    
    
    
    
    
  
}

