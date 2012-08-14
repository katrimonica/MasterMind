

package mastermind;

import java.util.*;


/**
* @author Katri Heikkinen
*/
public class Peli {
    private RivinTarkastin tarkastin;
    private ArrayList<ArrayList<Integer>> arvatutRivit;
    private int maxArvauksia;
    private boolean oikeinArvattu;
    
    /**
     * Alustaa pelin annetuilla tiedoilla
     *
     * @param vareja käytettyjen värien määrä
     * @param maxArvauksia arvausten maksimilukumäärä
     */
    public Peli(int vareja, int maxArvauksia) {
        if(maxArvauksia < 1) {
            throw new RuntimeException("maxArvauksia tulee olla suurempi kuin nolla");
        }
        tarkastin = new RivinTarkastin(vareja);
        arvatutRivit = new ArrayList<>();
        this.maxArvauksia = maxArvauksia;
        oikeinArvattu = false;
    }
    
    /**
     * Palauttaa tämänhetkisten arvausten lukumäärän
     * @return arvausten lukumäärä
     */
    public int haeArvauksia() {
        return arvatutRivit.size();
    }
    
    /**
     * Arvaa riviä. Tarkastaa ettei riviä ole arvattu liian monta kertaa.
     * @param arvaus arvattu rivi
     * @return rivin tarkastuksen tulos
     */          
    public TarkastusTulos arvaus(ArrayList<Integer> arvaus) {
        if(oikeinArvattu) {
            throw new RuntimeException("Arvattu jo oikein");
        }
        if(arvatutRivit.size() >= maxArvauksia) {
            throw new RuntimeException("Liian monta arvausta");
        }        
        arvatutRivit.add(arvaus);
        TarkastusTulos tulos = tarkastin.arvaus(arvaus);
        oikeinArvattu = tulos.haeKaikkiOikein();
        return tulos;
    }
    
    /**
     * Palauttaa oikein rivin 
     * @return oikea rivi
     */
    public ArrayList<Integer> haeOikeaRivi() {
        return tarkastin.haeOikeaRivi();
    }
    
    /**
     * Palauttaa arvatut rivit
     * @return lista arvatuista riveistä
     */
    public ArrayList<ArrayList<Integer>> haeArvatutRivit() {
        return arvatutRivit;
    }
}

