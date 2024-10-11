<<<<<<< Updated upstream
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author orveodiluca
 */
public class Director extends Thread {
    
}
=======
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
public class Director extends Employee{
    
    //Atributos     
    private ProyectManager pm;
    private Company company;
    int days = 0;
    int moneyDiscount = 0;
    
    //Constructor
    public Director(int ID, Wharehouse wh, Semaphore mutex, ProyectManager pm, Company company) {
        super(ID, wh, mutex);        
        this.pm = pm;
        this.company = company;
    }
    
    //======================Metodos=====================
    
    @Override
    public void run(){        
        float hours = 0f;
        boolean passDay = false;
        
        int min = 0;
        int max = 48;
        int randomHour = (int) (Math.random() * (max - min + 1)) + min;
        while(true){
            try {
                
                
                hours += 0.5;
                if(hours == 24){
                    days++;
                    hours = 0;
                    passDay = true;
                }
                if(passDay){
                    randomHour = (int) (Math.random() * (max - min + 1)) + min; 
                    passDay = false;
                }
                
                getMutex().acquire();
                if(days < Company.daysToDispatch){
                    float trueRandomHour = randomHour/2;
//                  System.out.println(hours + " " + randomHour/2);
                    if(hours == trueRandomHour){                        
                        statusVerificationPM();
                    }
                }
                else{
                    sellComputers();
                    days = 0;
                }
                getMutex().release();
                                
                
                Thread.sleep((Company.dayDuration/24)/2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void sellComputers(){
        int[] computers = getWh().getComputers();
        int[] computersSelled = getWh().getComputersSelled();
        
        computersSelled[0] = computers[0];
        computersSelled[1] = computers[1];
        
        computers[0] = 0;
        computers[1] = 0;   
        
        getWh().setComputers(computers);        
    }
    
    
    public void statusVerificationPM(){  
        if(!company.getProyectManager().isWorking()){
            moneyDiscount += 100;
            pm.setProfit(pm.getProfit() - 100);
        }        
    }
    
    
    //===================Getters and Setters===================
    public ProyectManager getPm() {
        return pm;
    }

    public void setPm(ProyectManager pm) {
        this.pm = pm;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    
    
    
    
}
>>>>>>> Stashed changes
