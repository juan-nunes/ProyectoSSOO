<<<<<<< Updated upstream
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
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import DataStructures.List;
import GUI.SimulationView;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private SimulationView sv;

    public Company(String nameCompany, int limitWorkers, Wharehouse wharehouse, int lastLicenseDigit, int dayDuration,
            int daysToDispatch, int computerPrice, int gpuComputerPrice, 
            Semaphore mutexEmployees, Semaphore mutex, SimulationView sv) {
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
        this.sv = sv;
    }
    
    
    @Override
    public void run(){        
        director.start();
        proyectManager.start();        
        for (int i = 0; i < workers.getSize(); i++) {
            Worker auxWorker = workers.get(i);            
            auxWorker.start();
        }
        for (int i = 0; i < assemblers.getSize(); i++) {
            Assembler auxAssemblers = assemblers.get(i);
            auxAssemblers.start();
        }
        while(true){            
            int[] components = wharehouse.getComponents();
            int[] computers = wharehouse.getComputers();
            int[] computersSelled = wharehouse.getComputersSelled();
                   
            sv.getDayCounter().setText(Integer.toString(proyectManager.getDays()));
            try {
                if(nameCompany.equals("Apple")){
                    sv.getC_mb_Apple().setText(Integer.toString(components[0]));
                    sv.getC_cpu_Apple().setText(Integer.toString(components[1]));
                    sv.getC_ram_Apple().setText(Integer.toString(components[2]));
                    sv.getC_ps_Apple().setText(Integer.toString(components[3]));
                    sv.getC_gpu_Apple().setText(Integer.toString(components[4]));           

                    sv.getComputersApple().setText("PC normales: " + Integer.toString(computers[0]));
                    sv.getGpuComputersApple().setText("PC con GPU: " + Integer.toString(computers[1])); 
                    sv.getComputersSelledApple().setText("PC normales verndidas: " + Integer.toString(computersSelled[0]));                    
                    sv.getGpuComputersSelledApple().setText("PC con GPU vendidas: " + Integer.toString(computersSelled[1]));
                    
                    sv.getDeadlineApple().setText("Dias que faltan para vender: " + Integer.toString(Company.daysToDispatch - director.days));
                    
                    if(proyectManager.isWorking()){
                        sv.getPmStatusApple().setText("Proyect Manager estatus: trabajando");                        
                    }
                    else{
                        sv.getPmStatusApple().setText("Proyect Manager estatus: viendo anime");                        
                    }
                    
                    sv.getDiscountPmApple().setText("Dinero descontado Proyect Manager: " + director.moneyDiscount);
                }
                else if(nameCompany.equals("Dell")){
                    sv.getC_mb_Dell().setText(Integer.toString(components[0]));
                    sv.getC_cpu_Dell().setText(Integer.toString(components[1]));
                    sv.getC_ram_Dell().setText(Integer.toString(components[2]));
                    sv.getC_ps_Dell().setText(Integer.toString(components[3]));
                    sv.getC_gpu_Dell().setText(Integer.toString(components[4]));

                    sv.getComputersDell().setText("PC normales: " + Integer.toString(computers[0]));
                    sv.getGpuComputersDell().setText("PC con GPU: " + Integer.toString(computers[1])); 
                    sv.getComputersSelledDell().setText("PC normales verndidas: " + Integer.toString(computersSelled[0]));                    
                    sv.getGpuComputersSelledDell().setText("PC con GPU vendidas: " + Integer.toString(computersSelled[1]));
                    
                    System.out.println(proyectManager.isWorking());
                    if(proyectManager.isWorking()){
                        sv.getPmStatusDell().setText("Proyect Manager estatus: trabajando");                        
                    }
                    else{
                        sv.getPmStatusDell().setText("Proyect Manager estatus: viendo anime");                        
                    }
                    
                    sv.getDiscountPmDell().setText("Dinero descontado Proyect Manager: " + director.moneyDiscount);
                }

                
                Thread.sleep(dayDuration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        
    
    public void createAssemblers(int quantity){
        for (int i = 0; i < quantity; i++) {
            Assembler newAssembler = new Assembler(i, wharehouse, mutexEmployees);
            assemblers.append(newAssembler);
        }
    }
    
    public void createWorkers(int[] arrayEmployees){
        for (int i = 0; i < arrayEmployees.length; i++) {
            int quantity = arrayEmployees[i];
            for (int j = 0; j < quantity; j++) {
                Worker newWorker = new Worker(j, i, calculateDaysPerComponent(i, lastLicenseDigit), wharehouse, mutexEmployees);
                workers.append(newWorker);
            }
        }
    }
    
    
    public float calculateDaysPerComponent(int type, int lastLicenseDigit){
        switch(type){
            case Worker.MOTHERBOARD_WORKER -> {
                return calculateMotherBoard(lastLicenseDigit);
            }
            case Worker.CPU_WORKER -> {
                return calculateCPU(lastLicenseDigit);
            }
            case Worker.RAM_WORKER -> {
                return calculateRAM(lastLicenseDigit);
            }
            case Worker.POWERSUPPLY_WORKER -> {
                return calculatePowerSupply(lastLicenseDigit);
            }
            case Worker.GPU_WORKER -> {
                return calculateGPU(lastLicenseDigit);
            }
        }
        return 0;
    }
    
    public float calculateMotherBoard(int lastLicenseDigit){
        if(lastLicenseDigit >= 0 && lastLicenseDigit < 3){
            return 2;
        }
        else if(lastLicenseDigit >= 3 && lastLicenseDigit < 6){
            return 3;
        }
        else if(lastLicenseDigit >= 6 && lastLicenseDigit < 9){
            return 4;
        }
        return 0;
    }
    
    public float calculateCPU(int lastLicenseDigit){
        if(lastLicenseDigit >= 0 && lastLicenseDigit < 3){
            return 2;
        }
        else if(lastLicenseDigit >= 3 && lastLicenseDigit < 6){
            return 3;
        }
        else if(lastLicenseDigit >= 6 && lastLicenseDigit < 9){
            return 4;
        }
        return 0;
    }
    
    public float calculateRAM(int lastLicenseDigit){
        if(lastLicenseDigit >= 0 && lastLicenseDigit < 3){
            return (float) 1/3;
        }
        else if(lastLicenseDigit >= 3 && lastLicenseDigit < 6){
            return (float) 1/2;
        }
        else if(lastLicenseDigit >= 6 && lastLicenseDigit < 9){
            return 1;
        }
        return 0;
    }
    
    public float calculatePowerSupply(int lastLicenseDigit){
        if(lastLicenseDigit >= 0 && lastLicenseDigit < 5){
            return (float) 1/3;
        }
        else if(lastLicenseDigit >= 5 && lastLicenseDigit <= 9){
            return (float) 1/5;
        }
        return 0;
    }
    
    public int calculateGPU(int lastLicenseDigit){
        if(lastLicenseDigit >= 0 && lastLicenseDigit < 5){
            return 3;
        }
        else if(lastLicenseDigit >= 5 && lastLicenseDigit <= 9){
            return 2;
        }        
        return 0;
    }
    

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
>>>>>>> Stashed changes
