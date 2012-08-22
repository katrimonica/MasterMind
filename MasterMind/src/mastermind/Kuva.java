/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
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
    public Kuva(int indeksi) {
        this.indeksi = indeksi;
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
            case 4 : vari = Color.RED;
                break;
            default :
                vari = Color.BLACK;
           
        }
        g.setColor(vari);
        g.fillRect(x ,y, 25 ,25);
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
