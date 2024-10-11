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
public class Worker extends Thread {
    private int type; //0 = placaBase, 1 = cpu, 2 = memoriaRam, 3 = fuentesAlimentacion, 4 = GPU. 
    private int workerProfit; //Se usuará para el acumalado del salario del worker. 
    private int salaryPerHour;
    private int quantityWorkers; //Cantidad de trabajadores.     
    public int days;
    public int daysCount;
    public int daysDuration; //Duracion de los dias de los trabajadores. 
    public int daysTofinishWork; 
    public Wharehouse wharehouse; 
    private Semaphore sem;       
    
    public Worker(int type, int dayDuration, int quantity, Wharehouse wharehouse, Semaphore sem, int daysTofinish){
        this.type = type; 
        this.quantityWorkers = quantity; 
        this.daysTofinishWork = daysTofinish; 
        this.quantityWorkers = quantity; 
        switch (type) {
            case 0: //Productor de placa base
                this.salaryPerHour = 20;
                break;
                
            case 1: //Productor de CPU
                this.salaryPerHour = 26;
                break;
                
            case 2: //Productor de RAM
                this.salaryPerHour = 40;
                break;
                
            case 3: //Productor de fuente de alimentacion 
                this.salaryPerHour = 16;
                break;
                
            case 4: //Productor de GPU
                this.salaryPerHour = 34;
                break;            
                
            default:
                this.salaryPerHour = 0;
                break;
        }
        this.workerProfit = 0;
        this.days = 0;
        this.daysCount = 0;
        this.daysDuration = dayDuration;
        this.sem = sem;   
        this.wharehouse = wharehouse; 
    }
    
    
    @Override
    public void run(){
        boolean run = true;
        while(run){
            try{
                work();
                paysalary();
                sleep(this.daysDuration); 
                System.out.println("Dia: " + this.days);
                System.out.println("Ganancia del trabajdor: " + this.workerProfit);
                System.out.println("Placas base: " + this.wharehouse.getMotherboard());
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public void paysalary(){ //se calcula el salario que tiene el trabajador. 
        this.setWorkerProfit(this.getWorkerProfit() + (this.getSalaryPerHour() * 24 ) * this.getQuantityWorkers()); 
    }
    
    public void work(){
        this.setDays(this.getDays() + 1);
        this.daysCount++;
        if(this.daysCount == this.getDaysTofinishWork()){ // 4
            try{
                this.sem.acquire(); 
                switch (type) {
                    case 0: //placa base
                        this.wharehouse.addMotherboard(this.quantityWorkers);                        
                        break;
                        
                    case 1: //CPU
                        this.wharehouse.addCpu(this.quantityWorkers);                        
                        break;
                    
                    case 2: //RAM
                        this.wharehouse.addRam(this.quantityWorkers);                        
                        break;
                       
                    case 3: //powerSupply
                        this.wharehouse.addPowerSupply(this.quantityWorkers);                        
                        break;
                    
                    case 4: //GPU
                        this.wharehouse.addGpu(this.quantityWorkers);                        
                        break;                                                                                
                }
                this.sem.release();                
                this.daysCount = 0;
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWorkerProfit() {
        return workerProfit;
    }

    public void setWorkerProfit(int workerProfit) {
        this.workerProfit = workerProfit;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public int getQuantityWorkers() {
        return quantityWorkers;
    }

    public void setQuantityWorkers(int quantityWorkers) {
        this.quantityWorkers = quantityWorkers;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public int getDaysTofinishWork() {
        return daysTofinishWork;
    }

    public void setDaysTofinishWork(int daysTofinishWork) {
        this.daysTofinishWork = daysTofinishWork;
    }

    public Wharehouse getWharehouse() {
        return wharehouse;
    }

    public void setWharehouse(Wharehouse wharehouse) {
        this.wharehouse = wharehouse;
    }

    public Semaphore getSem() {
        return sem;
    }

    public void setSem(Semaphore sem) {
        this.sem = sem;
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
public class Worker extends Employee{
    
    //Atributos
    private int type;
    private Float daysPerComponent;
    private Float componentsPerDay;
    
    //Constantes
    public static final int MOTHERBOARD_WORKER = 0;
    public static final int CPU_WORKER = 1;
    public static final int RAM_WORKER = 2;
    public static final int POWERSUPPLY_WORKER = 3;
    public static final int GPU_WORKER = 4;
        
    //Constructor
    public Worker(int ID, int type, float daysPerComponent, Wharehouse wh, Semaphore mutex) {
        super(ID, wh, mutex);
        this.type = type;       
        if(daysPerComponent >= 1){
            this.daysPerComponent = daysPerComponent;            
            this.componentsPerDay = null;
        }
        else{
            this.daysPerComponent = null;
            this.componentsPerDay = 1/daysPerComponent;
        }
        
        switch(type){
            case MOTHERBOARD_WORKER -> setSalaryPerHour(20);
            
            case CPU_WORKER -> setSalaryPerHour(26);             
            
            case RAM_WORKER -> setSalaryPerHour(40);                            
            
            case POWERSUPPLY_WORKER -> setSalaryPerHour(16);                            
            
            case GPU_WORKER -> setSalaryPerHour(34);                            
        }
    }
    
    //===============Metodos=================
    public void run(){
        int days = 0;
        while(true){
            try {         
                collectSalary();
                
                //Caso en el que el trabajador tarda 1 dia o mas en crear el componente
                getMutex().acquire();
                if(daysPerComponent != null){
                    if(days == daysPerComponent){                         
                        storeComponent();
                        days = 1;
                    }
                    else days++;
                }

                //Caso en el que el trabajador tarda menos de 1 dia en crear el componente
                else if(componentsPerDay != null){   
                    int quantity = (int) componentsPerDay.floatValue();
                    storeComponent(quantity);
                    fixComponents();
                }
                getMutex().release();
                
                int[] components = getWh().getComponents();                
                                    
                
                Thread.sleep(Company.dayDuration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void storeComponent(){
        int[] components = getWh().getComponents();
        switch (type) {
            case MOTHERBOARD_WORKER -> {
                if(components[0] < 25){
                    components[0] += 1;
                }
            }
            
            case CPU_WORKER -> {
                if(components[1] < 20){
                    components[1] += 1;
                }
            }
            
            case RAM_WORKER -> {
                if(components[2] < 55){
                    components[2] += 1;
                }
            }
            
            case POWERSUPPLY_WORKER -> {
                if(components[3] < 35){
                    components[3] += 1;
                }
            }
            
            case GPU_WORKER -> {
                if(components[4] < 10){
                    components[4] += 1;
                }
            }                
        }
        
        getWh().setComponents(components);
    }   
    
    
    public void storeComponent(int quantity){
        int[] components = getWh().getComponents();
        switch (type) {
            case MOTHERBOARD_WORKER -> {
                if(components[0] < 25){
                    if((components[0] += quantity) > 25){
                        components[0] = 25;
                    }
                    else{
                        components[0] += quantity;                        
                    }
                }
            }
            
            case CPU_WORKER -> {
                if(components[1] < 20){
                    if((components[1] += quantity) > 20){
                        components[1] = 20;
                    }
                    else{
                        components[1] += quantity;                        
                    }
                }
            }
            
            case RAM_WORKER -> {
                if(components[2] < 55){
                    if((components[2] += quantity) > 55){
                        components[2] = 55;
                    }
                    else{
                        components[2] += quantity;                        
                    }
                }
            }
            
            case POWERSUPPLY_WORKER -> {
                if(components[3] < 35){
                    if((components[3] += quantity) > 35){
                        components[3] = 35;
                    }
                    else{
                        components[3] += quantity;                        
                    }
                }
            }
            
            case GPU_WORKER -> {
                if(components[4] < 10){
                    if((components[4] += quantity) > 10){
                        components[4] = 10;
                    }
                    else{
                        components[4] += quantity;                        
                    }
                }
            }                
        }
        
        getWh().setComponents(components);
    }
    
    public void fixComponents(){
        int[] components = getWh().getComponents();
        if(components[0] > 25){
            components[0] = 25;
        }
        
        else if(components[1] > 20){
            components[1] = 20;
        }
        
        else if(components[2] > 55){
            components[2] = 55;
        }
        
        else if(components[3] > 35){
            components[3] = 35;
        }
        
        else if(components[4] > 10){
            components[4] = 10;
        }
    }
    
    
       
    //===================Getters and Setters===================
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Float getDaysPerComponent() {
        return daysPerComponent;
    }

    public void setDaysPerComponent(Float daysPerComponent) {
        this.daysPerComponent = daysPerComponent;
    }

    public Float getComponentsPerDay() {
        return componentsPerDay;
    }

    public void setComponentsPerDay(Float componentsPerDay) {
        this.componentsPerDay = componentsPerDay;
    }

    @Override
    public String toString() {
        return "Worker" + getID() + "{ type=" + type + ", daysPerComponent=" + daysPerComponent + ", componentsPerDay=" + componentsPerDay + '}';
    }
    
    
    
    
    

    

    
    
    
}
>>>>>>> Stashed changes
