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
    private String nameCompany; 
    private int employeesCantity; //cantidad de empleados.     
    private Worker[] employeesMotherboard;
    private Worker[] employeesCpus;
    private Worker[] employeesRams;
    private Worker[] employeesPowerSupplys;
    private Worker[] employeesGpus;
    private Worker[] employeesAssemblers;    
    private int computerProfit; //cuanto gana la empresa.  
    /*private int MotherBoard; //cantidad de placas bases que va a tener las empresas. 
    private int CPU; //cantidad de cpu's que va a tener las empresas. 
    private int RAM; //cantidad de RAM que va a tener las empresas. 
    private int PowerSupplys; //cantidad de Fuente de alimentacion que va a tener las empresas. 
    private int [] necessities; */
    private Semaphore sem;

    public Company(String nameCompany, int employeesCantity, int numMotherboards, int numCpus, int numRams, int numPowerSupplys, 
        int numGpus, int numAssemblers, Semaphore sem) {
            this.nameCompany = nameCompany;
            this.employeesCantity = employeesCantity;        
            this.employeesMotherboard = new Worker[numMotherboards];
            this.employeesCpus = new Worker[numCpus];//preguntar sobre que es esto?? 
            this.employeesRams = new Worker[numRams];
            this.employeesPowerSupplys = new Worker[numPowerSupplys];
            this.employeesGpus = new Worker[numGpus];
            this.employeesAssemblers = new Worker[numAssemblers];
            this.computerProfit = 0;                
            this.sem = sem;
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

    public Worker[] getEmployeesMotherboard() {
        return employeesMotherboard;
    }

    public void setEmployeesMotherboard(Worker[] employeesMotherboard) {
        this.employeesMotherboard = employeesMotherboard;
    }

    public Worker[] getEmployeesCpus() {
        return employeesCpus;
    }

    public void setEmployeesCpus(Worker[] employeesCpus) {
        this.employeesCpus = employeesCpus;
    }

    public Worker[] getEmployeesRams() {
        return employeesRams;
    }

    public void setEmployeesRams(Worker[] employeesRams) {
        this.employeesRams = employeesRams;
    }

    public Worker[] getEmployeesPowerSupplys() {
        return employeesPowerSupplys;
    }

    public void setEmployeesPowerSupplys(Worker[] employeesPowerSupplys) {
        this.employeesPowerSupplys = employeesPowerSupplys;
    }

    public Worker[] getEmployeesGpus() {
        return employeesGpus;
    }

    public void setEmployeesGpus(Worker[] employeesGpus) {
        this.employeesGpus = employeesGpus;
    }

    public Worker[] getEmployeesAssemblers() {
        return employeesAssemblers;
    }

    public void setEmployeesAssemblers(Worker[] employeesAssemblers) {
        this.employeesAssemblers = employeesAssemblers;
    }

           

    public Semaphore getSem() {
        return sem;
    }

    public void setSem(Semaphore sem) {
        this.sem = sem;
    }

    public int getComputerProfit() {
        return computerProfit;
    }

    public void setComputerProfit(int computerProfit) {
        this.computerProfit = computerProfit;
    }
    
    
}
