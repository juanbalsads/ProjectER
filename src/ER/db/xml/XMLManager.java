package ER.db.xml;

import java.io.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ER.POJOS.Patient;
import ER.db.xml.utils.CustomErrorHandler;
import ER.POJOS.Admission;
import javax.persistence.EntityManager;

public class XMLManager {
	
	private final String PERSISTENCE_PROVIDER = "ProjectER";
	private EntityManager em;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private EntityManagerFactory factory;
	private File xmlFile;
		
		public XMLManager() {
			super();
			connect();
		}
		
		public void connect() {
			
		    em = Persistence.createEntityManagerFactory("projectER").createEntityManager();
		    em.getTransaction().begin();
		    em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		    em.getTransaction().commit();
		    
		}
		
		public void disconnect() {
			em.close();
		}
	
	    public void main (String []args) {
		try {
		System.out.println("MENU");
		System.out.println("1. Patient from XML to Java \n"
				+ "2. Patient from Java to XML \n"
				+ "3. Check if the DTD is correct");
		
		System.out.println("Introduce an option: ");
		int option = Integer.parseInt(reader.readLine());
		while(option==0) {
			System.out.println("Introduce an option: ");
			option= Integer.parseInt(reader.readLine());
			
		}
		switch(option) {
		    case 1: 
		    	System.out.println("Option 1 has been selected: ");
		    	Xml2JavaPatient();
		    	break;
		    case 2:
		    	System.out.println("Option 2 has been selected: ");
		    	Java2XmlPatient();
		    	break;
		    case 3:
		    	System.out.println("Option 3 has been selected: ");
		    	dtdChecker();
		    	break;
		    	
		    default: break;
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	    
	 public void Xml2HtmlPatient() {
		 
		 TransformerFactory tFactory = TransformerFactory.newInstance();
			try {
				Transformer transformer = tFactory.newTransformer(new StreamSource(new File("./xmls/Patient-Style.xslt")));
				transformer.transform(new StreamSource(new File("./xmls/External-Patient.xml")),new StreamResult(new File("./xmls/External-Patient.html")));
				System.out.println("   successful, check External-Patient.html");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("   failed");
			}}
	  

	  public void Xml2JavaPatient(){
		
			try {

				JAXBContext jaxbContext;
				jaxbContext = JAXBContext.newInstance(Patient.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

				File file = new File("./xmls/External-Patient.xml");
				Patient p = (Patient) unmarshaller.unmarshal(file);
				//List <Admission> admission;
				System.out.println("   PATIENT:");
				System.out.println("    SSN:"+ p.getSSN());
				System.out.println("    Name: " + p.getName());
				System.out.println("    Weight: " + p.getWeight());
				System.out.println("    Height: "+ p.getHeight());
				System.out.println("    Genre: " + p.getGenre());
				System.out.println("    DOB: " + p.getDob());
				System.out.println("    Blood_Type: "+ p.getBloodType()+"\n");
			
				connect();
				em.getTransaction().begin();
				
				if(checkPatient(p.getSSN())) {
				em.persist(p);
				System.out.println("\n      successful");
				}
				else {
					System.out.println("\n       WARNING: The patient already exists");
				}
				em.getTransaction().commit();
		        
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	
	
	private boolean checkPatient(Integer id) {
		Query q1 = em.createNativeQuery("SELECT * FROM Patients", Patient.class);
		List<Patient> patient = (List<Patient>) q1.getResultList();
		for(Patient p: patient) {
			if(id == p.getSSN()) {
				return false;
			}
		}
		return true;	
	}
	
	private void printPatients() {
		Query q1 = em.createNativeQuery("SELECT * FROM Patients", Patient.class);
		List<Patient> patient = (List<Patient>) q1.getResultList();
		for (Patient p : patient) {
			System.out.println(p);
		}
	}
	public void Java2XmlPatient() {
		try {
			connect();
			JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			
			printPatients();
			System.out.print("\n  Choose a patient to turn into an XML file:");
			int p_id = Integer.parseInt(reader.readLine());
			Query q2 = em.createNativeQuery("SELECT * FROM Patients WHERE ssn = ?", Patient.class);
			q2.setParameter(1, p_id);
			Patient patient = (Patient) q2.getSingleResult();
			
			File file = new File("./xmls/Example-Patient.xml");
			marshaller.marshal(patient, file);
			marshaller.marshal(patient, System.out);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dtdChecker() {
		   
		xmlFile = new File("./xmls/External-Patient.xml"); 
	        
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
	            System.out.println("\n  "+xmlFile + " error while parsing!");
	        } catch (SAXException ex) {
	            System.out.println("\n  "+xmlFile + " was not well-formed!");
	        } catch (IOException ex) {
	            System.out.println("\n  "+xmlFile + " was not accesible!");
	        }
	}
	

	}

	


