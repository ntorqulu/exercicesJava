
package edu.ub.juanadearco;


import static edu.ub.juanadearco.Util.getUrl;
import edu.ub.juanadearco.actors.Heroina;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Representa el marcador de vida, punts i gemmes encontrades (no implementat)
 * 
 * @author Prog1
 */
public class Marcador {

    private int y = 0;
    
    private Font fontNormal = new Font("Dialog", Font.PLAIN, 12);
    private Font fontPetita = new Font("Dialog", Font.BOLD, 10);
    
    public Marcador() {
        y = Constants.ALCADA_FINESTRA - 30;        
    }
   
    /**
     * Dibuixa el seu contingut.
     * 
     * @param ctx context del joc
     * @param g gràfics de sortida
     */
    public void render(Context ctx, Graphics2D g) {
        pintarFons(g);
        pintarNivellVida(ctx, g);
        pintarSala(ctx, g);
        pintarClaus(ctx, g);
        inventari(ctx, g);
    }
        
    
    // private methods *********************************************************
    
    private void pintarFons(Graphics2D g) {
        g.setPaint(new GradientPaint(
                Constants.AMPLADA_FINESTRA / 2.f, y, Color.DARK_GRAY, 
                Constants.AMPLADA_FINESTRA / 2.f, y + 40.f, Color.BLACK));
        
        Rectangle  r = new Rectangle(0, y, 
                Constants.AMPLADA_FINESTRA, Constants.ALCADA_FINESTRA - y);
        g.fill(r);        
    }

    private void pintarNivellVida(Context ctx, Graphics2D g) {
        g.setPaint(Color.white);
        g.setFont(fontNormal);
        g.drawString("Vida: ", 5, y + 15);
        
        Rectangle r = new Rectangle(40, y + 5, 100, 12);
        g.setColor(Color.BLACK);
        g.fill(r);
                
        Rectangle t = new Rectangle();
        t.setRect(r.getX(), r.getY(), ctx.getJoc().getHeroina().getVida(), (int)r.getHeight());
        
        int nivell = (int)(ctx.getJoc().getHeroina().getVida());

        g.setColor(nivell < 50 ? Color.RED : Color.BLUE);        
        g.fill(t);                   
        g.setColor(Color.white);
        g.draw(r);
        g.setFont(fontPetita);
                
        g.drawString(nivell + "%" , 60, y + 15);
    }
    
    
    private void pintarSala(Context ctx, Graphics2D g) {
        g.setColor(Color.white);
        g.setFont(fontNormal);
        int planta = ctx.getJoc().getCastell().getPlanta();
        int sala = ctx.getJoc().getCastell().getNumHabitacio();
        g.drawString("Planta: " + planta + " - Sala: " + sala, 200, y + 15);
    }
    
    private void inventari(Context ctx, Graphics2D g) {
        Heroina heroina = (Heroina) ctx.getJoc().getHeroina();
        ArrayList<String> clauArray = heroina.getClaus();
        int x = 580;
        for(int i = 0;i < clauArray.size();i++){
            
            Image icon0 = Util.carregarImatge("objectes.png", 
                675, 50, 20, 30);
            g.drawImage(icon0, x, y, new Canvas());
            x+= 35;
        }
    
        
    }
    /**
     * 
     * metode que imprimeix sota la pantalla si la heroina ha trobat totes les claus o no
     */
     private void pintarClaus(Context ctx, Graphics2D g) {
        g.setColor(Color.white);
        g.setFont(fontNormal);
        Heroina heroina = (Heroina) ctx.getJoc().getHeroina();
        // TODO alumnes de la funció corresponent i descomentar el codi
        String trobat = "No";
        if(heroina.haTrobatLesClaus()){
            trobat = "Si";
        }
        g.drawString("Ha trobat tots els diamants? " + trobat, 350, y +15); 
    }
}
