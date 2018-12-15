
package edu.ub.juanadearco;

import edu.ub.juanadearco.actors.Brayan;
import edu.ub.juanadearco.actors.Clau;
import static edu.ub.juanadearco.actors.Clau.TipusClau.*;
import edu.ub.juanadearco.actors.Escut;
import edu.ub.juanadearco.actors.Heroina;
import edu.ub.juanadearco.actors.Menjar;
import edu.ub.juanadearco.actors.Vides;
import edu.ub.juanadearco.actors.Serpiente;

/**
 * Demo.
 * 
 * @author Prog1
 */


public class Practica{



    private Joc joc;
    private Castell castell;
    private Heroina heroina;

    private static final int MAX_MENJAR_PER_HABITACIO = 2;
    private static final int MAX_VIDES_PER_JOC = 2;
    
    private Practica() {
        // 1 planta amb tres habitacions
        castell = new Castell(3, 3);
        //afegir habitacio, planta 0 habitacio 0
        castell.addHabitacio(0, 0, crearHabitacio0Planta0());
        castell.addHabitacio(0, 1, crearHabitacio1Planta0());
        castell.addHabitacio(0, 2, crearHabitacio2Planta0());
        
        castell.addHabitacio(1, 0, crearHabitacio0Planta1());
        castell.addHabitacio(1, 1, crearHabitacio1Planta1());
        castell.addHabitacio(1, 2, crearHabitacio2Planta1());
        
        castell.addHabitacio(2, 0, crearHabitacio0Planta2());
        castell.addHabitacio(2, 1, crearHabitacio1Planta2());
        castell.addHabitacio(2, 2, crearHabitacio2Planta2());
        
        
        // situacio de l'heroina
        heroina = new Heroina();
        // establir-se a l'habitacio 0,0
        Habitacio h = castell.getHabitacio(0, 0);
        // de la cela 10, 10
        int[] p = h.getPosicioCela(10, 10);
        heroina.setPosicioInicial(p[0], p[1]);
        
        joc = new Joc(castell, heroina);                            
        distribuirMenjar();
        distribuirVides();
        distribuirSerpiente();
        distribuirClaus();
        posicionarBrayan();
        posicionarEscut();
        
        
        GuiJoc gui = new GuiJoc(joc);
        
        
        
       
            
        
    }
    
    
    // Crear totes les habitacions de la primera planta:
    private Habitacio crearHabitacio0Planta0() {
        // per crear habitacio llegeix un txt que creem nosaltres
        Habitacio h = Util.carregarHabitacio("h0_0.txt");
        
        // apuntar on estan les portes, es teletransporta a la cela 1, 1 del quadrat 14 24
        Porta porta = h.getPorta(13, 17);
        
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(6, 1));

