package mastermind;

import java.util.*;

/**
 * RivinTarkastin-luokka arpoo uuden rivin jota voidaan arvata arvaus-metodilla.
 * @author Katri Heikkinen
*/
public class RivinTarkastin {    
    public final int PAIKKOJA = 4;
    
    private int vareja;
    private ArrayList<Integer> rivi;
    private static Random satunnaislukuGen = new Random();
    
    
    /**
     * Alustaa uuden tarkastimen eli arpoo uuden rivin.
     * @param vareja värien määrä
    */
    public RivinTarkastin(int vareja) {
        if(vareja < 1) {
            throw new RuntimeException("Väreja tulee olla yli nolla");
        }
        
        this.vareja = vareja;    
        rivi = new ArrayList<Integer>();
        for(int i=0; i<PAIKKOJA; i++) {
            rivi.add(satunnaislukuGen.nextInt(this.vareja));
        }        
    }
    
    /**
     * Alustaa uuden olion annetulla rivillä.
     * @param vareja värien määrä
     * @param rivi annettu rivi
    */
    public RivinTarkastin(int vareja, ArrayList<Integer> rivi) {
        if(vareja < 1) {
            throw new RuntimeException("Väreja tulee olla yli nolla");
        }
        
        this.vareja = vareja;    
        this.rivi = rivi;
        for(Integer i : this.rivi) {
            if(i < 0 || i >= this.vareja) {
                throw new RuntimeException("Rivillä vääriä värejä");
            }
        }                        
    }
    
    /**
     * Etsii varsinaiset osumat (ne mitkä merkitään mustalla)
     * @param arvattuRivi arvattu rivi (se mihin verrataan oikeaa riviä)
     * @param kasitelty set johon merkitään ne paikat jotka on jo käsitelty (eli jotka osuvat)
     * @param jaljella lista niistä väreistä jotka voivat olla sivuosumia
     * @return osumien lukumäärä
     */
    private int etsiOsumat(ArrayList<Integer> arvattuRivi, TreeSet<Integer> kasitelty, ArrayList<Integer> jaljella) {
       int osumia = 0;
       for(int i=0; i<rivi.size(); i++) {
            if(arvattuRivi.get(i) == rivi.get(i)) {
                kasitelty.add(i);
                osumia++;
            }
            else {
                jaljella.add(rivi.get(i));
            }
        }
        return osumia;
    }
    
   /**
    * Etsii sivuosumat (new mitkä merkitään valkoisella)
    * @param arvattuRivi arvattu rivi (se mihin verrataan oikeaa riviä)
    * @param kasitelty set johon on merkitty ne paikat jotka on jo käsitelty (eli jotka on osunut)
    * @param jaljella lista niistä väreistä jotka voivat olla sivuosumia
    * @return sivuosumien lukumäärä
    */
    private int etsiSivuosumat(ArrayList<Integer> arvattuRivi, TreeSet<Integer> kasitelty, ArrayList<Integer> jaljella) {
        int sivuosumia = 0;
        for(int i=0; i<rivi.size(); i++) {
            if(!kasitelty.contains(i)) {
                int paikka = jaljella.indexOf(arvattuRivi.get(i));
                if(paikka >= 0) {
                    sivuosumia++;
                    jaljella.remove(paikka);
                }                
            }
        }
        return sivuosumia;
    }
    
    /**
     * Tarkastaa että annettu rivi on oikein pituinen eikä sisällä kelpaamattomia värejä. Heittää
     * poikkeuksen mikäli näin ei ole.
     *
     * @param arvattuRivi arvattu rivi
     */
    private void tarkistaEttaValidi(ArrayList<Integer> arvattuRivi) {
        if(arvattuRivi == null) {
            throw new RuntimeException("Arvattu rivi null");
        }
        if(arvattuRivi.size() != rivi.size()) {
            throw new RuntimeException("Rivillä väärä määrä merkkejä");
        }
        
        for(int i=0; i<rivi.size(); i++) {
            if(arvattuRivi.get(i) < 0 || arvattuRivi.get(i) >= this.vareja) {
                throw new RuntimeException("Rivillä vääriä värejä");
            }
        }                       
    }
    
    /**
     * Tarkastaa arvauksen
     * @param arvattuRivi arvattu rivi
     * @return arvauksen tulos
     */
    public TarkastusTulos arvaus(ArrayList<Integer> arvattuRivi) {
        tarkistaEttaValidi(arvattuRivi);
        
        TreeSet<Integer> kasitelty = new TreeSet<Integer>();
        ArrayList<Integer> jaljella = new ArrayList<Integer>();       
        int osumia = etsiOsumat(arvattuRivi, kasitelty, jaljella);                        
        int sivuosumia = etsiSivuosumat(arvattuRivi, kasitelty, jaljella);
                
        return new TarkastusTulos(osumia, sivuosumia, rivi.size() == osumia);
    }
    
    /**
     * Palauttaa oiken rivin
     * @return oikea rivi
     */
    public ArrayList<Integer> haeOikeaRivi() {
        return rivi;
    }
}
