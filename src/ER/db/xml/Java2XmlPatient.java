package ER.db.xml;

import java.io.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import ER.POJOS.Patient;

public class Java2XmlPatient {

	// Put entity manager and buffered reader here so it can be used
	// in several methods
	private static EntityManager em;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
	private static void printReports() {
		Query q1 = em.createNativeQuery("SELECT * FROM Patients", Patient.class);
		List<Patient> patient = (List<Patient>) q1.getResultList();
		// Print the departments
		for (Patient p : patient) {
			System.out.println(p);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// Get the entity manager
		// Note that we are using the class' entity manager
		em = Persistence.createEntityManagerFactory("projectER").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
				
		// Create the JAXBContext
		JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
		// Get the marshaller
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		// Pretty formatting
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		
		// Choose the report to turn into an XML
		// Choose his new department
		printReports();
		System.out.print("Choose a report to turn into an XML file:");
		int p_id = Integer.parseInt(reader.readLine());
		Query q2 = em.createNativeQuery("SELECT * FROM Patients WHERE ssn = ?", Patient.class);
		q2.setParameter(1, p_id);
		Patient patient = (Patient) q2.getSingleResult();
		
		// Use the Marshaller to marshal the Java object to a file
		File file = new File("./xmls/Example-Patient.xml");
		marshaller.marshal(patient, file);
		// Printout
		marshaller.marshal(patient, System.out);

	}
}
