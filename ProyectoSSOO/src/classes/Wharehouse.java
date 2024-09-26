/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import javax.swing.JOptionPane;

/**
 *
 * @author juann
 */
public class Wharehouse {
    public int motherboard;
    public int cpu;
    public int ram;
    public int powerSupply;
    public int gpu;       

    public Wharehouse() {
        this.motherboard = 0;
        this.cpu = 0;
        this.ram = 0;
        this.powerSupply = 0;
        this.gpu = 0;        
    }

    public int getMotherboard() {
        return motherboard;
    }

    public void addMotherboard() {
        if(this.motherboard > 25){
            JOptionPane.showMessageDialog(null, "Almacen de placas bases lleno!!");
        }
        else{
            this.motherboard++;            
        }
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        if(this.cpu > 20){
            JOptionPane.showMessageDialog(null, "Almacen de procesadores lleno!!");
        }
        else{
            this.cpu++;            
        }
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if(this.ram > 55){
            JOptionPane.showMessageDialog(null, "Almacen de memoria ram lleno!!");
        }
        else{
            this.ram++;            
        }
    }

    public int getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(int powerSupply) {
        if(this.powerSupply > 35){
            JOptionPane.showMessageDialog(null, "Almacen de fuentes de poder lleno!!");
        }
        else{
            this.powerSupply++;            
        }
    }

    public int getGpu() {
        return gpu;
    }

    public void setGpu(int gpu) {
        if(this.gpu > 10){
            JOptionPane.showMessageDialog(null, "Almacen de tarjetas graficas lleno!!");
        }
        else{
            this.gpu++;            
        }
    }

    
    
    
    
}
