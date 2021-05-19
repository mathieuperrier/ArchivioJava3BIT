package archiviojava3bit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contiene gli oggetti del programma.
 * Implementata tramite un ArrayList.
 * Ci permette di inserire gli oggetti,
 * effettuare ricerche e
 * aggiungere/rimuovere/modificare un oggetto.
 * @author Perrier Mathieu
 */
public class Archivio {
    private ArrayList<Scarpa> archivio;
    
    public Archivio() {
        archivio = new ArrayList(0);
    }

    private Scarpa cercaArticolo(String codice) {
        for (int i = 0; i < archivio.size(); i++) {
            if (archivio.get(i).getCodice().equals(codice)) {
                return archivio.get(i);
            }   
        }
    return null;
    }
    
    public String toString() {
        String s = "";
        for(int i = 0; i < archivio.size(); i++) {
            Scarpa scarpa = archivio.get(i);
            s += scarpa.toString();
            if(i<archivio.size()-1) {
                s += "\r\n";
            }
        }
        return s;
    }
  
    public ArrayList<Scarpa> elencoScarpe() {
        return archivio;
    }

    public boolean aggiungi(Scarpa scarpa) {
        if (Archivio.this.cercaArticolo(scarpa.getCodice()) != null) {
        return false;
        }
        archivio.add(scarpa);
        salvaSuFile();
        return true;
    }

    public boolean elimina(String codice) {
        Scarpa scarpa;
        scarpa = Archivio.this.cercaArticolo(codice);
        
        if (scarpa != null) {
        archivio.remove(scarpa);
        salvaSuFile();
        return true;
        }
        return false;
    }

    public boolean modificaArticolo(String codice, String marca, String colore, float prezzo, boolean isScontato, int quantita, String modello) {
        Scarpa scarpa;
        scarpa = Archivio.this.cercaArticolo(codice);
        if (scarpa != null) {
        scarpa.setMarca(marca);
        scarpa.setColore(colore);
        scarpa.setPrezzo(prezzo);
        scarpa.setIsScontato(isScontato);
        scarpa.setQuantita(quantita);
        scarpa.setModello(modello);

        salvaSuFile();
        return true;
            } 
        else 
            {
        return false;
        }
    }

    public ArrayList<Scarpa> cercaArticolo(float prezzoMinimo, float prezzoMassimo) {
        ArrayList<Scarpa> articoliTrovati = new ArrayList(0);

        for (int i = 0; i < archivio.size(); i++) {
            if (archivio.get(i).getPrezzo() >= prezzoMinimo
                    && archivio.get(i).getPrezzo() <= prezzoMassimo) {
              articoliTrovati.add(archivio.get(i));
            }
        }
    return articoliTrovati;
    }

    public ArrayList<Scarpa> cercaArticoloPerDescrizione(String descrizione) {
        ArrayList<Scarpa> articoliTrovati = new ArrayList(0);
        String descrizioneDaCercareMinuscolo = descrizione.toLowerCase();

        for (int i = 0; i < archivio.size(); i++) { 

            String descrizioneMinuscolo = archivio.get(i).getDescrizione().toLowerCase();

        if (descrizioneMinuscolo.contains(descrizioneDaCercareMinuscolo)) {
            articoliTrovati.add(archivio.get(i));
            }   
        }
    return articoliTrovati;
    }

    public void salvaSuFile() {
    FileWriter out;
        try {
          out = new FileWriter("archivio.txt");

        String sArchivio;
        sArchivio = toString();

        out.write(sArchivio);

        out.close();

        } catch (IOException ex) {
        Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    private ArrayList<Scarpa> leggiDaFile() {
        ArrayList<Scarpa> scarpe;
        scarpe = new ArrayList(0);

        FileReader fileReader;
        try {
          fileReader = new FileReader("archivio.txt");

        BufferedReader in;
        in = new BufferedReader(fileReader);

        String linea;
        String campi[];
        while ((linea = in.readLine()) != null) {
            campi = linea.split(",");
            int quantita = Integer.parseInt(campi[2]);
            float prezzo = Float.parseFloat(campi[3]);

            Scarpa scarpa = new scarpa(campi[0], campi[1], quantita, prezzo);

            scarpe.add(scarpa);
        }

        } catch (FileNotFoundException ex) {
        Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        Logger.getLogger(Archivio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return scarpe;
        }
    }


