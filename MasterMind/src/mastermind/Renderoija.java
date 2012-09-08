
package mastermind;

import java.awt.Canvas;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Renderoija muodostaa ComboBoxiin sopivia kuvia
 * 
 * @author katri
 */
public class Renderoija extends JLabel implements ListCellRenderer {
    private char merkki;
    /**
     * Alustaa renderoijan
     * @param merkki käytetty symbooli
     */
    public Renderoija(char merkki) {
        super();
        this.merkki = merkki;
    }
    /**
     * Kutsutaan Comboboxia piirrettäessä. Määrittää 
     * halutun merkin tietyn värisenä
     * @return oma komponentti
     */
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
