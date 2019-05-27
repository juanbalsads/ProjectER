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

	private static EntityManager em;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
	private static void printReports() {
		Query q1 = em.createNativeQuery("SELECT * FROM Patients", Patient.class);
		List<Patient> patient = (List<Patient>) q1.getResultList();
		for (Patient p : patient) {
			System.out.println(p);
		}
	}
	
	public static void main(String[] args) throws Exception {
		em = Persistence.createEntityManagerFactory("projectER").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
				
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
		System.out.println("pipi");
		Marshaller marshaller = jaxbContext.createMarshaller();
		System.out.println("pipi2");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		System.out.println("pipi3");
		printReports();
		System.out.print("Choose a patient to turn into an XML file:");
		int p_id = Integer.parseInt(reader.readLine());
		Query q2 = em.createNativeQuery("SELECT * FROM Patients WHERE ssn = ?", Patient.class);
		q2.setParameter(1, p_id);
		Patient patient = (Patient) q2.getSingleResult();
		
		File file = new File("./xmls/Example-Patient.xml");
		marshaller.marshal(patient, file);
		
		marshaller.marshal(patient, System.out);

	}
}
