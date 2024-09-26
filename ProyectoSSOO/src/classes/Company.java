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
public class Company extends Thread{
    public String nameCompany; 
    public int employeesCantity; //cantidad de empleados. 
    public Worker[] employeesArray;
    public int computerProfit; //cuanta gana la empresa. 
    public int motherboard;
    public int cpu;
    public int ram;
    public int powerSupply;
    public int gpu;   
    public int days;
    public int hours;
    public Semaphore sem;

    public Company(String nameCompany, int employeesCantity, Semaphore sem) {
        this.nameCompany = nameCompany;
        this.employeesCantity = employeesCantity;
        this.employeesArray = new Worker[employeesCantity];
        
        Semaphore semWorkers = new Semaphore(3);
        for (int i = 0; i < 3; i++) {            
            employeesArray[i] = new Worker(0, 2, semWorkers);
        }        
        
        this.computerProfit = 0;
        this.motherboard = 0;
        this.cpu = 0;
        this.ram = 0;
        this.powerSupply = 0;
        this.gpu = 0;
        this.days = 0;
        this.hours = 0;
        this.sem = sem;
    }
    
    @Override
    public void run(){
        try{
            System.out.println("Dia " + this.days + ". Hora " + this.hours);
            
        }
        catch(Exception e){
        
        }
    }
    

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

    public int getComputerProfit() {
        return computerProfit;
    }

    public void setComputerProfit(int computerProfit) {
        this.computerProfit = computerProfit;
    }
    
    
}
