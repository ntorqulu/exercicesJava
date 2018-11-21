/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menubicicletes;
import java.util.*;
/**
 *
 * @author nuriatorquetluna
 */
public class MenuBicicletes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean fi = false;
        int opt;
        TaulaBicicleta tb = new TaulaBicicleta(10);
        while(!fi){
            showMenu();
            opt = sc.nextInt();
            switch(opt){
                case 1:
                    System.out.println("Model");
                    String model = sc.next();
                    System.out.println("Preu");
                    Double preu = sc.nextDouble();
                    System.out.println("Suspensio(S/N)");
                    String suspensio = sc.next();
                    System.out.println("Pes");
                    Double pes = sc.nextDouble();
                    Bicicleta b = new Bicicleta(model, preu, suspensio, pes);
                    tb.afegirBici(b);
                    break;
                case 2:
                    tb.mostrarBicis();
                    break;
                case 3:
                    System.out.println(tb.getMinimCostPerKilo().toString());
                    
                    break;
                case 4:
                    System.out.println("Introdueix pes");
                    double pPes = sc.nextDouble();
                    System.out.println(tb.getBiciMinimoPes(pPes).toString());
                    break;
                case 5:
                    fi = true;
                    break;
                default:
                    break;
            }
        }
    
    
    }    
    
    
    public static void showMenu(){
        System.out.println("1. Afegir bicicleta.\n" +
"2. Mostrar bicis\n" +
"3. Obtenir el model de la bicicleta que tingui mínim cost per kilogram.\n" +
"4. Obtenir la bicicleta de pes inferior a un pes entrat per l’usuari, si és que n’hi ha alguna.\n" +
"5. Sortir.");

    }    
        
      
    
}
// Si volem treure bicis, el comptador també ha de disminuir
