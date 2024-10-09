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
 * @author juann
 */
public class ProyectManager extends Employee {
    
    //Atributos
    private boolean isWorking;
    private int days = 0;
    private float hours = 0;      
    
    //Constructor
    public ProyectManager(int ID, Wharehouse wh, Semaphore mutex) {
        super(ID, wh, mutex);
        this.isWorking = true;
    }
    
    //====================Metodos====================
    public void run(){
        boolean passDay = true; //Para testear
        while(true){
            try {
                
                //Codigo del hilo
                collectSalary();
                
                addHalfHour();
                if(hours <= 16){
                    isWorking = !isWorking;
                }
                else if(hours > 16 && !isWorking){
                    isWorking = true;
                }
                if(hours == 24){
                    addDay();
                    hours = 0;
                    passDay = true;
                }
                
                //Codigo del test
                if(passDay){
                    int[] components = getWh().getComponents();                
                    int[] computers = getWh().getComputers();                
                    int[] computersSelled = getWh().getComputersSelled();                
                    
                    String str = "Dia: " + days + " | Hora: " + hours + "\n";
                    str += "motherboard: " + components[0] + " | cpu: " + components[1] + " | ram: " + components[2];
                    str += " | powersupply: " + components[3] + " | gpu: " + components[4] + "\n";
                    str += "computers: " + computers[0] + " | gpuComputers: " + computers[1] + "\n";
                    str += "computadoras vendidas: " + computersSelled[0] + " Computadoras con gpu vendidas: " + computersSelled[1] + "\n";
                    System.out.println(str);
                    passDay = false;
                }
                Thread.sleep((Company.dayDuration/24)/2);
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProyectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void addDay(){
        days++;
    }
    
    public void addHalfHour(){
        hours += 0.5;
    }
    

    
    //===================Getters and Setters===================
    public boolean isWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }



    
    


    
    
    
    
    
}
