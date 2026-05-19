/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package findController;
import models.Product;
import models.Person;
import java.util.ArrayList;
/**
/**
* 
* 
* BUSQUEDA LINEAL ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
* Compara linealmente elemento por elemento hasta encontrar una coincidencia, sin embargo se vuelve demasiado lento y pesado
* en situaciones donde la base de datos donde debemos buscar es demasiado grande.
* Esta busqueda se representa simplemente con un bucle foreach y un condicional que pregunte si el elemento buscado
* es igual al elemento en la posicion actual del for.
* ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
* 
* 
* 
** BUSQUEDA BINARIA//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * Tambien conocido como busqueda dicotómica, pero requiere que el ordenamiento este ordenado.
 * En este metodo se definen dos variables importantes, el alto y el bajo, el alto es la ultima posicion y el bajo la primera posicion del arreglo.
 * Por lo cual; bajo = 0 y alto = array.length-1.
 * El punto central se obtiene de (bajo + alto)/2
 * 
 * Luego de esto, decidimos apra donde buscar, empezando por la mitad, se pregunta si el elemento buscado es igual a la mitad del arreglo.
 * luego se pregunta si es mayor o menor al punto central, con esto descartamos mas de la mitad de valores y buscamos en un lugar mas reducido.
 * Como ya descartamos la mitad, ahora tenemos un nuevo valor de alto, que seria alto = central -1.
 * 
 * Algo importante: dependiendo a donde busquemos despues de descartar una mitad, biscamos a la izquiera o a la derecha. Si buscamos hacia la izquierda
 * reducimos el limite de "Alto" y si buscamos a la derecha, aumentamos el limite de "bajo"
 * /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * 
 */
public class FindController {
    public void printRange(Person[] persons, int bajo, int alto){
        for(int i = bajo; i <= alto; i++){
            System.out.print(persons[i].getEdad());
            if(i < alto){
                System.out.print(" | ");
            }
        }
        System.out.println();
    }
    public int findByNameBinari(Product[] products, String name){
        
        int alto = products.length-1;                           //ULTIMA POSICION DEL ARREGLO
        int bajo = 0;                                           //PRIMERA POSICION
        
        while(bajo <= alto){                                    // SEGUIMOS BUSCANDO MIENTRAS LOS LIMITES POR LOS LADOS NO SE CRUZEN
            int central = (alto + bajo)/2;                      // PUNTO CETRAL DENTRO DEL WHILE PARA QUE SE ACTUALIZE EN CADA ITERACION
            if(products[central].getName().equals(name)){       // PREGUNTAMOS SI EL PUNTO CENTRAL ES IGUAL AL VALOR BUSADO
                 return central;
            }
            if(products[central].getName().compareTo(name)>0){   // EL COMPARE TO NOS DICE SI EL NOMBRE BUSCADO ES MAYOR O MENOS ALFABETICAMENTE AL CENTRO.
                bajo = central +1;                               //SI EL NUMERO ES MAYOR ALFABETICAMENTE, BUSCAMOS HACIA LA DERECHA O ARRIBA
            } else {
                alto = central -1;                               // SI ES  MENOR, BUSCAMOS HACIA LA IZQUIERA O ABAJO.
            }
        }
        return -1;                                               // SI NO SE ENCONTRO EL VALOR, POR CONVENCION SE RETORNA -1 PARA SABER QUE NO EXISTE
    }
    
    public void sortByName(Product[] products){
        int n = products.length;
        for(int i = 0; i<n; i++){
           boolean cambio = false;
           for(int j = 1; j<n;j++){
                if(products[i].getName().compareTo(products[j].getName())<0){
                    Product aux = products[i];
                    products[i]=products[j];
                    products[j] = aux;
                    cambio = true;
                }
            }
           if(!cambio)
               break;
        }    
    }
    
    
    public void sortByAgre(Person[] persons){
        int n = persons.length;
        
        for(int gap = n/2; gap>0; gap /=2){
            for(int i = gap; i<n; i++){
                Person temp = persons[i];
                int j = i;
                
                while(j>=gap && persons[j-gap].getEdad()>temp.getEdad()){
                    persons[j] = persons[j-gap];
                    j -= gap;
                }
                persons[j]=temp;
            }
        }
    }
    
    public int findByAge(Person[] persons, int ageFind){
        int alto = persons.length - 1;
        int bajo = 0;

        while(bajo <= alto){
            int central = (alto + bajo) / 2;
            printRange(persons, bajo, alto);
            System.out.print( "bajo=" + bajo + " " + " alto=" + alto + " "+ " centro=" + central +" " +" valorCentro=" + central);
            if(persons[central].getEdad() == ageFind){
                System.out.print(" " +  "ELEMENTO ENCONTRADO: "+central);
                System.out.println();
                return central;
            }
            if(persons[central].getEdad() > ageFind){
                System.out.print(" " + "BUSCAMOS EN LA IZQUIERDA");
                alto = central - 1;
            } else {
                System.out.print(" " + "BUSCAMOS EN LA DERECHA");
                bajo = central + 1;
            }
            System.out.println();
        }
        return -1;
    }
}
