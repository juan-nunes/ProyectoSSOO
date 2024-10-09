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
    
    
    

    

    
    
    
}
