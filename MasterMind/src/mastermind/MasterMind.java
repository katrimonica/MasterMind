/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

/**
 *
 * @author katri
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kayttoliittyma().setVisible(true);
            }
        });
    }
}
