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
 * Les serps decrementen la vida de l'heroina en 50 unitats quan impacta contra elles.
 * Un cop efectuada la col·lisió, desapareixen
 * @author Prog1
 */
public class Serpiente extends AbstractActor {

    private Image image;
    private int amplada;
    private int alcada;
    private String nom;
    private float mal = 50f;

    
    /**
     * Crea un nou objecte del tipus Serp amb una subimage del fitxer
     * <code>objectes.png</code> i el nom
     * 
     * @param nom Nom
     * @param imgPosX posició x de la subimage
     * @param imgPosY posició y de la subimage
     * @param imgAmplada amplada de la subimage
     * @param imgAlcada alçada de la subimage
     */
    public Serpiente(String nom, int imgPosX, int imgPosY, 
            int imgAmplada, int imgAlcada) {
        this.nom = nom;
        this.image = Util.carregarImatge("objectes.png", 
                imgPosX, imgPosY, imgAmplada, imgAlcada);
        this.amplada = imgAmplada;
        this.alcada = imgAlcada;
        // quan tenim una collisio, estat actiu
        setEstat(Constants.ESTAT_ACTIU);
    }
        
   

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
        if (actor instanceof Heroina) {
	        actor.setVida(Math.max(0 ,actor.getVida() - mal));
	        // si m'han menjat ja no apareixo en el joc
                // setVida(Math.max(0, getVida() - mal));
                setEstat(Constants.ESTAT_INACTIU);
        }
    }

    public void render(Graphics2D g) {
        g.drawImage(image, getX(), getY(), observer);
        g.setColor(Color.GREEN);
        Font f = new Font("Dialog", Font.BOLD, 10);
        g.setFont(f);
        g.drawString(nom, getX(), getY() - 3);
    }
           
}
