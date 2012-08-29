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
 *
 * @author katri
 */
public class Tulokset {
    public class Tulos implements Comparable<Tulos> {
        private String nimi;
        private int arvauksia;
        public Tulos(String nimi, int arvauksia) {
            this.nimi = nimi;
            this.arvauksia = arvauksia;
        }
        
        public String haeNimi() {
            return nimi;
        }
        
        public int haeArvauksia() {
            return arvauksia;
        }

        @Override
        public int compareTo(Tulos t) {
            return arvauksia - t.arvauksia;
        }
        
        
        
        
    } 
    private String nimi;
    private TreeMap<Integer, ArrayList<Tulos> > tulokset;
    public Tulokset(String nimi) {
        this.nimi = nimi;
        tulokset = new TreeMap< >();
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
    
    public boolean mahtuuko(int vareja, int arvauksia) {
        if(!tulokset.containsKey(vareja)) {
            return true;
        }
        ArrayList<Tulos> t = tulokset.get(vareja);
        if(t.size() < 10) {
            return true;
        }
        return t.get(9).haeArvauksia() < arvauksia;
    }
    
    public void lisaa(int vareja, int arvauksia, String nimi) {
        lisaa(vareja, arvauksia, nimi, true);
    }
   
    
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
     *
     * @param vareja
     * @return
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
