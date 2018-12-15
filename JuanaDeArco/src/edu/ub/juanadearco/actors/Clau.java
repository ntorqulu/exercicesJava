
package edu.ub.juanadearco.actors;

import edu.ub.juanadearco.Actor;
import edu.ub.juanadearco.Colisio;
import edu.ub.juanadearco.Constants;
import edu.ub.juanadearco.Context;
import edu.ub.juanadearco.Util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * Les claus permeten finalitzar el joc i guanyar la partida
 * 
 * @author Prog1
 */
public class Clau extends AbstractActor {

    private Image image;
    private int amplada;
    private int alcada;
    public String nom;
    public Clau[] arrayClaus;
    public boolean esClauOr;

    

    
   
    
        
   
    
    
    public void actualitzar(Context context) {
        // no fem res, es estàtic
    }

    public Rectangle getLimits() {
        return new Rectangle(getX(), getY(), amplada, alcada);
    }

    // obtenim un actor
    public void tractarColisio(Colisio colisio) {
        
        Actor actor = colisio.getActor();
        // instace of, aquest actor de la classe Actor es una heroina?
        
        if (actor instanceof Heroina){
            Heroina heroina = (Heroina)actor;
            // l'heroina afegeix al seu array de claus l'objecte contra el que ha col·lidit
            // cridem el mètode addClau de la classe heroina
            ((Heroina) actor).addClau(this);
            // cridem el metode setOr per checkejar si la clau és d'or
            ((Heroina) actor).setOr(this);
      
            setEstat(Constants.ESTAT_INACTIU);
                
            }

                
        }

    
    
        /**
     * Crea un nou objecte del tipus Clau basant-nos en el seu tipus. Crearem un enum
     * per evitar que s'introdueixin noms falsos.
     * 
     * 
     * @param nom Nom de la clau
     * @param tipus tipus de clau 
     * @param imgPosX posició x de la subimage
     * @param imgPosY posició y de la subimage
     * @param imgAmplada amplada de la subimage
     * @param imgAlcada alçada de la subimage
     */
    
    public static enum TipusClau{FERRO, BRONZE, PLATA, LLAUTO, OR};
    private TipusClau tipus;
    



    public Clau(TipusClau tipus) {
        this.tipus = tipus;
        this.esClauOr = false;
        image = Util.carregarImatge("objectes.png", 
                675, 50, 20, 30);
        amplada = 20;
        alcada = 30;
        switch (tipus){
            case FERRO:
                this.nom = "Ferro";
                
                break;
            case BRONZE:
                this.nom = "Bronze";
                
                break;
            case PLATA:
                this.nom = "Plata";
                
                break;
            case LLAUTO:
                this.nom = "Llauto";
                
                break;
            case OR:
                this.nom = "Or";
                esClauOr = true;
                
               
                break;
        }
        
    }

     public String getNom(){
        return nom;
    }
    

    public void render(Graphics2D g) {
        g.drawImage(image, getX(), getY(), observer);
        g.setColor(Color.GREEN);
        Font f = new Font("Dialog", Font.BOLD, 10);
        g.setFont(f);
        g.drawString(nom, getX(), getY() - 3);
    }
           
}
