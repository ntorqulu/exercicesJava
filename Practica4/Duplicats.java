'''
Crear programa que llegeixi n nombres enters sense dublicar i imprimeixi llista amb els enters sense duplicar.
'''

package javaapplication59;
import java.util.*;
/**
 *
 * @author nuriatorquetluna
 */
public class JavaApplication59 {

    /**
     * @param args the command line arguments
     */

        
    
   
 //Primer demanem a l'usuari que entri la longitud de l'array que crearem    
    
    public static void main (String[] args) {  
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=input.nextInt();
        
 // Creem l'array amb la longitud estipulada per l'user i li demanem que vagi entrant els num un per un
 // mitjançant un for de 0 (index 0) fins a la longitud de l'array(index long array- 1)
        
        int array[]=new int[n]; 
        System.out.println("Enter the elements one by one:");
        for (int s=0;s<array.length;s++){
            array[s]=input.nextInt();
        }
        
// Ordenem l'array per a que sigui més ràpid manipular-lo i cridem el mètode DuplicateRemoval que té com a paràmetres l'array
i la longitud de l'array

        Arrays.sort(array);
        int return_value= DuplicateRemoval(array, array.length);  
        System.out.println("Sorted Array after removing the Duplicate Elements:");
        for (int i=0; i<return_value; i++)  
           System.out.print(array[i]+" ");  
    }  
    
// Metode per eliminar elements duplicats    
    public static int DuplicateRemoval(int array[], int n){ 
    
// Si l'array no té element o només en té un    
        if (n==0 || n==1){  
            return n;  
        }   
        
// Variable k que utilitzarem com a index auxiliar        
        int k = 0;
// Iterem per tots els element de l'array menys l'últim        
        for (int i=0; i < n-1; i++){  
// Si l'element en índex i és diferent del element en posició i+1            
            if (array[i] != array[i+1]){
// Llavors assignem a la posició 1 l'element i            
                array[k++] = array[i];  
            }  
        }  
        array[k++] = array[n-1];  
        return k;  
    }         
}
