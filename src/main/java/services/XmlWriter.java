package services;

import moduls.RootElement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {

    private static final Logger log = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {
    }

    public static void createXmlFile(RootElement rootElement) {
        log.info("Starting createXmlFile");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RootElement.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Path path = Path.of("src/main/resources/xmlReqs");

            if (!Files.exists(path)) {
                try {
                    Files.createDirectory(path);
                    log.info("New directory created");
                } catch (IOException e) {
                    log.log(Level.SEVERE, "Directory has not been created", e);
                }
            }
            File xmlFile = new File(path + "/xmlInformation" + rootElement.getDate().getTime() + ".xml");
            marshaller.marshal(rootElement, xmlFile);
        } catch (JAXBException e) {
            log.log(Level.SEVERE, "Marshalling error", e);
        }
    }
}
