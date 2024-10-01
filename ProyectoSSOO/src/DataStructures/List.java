/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

/**
 *
 * @author juann
 */
public class List<T> {
    private Node head;
    private Node tail;
    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public List(T... elements){
        for(T data: elements){
            append(data);
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    public boolean isEmpty(){
        return this.head == null;
    }
    
    
    public void append(T data){
        Node newNode = new Node(data);
        if(isEmpty()){
            this.head = this.tail = newNode;            
        }
        else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }
    
    
    public void preappend(T data){
        Node newNode = new Node(data);
        if(isEmpty()){
            this.head = this.tail = newNode;            
        }
        else{
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }
    
    
    public void insert(int idx, T data){
        if(isEmpty()){
            append(data);
        }
        else{
            if(idx < 0 || idx > this.size-1){
                System.out.println("Error: indice fuera de rango");
            }
            else if(idx == 0){
                preappend(data);
            }
            else{
                Node newNode = new Node(data);
                
                Node pointer = this.head;
                for (int i = 0; i < idx-1; i++) {
                    pointer = pointer.getNext();
                }
                newNode.setNext(pointer.getNext());
                pointer.setNext(newNode);
                this.size--;
            }                        
        }
    }
    
    
    public void pop(int idx){
        if(isEmpty()){
            System.out.println("Error: Lista vacia");
        }
        else{
            if(idx < 0 || idx > this.size-1){
                System.out.println("Error: indice fuera de rango");
            }
            else if(idx == 0){
                this.head = this.head.getNext();
                this.size--;
            }
            else{
                
                Node pointer = this.head;
                for (int i = 0; i < idx-1; i++) {
                    pointer = pointer.getNext();
                }
                
            }                        
        }
    }
    
    
    public T get(int idx){
        if(isEmpty()){
            System.out.println("Error: Lista vacia");
        }
        else{
            if(idx < 0 || idx > this.size-1){
                System.out.println("Error: indice fuera de rango");
            }
            else if(idx == 0){
                return (T) this.head.getData();
            }
            else if(idx == this.size-1){
                return (T) this.tail.getData();
            }
            else{
                Node pointer = this.head;
                for (int i = 0; i < idx; i++) {
                    pointer = pointer.getNext();
                }
                return (T) pointer.getData();      
            }                        
        }
        return null;
    }
    
    
    public void print(){
        if(!isEmpty()){
            Node pointer = this.head;
            while(pointer != null){
                System.out.println(pointer.getData());
                pointer = pointer.getNext();
            }
        }
    }
    
    
    
    
}
