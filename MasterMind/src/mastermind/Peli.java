

package mastermind;

import java.util.*;


/**
* @author Katri Heikkinen
*/
class Arvaus {
        private ArrayList<Integer> arvaus;

        public ArrayList<Integer> haeArvaus() {
            return arvaus;
        }

        public TarkastusTulos haeTulos() {
            return tulos;
        }
        private TarkastusTulos tulos;
        
        public Arvaus(ArrayList<Integer> arvaus, TarkastusTulos tulos) {
            this.arvaus = arvaus;
            this.tulos = tulos;
        }
        
        
    }

public class Peli {
    
    private RivinTarkastin tarkastin;
    private ArrayList<Arvaus> arvatutRivit;
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
        TarkastusTulos tulos = tarkastin.arvaus(arvaus);
        arvatutRivit.add(new Arvaus(arvaus, tulos));
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
    public ArrayList<Arvaus> haeArvatutRivit() {
        return arvatutRivit;
    }
}

