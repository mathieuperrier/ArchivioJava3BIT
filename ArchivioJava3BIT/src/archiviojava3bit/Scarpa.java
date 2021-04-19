package archiviojava3bit;

/**
 * Classe utilizzata per l'oggetto da contenere nella collezione.
 * Contiene le varibili di istanza, il metodo costruttore, i setter/getter
 * e eventuali altri metodi
 * @author Perrier Mathieu
 */
public class Scarpa {
    private String codice; //es. ABC100A
    private String marca;
    private String colore;
    private float prezzo;
    private boolean isScontato;
    private int quantita;
    
    public Scarpa(String codice, String marca, String colore, float prezzo, boolean isScontato, int quantita) {
        this.codice=codice;
        this.marca=marca;
        this.colore=colore;
        this.prezzo=prezzo;
        this.isScontato=isScontato;
        this.quantita=quantita;
    }
    
    public String getCodice() {
        return codice;
    }
    
    public void setCodice() {
        this.codice=codice;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca() {
        this.marca=marca;
    }
    
    public String getColore() {
        return colore;
    }
    
    public void setColore() {
        this.colore=colore;
    }
    
    public float getPrezzo() {
        return prezzo;
    }
    
    public void setPrezzo() {
        this.prezzo=prezzo;
    }
    
    public boolean getIsScontato() {
        return isScontato;
    }
    
    public void setIsScontato() {
        this.isScontato=isScontato;
    }
    
    public int getQuantita() {
        return quantita;
    }
    
    public void setQuantita() {
        this.quantita=quantita;
    }
    
}
