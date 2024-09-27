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
    private int components;
    public int days;
    public int daysDuration; //Duracion de los dias de los trabajadores. 
    public int daysTofinishWork; 
    public Wharehouse wharehouse; 
    private Semaphore sem;       
    
    public Worker(int type,int dayDuration,int quantity ,Wharehouse wharehouse, Semaphore sem, int [] daysTofinish){
        this.type = type; 
        this.quantityWorkers = quantity; 
        this.daysTofinishWork = daysTofinish[type]; 
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
        this.daysDuration = dayDuration;
        this.sem = sem;   
        this.wharehouse = wharehouse; 
    }
    
    public void paysalary(){ //se calcula el salario que tiene el trabajador. 
        this.setWorkerProfit(this.getWorkerProfit() + (this.getSalaryPerHour() *24 ) * this.getQuantityWorkers()); 
    }
    
    public void work(){
        this.setDays(this.getDays() + 1);
        if(this.getDays() == this.getDaysTofinishWork()){
            try{
                this.getSem().acquire(); 
                this.getWharehouse(); 
            }catch(){
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

    public int getComponents() {
        return components;
    }

    public void setComponents(int components) {
        this.components = components;
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

