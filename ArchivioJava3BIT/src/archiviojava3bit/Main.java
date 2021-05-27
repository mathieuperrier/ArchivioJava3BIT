package archiviojava3bit;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Si occupa dell'interfaccia utente con un menu.
 * Qui si può usare println
 * @author Perrier Mathieu 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Archivio archivio;
        archivio = new Archivio();
        
        Scanner tastiera;
        tastiera = new Scanner(System.in);
        
        int scelta = 0;

    do {
      System.out.println("--- Menù per gestire le scarpe da calcio ---");
      System.out.println("1) Visualizzare elenco articoli");
      System.out.println("2) Inserire articolo");
      System.out.println("3) Eliminare articolo");
      System.out.println("4) Cercare articolo in base al prezzo");
      System.out.println("5) Cercare articolo in base alla marca");
      System.out.println("6) Modifica articolo");
      System.out.println("7) Esci");
      System.out.print("Scegli l'operazione (1-7): ");

      scelta = Integer.parseInt(tastiera.nextLine());

      switch (scelta) {
        case 1:
          ArrayList<Scarpa> elencoArticoli;
          elencoArticoli = archivio.elencoScarpe();
          visualizzaElencoArticoli(elencoArticoli);
          break;
          case 2:    
          System.out.print("Inserisci il codice: ");
          String codice = tastiera.nextLine();
          System.out.print("Inserisci la marca: ");
          String marca = tastiera.nextLine();
          System.out.print("Inserisci il colore: ");
          String colore = tastiera.nextLine();
          System.out.print("Inserisci il prezzo: ");
          float prezzo = Float.parseFloat(tastiera.nextLine());
          System.out.print("Inserisci se è scontato o no: ");
          boolean isScontato = Boolean.parseBoolean(tastiera.nextLine());
          System.out.print("Inserisci la quantità: ");
          int quantita = Integer.parseInt(tastiera.nextLine());
          System.out.print("Inserisci il modello: ");
          String modello = tastiera.nextLine();

          Scarpa scarpa = new Scarpa(codice, marca, colore, prezzo, isScontato, quantita, modello);

          if (archivio.aggiungi(scarpa)) {
            System.out.print("Articolo inserito correttamente");
            System.out.println("\n");
          } else {
            System.out.print("Esiste gia un articolo con lo stesso codice!");
          }
          break;

        case 3:         
          System.out.print("Inserisci il codice: ");
          codice = tastiera.nextLine();
         
          if (archivio.elimina(codice)) {
            System.out.println("Articolo eliminato correttamente.");
          } else {
            System.out.println("Eliminazione non riuscita.");
          }
          break;

        case 4:
          System.out.print("Inserisci il prezzo minimo: ");
          float prezzoMinimo = Float.parseFloat(tastiera.nextLine());
          System.out.print("Inserisci il prezzo massimo: ");
          float prezzoMassimo = Float.parseFloat(tastiera.nextLine());

          elencoArticoli = archivio.cercaArticolo(prezzoMinimo, prezzoMassimo);

          visualizzaElencoArticoli(elencoArticoli);
          
          break;

        case 5:
          System.out.print("Inserisci la marca: ");
          marca = tastiera.nextLine();

          elencoArticoli = archivio.cercaArticoloPerDescrizione(marca);

          visualizzaElencoArticoli(elencoArticoli);
          break;
        case 6:
          System.out.print("Inserisci il codice: ");
          codice = tastiera.nextLine();
          System.out.print("Inserisci la marca: ");
          marca = tastiera.nextLine();
          System.out.print("Inserisci il colore: ");
          colore = tastiera.nextLine();
          System.out.print("Inserisci il prezzo: ");
          prezzo = Float.parseFloat(tastiera.nextLine());
          System.out.print("Inserisci se è scontato o meno: ");
          isScontato = Boolean.parseBoolean(tastiera.nextLine());
          System.out.print("Inserisci la quantità: ");
          quantita = Integer.parseInt(tastiera.nextLine());
          System.out.print("Inserisci il modello: ");
          modello = tastiera.nextLine();

          if (archivio.modificaArticolo(codice, marca, colore, prezzo, isScontato, quantita, modello)) {
            System.out.println("Modifica della scarpa avvenuta correttamente.");
          } else {
            System.out.println("Non è stato possibile modificare la scarpa.");
          }
          break;

    } 
      
    } while (scelta != 7);
    
    }


    private static void visualizzaElencoArticoli(ArrayList<Scarpa> elencoArticoli) {
    System.out.println("N°\tCodice\t\tMarca\t\tColore\t\tPrezzo\t\tScontato\tQuantità\tModello");
    System.out.println();
    for (int i = 0; i < elencoArticoli.size(); i++) {
      System.out.print(i + 1);
      System.out.print("\t" + elencoArticoli.get(i).getCodice());
      System.out.print("\t\t" + elencoArticoli.get(i).getMarca());
      System.out.print("\t\t" + elencoArticoli.get(i).getColore());
      System.out.print("\t\t" + elencoArticoli.get(i).getPrezzo());
      System.out.print("\t\t" + elencoArticoli.get(i).getIsScontato());
      System.out.print("\t\t" + elencoArticoli.get(i).getQuantita());
      System.out.print("\t\t" + elencoArticoli.get(i).getModello());
      System.out.println();
    }

    System.out.println("\n");

    }
    
}

       