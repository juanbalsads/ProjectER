package ER.db.xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ER.db.xml.utils.CustomErrorHandler;

public class DTDCheckerPatient {

    public static void main(String[] args) {
        File xmlFile = new File("./xmls/External-Patient.xml"); 
        try {
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            dBF.setValidating(true);
            DocumentBuilder builder = dBF.newDocumentBuilder();
            CustomErrorHandler customErrorHandler = new CustomErrorHandler();
            builder.setErrorHandler(customErrorHandler);
            Document doc = builder.parse(xmlFile);
            if (customErrorHandler.isValid()) {
                System.out.println(xmlFile + " was valid!");
            }
        } catch (ParserConfigurationException ex) {
            System.out.println(xmlFile + " error while parsing!");
        } catch (SAXException ex) {
            System.out.println(xmlFile + " was not well-formed!");
        } catch (IOException ex) {
            System.out.println(xmlFile + " was not accesible!");
        }

    }
}
