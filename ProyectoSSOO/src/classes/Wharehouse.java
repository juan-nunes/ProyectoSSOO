/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import javax.swing.JOptionPane;
import javax.swing.JLabel;

/**
 *
 * @author juann
 */
public class Wharehouse {
    
    public int motherboardComponent; // = private int guiones
    public int cpuComponent; //private int escenarios
    public int ramComponent; //   private int animaciones;
    public int powerSupplyComponent; //private int doblajes;
    public int gpuComponent; //    private int plotwist;
    public int pcGPU; //   private int guionPlotTwist;
    public int motherboard;
    public int cpu;
    public int ram;
    public int powerSupply;
    public int gpu; 
    public int counterGPU; //    private int counterForPT;
    public int computers; //private int capitulos;
    public int [] necessities; //recursos necesarios para producir una computadora.
    private Company company;
    private JLabel [] labels;

    public Wharehouse(int [] necessities,Company company ) {
        this.necessities = necessities; 
        this.company= company; 
        this.motherboard = 0;
        this.cpu = 0;
        this.ram = 0;
        this.powerSupply = 0;
        this.gpu = 0;
        this.counterGPU = 0; 
        this.motherboardComponent = 0; 
        this.cpuComponent = 0; 
        this.ramComponent = 0; 
        this.gpuComponent = 0; 
        this.pcGPU = 0; 
        this.powerSupplyComponent = 0; 
    }
    
    public void addPC(int quantityAssemblers){
        int quantityComputers = quantityAssemblers; //se puede ver cuantas computadoras se pueden hacer, por la cantidad de ensambladores que hay. 
        //placa base
        int quantity = calculatePossibleComponent(this.motherboardComponent,0); 
        if(quantity < quantityComputers){
            quantityComputers = quantity; 
        }
        //cpu
        quantity = calculatePossibleComponent(this.cpuComponent,1); 
        if(quantity < quantityComputers){
            quantityComputers = quantity; 
        }
        //ram
        quantity = calculatePossibleComponent(this.ramComponent,2);
        if(quantity < quantityComputers){
            quantityComputers = quantity; 
        }
        //powerSupply
        quantity = calculatePossibleComponent(this.powerSupplyComponent,3); 
        if(quantity < quantityComputers){
            quantityComputers = quantity; 
        }

        

            motherboardComponent -= (necessities[0] * quantityComputers);
            cpuComponent -= (necessities[1] * quantityComputers);
            ramComponent -= (necessities[2] * quantityComputers);
            powerSupplyComponent -= (necessities[3] * quantityComputers);

        
        while(counterGPU >= necessities[5] && pcGPU >= necessities[4] && quantityComputers > 0){
            gpuComponent += 1; 
            pcGPU -= necessities[4]; 
            counterGPU -= necessities[5];
            quantityComputers -= 1; 
        }
        computers += quantityAssemblers - quantityComputers; // Se añade el total de computadoras fabricadas.
        counterGPU += (quantityAssemblers - quantityComputers);
        
    }
    
    public int calculatePossibleComponent(int value,int type){
        int cantidad = value; 
        int quantity = 0; 
        while(cantidad > 0){
            int restante = cantidad - necessities[type];
            if (restante >= 0){
                quantity += 1; 
            }
            cantidad = restante; 
        }
        return quantity; 
    }
    
    public int getMotherboard() {
        return motherboard;
    }

    public void addMotherboard(int quantity) {
        if(this.motherboard > 25){
            JOptionPane.showMessageDialog(null, "Almacen de placas bases lleno!!");
        }
        else{
            this.motherboard += quantity;            
        }
    }

    public int getCpu() {
        return cpu;
    }

    public void addCpu(int quantity) {
        if(this.cpu > 20){
            JOptionPane.showMessageDialog(null, "Almacen de procesadores lleno!!");
        }
        else{
            this.cpu += quantity;        
        }
    }

    public int getRam() {
        return ram;
    }

    public void addRam(int quantity) {
        if(this.ram > 55){
            JOptionPane.showMessageDialog(null, "Almacen de memoria ram lleno!!");
        }
        else{
            this.ram += quantity;            
        }
    }

    public int getPowerSupply() {
        return powerSupply;
    }

    public void addPowerSupply(int quantity) {
        if(this.powerSupply > 35){
            JOptionPane.showMessageDialog(null, "Almacen de fuentes de poder lleno!!");
        }
        else{
            this.powerSupply += quantity;          
        }
    }

    public int getGpu() {
        return gpu;
    }

    public void addGpu(int quantity) {
        if(this.gpu > 10){
            JOptionPane.showMessageDialog(null, "Almacen de tarjetas graficas lleno!!");
        }
        else{
            this.gpu += quantity;            
        }
    }

    public int getMotherboardComponent() {
        return motherboardComponent;
    }

    public void setMotherboardComponent(int motherboardComponent) {
        this.motherboardComponent = motherboardComponent;
    }

    public int getCpuComponent() {
        return cpuComponent;
    }

    public void setCpuComponent(int cpuComponent) {
        this.cpuComponent = cpuComponent;
    }

    public int getRamComponent() {
        return ramComponent;
    }

    public void setRamComponent(int ramComponent) {
        this.ramComponent = ramComponent;
    }

    public int getPowerSupplyComponent() {
        return powerSupplyComponent;
    }

    public void setPowerSupplyComponent(int powerSupplyComponent) {
        this.powerSupplyComponent = powerSupplyComponent;
    }

    public int getGpuComponent() {
        return gpuComponent;
    }

    public void setGpuComponent(int gpuComponent) {
        this.gpuComponent = gpuComponent;
    }

    public int getPcGPU() {
        return pcGPU;
    }

    public void setPcGPU(int pcGPU) {
        this.pcGPU = pcGPU;
    }

    public int getCounterGPU() {
        return counterGPU;
    }

    public void setCounterGPU(int counterGPU) {
        this.counterGPU = counterGPU;
    }

    public int getComputers() {
        return computers;
    }

    public void setComputers(int computers) {
        this.computers = computers;
    }

    
    
    
    
}
