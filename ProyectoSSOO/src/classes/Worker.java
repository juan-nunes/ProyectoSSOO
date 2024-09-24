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
public class Worker extends Thread {
    private int type; //0=productoresplacabase,1=productorescpu,2=productoresmemoriaram,3=productoresfuentesalimentacion. 
    private int salaryperhour; 
    private Semaphore mutex; 
    
    public Worker(int type, int salaryperhour,Semaphore mutex){
        this.type = type; 
        this.salaryperhour = salaryperhour; 
        this.mutex = mutex; 
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSalaryperhour() {
        return salaryperhour;
    }

    public void setSalaryperhour(int salaryperhour) {
        this.salaryperhour = salaryperhour;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    
}
