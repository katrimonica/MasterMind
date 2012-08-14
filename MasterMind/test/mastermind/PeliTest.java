/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author katri
 */
public class PeliTest {
    
    public PeliTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of haeArvauksia method, of class Peli.
     */
    @Test(expected=RuntimeException.class)
    public void testLiikaaArvauksia() {
        System.out.println("Liikaa arvauksia");
        Peli instance = null;
        ArrayList<Integer> oikeaRivi = null;
        try{
            instance = new Peli(5,3);
            oikeaRivi = (ArrayList<Integer>)instance.haeOikeaRivi().clone();
            if(oikeaRivi.get(0) == 0) {
                oikeaRivi.set(0, 1);
            }
            else {
                oikeaRivi.set(0, 0);
            }
            TarkastusTulos arvaus = instance.arvaus(oikeaRivi);
            arvaus = instance.arvaus(oikeaRivi);
            arvaus = instance.arvaus(oikeaRivi);
        } 
        catch(Exception e) {
            fail("arvaus heitti poikkeuksen");
        }
        instance.arvaus(oikeaRivi);
        fail("Arvaus ei heittänyt poikkeusta");
    }

    /**
     * Test of haeArvauksia method, of class Peli.
     */
    @Test(expected=RuntimeException.class)
    public void testOikeaArvaus() {
        System.out.println("Liikaa arvauksia");
        Peli instance = null;
        ArrayList<Integer> oikeaRivi = null;
        try{
            instance = new Peli(4,4);
        oikeaRivi = instance.haeOikeaRivi();
        
        
            TarkastusTulos tulos = instance.arvaus(oikeaRivi);
            assertEquals(tulos.haeKaikkiOikein(), true);
            
        } 
        catch(Exception e) {
            fail("arvaus heitti poikkeuksen");
        }
        instance.arvaus(oikeaRivi);
        fail("Arvaus ei heittänyt poikkeusta");
    }

    
   
}
