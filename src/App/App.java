/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package App;
import models.Product;
import findController.FindController;
/**
 *
 * @author User
 */
public class App {
    public static void main(String[] args) {
        
        Product[] products = {                // Reaizamos un arreglo de ejemplo para usar busqueda binaria
            new Product("Laptop", 20),
            new Product("SmartPhone",25),
            new Product("Tablet", 10),
            new Product("Monitor",5),
            new Product("KeyBoard",15)
        };
        
        FindController findController = new FindController();
        findController.sortByName(products);
        
        for(Product p : products){
            System.out.println(p);
        }
        
        int result = findController.findByNameBinari(products, "Laptop");
        if(result >= 0){
            System.out.println("Esta en la posicion "+result);
        } else {
            System.out.println("No se encontro");
        }
        
        
        
    }
    
}
