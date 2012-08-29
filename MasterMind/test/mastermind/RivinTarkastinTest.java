package mastermind;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class RivinTarkastinTest {
    
    public RivinTarkastinTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test(expected=RuntimeException.class)
    public void testArvausNollaVaria() {
        System.out.println("arvaus");
        ArrayList<Integer> arvattuRivi = null;
        RivinTarkastin instance = new RivinTarkastin(0);
        fail("Ei poikkeusta");        
    }   
     /**
     * Testaus arvauksesta jossa kaikki on oikein.
     */
    
    @Test
    public void testArvausSama() {
        System.out.println("arvaus ok");                
        ArrayList<Integer> rivi = new ArrayList<Integer>();        
        rivi.add(1);
        rivi.add(2);
        rivi.add(3);
        rivi.add(4);
        RivinTarkastin instance = new RivinTarkastin(5, rivi);
        TarkastusTulos expResult = new TarkastusTulos(4,0, true);
        TarkastusTulos result = instance.arvaus(rivi);
        assertEquals(expResult, result);
    }
     /**
     * Testaus arvauksesta jossa kaikki on väärin.
     */
    
    @Test
    public void testArvausKaikkiVaarin() {
        System.out.println("kaikki väärin");                
        ArrayList<Integer> rivi = new ArrayList<Integer>();        
        rivi.add(1);
        rivi.add(1);
        rivi.add(1);
        rivi.add(1);
        ArrayList<Integer> rivi2 = new ArrayList<Integer>();        
        rivi2.add(2);
        rivi2.add(2);
        rivi2.add(3);
        rivi2.add(4);
        RivinTarkastin instance = new RivinTarkastin(5, rivi);
        TarkastusTulos expResult = new TarkastusTulos(0,0,false);
        TarkastusTulos result = instance.arvaus(rivi2);
        assertEquals(expResult, result);
    }
     /**
     * Testaus arvauksesta, jossa kaikki on väärillä paikoilla.
     */
    
    @Test
    public void testArvausKaikkiVaarillaPaikoilla() {
        System.out.println("kaikki väärillä paikoilla");                
        ArrayList<Integer> rivi = new ArrayList<Integer>();        
        rivi.add(1);
        rivi.add(2);
        rivi.add(3);
        rivi.add(4);
        ArrayList<Integer> rivi2 = new ArrayList<Integer>();        
        rivi2.add(4);
        rivi2.add(3);
        rivi2.add(2);
        rivi2.add(1);
        RivinTarkastin instance = new RivinTarkastin(5, rivi);
        TarkastusTulos expResult = new TarkastusTulos(0,4,false);
        TarkastusTulos result = instance.arvaus(rivi2);
        assertEquals(expResult, result);
    }
     /**
     * Osa oikein arvauksen testaus.
     */
    
    @Test
    public void testArvausOsaOikein() {
        System.out.println("osa oikein");                
        ArrayList<Integer> rivi = new ArrayList<Integer>();        
        rivi.add(1);
        rivi.add(2);
        rivi.add(3);
        rivi.add(4);
        ArrayList<Integer> rivi2 = new ArrayList<Integer>();        
        rivi2.add(1);
        rivi2.add(4);
        rivi2.add(3);
        rivi2.add(2);
        RivinTarkastin instance = new RivinTarkastin(5, rivi);
        TarkastusTulos expResult = new TarkastusTulos(2,2,false);
        TarkastusTulos result = instance.arvaus(rivi2);
        assertEquals(expResult, result);
    }
    
    /**
     * Väärän värin testaus, jolloin arvaus heittää poikkeuksen.
     */
    @Test(expected=RuntimeException.class)
    public void testArvausVaaraVari() {
        System.out.println("väärä väri");                
        ArrayList<Integer> rivi = new ArrayList<Integer>();        
        rivi.add(1);
        rivi.add(2);
        rivi.add(3);
        rivi.add(4);
        ArrayList<Integer> rivi2 = new ArrayList<Integer>();        
        rivi2.add(1);
        rivi2.add(4);
        rivi2.add(3);
        rivi2.add(5);
        RivinTarkastin instance = new RivinTarkastin(5, rivi);
        TarkastusTulos expResult = new TarkastusTulos(2,2,false);
        TarkastusTulos result = instance.arvaus(rivi2);        
        fail("Ei poikkeusta");        
    }

   
}
