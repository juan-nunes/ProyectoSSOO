/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import DataStructures.List;
import java.util.concurrent.Semaphore;

/**
 *
 * @author juann
 */
public class Company extends Thread{
    
    //Atributos
    private String nameCompany; 
    private int limitWorkers;          
    private List<Worker> workers;
    private List<Assembler> assemblers; 
    private ProyectManager proyectManager;
    private Director director;
    private Wharehouse wharehouse;   
    private int lastLicenseDigit;
    public static int dayDuration;
    public static int daysToDispatch;
    private int profit;
    private int computerPrice;
    private int gpuComputerPrice; 
    private Semaphore mutexEmployees;
    private Semaphore mutex;

    public Company(String nameCompany, int limitWorkers, Wharehouse wharehouse, int lastLicenseDigit, int dayDuration,
            int daysToDispatch, int computerPrice, int gpuComputerPrice, Semaphore mutexEmployees, Semaphore mutex) {
        this.nameCompany = nameCompany;
        this.limitWorkers = limitWorkers;        
        this.workers = new List<>();
        this.assemblers = new List<>();
        this.proyectManager = new ProyectManager(0, wharehouse, mutexEmployees);
        this.director = new Director(0, wharehouse, mutexEmployees, proyectManager, this);
        this.wharehouse = wharehouse; 
        this.lastLicenseDigit = lastLicenseDigit;
        Company.dayDuration = dayDuration;
        Company.daysToDispatch = daysToDispatch;
        this.profit = 0;
        this.computerPrice = computerPrice;
        this.gpuComputerPrice = gpuComputerPrice;
        this.mutexEmployees = mutexEmployees;
        this.mutex = mutex;
    }
    
    
    public void run(){
        while(true){
            
        }
    }
    
    
//    public void createWorkers(int[] arrayEmployees){
//        for (int i = 0; i < arrayEmployees.length; i++) {
//            int quantity = arrayEmployees[i];
//            for (int j = 0; j < quantity; j++) {
//                Worker newWorker = new Worker(j, i);
//            }
//        }
//    }
    

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getLimitWorkers() {
        return limitWorkers;
    }

    public void setLimitWorkers(int limitWorkers) {
        this.limitWorkers = limitWorkers;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Assembler> getAssemblers() {
        return assemblers;
    }

    public void setAssemblers(List<Assembler> assemblers) {
        this.assemblers = assemblers;
    }

    public ProyectManager getProyectManager() {
        return proyectManager;
    }

    public void setProyectManager(ProyectManager proyectManager) {
        this.proyectManager = proyectManager;
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

    public int getLastLicenseDigit() {
        return lastLicenseDigit;
    }

    public void setLastLicenseDigit(int lastLicenseDigit) {
        this.lastLicenseDigit = lastLicenseDigit;
    }        

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getComputerPrice() {
        return computerPrice;
    }

    public void setComputerPrice(int computerPrice) {
        this.computerPrice = computerPrice;
    }

    public int getGpuComputerPrice() {
        return gpuComputerPrice;
    }

    public void setGpuComputerPrice(int gpuComputerPrice) {
        this.gpuComputerPrice = gpuComputerPrice;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    
    
    
    
}
