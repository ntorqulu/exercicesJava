

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

        
    
   
       
    public static void main (String[] args) {  
        int numero = 0;
        int set = 7;
        int i = 1;
        boolean zeros;
        int nombrezeros = 0;
        while( numero <= 10000 ){
            numero = i * set;
            zeros = nZeros(numero);
            if (zeros == true ){
                nombrezeros ++;
            }
            
            i ++;            
        }
    System.out.println(nombrezeros);
        }
  
    static boolean nZeros (int n){
      String b = String.valueOf(n);
      boolean count = false;
      for(int i = 0; i< b.length(); i++){
          if (b.charAt(i) == '0'){
              count = true;
          }
      }
      return count;
    }
        
}
            
 
        
    


