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
