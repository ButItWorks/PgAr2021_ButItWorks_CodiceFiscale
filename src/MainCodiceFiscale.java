import java.util.ArrayList;

public class MainCodiceFiscale {

    public static void main(String[] args) {
        try {
            ArrayList<Persona> persone = XmlUtilities.leggiPersone();
            ArrayList<Comune> comuni = XmlUtilities.leggiComuni();

            for (Persona p : persone) {
                p.setCodiceFiscale(CodiceFiscale.generaCodiceFiscale(p, comuni));
            }

            for (Persona p : persone) {
                System.out.println("-------------------------");
                System.out.println(p.getId());
                System.out.println(p.getNome());
                System.out.println(p.getCognome());
                System.out.println(p.getSesso());
                System.out.println(p.getComuneNascita());
                System.out.println(p.getDataNascita());
                System.out.println(p.getCodiceFiscale());
                System.out.println("-------------------------");
            }
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

    }

}
