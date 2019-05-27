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

import ER.POJOS.Patient;
import ER.POJOS.Admission;
import javax.persistence.EntityManager;

public class XMLManager {
	
	private static final String PERSISTENCE_PROVIDER = "ProjectER";
	private static EntityManager em;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static EntityManagerFactory factory;
	
		
		public XMLManager() {
			super();
			connect();
		}
		
		public static void connect() {
			
		    em = Persistence.createEntityManagerFactory("projectER").createEntityManager();
		    em.getTransaction().begin();
		    em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		    em.getTransaction().commit();
		    
		}
		
		public void disconnect() {
			em.close();
		}
	
	    public static void main (String []args) {
		try {
		System.out.println("MENU");
		System.out.println("1. Patient from XML to Java \n"
				+ "2. Patient from Java to XML \n");
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
		    
		    default: break;
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	    
	   
	  

	  public static void Xml2JavaPatient(){
		
			try {

				JAXBContext jaxbContext;
				jaxbContext = JAXBContext.newInstance(Patient.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

				File file = new File("./xmls/External-Patient.xml");
				Patient p = (Patient) unmarshaller.unmarshal(file);
				//List <Admission> admission;
				
				System.out.println("Patient:");
				System.out.println("SSN:"+ p.getSSN());
				System.out.println("Name: " + p.getName());
				System.out.println("Weight: " + p.getWeight());
				System.out.println("Height: "+ p.getHeight());
				System.out.println("Genre: " + p.getGenre());
				System.out.println("DOB: " + p.getDob());
				System.out.println("Blood_Type: "+ p.getBloodType());
			
				connect();
				em.getTransaction().begin();
				
				if(checkPatient(p.getSSN())) {
				em.persist(p);
				System.out.println("successful");
				}
				else {
					System.out.println("The patient already exists");
				}
				em.getTransaction().commit();
		        
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	
	
	private static boolean checkPatient(Integer id) {
		Query q1 = em.createNativeQuery("SELECT * FROM Patients", Patient.class);
		List<Patient> patient = (List<Patient>) q1.getResultList();
		for(Patient p: patient) {
			if(id == p.getSSN()) {
				return false;
			}
		}
		return true;	
	}
	
	private static void printPatients() {
		Query q1 = em.createNativeQuery("SELECT * FROM Patients", Patient.class);
		List<Patient> patient = (List<Patient>) q1.getResultList();
		for (Patient p : patient) {
			System.out.println(p);
		}
	}
	public static void Java2XmlPatient() {
		try {
			connect();
			JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			
			printPatients();
			System.out.print("Choose a patient to turn into an XML file:");
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
	

	}

	


