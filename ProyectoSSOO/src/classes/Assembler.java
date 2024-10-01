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
public class Assembler extends Thread{
    
    //Atributos
    private int salaryPerHour; 
    private int daysPerComputer;  
    private int motherboardsNecesary;
    private int cpuNecesary;
    private int ramNecesary;
    private int powerSupplyNecesary; 
    private Wharehouse wharehouse;
    private int profit;
    private Semaphore mutex;
    
    //Constructor
    public Assembler(Wharehouse wharehouse, int motherboardsNecesary, int cpuNecesary, int ramNecesary, int powerSupplyNecesary,
            Semaphore mutex){
        this.salaryPerHour = 50; 
        this.daysPerComputer = 2; 
        this.motherboardsNecesary = motherboardsNecesary;
        this.cpuNecesary = cpuNecesary;
        this.ramNecesary = ramNecesary;
        this.powerSupplyNecesary = powerSupplyNecesary;
        this.wharehouse = wharehouse;
        this.profit = 0; 
        this.mutex = mutex;
    }
    
    //=========================Metodos=========================
    @Override
    public void run(){
        boolean run = true;
        while(run){
            try {
                Thread.sleep(wharehouse.getDaysDuration()/24);
            } catch (InterruptedException ex) {
                Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(this.wharehouse.getMotherboards() >= motherboardsNecesary && this.wharehouse.getCpus() >= cpuNecesary &&
               this.wharehouse.getRams() >= ramNecesary && this.wharehouse.getPowerSupplys() >= powerSupplyNecesary){
                this.wharehouse.removeMotherboard(motherboardsNecesary);
                this.wharehouse.removeCpu(cpuNecesary);
                this.wharehouse.removeRam(ramNecesary);                
                this.wharehouse.removePowerSupply(powerSupplyNecesary);                
                this.wharehouse.addComputer();
            }
        }
    }
    
    public void addComputer(){
        wharehouse.addComputer();
    }
        
    
    
    //=========================Getters y Setters=========================

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public int getDaysPerComputer() {
        return daysPerComputer;
    }

    public void setDaysPerComputer(int daysPerComputer) {
        this.daysPerComputer = daysPerComputer;
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

    public int getMotherboardsNecesary() {
        return motherboardsNecesary;
    }

    public void setMotherboardsNecesary(int motherboardsNecesary) {
        this.motherboardsNecesary = motherboardsNecesary;
    }

    public int getCpuNecesary() {
        return cpuNecesary;
    }

    public void setCpuNecesary(int cpuNecesary) {
        this.cpuNecesary = cpuNecesary;
    }

    public int getRamNecesary() {
        return ramNecesary;
    }

    public void setRamNecesary(int ramNecesary) {
        this.ramNecesary = ramNecesary;
    }

    public int getPowerSupplyNecesary() {
        return powerSupplyNecesary;
    }

    public void setPowerSupplyNecesary(int powerSupplyNecesary) {
        this.powerSupplyNecesary = powerSupplyNecesary;
    }
    
    
    
    
    
    
    
}
