/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menubicicletes;

/**
 *
 * @author nuriatorquetluna
 */
public class TaulaBicicleta {
    // comptador
    int nBicis = 0;
    // vector de bicis
    Bicicleta[] tb;
    
    // constructor per a afegir bicicletes a l'array
    TaulaBicicleta(int max){
        if (max > 25){
            tb = new Bicicleta[25];
            
        }
        else{
            tb = new Bicicleta[max];
        }
    }
    void afegirBici(Bicicleta b){
        // tb en la posició nBicis li assigno la bicicleta b
        tb[nBicis] = b;
        nBicis += 1;
    }
    
    // imprimir info de cada bici, necessito recorregut
    void mostrarBicis(){
        for (int i = 0; i < nBicis; i++){
            // cridem metode toString de cada objecte bicicleta per imprimir atribiuts
            System.out.println(tb[i].toString());
        }
    }
    // demana minim
    Bicicleta getMinimCostPerKilo(){
        double ratio;
        double min = 1000.000;
        int aux = 0;
        for( int i = 0; i < nBicis; i++){
            ratio = tb[i].preu / tb[i].pes;
            // si quocient es menor que el minim, assignem al minim el ratio
            if (ratio < min){
                min = ratio;
                // guardar index bicicleta mes barata
                aux = i;
            }
        }
        return tb[aux];
    }
    Bicicleta getBiciMinimoPes(double peso){
        boolean trobat = false;
        int aux = 0;
        // fer una cerca per totes les bicis
        for( int i = 0; i < nBicis && !trobat; i++){
            if (tb[i].pes < peso){
             aux = i;
             trobat = true;
            }
            
        }
        return tb[aux];
    }
    
    
}
