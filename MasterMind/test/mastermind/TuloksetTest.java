package mastermind;

import java.util.ArrayList;
import mastermind.Tulokset.Tulos;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tulokset-luokan testiluokka
 * @author katri
 */
public class TuloksetTest {       
    /**
     * Testataan toimiiko mahtuuko-metodi oikein
     */
    @Test
    public void testMahtuuko() {
        System.out.println("mahtuuko");
        int vareja = 4;
        int arvauksia = 5;
        Tulokset instance = new Tulokset("tiedosto.txt", false);        
        boolean expResult = true;
        boolean result = instance.mahtuuko(vareja, arvauksia);                
        assertEquals(expResult, result);
        for(int i=0; i<9; i++) {
          instance.lisaa(vareja, 3, "pelaaja");                
        }        
        result = instance.mahtuuko(vareja, arvauksia);                
        assertEquals(expResult, result);
        instance.lisaa(vareja+1, 3, "pelaaja");                
        result = instance.mahtuuko(vareja, arvauksia);                
        assertEquals(expResult, result);
        instance.lisaa(vareja, 3, "pelaaja");                
        expResult = false;
        result = instance.mahtuuko(vareja, arvauksia);                
        assertEquals(expResult, result);                        
    }

    /**
     * Testataan toimiiko lisääminen oikein
     */
    @Test
    public void testLisaa() {
        System.out.println("lisaa");
        int vareja = 1;
        int arvauksia = 1;
        String nimi = "nimi";
        Tulokset instance = new Tulokset("tulos.txt", false);
        instance.lisaa(vareja, arvauksia, nimi);
        arvauksia = 3;
        instance.lisaa(vareja, arvauksia, nimi);
        arvauksia = 2;
        instance.lisaa(vareja, arvauksia, nimi);
        ArrayList<Tulos> l = instance.haeLista(vareja);
        assertEquals(l.size(), 3);
        assertEquals(l.get(0).haeNimi(), "nimi");
        assertEquals(l.get(0).haeArvauksia(), 1);
        assertEquals(l.get(1).haeArvauksia(), 2);
        assertEquals(l.get(2).haeArvauksia(), 3);                
    }

    /**
     * Testataan toimiiko tiedostosta lukeminen ja kirjoittaminen
     * oikein
     */
    @Test
    public void testTiedosto() {
        System.out.println("haeLista");
        int vareja = 0;
        Tulokset instance = new Tulokset("tulos.txt", false);
        instance.lisaa(1, 1, "1");
        instance.lisaa(2, 3, "4");
        instance.lisaa(1, 3, "3");
        instance.lisaa(1, 2, "4");
        instance = new Tulokset("tulos.txt");
        
        ArrayList<Tulos> l = instance.haeLista(2);
        assertEquals(l.size(), 1);
        assertEquals(l.get(0).haeNimi(), "4");
        assertEquals(l.get(0).haeArvauksia(), 3);
        l = instance.haeLista(1);
        assertEquals(l.size(), 3);
        assertEquals(l.get(0).haeNimi(), "1");
        assertEquals(l.get(1).haeNimi(), "4");
        assertEquals(l.get(2).haeNimi(), "3");
        assertEquals(l.get(0).haeArvauksia(), 1);
        assertEquals(l.get(1).haeArvauksia(), 2);
        assertEquals(l.get(2).haeArvauksia(), 3);                        
    }
}
