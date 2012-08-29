/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author katri
 */
public class Kuva implements Icon {
    private int indeksi;
    private char merkki;
    public Kuva(char merkki, int indeksi) {
        this.indeksi = indeksi;
        this.merkki = merkki;
    }
    
    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int x, int y) {
        Graphics g = grphcs.create();
        Color vari;
        switch (indeksi) {
            case 0 : vari = Color.RED;
                break;
            case 1 : vari = Color.BLUE;
                break;
            case 2 : vari = Color.GREEN;
                break;
            case 3 : vari = Color.YELLOW;
                break;
            case 4 : vari = Color.GRAY;
                break;
            case 5 : vari = Color.PINK;
                break;
            case 6 : vari = Color.CYAN;
                break;
            case 7 : vari = Color.MAGENTA;
                break;
            case 8 : vari = Color.DARK_GRAY;
                break;
            case 9 : vari = Color.ORANGE;
                break;
            case 10 : vari = Color.LIGHT_GRAY;
                break;
                

            default :
                vari = Color.BLACK;
           
        }
        g.setColor(vari);
        if(merkki == 0) {
            g.fillRect(x ,y, 25 ,25);
        }
        else {
            g.setFont(new Font(null, Font.PLAIN, 20));
            g.drawString(""+merkki, x, y+15);
        }
        g.dispose();
    }

    @Override
    public int getIconWidth() {
        return 25;
    }

    @Override
    public int getIconHeight() {
        return 25;
    }
    
}
