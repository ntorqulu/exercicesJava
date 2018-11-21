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
public class Bicicleta {
    String model;
    double preu;
    boolean suspensio;
    double pes;
    
    Bicicleta(String model, double pes, String s, double preu){
        this.model = model;
        this.pes = pes;
        this.preu = preu;
        suspensio = s.equals("S");
    }
    
    @Override
    public String toString(){ //retornar els atributs d'una classe com una serie de caracters
        return model + " -- " + preu + " -- " + suspensio + " -- " + pes;
    }
}
