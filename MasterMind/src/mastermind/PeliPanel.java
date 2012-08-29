/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author katri
 */
public class PeliPanel extends JPanel {
    private ArrayList<Arvaus> arvatutRivit;
    private char merkki;
    
    public void asetaMerkki(char merkki) {
        this.merkki = merkki; 
    }
    
    public void asetaRivit(ArrayList<Arvaus> arvatutRivit) {
        this.arvatutRivit = arvatutRivit;
    }
    
    @Override
    public void paintComponent(Graphics g) {
         super.paintComponent(g);
         int rivinumero=0;
         if(arvatutRivit != null) {
         for(Arvaus i : arvatutRivit) {
             int sarakenumero = 0;
             for(Integer j : i.haeArvaus()) {
                 Kuva k = new Kuva(merkki,j);
                 k.paintIcon(this, g, sarakenumero*30, rivinumero*30);
                 sarakenumero++;
             }
             int paikka = 0;
             for(int j = 0; j<i.haeTulos().haeOsumat(); j++,paikka++) {
                 g.setColor(Color.BLACK);                 
                 g.fillOval(sarakenumero*30 + 30+paikka*10, rivinumero*30, 5, 5);
             }
             for(int j = 0; j<i.haeTulos().haeSivuosumat(); j++, paikka++) {
                 g.setColor(Color.WHITE);
                 g.fillOval(sarakenumero*30 + 30+paikka*10, rivinumero*30, 5, 5);
             }
             rivinumero++;
         }
         }
    }
}
