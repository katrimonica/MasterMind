/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

/**
 * Pääohjelma
 * @author katri
 */
public class MasterMind {

    /**
     * Pääohjelma
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kayttoliittyma().setVisible(true);
            }
        });
    }
}
