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
    private String modello;
    
    public Scarpa(String codice, String marca, String colore, float prezzo, boolean isScontato, int quantita, String modello) {
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

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isIsScontato() {
        return isScontato;
    }

    public void setIsScontato(boolean isScontato) {
        this.isScontato = isScontato;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }
    
    
    
    public String toString() {
        String s;
        s = codice;
        s += ",";
        s += marca;
        s += ",";
        s += colore;
        s += ",";
        s += Float.toString(prezzo);
        s += ",";
        s += Boolean.toString(isScontato);
        s += ",";
        s += Integer.toString(quantita);
        s += ",";
        s += modello;
        return s;
    }
}
