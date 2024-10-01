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
public class ProyectManager extends Thread{
    
    //Atributos
    private int salaryPerHour;
    private boolean isWorking;
    private int profit;
    private double hoursCounter;
    private Wharehouse wharehouse;    
    
    //Constructor
    public ProyectManager(Wharehouse wharehouse) {
        this.salaryPerHour = 40;
        this.isWorking = true;
        this.profit = 0;
        this.hoursCounter = 0;        
    }
    
    //=======================Metodos=======================
    @Override
    public void run(){
        boolean run = true;
        while(run){
            try {
                Thread.sleep((wharehouse.getDaysDuration()/24)/2); //Media hora
                if(this.hoursCounter <= 16){
                    this.isWorking = !this.isWorking;                    
                }
                else if (this.hoursCounter >= 24){
                    this.hoursCounter = 0;
                    wharehouse.addDay();
                }
                this.hoursCounter += 0.5;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProyectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void countDay(){
        this.wharehouse.addDay();
    }
    
    public void countHour(){
        this.wharehouse.addHour();
    }
    
    
    //=======================Getters y Setters=======================

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public boolean isIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
    
    
    
    
    
    
    
}
