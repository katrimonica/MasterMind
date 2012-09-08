package mastermind;

import org.junit.*;
import static org.junit.Assert.*;

public class TarkastusTulosTest {
    /**
     * Testaa että haeOsumat toimii
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
     * Testaa että haeSivuosumat toimii
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
     * Testaa että equals metodi toimii
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
     * Testaa että equals palauttaa false kun oliot eivät ole samanlaisia
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
