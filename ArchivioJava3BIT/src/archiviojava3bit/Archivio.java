package archiviojava3bit;

import java.util.ArrayList;

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
    
    public void aggiungi(Scarpa scarpa) {
        archivio.add(scarpa);
    }
    
    public Scarpa cerca(String codice) {
        for(int i=0; i<archivio.size(); i++) {
            Scarpa scarpa = archivio.get(i);
            if(scarpa.getCodice()==codice) {
                return scarpa;
            }
        }
    }
   }
