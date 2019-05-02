package ER.db.xml;

import java.io.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ER.POJOS.Patient;
import ER.POJOS.Admission;

public class Xml2JavaReport {

	private static final String PERSISTENCE_PROVIDER = "company-provider";
	private static EntityManagerFactory factory;

	public static void main(String[] args) throws JAXBException {

		// Create the JAXBContext
		JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
		// Get the unmarshaller
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		// Use the Unmarshaller to unmarshal the XML document from a file
		File file = new File("./xmls/External-Report.xml");
		Patient p = (Patient) unmarshaller.unmarshal(file);

		// Print the patient
		System.out.println("Patient:");
		System.out.println("SSN:"+ Patient.getSSN());
		System.out.println("Name: " + Patient.getName());
		System.out.println("Weight: " + Patient.getWeight());
		System.out.println("Height: "+ Patient.getHeight());
		System.out.println("Genre: " + Patient.getGenre());
		System.out.println("DOB: " + Patient.getDob());
		System.out.println("Blood_Type: "+ Patient.getBloodType());
		
		List<Admission> admission = Patient.getAdmission();
		for (Admision a : admission) {
			System.out.println("Admission: " + a.getId());
		}

		// Store the report in the database
		// Create entity manager
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_PROVIDER);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();

		// Create a transaction
		EntityTransaction tx1 = em.getTransaction();

		// Start transaction
		tx1.begin();

		// Persist
		// We assume the authors are not already in the database
		// In a real world, we should check if they already exist
		// and update them instead of inserting as new
		for (Admission a : admission) {
			em.persist(a);
		}
		em.persist(p);
		
		// End transaction
		tx1.commit();
	}
}
