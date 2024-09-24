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
public class Assembler extends Thread{
    private int salaryperhour; //Salario del ensamblador. 
    private int workday; //Días en lo que tarda. 
    private Semaphore mutex;
    private int motherboard; //placa base
    private int cpu; 
    private int ram; 
    private int powersupplies; //fuente de alimentacion. 
    
    public Assembler(int salaryperhour, int workday,Semaphore mutex){
        this.salaryperhour = salaryperhour; 
        this.workday = workday; 
        this.mutex = mutex; 
    }

    public int getSalaryperhour() {
        return salaryperhour;
    }

    public void setSalaryperhour(int salaryperhour) {
        this.salaryperhour = salaryperhour;
    }

    public int getWorkday() {
        return workday;
    }

    public void setWorkday(int workday) {
        this.workday = workday;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    
}
