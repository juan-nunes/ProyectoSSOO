/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import javax.swing.JOptionPane;
import javax.swing.JLabel;

/**
 *
 * @author juann
 */
public class Wharehouse {
    
    //Atributos
    private int motherboards; 
    private int cpus; 
    private int rams; 
    private int powerSupplys; 
    private int gpus;
    private int computers;
    private int gpuComputers; 
    private int daysCounter;
    private int hoursCounter;
    private int daysToDispatch;
    private int daysDuration;
    private int[] necessities; 
    private int computersSelled;
    
    //Constructor
    public Wharehouse(int[] necessities, int daysToDispatch, int daysDuration) {
        this.motherboards = 0;
        this.cpus = 0;
        this.rams = 0;
        this.powerSupplys = 0;
        this.gpus = 0;
        this.computers = 0;
        this.gpuComputers = 0;
        this.daysCounter = 0;
        this.hoursCounter = 0;
        this.daysToDispatch = daysToDispatch;
        this.daysDuration = daysDuration;
        this.necessities = necessities;
        this.computersSelled = 0;
    }
    
    //==========================Metodos==========================
    
    
    
    //==========================Getters y Setters==========================
    public int getMotherboards() {
        return motherboards;
    }

    public void addMotherboard() {
        if(this.motherboards < necessities[0]){
            this.motherboards++;
        }
    }
    
    public void removeMotherboard(int quantity){
        this.motherboards = this.motherboards - quantity;
    }

    public int getCpus() {
        return cpus;
    }

    public void addCpu() {
        if(this.cpus < necessities[1]){
            this.cpus++;
        }
    }
    
    public void removeCpu(int quantity){
        this.cpus = this.cpus = quantity;
    }

    public int getRams() {
        return rams;
    }

    public void addRam() {
        if(this.rams < necessities[2]){
            this.rams++;
        }
    }
    
    public void removeRam(int quantity){
        this.rams = this.rams - quantity;
    }

    public int getPowerSupplys() {
        return powerSupplys;
    }

    public void addPowerSupply() {
        if(this.powerSupplys < necessities[3]){
            this.powerSupplys++;
        }
    }
    
    public void removePowerSupply(int quantity){
        this.powerSupplys = this.powerSupplys = quantity;
    }

    public int getGpus() {
        return gpus;
    }

    public void addGpu() {
        if(this.gpus < necessities[4]){
            this.gpus++;
        }
    }
    
    public void removeGpu(int quantity){
        this.gpus = this.gpus - quantity;
    }

    public int getComputers() {
        return computers;
    }

    public void addComputer() {
        this.computers++;
    }
    
    public void removeComputers(int quantity){
        this.computers = this.computers - quantity;
    }

    public int getGpuComputers() {
        return gpuComputers;
    }

    public void addGpuComputer() {
        this.gpuComputers++;
    }
    
    public void removeGpuComputers(int quantity){
        this.gpuComputers = this.gpuComputers - quantity;
    }

    public int[] getNecessities() {
        return necessities;
    }

    public void setNecessities(int[] necessities) {
        this.necessities = necessities;
    }

    public int getDaysCounter() {
        return daysCounter;
    }

    public void setDaysCounter(int daysCounter) {
        this.daysCounter = daysCounter;
    }
    
    public void addDay(){
        this.daysCounter++;
    }

    public int getDaysToDispatch() {
        return daysToDispatch;
    }

    public void setDaysToDispatch(int daysToDispatch) {
        this.daysToDispatch = daysToDispatch;
    }

    public int getHoursCounter() {
        return hoursCounter;
    }

    public void setHoursCounter(int hoursCounter) {
        this.hoursCounter = hoursCounter;
    }
    
    public void addHour(){
        this.hoursCounter++;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public int getComputersSelled() {
        return computersSelled;
    }

    public void setComputersSelled(int computersSelled) {
        this.computersSelled = computersSelled;
    }
    
    
    
    
    
            
    
    
    
}
