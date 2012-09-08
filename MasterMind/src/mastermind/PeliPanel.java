package mastermind;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * PeliPanel johon pelin tapahtumat piirretään
 * @author katri
 */
public class PeliPanel extends JPanel {
    private ArrayList<Arvaus> arvatutRivit;
    private char merkki;
    
    /**
     * Asettaa käytetyn merkin
     * @param merkki käytetty merkki
     */
    public void asetaMerkki(char merkki) {
        this.merkki = merkki; 
    }
    
    /**
     * Asettaa tämän hetkiset arvatut rivit (piirtämistä varten)
     * @param arvatutRivit arvatut rivit
     */
    public void asetaRivit(ArrayList<Arvaus> arvatutRivit) {
        this.arvatutRivit = arvatutRivit;
    }
    
    /**
     * Piirtää komponentin
     * @param g mihin piirretään
     */
    @Override
    public void paintComponent(Graphics g) {
         super.paintComponent(g);
         int rivinumero=0;
         
         // jos ei ole rivejä, ei piirretä mitään
         if(arvatutRivit != null) {
            // mennään läpi arvatut rivit
            for (Arvaus i : arvatutRivit) {
                int sarakenumero = 0;
                // tulostetaan merkit oikeaan paikkaan
                for (Integer j : i.haeArvaus()) {
                    Kuva k = new Kuva(merkki, j);
                    k.paintIcon(this, g, sarakenumero * 30, rivinumero * 30);
                    sarakenumero++;
                }
                // tulostetaan mustat merkit
                int paikka = 0;
                for (int j = 0; j < i.haeTulos().haeOsumat(); j++, paikka++) {
                    g.setColor(Color.BLACK);
                    g.fillOval(sarakenumero * 30 + 30 + paikka * 10, rivinumero * 30, 5, 5);
                }
                // tulostetaan valkoiset merkit
                for (int j = 0; j < i.haeTulos().haeSivuosumat(); j++, paikka++) {
                    g.setColor(Color.WHITE);
                    g.fillOval(sarakenumero * 30 + 30 + paikka * 10, rivinumero * 30, 5, 5);
                }
                rivinumero++;
            }
        }
    }
}
