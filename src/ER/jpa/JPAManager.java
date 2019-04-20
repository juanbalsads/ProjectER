package ER.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import ER.POJOS.*;



public class JPAManager {
    
	private static EntityManager em;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		public JPAManager() {
			super();
			connectEntity();
		}
		
		public static void connectEntity() {
			
		    em = Persistence.createEntityManagerFactory("projectER").createEntityManager();
		    em.getTransaction().begin();
		    em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		    em.getTransaction().commit();
		    
		}
		
		public static void disconnectEntity() {
			em.close();
		}
	
///CREATE: Patient(D-Notallergies),Nurse(D)
		///,Doctor(D.attentionToAvailability),drug(D),box(D.Ive done changes),
		///admission(D),dosage()??		
      	
		public void createPatient() throws NumberFormatException, IOException {
      		connectEntity();
      		try {
      			
      			System.out.println("Please, input the patient data: ");
    			System.out.println("Insert the patient's ssn:");
    			int ssn = Integer.parseInt(reader.readLine());
    			System.out.println("Insert the patient's name:");
    				String name = reader.readLine();
    			System.out.println("Insert weight:");
    				Double weight = Double.parseDouble(reader.readLine());
    			System.out.println("Insert height(meters):");
    				Double height = Double.parseDouble(reader.readLine());
    			System.out.println("Insert genre: ");
    				String genre = reader.readLine();
    			System.out.println("Insert date of birth (yyyy-MM-dd): ");
    				String dob = reader.readLine();
    				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    			    LocalDate date = LocalDate.parse(dob, formatter);
    			    Date dob2= Date.valueOf(date);
    			System.out.println("Insert the patient's blood type:");
    				String bloodType = reader.readLine();
    				System.out.println("Type the patient's allergies:");
    				
    				Patient pat1 = 
    						new Patient(ssn,name, weight, height,genre, dob2, bloodType);
    				 
    				em.getTransaction().begin();
    				em.persist(pat1);
    				em.getTransaction().commit();
    				disconnectEntity();
    				
      		
      		}catch(IOException e) {
      			e.printStackTrace();
      		}
      		
      	}
		public void createAdmission() throws NumberFormatException, IOException {
			connectEntity();
			try {
				System.out.println("Please, input the admission data:");
				System.out.println("Id of the admission");
				int id = Integer.parseInt(reader.readLine());
				System.out.print("Patient`s SSD: ");
				int SSD = Integer.parseInt(reader.readLine());
				Patient patient = searchPatient(SSD);		
				System.out.print("Doctor´s id in charge: ");
				int doctor_id = Integer.parseInt(reader.readLine());
				Doctor doctor = searchDoctor(doctor_id);
				System.out.print("Nurse´s id in charge: ");
				int nurse_id =  Integer.parseInt(reader.readLine());
				Nurse nurse = searchNurse(nurse_id);
				System.out.print("Box: ");
				int box_id = Integer.parseInt(reader.readLine());
				Box box = searchBox(box_id);
				
				
				System.out.print("Arrival time (yyyy-MM-dd HH:mm): ");
				String dateS = reader.readLine();
				DateTimeFormatter formatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime localDate = LocalDateTime.parse(dateS, formatterWithTime);		
				Date arrivalTime = Date.valueOf(localDate.toString());
				
				System.out.print("Test: ");
				String tests = reader.readLine();
				
				
				System.out.println("The patient is going to be internated");
				boolean release = false;
				Admission adm1 = 
						new Admission(id,patient,arrivalTime,tests,release, nurse,doctor, box);
	 
				em.getTransaction().begin();
				em.persist(adm1);
				em.getTransaction().commit();
				disconnectEntity();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		
		public void createDoctor(){
			connectEntity();
			try {
				System.out.println("Write the ID of the doctor: ");
				int id = Integer.parseInt(reader.readLine());
				System.out.println("Write the name of the doctor: ");
				String name = reader.readLine();
				System.out.println("Write the name of the specialty: ");
				String speciality = reader.readLine();
				boolean availability = true;
				/*System.out.println("Is the doctor available?:");
				String yes_no = reader.readLine();
				boolean availability = true;
				if(yes_no.equals(true)) {
					availability = true;
				}
				else{
					availability = false;
				}*/
				
				Doctor d = new Doctor(id,name,speciality,availability);
				em.getTransaction().begin();
				em.persist(d);
				em.getTransaction().commit();
				em.close();
				disconnectEntity();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		
		public void createNurse(){
			connectEntity();
			try {
				System.out.println("Write the ID of the nurse: ");
				int id = Integer.parseInt(reader.readLine());
				System.out.println("Write the name of the nurse: ");
				String name = reader.readLine();
				System.out.println("Write the name of the specialty: ");
				String speciality = reader.readLine();
				boolean availability = true;
				/*System.out.println("Is the nurse available?:");
				String yes_no = reader.readLine();
				boolean availability = true;
				if(yes_no.equals(true)) {
					availability = true;
				}
				else{
					availability = false;
				}*/
				Nurse n = new Nurse(id,name,speciality,availability);
				em.getTransaction().begin();
				em.persist(n);
				em.getTransaction().commit();
				em.close();
				disconnectEntity();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		public void createBox() {
			connectEntity();
			try {
				System.out.println("Write the ID of the box-room: ");
				int id = Integer.parseInt(reader.readLine());
				System.out.println("Is the box-room available: ");
				boolean availability = true;
	           /*juan: SO SORRY GUYS!! 'Im going to set by default that
	            * When creating a new box is always available
	            * we may change this attribute when assigning an admission*/			
				Box b = new Box(id,availability);
				em.getTransaction().begin();
				em.persist(b);
				em.getTransaction().commit();
				em.close();
				disconnectEntity();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void createDrug() {
			connectEntity();
			try {
				System.out.println("Write the ID of the drug: ");
				int id = Integer.parseInt(reader.readLine());
				System.out.println("Write the name of the drug: ");
				String name = reader.readLine();
				Drug d = new Drug(id,name);
				em.getTransaction().begin();
				em.persist(d);
				em.getTransaction().commit();
				disconnectEntity();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		///SEARCH METHODS
		public Patient searchPatient(int SSD) {
			Query q = em.createNativeQuery("SELECT * FROM patients WHERE SSD = ?", Patient.class);
			q.setParameter(1, SSD);
			Patient p = (Patient) q.getSingleResult();	
			return p;
		}
		public Doctor searchDoctor(int id) {
			Query q = em.createNativeQuery("SELECT * FROM doctors WHERE id = ?", Doctor.class);
			q.setParameter(1, id);
			Doctor d = (Doctor) q.getSingleResult();	
			return d;
		}
		public Nurse searchNurse(int id) {
			Query q = em.createNativeQuery("SELECT * FROM nurses WHERE id = ?", Nurse.class);
			q.setParameter(1, id);
			Nurse n = (Nurse) q.getSingleResult();	
			return n;
		}
		public Box searchBox(int id) {
			Query q = em.createNativeQuery("SELECT * FROM boxes WHERE id = ?", Box.class);
			q.setParameter(1, id);
			Box b = (Box) q.getSingleResult();	
			return b;
		}
		
		////CREATE////
	
	     ///READ: Patient(D),Nurse(D)
	    ///,Doctor(D),drug(),box(D),
	    ///admission(D),dosage(NOtD)??
		
		public void readAdmission() {
			connectEntity();
			
			try {
				System.out.print("Write the admission's ID: ");
				int adm_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM admissions WHERE id = ?", Admission.class);
				q.setParameter(1, adm_id);
				Admission admission = (Admission) q.getSingleResult();
				System.out.println(admission.toString());
				em.close();
				
				disconnectEntity();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void readPatient() {
			connectEntity();
			
			try {
				System.out.print("Write the patient's SSD: ");
				int pat_SSD = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM patients WHERE id = ?", Patient.class);
				q.setParameter(1, pat_SSD);
				Patient p = (Patient) q.getSingleResult();
				System.out.println(p.toString());
				em.close();
				
				disconnectEntity();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void readDoctor() {
			connectEntity();
			
			try {
				System.out.print("Write the doctor's id: ");
				int d_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM doctors WHERE id = ?", Doctor.class);
				q.setParameter(1, d_id);
				Doctor d = (Doctor) q.getSingleResult();
				System.out.println(d.toString());
				em.close();
				
				disconnectEntity();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void readNurse() {
			connectEntity();
			
			try {
				System.out.print("Write the nurse`s id: ");
				int n_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM nurses WHERE id = ?", Nurse.class);
				q.setParameter(1, n_id);
				Nurse n = (Nurse) q.getSingleResult();
				System.out.println(n.toString());
				em.close();
				
				disconnectEntity();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		public void readBox() {
			connectEntity();
			
			try {
				System.out.print("Write the box`s id: ");
				int b_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM boxes WHERE id = ?", Box.class);
				q.setParameter(1, b_id);
				Box b = (Box) q.getSingleResult();
				System.out.println(b.toString());
				em.close();
				
				disconnectEntity();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void readDrug() {
			connectEntity();
			
			try {
				System.out.print("Write the drugs`s id: ");
				int dr_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM drugs WHERE id = ?", Drug.class);
				q.setParameter(1, dr_id);
				Drug dr = (Drug) q.getSingleResult();
				System.out.println(dr.toString());
				em.close();
				
				disconnectEntity();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	     ///READ////
		
		///PRINTLIST: Patient(D),Nurse(D)
	    ///,Doctor(D),drug(D),box(D),
	    ///admission(D),dosage(NOtD)??
		
		public void listPatients() {
			connectEntity();
			Query q1 = em.createNativeQuery("SELECT * FROM patients", Patient.class);
			List<Patient> pats = (List<Patient>) q1.getResultList();
			for (Patient pat : pats) {
				System.out.println(pat);
			}
			disconnectEntity();
		}
		public void listAdmissions() {
			connectEntity();
			Query q1 = em.createNativeQuery("SELECT * FROM admissions", Admission.class);
			List<Admission> adms = (List<Admission>) q1.getResultList();
			for (Admission adm : adms) {
				System.out.println(adm);
			}
			disconnectEntity();
		}
		
		public void listDoctors() {
			connectEntity();
			Query q1 = em.createNativeQuery("SELECT * FROM doctors", Doctor.class);
			List<Doctor> docs = (List<Doctor>) q1.getResultList();
			for (Doctor doc : docs) {
				System.out.println(doc);
			}
			disconnectEntity();
		}
		public void listNurses() {
			connectEntity();
			Query q1 = em.createNativeQuery("SELECT * FROM nurses", Nurse.class);
			List<Nurse> nurs = (List<Nurse>) q1.getResultList();
			for (Nurse nur : nurs) {
				System.out.println(nur);
			}
			disconnectEntity();
		}
		public void listDrugs() {
			connectEntity();
			Query q1 = em.createNativeQuery("SELECT * FROM drugs", Drug.class);
			List<Drug> drugs = (List<Drug>) q1.getResultList();
			for (Drug drug : drugs) {
				System.out.println(drug);
			}
			disconnectEntity();
		}
		public void listBoxes() {
			connectEntity();
			Query q1 = em.createNativeQuery("SELECT * FROM boxes", Box.class);
			List<Box> boxes = (List<Box>) q1.getResultList();
			for (Box box : boxes) {
				System.out.println(box);
			}
			disconnectEntity();
		}			
		/////////PRINTLIST///////
		
		///DELETE: Patient(D),Nurse(D)
	    ///,Doctor(d),drug(d),box(D),
	    ///admission(D),dosage(NOtD)??
		
		public void deletePatient(){
			connectEntity();
			System.out.println("Patients list:");
			listPatients();
			try {
				System.out.print("Choose a patient to delete. Type its SSD:");
				int p_SSD = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM patients WHERE id = ?", Patient.class);
				q2.setParameter(1,p_SSD);
				Patient pdelete = (Patient) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(pdelete);

				em.getTransaction().commit();

				em.close();
				disconnectEntity();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		public void deleteNurse(){
			connectEntity();
			System.out.println("Nurse list:");
			listNurses();
			try {
				System.out.print("Choose a nurse to delete. Type its id:");
				int n_id = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM nurses WHERE id = ?", Nurse.class);
				q2.setParameter(1,n_id);
				Nurse ndelete = (Nurse) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(ndelete);

				em.getTransaction().commit();

				em.close();
				disconnectEntity();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		
		public void deleteDoctor(){
			connectEntity();
			System.out.println("Doctors list:");
			listDoctors();
			try {
				System.out.print("Choose a doctor to delete. Type its id:");
				int d_id = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM doctors WHERE id = ?", Doctor.class);
				q2.setParameter(1,d_id);
				Doctor ddelete = (Doctor) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(ddelete);

				em.getTransaction().commit();

				em.close();
				disconnectEntity();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		public void deleteAdmission(){
			connectEntity();
			System.out.println("Admission list:");
			listAdmissions();
			try {
				System.out.print("Choose an admission to delete. Type its id:");
				int adm_id = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM admissions WHERE id = ?", Admission.class);
				q2.setParameter(1,adm_id);
				Admission admdelete = (Admission) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(admdelete);

				em.getTransaction().commit();

				em.close();
				disconnectEntity();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		public void deleteBox(){
			connectEntity();
			System.out.println("Box list:");
			listBoxes();
			try {
				System.out.print("Choose an box to delete. Type its id:");
				int b_id = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM boxes WHERE id = ?", Box.class);
				q2.setParameter(1,b_id);
				Box bdmdelete = (Box) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(bdmdelete);

				em.getTransaction().commit();

				em.close();
				disconnectEntity();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		public void deleteDrug(){
			connectEntity();
			System.out.println("Drug list:");
			listDrugs();
			try {
				System.out.print("Choose an drug to delete. Type its id:");
				int d_id = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM drugs WHERE id = ?", Drug.class);
				q2.setParameter(1,d_id);
				Drug ddmdelete = (Drug) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(ddmdelete);

				em.getTransaction().commit();

				em.close();
				disconnectEntity();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		
		
		
		///UPDATE: Patient()//
	    ///admission(),dosage(NOtD)??
		///Doesn't make sense to create an Update for doctors, nurses if you change your name and speciality
		///you can delete it an create a new one, same with drugs and box
		
		/*public void updatePatient() {
			boolean bol = true ;
			connectEntity();

			//System.out.println("Company's departments:");
			//Query q1 = em.createNativeQuery("SELECT * FROM departments WHERE name LIKE ?", Department.class);
			listPatients();
			System.out.print("Choose a patient to modify. Type it's SSD:");
			int p_SSD = Integer.parseInt(reader.readLine());
			Query q2 = em.createNativeQuery("SELECT * FROM patients WHERE id = ?", Doctor.class);
			q2.setParameter(1,p_SSD);
			Patient doc = (Patient) q2.getSingleResult();
			while(bol) {
				System.out.println("Write the attribute you want to change:");
				System.out.println("1.height");
				System.out.println("2.weight");
				System.out.println("3.allergies");
				
			}
			
			

			em.getTransaction().begin();
			// Make changes
			dep.setAddress(newLocation);
			// End transaction
			em.getTransaction().commit();
			
			// Close the entity manager
			em.close();
			
		}*/
		
		
		
		
		
		/////UPDATE//////
		
		

		/*//----------------------------------------------------------------------------
		/*
		//ASK ADMISSION
		
		
		
		//ASK PATIENT
		
		
		
		//ASK DOCTOR
		
		public Doctor askDoctor() {
			try {
			System.out.println("Write the ID of the doctor: ");
			int id = Integer.parseInt(reader.readLine());
			System.out.println("Write the name of the doctor: ");
			String name = reader.readLine();
			String specialty = reader.readLine();
			String yes_no = reader.readLine();
			boolean availability = true;
			if(yes_no.equals(true)) {
				availability = true;
			}
			else{
				availability = false;
			}
			Doctor d = new Doctor(id,name,specialty,availability);
			return d;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public Nurse askNurse() {
			try {
			System.out.println("Write the ID of the nurse: ");
			int id = Integer.parseInt(reader.readLine());
			System.out.println("Write the name of the nurse: ");
			String name = reader.readLine();
			String specialty = reader.readLine();
			String yes_no = reader.readLine();
			boolean availability = true;
			if(yes_no.equals(true)) {
				availability = true;
			}
			else{
				availability = false;
			}
			Nurse n = new Nurse(id,name,specialty,availability);
			return n;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public Box askBox() {
			try {
				System.out.println("Write the ID of the box-room: ");
				int id = Integer.parseInt(reader.readLine());
				System.out.println("Is the box-room available: ");
				String yes_no = reader.readLine();
				boolean availability = true;
				if(yes_no.equals(true)) {
					availability = true;
				}
				else{
					availability = false;
				}
				Admission admission =
						/*We have to call here the method askAdmission for adding it
						 * in the Box constructor*/
				/*Box b = new Box(id,availability,admission);
				return b;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		//ASK DRUG
		
		*/
		
		
		
		
		
		
		
		
		//----------------------------------------------------------------------------------
	}


