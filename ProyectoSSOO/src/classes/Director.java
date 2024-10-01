/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orveodiluca
 */
public class Director extends Thread{    
    
    //Atributos
    private int salaryPerHour;    
    private int profit;
    private Wharehouse wharehouse;    


    //Constructor
    public Director(Wharehouse wharehouse) {
        this.salaryPerHour = 60;
        this.profit = 0;
        this.wharehouse = wharehouse;
    }
    
    //=========================Metodos=========================
    @Override
    public void run(){
        boolean run = true;
        while(run){
            if(canDispatch()){
                try {
                    Thread.sleep(wharehouse.getDaysDuration()/24);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
                }
                int computers = wharehouse.getComputers();
                wharehouse.removeComputers(computers);
                wharehouse.setComputersSelled(wharehouse.getComputersSelled() + computers);
            }
        }
    }
    
    public boolean canDispatch(){
        return wharehouse.getDaysCounter() >= wharehouse.getDaysToDispatch();
    }
    
    
    
    
    //=========================Getters y Setters=========================
    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
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
    
    
}