        porta = h.getPorta(0, 10);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 10));
        
        porta = h.getPorta(16, 10);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 10));

        return h;
    }
    
    private Habitacio crearHabitacio1Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_1.txt");

        Porta porta = h.getPorta(6, 0);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(13, 16));
       
        return h;
    }

    private Habitacio crearHabitacio2Planta0() {
        Habitacio h = Util.carregarHabitacio("h0_2.txt");
        Porta porta = h.getPorta(16, 10);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 10));
        
        porta = h.getPorta(16, 14);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(12, 12));
        
        porta = h.getPorta(8, 0);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8, 23));
        
        porta = h.getPorta(8, 24);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8, 1));
        
        porta = h.getPorta(8, 12);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8, 11));
        
        porta = h.getPorta(0, 10);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 14));
        
        porta = h.getPorta(0, 14);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(1, 10));
        
        return h;
    }
    
    // Crear habitacions segona planta
    private Habitacio crearHabitacio0Planta1() {
        // per crear habitacio llegeix un txt que creem nosaltres
        Habitacio h = Util.carregarHabitacio("h1_0.txt");
        // apuntar on estan les portes, es teletransporta a la cela 1, 1 del quadrat 14 24
        Porta porta = h.getPorta(0, 10);
        porta.setNumPlantaDesti(0);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 10));

        porta = h.getPorta(8, 20);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 4));

        porta = h.getPorta(16, 10);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(2, 2));

        return h;
    }
    
    private Habitacio crearHabitacio1Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_1.txt");

        Porta porta = h.getPorta(0, 2);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 10));
       
        porta = h.getPorta(8, 10);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8, 1));
       
        return h;
    }

    private Habitacio crearHabitacio2Planta1() {
        Habitacio h = Util.carregarHabitacio("h1_2.txt");
        
        Porta porta = h.getPorta(8, 0);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(8, 9));
       
        return h;
    }
    
    
    
    // crear habitacions de la tercera planta
    private Habitacio crearHabitacio0Planta2() {
        // per crear habitacio llegeix un txt que creem nosaltres
        Habitacio h = Util.carregarHabitacio("h2_0.txt");
        // apuntar on estan les portes, es teletransporta a la cela 1, 1 del quadrat 14 24
        Porta porta = h.getPorta(0, 12);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 12));

        porta = h.getPorta(16, 4);
        porta.setNumPlantaDesti(1);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(10, 20));        

        return h;
    }
    
    // Crear habitacions segona planta
    private Habitacio crearHabitacio1Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_1.txt");

        Porta porta = h.getPorta(0, 12);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(2);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(14, 12));
        
        porta = h.getPorta(16, 12);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(0);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(2, 12));
        
       
        return h;
    }

    private Habitacio crearHabitacio2Planta2() {
        Habitacio h = Util.carregarHabitacio("h2_2.txt");
        Porta porta = h.getPorta(16, 12);
        porta.setNumPlantaDesti(2);
        porta.setNumHabitacioDesti(1);
        porta.setPosicioHabitacioDesti(h.getPosicioCela(2, 12));
        
        
       
        return h;
    }
    
    
   
    
    private void distribuirMenjar() {
        String[] menjars = {  "Pizza", "Pollastre", "Síndria" } ;
        // { calories,x,y,width,height } de cada imatge
        int[][] dades = {
            { 25, 540, 14, 30, 22 },
            { 50, 439, 14, 27, 23 },
            { 50, 97, 100, 30, 20 }
        };
        
        for (int i = 0; i < castell.getNumPlantes(); i++) {
            
            for (int j = 0; j < castell.getNumHabitacions(i); j++) {
                Habitacio h = castell.getHabitacio(i, j);
                int numMenjars = (int)(Math.random() * (MAX_MENJAR_PER_HABITACIO + 1));
                
                for (int k = 0; k < numMenjars; k++) {
                    int[] cela = obtenirCelaLliure(h);
                    int imenjar = (int)(Math.random() * menjars.length);
                    Menjar m = new Menjar(menjars[imenjar], 
                            dades[imenjar][0], dades[imenjar][1], dades[imenjar][2], 
                            dades[imenjar][3], dades[imenjar][4]);
                    
                    int[] posicio = h.getPosicioCela(cela[0], cela[1]);
                    m.setPosicioInicial(posicio[0], posicio[1]);
                    h.addActor(m);                     
                }
            }
            
        }
    }
   
    private int[] obtenirCelaLliure(Habitacio h) {
        int fila = 0;
        int col = 0;
        int cela[] = null;
        boolean trobada = false;
        boolean terra = false;
        
        while (!trobada) {            
            terra = false;
            while (!terra) {
                fila = (int)(Math.random() * Constants.NUM_CELES_VERTICALS);
                col = (int)(Math.random() * Constants.NUM_CELES_HORIZONTALS);
                terra = h.getValor(fila, col) == Constants.SIMBOL_TERRA;
            }
            
            // comprovar que cap actor està dins la cela
            Actor[] actors = h.getActorsAsArray();
            int i = 0;
            boolean lliure = true;
            while (i < actors.length && lliure) {
                cela = h.getCela(actors[i].getPosicioInicial()[0], 
                        actors[i].getPosicioInicial()[1]);
                lliure = fila != cela[0] || col != cela[1];            
                i++;
            }         
            trobada = lliure;
        }
        return new int[] { fila, col };
    }
    
    //Distribuye 2 vidas por el castillo. En
    //este caso cada vida de una habitación se crea 
    //y se posiciona en una celda concreta definida
    //al crearse la habitación misma.
    
    
    
    private void distribuirVides() {
        
        //Creem dos objectes que emmagatzemin la info de la classe Vides
        Vides vida1 = new Vides("Vida", 174, 12, 26, 24);
        Vides vida2 = new Vides("Vida", 174, 12, 26, 24);
        //creem objectes h1 i h2 que guardaran planta i pis
       Habitacio h1 = this.castell.getHabitacio(0,2);
       Habitacio h2 = this.castell.getHabitacio(2,0);
        // diem a quines caselles volem que es situin les dues vides
       int[]cela1 = {3, 20};
        int[]cela2 = {9, 5};
        int[]posicio1 = h1.getPosicioCela(cela1[0], cela1[1]);
        int[]posicio2 = h2.getPosicioCela(cela2[0], cela2[1]);
        vida1.setPosicioInicial(posicio1[0], posicio1[1]);
        vida2.setPosicioInicial(posicio2[0], posicio2[1]);
        h1.addActor(vida1);   
        h2.addActor(vida2);
}
    
    private void distribuirSerpiente() {
        String[] serpiente = {"Serp1", "Serp2", "Serp3", "Serp4"} ;
        // { calories,x,y,width,height } de cada imatge
        int[][] dades = {
            { 700, 0, 40, 42},
            { 700, 42, 40, 42},
            { 700, 84, 40, 42},
            { 700, 84, 40, 42}
        };
        Habitacio h0 = castell.getHabitacio(0, 2);
        Habitacio h1 = castell.getHabitacio(2, 2);
        Habitacio h2 = castell.getHabitacio(2, 1);
        Habitacio h3 = castell.getHabitacio(1, 0);
        Serpiente[] serpArray = new Serpiente[4];
        for (int k = 0; k < 4; k++){
            Serpiente s = new Serpiente(serpiente[k], 
                            dades[k][0], dades[k][1], dades[k][2], 
                            dades[k][3]);
            serpArray[k] = s;
        }

        int[] posicio0 = h0.getPosicioCela(13, 2);
        int[] posicio1 = h1.getPosicioCela(10, 10);
        int[] posicio2 = h2.getPosicioCela(11, 12);
        int[] posicio3 = h3.getPosicioCela(12, 14);
        serpArray[0].setPosicioInicial(posicio0[0], posicio0[1]);
        serpArray[1].setPosicioInicial(posicio1[0], posicio1[1]);
        serpArray[2].setPosicioInicial(posicio2[0], posicio2[1]);
        serpArray[3].setPosicioInicial(posicio3[0], posicio3[1]);
        h0.addActor(serpArray[0]);
        h1.addActor(serpArray[1]);
        h2.addActor(serpArray[2]);
        h3.addActor(serpArray[3]);
                           
            
        }
    private void distribuirClaus() {
    Clau[] array = new Clau[5];
        array[0] =  new Clau(FERRO);
        array[1] = new Clau(PLATA);
        array[2] = new Clau(BRONZE);
        array[3] = new Clau(LLAUTO);
        array[4] = new Clau(OR);
        
        for (int i = 0; i < 5; i++){
            int pis = (int)(Math.random() * 3);
            int habitacio = (int)(Math.random() * 3);
            Habitacio h = castell.getHabitacio(pis, habitacio);
            int[] cela = obtenirCelaLliure(h);
                int[] posicio = h.getPosicioCela(cela[0], cela[1]);
                array[i].setPosicioInicial(posicio[0], posicio[1]);
                h.addActor(array[i]);              
        }
    }    
    // Posicionem Brayan de forma aleatória    
    
    private void posicionarBrayan(){
      int planta = (int)(Math.random() * castell.getNumPlantes());
      int numHabitacio = (int)(Math.random() * castell.getNumHabitacions(planta));
      Habitacio h = castell.getHabitacio(planta, numHabitacio);
      int [] cela = obtenirCelaLliure(h);
      int [] posicio = h.getPosicioCela(cela[0],cela[1]);
      Brayan brayan = new Brayan("General Brayan", 0, 0, 25, 50);
      brayan.setPosicioInicial(posicio[0],posicio[1]);
      h.addActor(brayan);	
      }
    
    // Posicionem l'Escut a la última sala de la última planta    
    
    private void posicionarEscut() {
      int planta = 2;
      int numHabitacio = 2;
      Habitacio h = castell.getHabitacio(planta, numHabitacio);
      int [] cela = obtenirCelaLliure(h);
      int [] posicio = h.getPosicioCela(cela[0],cela[1]);
      Escut escut = new Escut("Escut", 4, 85, 32, 36);
      escut.setPosicioInicial(posicio[0],posicio[1]);
      h.addActor(escut);	
      }   
        
        
    
        
                 
        
        
        
                
        
        
    
    
    
             
                
        
    
       
            
        
    

    /**
     * Principal.
     * 
     * @param args
     */
    public static void main(String[] args) {
        new Practica();
    }
}





    
     
            
            
        
    
        
        
    

    

