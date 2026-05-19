/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package App;
import models.Product;
import findController.FindController;
import java.util.Scanner;
import models.Person;
/**
 *
 * @author User
 */
public class App {
    public static void main(String[] args) {
        FindController controller = new FindController();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("BIENVENIDO AL SISTEMA DE BUSQUEDA");
        System.out.print("Ingrese la cantidad de personas: ");
        int num = sc.nextInt();
        sc.nextLine();
        
        Person[] persons = new Person[num];
        for(int i = 0; i<num; i++){
            System.out.println("Datos de la persona "+(i+1)+":");
            System.out.print("Nombre: ");
            String name = sc.nextLine();
            System.out.print("Edad: ");
            int age = sc.nextInt();
            sc.nextLine();
            
            Person p = new Person(name,age);
            persons[i]=p;
        }
        
        System.out.println("ARREGLO CREADO --- INGRESE LA EDAD A BUSCAR ---");
        System.out.print("Age: ");
        int ageFind = sc.nextInt();
        sc.nextLine();
        
        System.out.println("EL ARREGLO SE ORDENO POR EDAD");
        controller.sortByAgre(persons);
        int res = controller.findByAge(persons, ageFind);
        
        if (res>= 0) {
            System.out.println("La persona con la edad: "+ persons[res].getEdad()+ " es: ");
            System.out.println("\tDATOS: "+ persons[res]);
        }else{
            System.out.println("No se encontro una persona con la edad ingresada");
        }
        
        
        /*Product[] products = {                
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
        }*/
        
        
        
    }
    
}
