/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
public class Product {
    private String name;
    private int cant;
    
    public Product(){}

    public Product(String name, int cant) {
        this.name = name;
        this.cant = cant;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", cant=" + cant + '}';
    }
    
    
    
    
}
