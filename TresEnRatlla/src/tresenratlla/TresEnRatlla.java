/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenratlla;
import java.util.Scanner;

/**
 *
 * @author nuriatorquetluna
 */
public class TresEnRatlla {
    int[][] tauler = new int[3][3];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       TresEnRatlla joc = new TresEnRatlla();
       Scanner sc = new Scanner(System.in);
       System.out.println("Vols jugar al tres en ratlla?");
       boolean[] fiDelJoc = new boolean[2];
       while((fiDelJoc[0] == false) || (fiDelJoc[1] == false) || (fiDelJoc[2] == false)){
            System.out.println("Introduiu la posició (x,y) de la fitxa");
            int f = sc.nextInt();
            int c = sc.nextInt();
            joc.tiradaJugador(f,c);
            joc.printTauler();
            fiDelJoc = joc.fiJoc();
            joc.tiradaMaquina();
            joc.printTauler();
            fiDelJoc = joc.fiJoc();
  
    }
       if(fiDelJoc[0] == true){
           System.out.println("Has guanyat");
       }
       if(fiDelJoc[1] == true){
          System.out.println("Ha guanyat la màquina"); 
       }
       if(fiDelJoc[2] == true){
          System.out.println("Hi ha hagut un empat"); 
       }
    }
    
    public TresEnRatlla(){
        this.tauler = tauler;
        for(int i = 0; i < tauler.length; i++){
            for(int j = 0; j < tauler[i].length; j ++){
                tauler[i][j] = -1;
            }
        }
        
    }
    public void tiradaJugador(int f, int c){
        if(!celaOcupada(f, c) == true){
            tauler[f][c] = 1;
        }
        else{
            System.out.println("La cela ja estava ocupada");
        }
    }
    
    public boolean celaOcupada(int f, int c){
        if (tauler[f][c] == 1){
            return true;
        }
        else{
            return false;
        }
    }
    // número aleatorio entre 0 y 10
    public void tiradaMaquina(){
        // tirada entre el 0 i el 2
        int dauFiles = (int)(Math.random()*3);
        int dauColumnes = (int)(Math.random()*3);
        if(!celaOcupada(dauFiles, dauColumnes) == true){
            tauler[dauFiles][dauColumnes] = 0;
        }
    }
    
    public boolean[] fiJoc(){
        boolean[] fiDelJoc = new boolean[3];
        if(fiJocJugador() == true){
            fiDelJoc[0] = true;
        }
        if(fiJocMaquina() == true){
            fiDelJoc[1] = true;
        }
        if(fiJocCaselles() == true){
            fiDelJoc[2] = true;
        }
    return fiDelJoc;
        
    }
    
    /**
     * |_1_|_0_|_-1_|
     * |_1_|_1_|_0_|
     * |_1_|_0_|_1_|
     * 
     * per check files, comptador, si comptador= 3, tenim tres en ratlla fila
     * com que primer evaluem files, un cop sortim de la fila comptador torna
     * a 0
     * per check columnes, fem un for al reves
     * 
     * per check diagonals, if tauler[i][j] = 1 quan i = j, comptador diagonal
     * 
     * 
     * (0,0), (1,0), (2,0) 
     */
    
    
    public boolean fiJocJugador(){
        int comptadorColumna0 = 0;
        int comptadorColumna1 = 0;
        int comptadorColumna2 = 0;
        int comptadorDiagonal1 = 0;
        int comptadorDiagonal2 = 0;
        int comptadorFiles = 0;
        boolean guanyaJugador = false;
        
        for(int i = 0; i< tauler.length; i ++){
            comptadorFiles = 0;
            if(tauler[i][0] == 1){
                comptadorColumna0 ++;
            }
            if(tauler[i][1] == 1){
                comptadorColumna1 ++;
            }
            if(tauler[i][2] == 1){
                comptadorColumna2 ++; 
                
            }
            for(int j = 0; j < tauler.length; j++){
                if (tauler[i][j] == 1){
                    comptadorFiles +=1;
                }
            
                if ((i == j) && (i != 0 && j != 2) && (j != 0 && i != 2)){
                    if(tauler[i][j] == 1){
                        comptadorDiagonal1 += 1;
                    }
                }
                if ((i == j) && (i != 0 && j != 0) && (j != 2 && i != 2)){
                    if(tauler[i][j] == 1){
                        comptadorDiagonal2 += 1;
                    }
                }
                    
                }
                
            }
        if ((comptadorColumna0 == 3) || (comptadorColumna1 == 3) || (comptadorColumna2 == 3) || 
                (comptadorDiagonal1 == 3) || (comptadorDiagonal2 == 3) || (comptadorFiles == 3)){
            guanyaJugador = true;
        }
        return guanyaJugador;
        }
        
    
    
    public boolean fiJocMaquina(){
        int comptadorColumna0 = 0;
        int comptadorColumna1 = 0;
        int comptadorColumna2 = 0;
        int comptadorDiagonal1 = 0;
        int comptadorDiagonal2 = 0;
        int comptadorFiles = 0;
        boolean guanyaMaquina = false;
        
        for(int i = 0; i< tauler.length; i ++){
            comptadorFiles = 0;
            if(tauler[i][0] == 0){
                comptadorColumna0 ++;
            }
            if(tauler[i][1] == 0){
                comptadorColumna1 ++;
            }
            if(tauler[i][2] == 0){
                comptadorColumna2 ++; 
                
            }
            for(int j = 0; j < tauler.length; j++){
                if (tauler[i][j] == 0){
                    comptadorFiles +=1;
                }
            
                if ((i == j) && (i != 0 && j != 2) && (j != 0 && i != 2)){
                    if(tauler[i][j] == 0){
                        comptadorDiagonal1 += 1;
                    }
                }
                if ((i == j) && (i != 0 && j != 0) && (j != 2 && i != 2)){
                    if(tauler[i][j] == 0){
                        comptadorDiagonal2 += 1;
                    }
                }
                    
                }
                
            }
        if ((comptadorColumna0 == 3) || (comptadorColumna1 == 3) || (comptadorColumna2 == 3) || 
                (comptadorDiagonal1 == 3) || (comptadorDiagonal2 == 3) || (comptadorFiles == 3)){
            guanyaMaquina = true;
        }
        return guanyaMaquina;
        
    }
    public boolean fiJocCaselles(){
        boolean empat = false;
        for(int i = 0; i < tauler.length; i++){
            for(int j = 0; j< tauler[i].length; j ++){
                if(tauler[i][j] != -1){
                    empat = true;
                }
            }
        }
        return empat;
    }
    
    
    public void printTauler(){
        for(int i = 0; i< tauler.length; i ++){
            System.out.println();
            for(int j = 0; j < tauler.length; j++){
                System.out.print(tauler[i][j] + "\t");
            }
        }
    }
    
}
