import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class XmlUtilities {

    public static ArrayList<Persona> leggiPersone() throws Exception {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        String filepath = "resources/inputPersone.xml";

        xmlif = XMLInputFactory.newInstance();
        xmlr = xmlif.createXMLStreamReader("inputPersone", new FileInputStream(filepath));

        ArrayList<Persona> persone = new ArrayList<Persona>();
        Persona persona = new Persona();

        while (xmlr.hasNext()) {
            switch (xmlr.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    if(xmlr.getLocalName().equals("persona")) {
                        persona = new Persona();
                        persona.setId(Integer.parseInt(xmlr.getAttributeValue(0)));
                    } else if(xmlr.getLocalName().equals("nome")) {
                        xmlr.next();
                        persona.setNome(xmlr.getText());
                    } else if(xmlr.getLocalName().equals("cognome")) {
                        xmlr.next();
                        persona.setCognome(xmlr.getText());
                    } else if(xmlr.getLocalName().equals("sesso")) {
                        xmlr.next();
                        persona.setSesso(xmlr.getText());
                    } else if(xmlr.getLocalName().equals("comune_nascita")) {
                        xmlr.next();
                        persona.setComuneNascita(xmlr.getText());
                    } else if(xmlr.getLocalName().equals("data_nascita")) {
                        xmlr.next();
                        persona.setDataNascita(xmlr.getText());
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    if(xmlr.getLocalName().equals("persona")) {
                        persone.add(persona);
                        persona = new Persona();
                    }
                    break;
            }
            xmlr.next();
        }

        return persone;
    }

    public static ArrayList<Comune> leggiComuni() throws Exception {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        String filepath = "resources/comuni.xml";

        xmlif = XMLInputFactory.newInstance();
        xmlr = xmlif.createXMLStreamReader("comuni", new FileInputStream(filepath));

        ArrayList<Comune> comuni = new ArrayList<Comune>();
        Comune comune = new Comune();

        while (xmlr.hasNext()) {
            switch (xmlr.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    if(xmlr.getLocalName().equals("comune")) {
                        comune = new Comune();
                    } else if(xmlr.getLocalName().equals("nome")) {
                        xmlr.next();
                        comune.setNome(xmlr.getText());
                    } else if(xmlr.getLocalName().equals("codice")) {
                        xmlr.next();
                        comune.setCodice(xmlr.getText());
                    }

                    break;

                case XMLStreamConstants.END_ELEMENT:
                    if(xmlr.getLocalName().equals("comune")) {
                        comuni.add(comune);
                        comune = new Comune();
                    }
                    break;
            }
            xmlr.next();
        }

        return comuni;
    }

    public static ArrayList<String> leggiCodiciFiscali() throws Exception {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        String filepath = "resources/codiciFiscali.xml";

        xmlif = XMLInputFactory.newInstance();
        xmlr = xmlif.createXMLStreamReader("codiciFiscali", new FileInputStream(filepath));

        ArrayList<String> codiciFiscali = new ArrayList<String>();

        while (xmlr.hasNext()) {
            if(xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
                xmlr.next();
                codiciFiscali.add(xmlr.getText());
            }
            xmlr.next();
        }

        return codiciFiscali;
    }

}
