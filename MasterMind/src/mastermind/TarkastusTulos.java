package mastermind;

/**
 * Yksinkertainen tietorakenne johon säilötään osumien ja sivuosumien määrä
 * @author Katri Heikkinen
*/
public class TarkastusTulos {
    private int osumia;
    private int sivuosumia;
  
    /**
     * Alustaa olion annetuilla arvoilla
     * @param osumia osumien lukumäärä
     * @param sivuosumia sivuosumien lukumäärä
     */
    public TarkastusTulos(int osumia, int sivuosumia) {
        this.osumia = osumia;
        this.sivuosumia = sivuosumia;        
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
    
    @Override
    public boolean equals(Object toinen) {
        if (toinen instanceof TarkastusTulos) {
            TarkastusTulos tulos = (TarkastusTulos)toinen;
            return osumia == tulos.osumia && sivuosumia == tulos.sivuosumia;    
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "(" + osumia + "-" + sivuosumia + ")";
    }
}
