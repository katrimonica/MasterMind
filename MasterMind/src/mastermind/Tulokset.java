/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Tulostietokanta
 * @author katri
 */
public class Tulokset {
    /**
     * Sisältää tiedot tuloksesta
     */
    public class Tulos implements Comparable<Tulos> {
        private String nimi;
        private int arvauksia;
        /**
         * Alustaa tuloksen
         * @param nimi pelaajan nimi
         * @param arvauksia arvauksien määrä
         */
        public Tulos(String nimi, int arvauksia) {
            this.nimi = nimi;
            this.arvauksia = arvauksia;
        }
        
        /**
         * Palauttaa nimen
         * @return nimi
         */
        public String haeNimi() {
            return nimi;
        }
        
        /**
         * Palauttaa arvausten määrän
         * @return arvausten määrä
         */
        public int haeArvauksia() {
            return arvauksia;
        }

        /**
         * Vertailee Tulos-olioita
         * @param t toinen tulosolio
         * @return vertailun tulos
         */
        @Override       
        public int compareTo(Tulos t) {
            return arvauksia - t.arvauksia;
        }                                
    } 
    
    private String nimi;
    private TreeMap<Integer, ArrayList<Tulos> > tulokset;
    
    /**
     * Luo tulostietokannan
     * @param nimi 
     */
    public Tulokset(String nimi) {
        this.nimi = nimi;
        tulokset = new TreeMap< >();
        lataa();
    }
    
    private void lataa() {
        File tiedosto = new File(this.nimi);
        try {
            Scanner lukija = new Scanner(tiedosto);
            while(lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] sarakkeet = rivi.split(" ", 3);
                int vareja = Integer.parseInt(sarakkeet[0]);
                int arvauksia = Integer.parseInt(sarakkeet[1]);
                String pelaaja = sarakkeet[2];
                lisaa(vareja, arvauksia, pelaaja, false);
            }
        } catch(Exception e) {
            
        }
    }
    
    /**
     * Luo tulostietokannan. Tämä konstruktori on testausta varten
     * @param nimi 
     * @param haeTiedot jos false, ei ladata tietoja tiedostosta 
     */
    public Tulokset(String nimi, boolean haeTiedot) {        
        this.nimi = nimi;
        tulokset = new TreeMap< >();
        if(haeTiedot) {
            lataa();
        }
    }
    
    /**
     * Kirjoittaa tiedot tiedostoon
     */
    private void kirjoita() {
        File tiedosto = new File(nimi);
        try {
            FileWriter kirjoittaja = new FileWriter(tiedosto);
            for(int vareja : tulokset.keySet()) {
                for(Tulos t : tulokset.get(vareja)) {
                    kirjoittaja.write(vareja+" "+t.haeArvauksia()+" "+t.haeNimi()+"\n");                   
                }
            }
            kirjoittaja.close();
        } 
        catch(Exception e) {
      
        }
    }
    
    /**
     * Palauttaa true mikäli ennätystulos pääsee listoille
     * @param vareja värien määrä
     * @param arvauksia arvausten lukumäärä
     * @return true mikäli ennätystulos pääsee listoille
     */
    public boolean mahtuuko(int vareja, int arvauksia) {
        if(!tulokset.containsKey(vareja)) {
            return true;
        }
        ArrayList<Tulos> t = tulokset.get(vareja);
        if(t.size() < 10) {
            return true;
        }
        return t.get(9).haeArvauksia() > arvauksia;
    }
    
    /**
     * Lisää tuloksen tulostietoihin
     * @param vareja värien määrä
     * @param arvauksia arvausten lukumäärä
     * @param nimi pelaajan nimi
     */
    public void lisaa(int vareja, int arvauksia, String nimi) {
        lisaa(vareja, arvauksia, nimi, true);
    }
   
    /**
     * Lisää tulostiedon tietokantaan
     * @param vareja värien määrä
     * @param arvauksia arvausten lukumäärä
     * @param nimi pelaajan nimi
     * @param paivita päivitä myös tiedostoon
     */
    private void lisaa(int vareja, int arvauksia, String nimi, boolean paivita) {
        ArrayList<Tulos> t;
                
        if(tulokset.containsKey(vareja)) {
            t = tulokset.get(vareja);
        }
        else {
            t = new ArrayList<>(); 
            tulokset.put(vareja, t);
        }
        t.add(new Tulos(nimi, arvauksia));
        Collections.sort(t);
        if(paivita) {
            kirjoita();
        }
    }
    
    /**
     * Palauttaa listan parhaista tuloksista
     * @param vareja värien määrä
     * @return lista parhaista tuloksista
     */
    public ArrayList<Tulos> haeLista(int vareja) {
        if(tulokset.containsKey(vareja)) {
            return tulokset.get(vareja);
        }
        else {
            return new ArrayList<>();                    
        }
    }

}
