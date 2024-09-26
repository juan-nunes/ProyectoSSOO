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
    private int workerProfit;
    private int salaryPerHour;
    private int daysPerComponent;
    private int components;
    public int days;
    public int hours;
    private Semaphore sem;       
    
    public Worker(int type, int daysPerComponent, Semaphore sem){
        this.type = type; 
        this.workerProfit = 0;
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
        this.daysPerComponent = daysPerComponent;
        this.days = 0;
        this.hours = 0;
        this.sem = sem;         
    }
    
    @Override
    public void run(){
        try{
            while(true){
                System.out.println("Dia " + this.days + ". Hora " + this.hours);
                System.out.println("El trabajador ha ganado " + this.workerProfit + "$");
                System.out.println("Se han hecho " + this.components + " componentes\n");
                this.workerProfit += this.salaryPerHour;
                this.hours += 1;
                if(this.hours / 24 == 1){
                    this.days++;
                    this.components++;
                    this.hours = 0;
                }                
                Thread.sleep(1000);               
            }
        }   
        catch(Exception e){
            System.out.println(e);
        }
    }
    

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSalaryperhour() {
        return salaryPerHour;
    }

    public void setSalaryperhour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public Semaphore getSem() {
        return sem;
    }

    public void setSem(Semaphore sem) {
        this.sem = sem;
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    
    

    

        
    

    
    
    
    
}
