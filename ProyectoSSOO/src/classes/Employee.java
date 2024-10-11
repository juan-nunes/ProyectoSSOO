/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author juann
 */
public class Employee extends Thread{
    
    //Atributos
    private int ID;
    private int salaryPerHour;
    private int profit;
    private Wharehouse wh;
    private Semaphore mutex;    
    
    //Constructor
    public Employee(int ID, Wharehouse wh, Semaphore mutex) {
        this.ID = ID;
        this.salaryPerHour = 0;
        this.profit = 0;
        this.wh = wh;
        this.mutex = mutex;
    }
    //=====================Metodos====================
    public void collectSalary(){
        setProfit(getProfit() + (getSalaryPerHour()*24));
    }

    
        
    //=====================Getters y Setters====================
    public int getID() {
        return ID;
    }

    public void setID(int ID) {    
        this.ID = ID;
    }

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

    public Wharehouse getWh() {
        return wh;
    }

    public void setWh(Wharehouse wh) {
        this.wh = wh;
    }        

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }


    
    
}
