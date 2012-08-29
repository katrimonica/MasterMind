package mastermind;

/**
 * Yksinkertainen tietorakenne johon säilötään osumien ja sivuosumien määrä
 * @author Katri Heikkinen
*/
public class TarkastusTulos {
    private int osumia;
    private int sivuosumia;
    private boolean kaikkiOikein;
  
    /**
     * Alustaa olion annetuilla arvoilla
     * @param osumia osumien lukumäärä
     * @param sivuosumia sivuosumien lukumäärä
     * @param kaikkiOikein true jos kaikki on oikein
     */
    public TarkastusTulos(int osumia, int sivuosumia, boolean kaikkiOikein) {
        this.osumia = osumia;
        this.sivuosumia = sivuosumia;        
        this.kaikkiOikein = kaikkiOikein;
    }
    
    /**
     * Palauttaa osumien lukumäärän
     * @return osumien lukumäärä
     */
    public int haeOsumat() {
        return osumia;
    }

    /**
     * Palauttaa sivuosumien lukumäärän
     * @return sivuosumien lukumäärä
     */
    public int haeSivuosumat() {
        return sivuosumia;
    }
    
    /**
     * Palauttaa true jos kaikki on oikein
     * @return true jos kaikki on oikein
     */
    public boolean haeKaikkiOikein() {
        return kaikkiOikein;
    }
    
     /**
     * Vertailee oliota toiseen
     * @param toinen vertailtava olio
     * @return true jos olio vastaa toista
     */
    
    @Override
    public boolean equals(Object toinen) {
        if (toinen instanceof TarkastusTulos) {
            TarkastusTulos tulos = (TarkastusTulos)toinen;
            return osumia == tulos.osumia && sivuosumia == tulos.sivuosumia &&
                    kaikkiOikein == tulos.kaikkiOikein;    
        }
        return false;
    }
     
     /**
     * Palauttaa osumien ja sivuosumien määrän merkkijonoesityksenä
     * @return osumien ja sivuosumien merkkijonoesitys
     */
    
    @Override
    public String toString() {
        return "(" + osumia + "-" + sivuosumia + ")";
    }
}
