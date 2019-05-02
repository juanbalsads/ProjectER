package ER.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;
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
      	
		public void createPatient() {		
      		Patient pat1 = askForPatient();			 
			em.getTransaction().begin();
			em.persist(pat1);
			em.getTransaction().commit();   		
      	}
		public void createAdmission(){
				Admission adm1 = askForAdmission();
				em.getTransaction().begin();
				em.persist(adm1);
				adm1.getPatient().setAdmission(adm1);
				adm1.getDoctor().addAdmission(adm1);
				adm1.getNurse().addAdmission(adm1);
				adm1.getBox().setAdmission(adm1);
				em.getTransaction().commit();
			}	
		public void createDoctor(){		
				Doctor d = askForDoctor();
				em.getTransaction().begin();
				em.persist(d);
				em.getTransaction().commit();
			}
		
		public void createNurse(){
				Nurse n = askForNurse();
				em.getTransaction().begin();
				em.persist(n);
				em.getTransaction().commit();
			}
		public void createBox() {			
				Box b = askForBox();
				System.out.println(b.equals(null));
				System.out.println("traza");
				em.getTransaction().begin();
				em.persist(b);
				em.getTransaction().commit();
				}
		
		public void createDrug() {
			Drug d = askForDrug();
				em.getTransaction().begin();
				em.persist(d);
				em.getTransaction().commit();
			}
		

		////CREATE////
		
		///ASKForDAta: Patient(),Nurse()
	    ///,Doctor(),drug(),box(),
	    ///admissionD),dosage()??
		
		public Patient askForPatient() {
			Patient pat = null;
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
    			pat = new Patient(ssn,name, weight, height,genre, dob2, bloodType);		
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			return pat;		
		}
		public Doctor askForDoctor() {
			Doctor doc = null;
			try {
				System.out.println("Write the name of the doctor: ");
				String name = reader.readLine();
				System.out.println("Write the name of the specialty: ");
				String speciality = reader.readLine();
				boolean availability = true;
				System.out.println("Is the doctor available?:");
				String yes_no = reader.readLine();
				if(yes_no.equals(true)) {
					availability = true;
				}
				else{
					availability = false;
				}
				doc = new Doctor(name,speciality,availability);		
			}catch(IOException e) {
				e.printStackTrace();
			}
			return doc;	
		}
		public Nurse askForNurse() {
			Nurse nurse = null;
			try {
				System.out.println("Write the name of the nurse: ");
				String name = reader.readLine();
				System.out.println("Write the name of the specialty: ");
				String speciality = reader.readLine();
				boolean availability = true;
				System.out.println("Is the nurse available?:");
				String yes_no = reader.readLine();
				if(yes_no.equals(true)) {
					availability = true;
				}
				else{
					availability = false;
				}			
			nurse = new Nurse(name,speciality,availability);	
			}catch(IOException e) {
				e.printStackTrace();
			}
			return nurse;
		}
		public Drug askForDrug() {
			Drug drug = null;
			try {
				System.out.println("Write the name of the drug: ");
				String name = reader.readLine();
				drug = new Drug(name);	
			}catch(IOException e) {
				e.printStackTrace();
			}
			return drug;
		}
		public Box askForBox() {
			Box box = null;
			try {
				System.out.println("Write the name of the box-room: ");
				String name= reader.readLine();
				boolean availability = true;
				box = new Box(name,availability);			
			}catch(IOException e) {
				e.printStackTrace();
			}
			return box;			
		}
		public Admission askForAdmission()  {
			Admission adm = null;
			try {
				System.out.println("Please, input the admission data:\n");
				System.out.print("Patient`s SSD:\n");
				listPatients();
				int SSD = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Patients WHERE ssn = ?", Patient.class);
				q.setParameter(1, SSD);
				Patient p = (Patient) q.getSingleResult();	
				System.out.print("Doctors id in charge:\n");
				listDoctors();
				int doctor_id = Integer.parseInt(reader.readLine());
				q = em.createNativeQuery("SELECT * FROM Doctors WHERE id = ?", Doctor.class);
				q.setParameter(1, doctor_id);
				Doctor doctor = (Doctor) q.getSingleResult();	
				System.out.print("Nurses id in charge:\n");
				listNurses();
				int nurse_id =  Integer.parseInt(reader.readLine());
				q = em.createNativeQuery("SELECT * FROM Nurses WHERE id = ?", Nurse.class);
				q.setParameter(1,nurse_id);
				Nurse nurse = (Nurse) q.getSingleResult();	
				System.out.print("Box:\n");
				listBoxes();
				int box_id = Integer.parseInt(reader.readLine());
				q = em.createNativeQuery("SELECT * FROM Boxes WHERE id = ?", Box.class);
				q.setParameter(1,box_id);
				Box box = (Box) q.getSingleResult();		
				System.out.print("Arrival time (yyyy-MM-dd HH:mm):\n");
				String dateS = reader.readLine();
				DateTimeFormatter formatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	
				LocalDateTime localDateTime = LocalDateTime.parse(dateS, formatterWithTime);		
				Timestamp arrivalTime = Timestamp.valueOf(localDateTime);
				System.out.print("Test: ");
				String tests = reader.readLine();
				System.out.println("\nThe patient is going to be internated");
				boolean release = false;
				adm = new Admission(p,arrivalTime,tests,release, nurse,doctor, box);		
			}catch(IOException e) {
				e.printStackTrace();
			}
			return adm;	
			
		}
		
			
		//////ASKForData////////
	
	     ///READ: Patient(D),Nurse(D)
	    ///,Doctor(D),drug(D),box(D),
	    ///admission(D),dosage(NOtD)??
		
		public void readAdmission() {
			
			
			try {
				System.out.print("Write the admission's ID: ");
				int adm_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Admissions WHERE id = ?", Admission.class);
				q.setParameter(1, adm_id);
				Admission admission = (Admission) q.getSingleResult();
				System.out.println(admission.toString());				
				
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void readPatient() {
		
			
			try {
				System.out.print("Write the patient's SSD: ");
				int pat_SSD = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Patients WHERE ssn = ?", Patient.class);
				q.setParameter(1, pat_SSD);
				Patient p = (Patient) q.getSingleResult();
				System.out.println(p.toString());
				
				
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void readDoctor() {
		
			
			try {
				System.out.print("Write the doctor's id: ");
				int d_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Doctors WHERE id = ?", Doctor.class);
				q.setParameter(1, d_id);
				Doctor d = (Doctor) q.getSingleResult();
				System.out.println(d.toString());
			
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void readNurse() {
			
			
			try {
				System.out.print("Write the nurse`s id: ");
				int n_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Nurses WHERE id = ?", Nurse.class);
				q.setParameter(1, n_id);
				Nurse n = (Nurse) q.getSingleResult();
				System.out.println(n.toString());
				
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		public void readBox() {
			
			
			try {
				System.out.print("Write the box`s id: ");
				int b_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Boxes WHERE id = ?", Box.class);
				q.setParameter(1, b_id);
				Box b = (Box) q.getSingleResult();
				System.out.println(b.toString());
		
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void readDrug() {
		
			
			try {
				System.out.print("Write the drugs`s id: ");
				int dr_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Drugs WHERE id = ?", Drug.class);
				q.setParameter(1, dr_id);
				Drug dr = (Drug) q.getSingleResult();
				System.out.println(dr.toString());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	     ///READ////
		
		///PRINTLIST: Patient(D),Nurse(D)
	    ///,Doctor(D),drug(D),box(D),
	    ///admission(D),dosage(NOtD)??
		
		public void listPatients() {
			
			Query q1 = em.createNativeQuery("SELECT * FROM Patients", Patient.class);
			List<Patient> pats = (List<Patient>) q1.getResultList();
			for (Patient pat : pats) {
				System.out.println(pat);
			}
		}
		public void listPatients2() {
		
			Query q1 = em.createNativeQuery("SELECT * FROM Patients", Patient.class);
			List<Patient> pats = (List<Patient>) q1.getResultList();
			for (Patient pat : pats) {
				System.out.println(pat.toString2());
			}
		}
		public void listAdmissions() {
			
			Query q1 = em.createNativeQuery("SELECT * FROM Admissions", Admission.class);
			List<Admission> adms = (List<Admission>) q1.getResultList();
			for (Admission adm : adms) {
				System.out.println(adm);
			}
		
		}
		
		public void listDoctors() {
			
			Query q1 = em.createNativeQuery("SELECT * FROM Doctors", Doctor.class);
			List<Doctor> docs = (List<Doctor>) q1.getResultList();
			for (Doctor doc : docs) {
				System.out.println(doc);
			}
		}
		public void listDoctors2() {
		
			Query q1 = em.createNativeQuery("SELECT * FROM Doctors", Doctor.class);
			List<Doctor> docs = (List<Doctor>) q1.getResultList();
			for (Doctor doc : docs) {
				System.out.println(doc.toString2());
			}
		}
		public void listNurses() {
			Query q1 = em.createNativeQuery("SELECT * FROM Nurses", Nurse.class);
			List<Nurse> nurs = (List<Nurse>) q1.getResultList();
			for (Nurse nur : nurs) {
				System.out.println(nur);
			}
		}
		
		public void listNurses2() {
			Query q1 = em.createNativeQuery("SELECT * FROM Nurses", Nurse.class);
			List<Nurse> nurs = (List<Nurse>) q1.getResultList();
			for (Nurse nur : nurs) {
				System.out.println(nur.toString2());
			}
		}
		public void listDrugs() {
			
			Query q1 = em.createNativeQuery("SELECT * FROM Drugs", Drug.class);
			List<Drug> drugs = (List<Drug>) q1.getResultList();
			for (Drug drug : drugs) {
				System.out.println(drug);
			}
		}
		public void listBoxes() {
			Query q1 = em.createNativeQuery("SELECT * FROM Boxes", Box.class);
			List<Box> boxes = (List<Box>) q1.getResultList();
			for (Box box : boxes) {
				System.out.println(box);
			}	
		}			
		
		public void listBoxes2() {
			Query q1 = em.createNativeQuery("SELECT * FROM Boxes", Box.class);
			List<Box> boxes = (List<Box>) q1.getResultList();
			for (Box box : boxes) {
				System.out.println(box.toString2());
			}	
		}	
		/////////PRINTLIST///////
		
		///DELETE: Patient(D),Nurse(D)
	    ///,Doctor(d),drug(d),box(D),
	    ///admission(D),dosage(NOtD)??
		
		public void deletePatient(){
			
			System.out.println("Patients list:");
			listPatients();
			try {
				System.out.print("Choose a patient to delete. Type its SSN:");
				int p_SSD = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM Patients WHERE ssn = ?", Patient.class);
				q2.setParameter(1, p_SSD);
				Patient pdelete = (Patient) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(pdelete);
				em.getTransaction().commit();

			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		public void deleteNurse(){
			System.out.println("Nurse list:");
			listNurses();
			try {
				System.out.print("Choose a nurse to delete. Type its id:");
				int n_id = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM Nurses WHERE id = ?", Nurse.class);
				q2.setParameter(1,n_id);
				Nurse ndelete = (Nurse) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(ndelete);

				em.getTransaction().commit();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		
		public void deleteDoctor(){
			System.out.println("Doctors list:");
			listDoctors();
			try {
				System.out.print("Choose a doctor to delete. Type its id:");
				int d_id = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM Doctors WHERE id = ?", Doctor.class);
				q2.setParameter(1,d_id);
				Doctor ddelete = (Doctor) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(ddelete);

				em.getTransaction().commit();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		public void deleteAdmission(){
			System.out.println("Admission list:");
			listAdmissions();
			try {
				System.out.print("Choose an admission to delete. Type its id:");
				int adm_id = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM Admissions WHERE id = ?", Admission.class);
				q2.setParameter(1,adm_id);
				Admission admdelete = (Admission) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(admdelete);
				em.getTransaction().commit();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		public void deleteBox(){
			System.out.println("Box list:");
			listBoxes();
			try {
				System.out.print("Choose an box to delete. Type its id:");
				int b_id = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM Boxes WHERE id = ?", Box.class);
				q2.setParameter(1,b_id);
				Box bdmdelete = (Box) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(bdmdelete);

				em.getTransaction().commit();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		public void deleteDrug(){
			System.out.println("Drug list:");
			listDrugs();
			try {
				System.out.print("Choose an drug to delete. Type its id:");
				int d_id = Integer.parseInt(reader.readLine());		
				Query q2 = em.createNativeQuery("SELECT * FROM Drugs WHERE id = ?", Drug.class);
				q2.setParameter(1,d_id);
				Drug ddmdelete = (Drug) q2.getSingleResult();
				em.getTransaction().begin();
				em.remove(ddmdelete);

				em.getTransaction().commit();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		
		
		
		///UPDATE: Patient(D--what to do with relation entity such as admission),Nurse(D)
	    ///,Doctor(D),drug(),box(D),
	    ///admission(),dosage(NOtD)??
		
		public void updateAdmission() {
			listAdmissions();
			System.out.println("Choose admission to modify. Type its id:");
			try {
				int adm_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Admission WHERE id = ?", Admission.class);
				q.setParameter(1,adm_id);
				Admission adm = (Admission) q.getSingleResult();
				
				
				System.out.println("New dob (yyyy-MM-dd HH:mm):");
				String newArrivalTimeS= reader.readLine();
					if(newArrivalTimeS.equals("")) {
						newArrivalTimeS= adm.getArrivalTime().toString();}
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				    LocalDate date = LocalDate.parse(newArrivalTimeS, formatter);
				    Date newDob = Date.valueOf(date);
				///PROBLEM
				
			
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		public void updatePatient() {

			//System.out.println("Company's departments:");
			//Query q1 = em.createNativeQuery("SELECT * FROM departments WHERE name LIKE ?", Department.class);
			
			listPatients();
			System.out.print("Choose a patient to modify. Type its SSD:");
			try {
				int p_SSD = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Patients WHERE ssn = ?", Patient.class);
				q.setParameter(1,p_SSD);
				Patient p = (Patient) q.getSingleResult();
				System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= p.getName();}
				
				System.out.println("New weight:");
				Double newWeight;
				String newWeightS = reader.readLine();
					if(newWeightS.equals("")) {
						newWeight= p.getWeight();}
					else {
						newWeight= Double.parseDouble(newWeightS);}
			    System.out.println("New height:");
				Double newHeight;
				String newHeightS = reader.readLine();
					if(newHeightS.equals("")) {
						newHeight= p.getHeight();}
					else {
						newHeight= Double.parseDouble(newHeightS);}
			
				System.out.println("New genre:");
				String newGenre= reader.readLine();
					if(newGenre.equals("")) {
						newGenre= p.getGenre();}
			    
				System.out.println("New dob (yyyy-MM-dd):");
				String newDobS= reader.readLine();
					if(newDobS.equals("")) {
						newDobS= p.getDob().toString();}
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				    LocalDate date = LocalDate.parse(newDobS, formatter);
				    Date newDob = Date.valueOf(date);
		    
				System.out.println("New bloodtype:");
			    String newBloodType = reader.readLine();
			        if(newBloodType.equals("")){
			        	newBloodType=p.getBloodType();}
				
				em.getTransaction().begin();
				p.setName(newName);
				p.setWeight(newWeight);
				p.setHeight(newHeight);
				p.setGenre(newGenre);
				p.setDob(newDob);
				p.setBloodType(newBloodType);
				em.getTransaction().commit();
			}catch(IOException e) {
				e.printStackTrace();
			}
					
		}
		public void updateDoctor() {
			listDoctors();
			System.out.print("Choose doctor to modify. Type its id:");
			try {
				int d_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Doctors WHERE id = ?", Doctor.class);
				q.setParameter(1,d_id);
				Doctor d = (Doctor) q.getSingleResult();			
			    System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= d.getName();}
			    System.out.println("New speciality:");
				String newSpecialty= reader.readLine();
					if(newSpecialty.equals("")) {
						newSpecialty= d.getSpecialty();}
			    System.out.println("It is available?(write yes or no): ");
			    String yes_no = reader.readLine();
			    Boolean availability = true;
		            if(yes_no.equalsIgnoreCase("YES")) {
		            	availability = true;
		            }
		            if(yes_no.equalsIgnoreCase("NO")) {
		            	availability = false;
		            }
				
		        em.getTransaction().begin();
			    d.setName(newName);
				d.setSpecialty(newSpecialty);
				d.setAvailability(availability);
			     em.getTransaction().commit();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		public void updateNurse() {
			listNurses();
			System.out.print("Choose nurse to modify. Type its id:");
			try {
				int n_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Nurses WHERE id = ?", Nurse.class);
				q.setParameter(1,n_id);
				Nurse n = (Nurse) q.getSingleResult();			
			    System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= n.getName();}
			    System.out.println("New speciality:");
				String newSpecialty= reader.readLine();
					if(newSpecialty.equals("")) {
						newSpecialty= n.getSpecialty();}
			    System.out.println("It is available?(write yes or no): ");
			    String yes_no = reader.readLine();
			    Boolean availability = true;
		            if(yes_no.equalsIgnoreCase("YES")) {
		            	availability = true;
		            }
		            if(yes_no.equalsIgnoreCase("NO")) {
		            	availability = false;
		            }
				
		        em.getTransaction().begin();
			    n.setName(newName);
				n.setSpecialty(newSpecialty);
				n.setAvailability(availability);
			     em.getTransaction().commit();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void updateBox() {
			listBoxes();
			System.out.print("Choose box to modify. Type its id:");
			try {			
				int box_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Boxes WHERE id = ?", Box.class);
				q.setParameter(1,box_id);
				Box b = (Box) q.getSingleResult();
				 System.out.println("Write if the box is available or occupied: ");
				 String yes_no = reader.readLine();
				    Boolean availability = true;
			            if(yes_no.equalsIgnoreCase("YES")) {
			            	availability = true;
			            }
			            if(yes_no.equalsIgnoreCase("NO")) {
			            	availability = false;
			            }
			            
				  em.getTransaction().begin();
		          b.setAvailability(availability);
				  em.getTransaction().commit();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			}
			
		public void updateDrug() {
			listDrugs();
			System.out.print("Choose drug to modify. Type its id:");
			try {			
				int drug_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Drugs WHERE id = ?", Drug.class);
				q.setParameter(1,drug_id);
				Drug d = (Drug) q.getSingleResult();
				System.out.println("new name: ");
				String newName= reader.readLine();
				if(newName.equals("")) {
					newName= d.getName();}        
				  em.getTransaction().begin();
		          d.setName(newName);
				  em.getTransaction().commit();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			}
		
		
		
		
		

	}


