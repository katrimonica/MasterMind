/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.awt.Canvas;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author katri
 */
public class Renderoija extends JLabel implements ListCellRenderer {
    private char merkki;
    public Renderoija(char merkki) {
        super();
        this.merkki = merkki;
    }
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,boolean isSelected,
                                       boolean cellHasFocus) {
        System.out.println("+"+value+"+");
        int selectedIndex = Integer.parseInt(((String)value))-1;
        Kuva k = new Kuva(merkki, selectedIndex);
        setIcon(k);
        return this;
    }
    
}
