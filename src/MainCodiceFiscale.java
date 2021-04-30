import java.util.ArrayList;

public class MainCodiceFiscale {

    public static void main(String[] args) {
        try {
            System.out.println("********* CODICE FISCALE *********");

            System.out.println("Lettura file inputPersone.xml in corso");
            ArrayList<Persona> persone = XmlUtilities.leggiPersone();
            System.out.println("Lettura completata");

            System.out.println("Lettura file comuni.xml in corso");
            ArrayList<Comune> comuni = XmlUtilities.leggiComuni();
            System.out.println("Lettura completata");

            System.out.println("Lettura file codiciFiscali.xml in corso");
            ArrayList<String> codiciFiscali = XmlUtilities.leggiCodiciFiscali();
            System.out.println("Lettura completata");

            for (Persona p : persone) {
                p.setCodiceFiscale(CodiceFiscale.generaCodiceFiscale(p, comuni));
            }

            System.out.println("Creazione del file in corso...");
            XmlUtilities.produciOutput(codiciFiscali, persone, comuni);
            System.out.println("File creato correttamente!");

        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

    }

}
