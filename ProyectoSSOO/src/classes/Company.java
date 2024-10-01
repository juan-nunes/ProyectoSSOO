/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import DataStructures.List;
import java.util.concurrent.Semaphore;

/**
 *
 * @author orveodiluca
 */
public class Company{
    
    //Atributos
    private String nameCompany; 
    private int employeesCantity;      
    private List<Worker> workers;
    private List<Assembler> employeesAssemblers; 
    private ProyectManager pm;
    private Director director;
    private Wharehouse wharehouse;    
    private int daysToCreateGPUComputer;
    private int daysDuration; //milisegundos
    private int daysToDispatch;
    private int[] necessities;
    private int profit;
    private int pcPrice;
    private int gpuPcPrice;    
    
    
    //Constructor
    public Company(String nameCompany, int employeesCantity, Wharehouse wharehouse, int daysDuration, int daysToDispatch, int[] necessities,             
            int daysToCreateGPUComputer, int pcPrice, int gpuPcPrice) {
        this.nameCompany = nameCompany;
        this.employeesCantity = employeesCantity;
        this.workers = new List<>();
        this.employeesAssemblers = new List<>();
        this.wharehouse = wharehouse;
        this.pm = new ProyectManager(wharehouse);
        this.daysToCreateGPUComputer = daysToCreateGPUComputer;
        this.pcPrice = pcPrice;
        this.director = new Director(wharehouse);
        this.gpuPcPrice = gpuPcPrice;
        this.profit = 0;
        this.daysDuration = daysDuration;
        this.daysToDispatch = daysToDispatch;
        this.necessities = necessities;
    }
    
    //============================Metodos============================
  
        
    public void startSimulation(){
        for (int i = 0; i < workers.getSize(); i++) {
            Worker auxWorker = workers.get(i);
            auxWorker.start();
        }
        for (int i = 0; i < employeesAssemblers.getSize(); i++) {
            Assembler assembler = employeesAssemblers.get(i);
            assembler.start();
        }
        pm.start();
        director.start();
    }
        
    
    
    //============================Getters y Setters============================
    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getEmployeesCantity() {
        return employeesCantity;
    }

    public void setEmployeesCantity(int employeesCantity) {
        this.employeesCantity = employeesCantity;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Assembler> getEmployeesAssemblers() {
        return employeesAssemblers;
    }

    public void setEmployeesAssemblers(List<Assembler> employeesAssemblers) {
        this.employeesAssemblers = employeesAssemblers;
    }

    public ProyectManager getPm() {
        return pm;
    }

    public void setPm(ProyectManager pm) {
        this.pm = pm;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Wharehouse getWharehouse() {
        return wharehouse;
    }

    public void setWharehouse(Wharehouse wharehouse) {
        this.wharehouse = wharehouse;
    }

    public int getDaysToCreateGPUComputer() {
        return daysToCreateGPUComputer;
    }

    public void setDaysToCreateGPUComputer(int daysToCreateGPUComputer) {
        this.daysToCreateGPUComputer = daysToCreateGPUComputer;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getPcPrice() {
        return pcPrice;
    }

    public void setPcPrice(int pcPrice) {
        this.pcPrice = pcPrice;
    }

    public int getGpuPcPrice() {
        return gpuPcPrice;
    }

    public void setGpuPcPrice(int gpuPcPrice) {
        this.gpuPcPrice = gpuPcPrice;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public int getDaysToDispatch() {
        return daysToDispatch;
    }

    public void setDaysToDispatch(int daysToDispatch) {
        this.daysToDispatch = daysToDispatch;
    }

    public int[] getNecessities() {
        return necessities;
    }

    public void setNecessities(int[] necessities) {
        this.necessities = necessities;
    }
    
    
    
    

    
    
    
    
}
