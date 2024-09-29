/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
/**
 *
 * @author orveodiluca
 */
public class Pm extends Thread {
    private float salaryAcumulate; 
    private int salary; 
    private int DayDuration; 
    private int minutesCounter; 
    private int hourCounter; 
    private String status; 
    private int fault; 
    private int discounted;
    private int DayPassedTotal; 
    private Company company; 
    private Semaphore sem; 
    private Semaphore sem2; //controlara las operaciones financieras. 
    private JLabel[] labels;
    
    public Pm(int DayDuration, Semaphore sem,Semaphore sem2, Company company){
       this.salaryAcumulate = 0; 
       this.DayDuration = DayDuration; 
       this.salary = 40; 
       this.fault = 0; 
       this.discounted = 0; 
       this.DayPassedTotal = 0; 
       this.status = "Viendo One Pice"; 
       this.sem = sem; 
       this.sem2 = sem2; 
       this.company = company; 
    }

    public void paymetSalary(){ //calcula el salario del project manager
        try{
            this.sem2.acquire(); 
            salaryAcumulate = this.salaryAcumulate + (this.salary * 24); 
            this.sem2.release(); 
        }catch(InterruptedException ex){
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void work(){
        
    }
    
    public float getSalaryAcumulate() {
        return salaryAcumulate;
    }

    public void setSalaryAcumulate(float salaryAcumulate) {
        this.salaryAcumulate = salaryAcumulate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDayDuration() {
        return DayDuration;
    }

    public void setDayDuration(int DayDuration) {
        this.DayDuration = DayDuration;
    }

    public int getMinutesCounter() {
        return minutesCounter;
    }

    public void setMinutesCounter(int minutesCounter) {
        this.minutesCounter = minutesCounter;
    }

    public int getHourCounter() {
        return hourCounter;
    }

    public void setHourCounter(int hourCounter) {
        this.hourCounter = hourCounter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFault() {
        return fault;
    }

    public void setFault(int fault) {
        this.fault = fault;
    }

    public int getDiscounted() {
        return discounted;
    }

    public void setDiscounted(int discounted) {
        this.discounted = discounted;
    }

    public int getDayPassedTotal() {
        return DayPassedTotal;
    }

    public void setDayPassedTotal(int DayPassedTotal) {
        this.DayPassedTotal = DayPassedTotal;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Semaphore getSem() {
        return sem;
    }

    public void setSem(Semaphore sem) {
        this.sem = sem;
    }
    
    
}
