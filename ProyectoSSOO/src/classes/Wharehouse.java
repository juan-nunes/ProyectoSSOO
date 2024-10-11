<<<<<<< Updated upstream
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
        this.computers = 0; 
        
    }
    
    public void addPC(int quantityAssemblers){
        int quantityComputers = quantityAssemblers; //se puede ver cuantas computadoras se pueden hacer, por la cantidad de ensambladores que hay. 
        //placa base
        int quantity = calculatePossibleComponent(this.motherboard,0); 
        if(quantity < quantityComputers){
            quantityComputers = quantity; 
        }
        //cpu
        quantity = calculatePossibleComponent(this.cpu,1); 
        if(quantity < quantityComputers){
            quantityComputers = quantity; 
        }
        //ram
        quantity = calculatePossibleComponent(this.ram,2);
        if(quantity < quantityComputers){
            quantityComputers = quantity; 
        }
        //powerSupply
        quantity = calculatePossibleComponent(this.powerSupply,3); 
        if(quantity < quantityComputers){
            quantityComputers = quantity; 
        }
        
        motherboard -= (necessities[0] * quantityComputers); 
        this.labels[0].setText(Integer.toString(this.getMotherboard())); 
        cpu -= (necessities[1] * quantityComputers); 
        this.labels[1].setText(Integer.toString(this.getCpu()));
        ram -= (necessities[2] * quantityComputers); 
        this.labels[2].setText(Integer.toString(this.getRam())); 
        powerSupply -= (necessities[3] * quantityComputers); 
        this.labels[3].setText(Integer.toString(this.getPowerSupply()));
        
        while(counterGPU >= necessities[5] && pcGPU >= necessities[4] && quantityComputers > 0){
            gpuComponent +=1; 
            pcGPU -= necessities[4]; 
            counterGPU -= necessities[5]; 
            quantityComputers -= 1; 
            
        }
        this.labels[4].setText(Integer.toString(pcGPU)); 
        computers += quantityComputers; 
        counterGPU += quantityComputers; 
        
        this.labels[5].setText(Integer.toString(computers)); 
        this.labels[6].setText(Integer.toString(pcGPU)); 
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
    
    
    public JLabel[] getLabels() {
        return labels;
    }

    public void setLabels(JLabel[] labels) {
        this.labels = labels;
    }
    
    
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author juann
 */
public class Wharehouse {
    //Atributos
    private int computersToCreateGPUComputer;
        
    // Array de componenets almacenados
    // 0 -> motherboard | 1 -> cpu | 2 -> ram | 3 -> powersupply | 4 -> gpu
    private int[] components;
    
    
    // Array de computadoras almacenadas
    // 0 -> computadoras normales | 1 -> computadoras con gpu    
    private int[] computers;
         
        
    // Array de requerimientos para armar una pc
    // 0 -> motherboard | 1 -> cpu | 2 -> ram | 3 -> powersupply | 4 -> gpu    
    private int[] requirements; 
    
    // Array de computadoras vendidas
    // 0 -> computadoras normales | 1 -> computadoras con gpu    
    private int[] computersSelled;
        
    
    //Constructor
    public Wharehouse(int computersToCreateGPUComputer, int[] requeriments) {
        this.components = new int[5];
        this.computers = new int[2];
        this.requirements = requeriments;
        this.computersSelled = new int[2];
        this.computersToCreateGPUComputer = computersToCreateGPUComputer;
        
        //Inicializar valores de los arrays en cero
        for (int i = 0; i < 5; i++) {
            this.components[i] = 0;            
            if(i < 2){
                this.computers[i] = 0;
                this.computersSelled[i] = 0;
            }
        }        
    }
    
    
    
    
    
    //===================Getters and Setters===================
    public int getComputersToCreateGPUComputer() {
        return computersToCreateGPUComputer;
    }

    public void setComputersToCreateGPUComputer(int computersToCreateGPUComputer) {
        this.computersToCreateGPUComputer = computersToCreateGPUComputer;
    }

    public int[] getComponents() {
        return components;
    }

    public void setComponents(int[] components) {
        this.components = components;
    }

    public int[] getComputers() {
        return computers;
    }

    public void setComputers(int[] computers) {
        this.computers = computers;
    }

    public int[] getRequirements() {
        return requirements;
    }

    public void setRequirements(int[] requirements) {
        this.requirements = requirements;
    }

    public int[] getComputersSelled() {
        return computersSelled;
    }

    public void setComputersSelled(int[] computersSelled) {
        this.computersSelled = computersSelled;
    }
    
}
>>>>>>> Stashed changes
