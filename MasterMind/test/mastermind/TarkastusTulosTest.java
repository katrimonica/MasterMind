package mastermind;

import org.junit.*;
import static org.junit.Assert.*;

public class TarkastusTulosTest {
    
    public TarkastusTulosTest() {
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

    /**
     * Test of haeOsumat method, of class TarkastusTulos.
     */
    @Test
    public void testHaeOsumat() {
        System.out.println("haeOsumat");
        TarkastusTulos instance = new TarkastusTulos(1,2, false);
        int expResult = 1;
        int result = instance.haeOsumat();
        assertEquals(expResult, result);
    }

    /**
     * Test of haeSivuosumat method, of class TarkastusTulos.
     */
    @Test
    public void testHaeSivuosumat() {
        System.out.println("haeSivuosumat");
        TarkastusTulos instance = new TarkastusTulos(1,2, false);
        int expResult = 2;
        int result = instance.haeSivuosumat();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class TarkastusTulos.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object toinen = new TarkastusTulos(1,2, true);
        TarkastusTulos instance = new TarkastusTulos(1,2, true);
        boolean expResult = true;
        boolean result = instance.equals(toinen);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of notEquals method, of class TarkastusTulos.
     */
        
    
    @Test
    public void testNotEquals() {
        System.out.println("not equals");
        Object toinen = new TarkastusTulos(2,1, true);
        TarkastusTulos instance = new TarkastusTulos(1,2, false);
        boolean expResult = false;
        boolean result = instance.equals(toinen);
        assertEquals(expResult, result);
    }

}
