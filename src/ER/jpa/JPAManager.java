package ER.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.io.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ER.POJOS.*;
import Manager.Manager;
import sample.db.graphics.ImageWindow;



public class JPAManager implements Manager {
    
	private static EntityManager em;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		public JPAManager() {
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
				adm1.getBox().setAvailability(false);;
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
		
		public void createAdmissionToDrug() {
			Admission adm = null;
			Drug d = null; 
			try {
				listAdmissions();
				System.out.println("choose the admission");
				int id_p = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Admissions WHERE id = ?", Admission.class);
				q.setParameter(1, id_p);
				adm = (Admission) q.getSingleResult();
				listDrugs();
				System.out.println("choose the drug");
				int id_d = Integer.parseInt(reader.readLine());
				q = em.createNativeQuery("SELECT * FROM Drugs WHERE id = ?", Drug.class);
				q.setParameter(1, id_d);
				d = (Drug) q.getSingleResult();
			}catch(IOException e) {
				e.printStackTrace();
			}
			addDrugToAdmission(adm,d);	
		}
		
		public void addDrugToAdmission(Admission adm, Drug d) {
			em.getTransaction().begin();
			adm.addDrug(d);
			d.addAdmission(adm);
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
    			String id=reader.readLine();
    			while(!onlyContainsNumbers(id)) {
    				System.out.println("Insert a valid patient's ssn:");
        			 id=reader.readLine();
    			}
    			int ssn = Integer.parseInt(id);
    			System.out.println("Insert the patient's name:");
    				String name = reader.readLine();
    			System.out.println("Insert weight:");
    				String w=reader.readLine();
    			while(!onlyContainsDouble(w)) {
        			System.out.println("  Insert a valid patient's weight:");
           			 w=reader.readLine();
        		}
    				Double weight = Double.parseDouble(w);
    			System.out.println("Insert height(meters):");
    			String h= reader.readLine();
    			while(!onlyContainsDouble(h)) {
        			System.out.println("  Insert a valid patient's height:");
           			 h=reader.readLine();
        		}
    				Double height = Double.parseDouble(h);
    			System.out.println("Insert gender (male|female): ");
    				String genre = reader.readLine();
    				
    				while (!genre.equals("male")&&!genre.equals("MALE")&&!genre.equals("female")&&!genre.equals("FEMALE")) {
    					System.out.println("Insert a valid gender (male|female): ");
        				genre = reader.readLine();	
    				}
    					
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
				if(yes_no.equals("true")||yes_no.equals("yes")) {
					availability = true;}
				if(yes_no.equals("false")||yes_no.equals("no")) {
					availability=false; }
				while(!yes_no.equals("true")&&!yes_no.equals("yes")&&!yes_no.equals("false")&&!yes_no.equals("no")) {
					System.out.println("Is the doctor available?:");
					yes_no = reader.readLine();
					if(yes_no.equals("true")||yes_no.equals("yes")) {
						availability = true;}
					if(yes_no.equals("false")||yes_no.equals("no")) {
						availability=false; }
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
				if(yes_no.equals("true")||yes_no.equals("yes")) {
					availability = true;}
				if(yes_no.equals("false")||yes_no.equals("no")) {
					availability=false; }
				while(!yes_no.equals("true")&&!yes_no.equals("yes")&&!yes_no.equals("false")&&!yes_no.equals("no")) {
					System.out.println("Is the doctor available?:");
					yes_no = reader.readLine();
					if(yes_no.equals("true")||yes_no.equals("yes")) {
						availability = true;}
					if(yes_no.equals("false")||yes_no.equals("no")) {
						availability=false; }
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
				while(!patientsIds().contains(SSD)) {
					System.out.print("Not valid. Patient`s SSD:\n");
					listPatients();
					SSD = Integer.parseInt(reader.readLine());}
				Patient p= getPatient(SSD);
				
				System.out.print("Doctors id in charge:\n");
				listDoctors();
				int doctor_id = Integer.parseInt(reader.readLine());
				while(!doctorsIds().contains(doctor_id)) {
					System.out.print("Not valid. Doctors id in charge:\n");
					listDoctors();
					doctor_id = Integer.parseInt(reader.readLine());}
				Doctor doctor = getDoctor(doctor_id);
				
				System.out.print("Nurses id in charge:\n");
				listNurses();
				int nurse_id =  Integer.parseInt(reader.readLine());
				while(!nursesIds().contains(nurse_id)) {
					System.out.print("Not valid. Nurses id in charge:\n");
					listNurses();
				    nurse_id =  Integer.parseInt(reader.readLine());}
				Nurse nurse = getNurse(nurse_id);
				
				System.out.print("Box id:\n");
				listBoxes();
				int box_id = Integer.parseInt(reader.readLine());
				while(!boxesIds().contains(box_id)) {
					System.out.print("Not valid. Box id:\n");
					listBoxes();
				    box_id = Integer.parseInt(reader.readLine());}
				Box box = getBox(box_id);	
				
				System.out.print("Arrival time (yyyy-MM-dd HH:mm):\n");
				String dateS = reader.readLine();
				DateTimeFormatter formatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	
				LocalDateTime localDateTime = LocalDateTime.parse(dateS, formatterWithTime);		
				Timestamp arrivalTime = Timestamp.valueOf(localDateTime);
				System.out.println("\nThe patient is going to be internated");
				adm = new Admission(p,arrivalTime,nurse,doctor, box);			
			}catch(IOException e) {
				e.printStackTrace();
			}
			return adm;	
			
		}
		
//GETS
		
public Patient getPatient(int id) {
	Query q = em.createNativeQuery("SELECT * FROM Patients WHERE ssn = ?", Patient.class);
	q.setParameter(1, id);
	Patient p = (Patient) q.getSingleResult();
	return p;}

public Doctor getDoctor(int id) {
	Query q = em.createNativeQuery("SELECT * FROM Doctors WHERE id = ?", Doctor.class);
	q.setParameter(1, id);
	Doctor d = (Doctor) q.getSingleResult();
	return d;}

public Nurse getNurse(int id) {
	Query q = em.createNativeQuery("SELECT * FROM Nurses WHERE id = ?", Nurse.class);
	q.setParameter(1, id);
	Nurse n = (Nurse) q.getSingleResult();
	return n;}

public Drug getDrug(int id) {
	Query q = em.createNativeQuery("SELECT * FROM Drugs WHERE id = ?", Drug.class);
	q.setParameter(1, id);
	Drug d = (Drug) q.getSingleResult();
	return d;}

public Box getBox(int id) {
	Query q = em.createNativeQuery("SELECT * FROM Boxes WHERE id = ?", Box.class);
	q.setParameter(1, id);
	Box b= (Box) q.getSingleResult();
	return b;}

public Admission getAdmission (int id) {
	Query q = em.createNativeQuery("SELECT * FROM Admissions WHERE id = ?", Admission.class);
	q.setParameter(1, id);
	Admission a= (Admission) q.getSingleResult();
	return a;}

			
		//////ASKForData////////
	
	     ///READ: Patient(D),Nurse(D)
	    ///,Doctor(D),drug(D),box(D),
	    ///admission(D),dosage(NOtD)??
		
		public void readAdmission() {
			try {
				System.out.print("Write the admission's ID: ");
				int adm_id = Integer.parseInt(reader.readLine());
				Admission admission = getAdmission(adm_id);
				System.out.println(admission.toString());				
			}catch(IOException e) {
				e.printStackTrace();}
		}
		
		
		public void readPatient() {
			try {
				System.out.print("Write the patient's SSD: ");
				int pat_SSD = Integer.parseInt(reader.readLine());
				Patient p = getPatient(pat_SSD);
				System.out.println(p.toString());
			}catch(IOException e) {
				e.printStackTrace();}
		}
		
		public void readDoctor() {
			try {
				listDoctors();
				System.out.print("Write the doctor's id: ");
				int d_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Doctors WHERE id = ?", Doctor.class);
				q.setParameter(1, d_id);
				Doctor d = (Doctor) q.getSingleResult();
				System.out.println(d.toString());
				if(d.getPhoto()!=null) {
					showPicture(d.getPhoto());}
			}catch(IOException e) {
				e.printStackTrace();}
		}
		
		public void readNurse() {
			try {
				listNurses();
				System.out.print("Write the nurse`s id: ");
				int n_id = Integer.parseInt(reader.readLine());
				Query q = em.createNativeQuery("SELECT * FROM Nurses WHERE id = ?", Nurse.class);
				q.setParameter(1, n_id);
				Nurse n = (Nurse) q.getSingleResult();
				System.out.println(n.toString());
			}catch(IOException e) {
				e.printStackTrace();}
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
				e.printStackTrace();}
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
				e.printStackTrace();}
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
		public void listAdmissions2() {
			
			Query q1 = em.createNativeQuery("SELECT * FROM Admissions", Admission.class);
			List<Admission> adms = (List<Admission>) q1.getResultList();
			for (Admission adm : adms) {
				System.out.println(adm.toString2());
			}
		
		}
		public void listDoctorAdmissions() {
			try {
				listDoctors();
				System.out.print("Write the doctor's id: ");
				int d_id = Integer.parseInt(reader.readLine());
				Query q1 = em.createNativeQuery("SELECT * FROM Admissions WHERE id = ?", Admission.class);
				q1.setParameter(1, d_id);
				List<Admission> adms = (List<Admission>) q1.getResultList();
				for (Admission adm : adms) {
					System.out.println(adm);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		public void listNurseAdmissions() {
			try {
				listNurses();
				System.out.print("Write the nurse`s id: ");
				int n_id = Integer.parseInt(reader.readLine());
				Query q1 = em.createNativeQuery("SELECT * FROM Admissions WHERE id = ?", Admission.class);
				q1.setParameter(1, n_id);
				List<Admission> adms = (List<Admission>) q1.getResultList();
				for (Admission adm : adms) {
					System.out.println(adm);
				}
			}catch(IOException e) {
				e.printStackTrace();
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
		public void listDrugs2() {
			
			Query q1 = em.createNativeQuery("SELECT * FROM Drugs", Drug.class);
			List<Drug> drugs = (List<Drug>) q1.getResultList();
			for (Drug drug : drugs) {
				System.out.println(drug.toString2());
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
		
		

		
		
		// ArrayList<Admission> listaadm = listAdmissionsList();
		
		
		/////////PRINTLIST///////
		
		///DELETE: Patient(D),Nurse(D)
	    ///,Doctor(d),drug(d),box(D),
	    ///admission(D),dosage(NOtD)??
		
		public void deletePatient(){		
			System.out.println("Patients list:");
			listPatients();
			try {
				System.out.print("Choose a patient to delete. Type its SSN:");
				String id=reader.readLine();
				while(!onlyContainsNumbers(id)) {
					System.out.println("    Select a valid patient SSN: ");
					id=reader.readLine();
				}
				int p_SSD = Integer.parseInt(id);
				if(!patientsIds().contains(p_SSD)) {
					System.out.println("    This patient does not exist");
				}
				else {
						
				Patient pdelete = getPatient(p_SSD);
				em.getTransaction().begin();
				if (pdelete.getAdmission()!=null) {
				pdelete.getAdmission().getDoctor().removeAdmission(pdelete.getAdmission());
				pdelete.getAdmission().getDoctor().removeAdmission(pdelete.getAdmission());
				pdelete.getAdmission().getBox().setAvailability(true);
				pdelete.getAdmission().getBox().setAdmission(null);;
				em.remove(pdelete.getAdmission());}
				em.remove(pdelete);
				em.getTransaction().commit();}
			}catch(IOException e) {
				e.printStackTrace();}	
		}
		
		public void deleteNurse(){
			System.out.println("Nurse list:");
			listNurses();
			try {
				System.out.print("Choose a nurse to delete. Type its id:");
				String id=reader.readLine();
				while(!onlyContainsNumbers(id)) {
					System.out.println("    Select a valid nurse id: ");
					id=reader.readLine();
				}
				int n_id = Integer.parseInt(id);	
				if(!nursesIds().contains(n_id)) {
					System.out.println("    This nurse does not exist");
				}
				else {	
				Nurse ndelete = getNurse(n_id);
				em.getTransaction().begin();
				em.remove(ndelete);
				em.getTransaction().commit();}
			}catch(IOException e) {
				e.printStackTrace();}	
		}
		
		public void deleteDoctor(){
			System.out.println("Doctors list:");
			listDoctors();
			try {
				System.out.print("Choose a doctor to delete. Type its id:");
				String id=reader.readLine();
				while(!onlyContainsNumbers(id)) {
					System.out.println("    Select a valid doctor id: ");
					id=reader.readLine();
				}
				int d_id = Integer.parseInt(id);	
				if(!doctorsIds().contains(d_id)) {
					System.out.println("    This doctor does not exist");
				}
				else {
				Doctor ddelete = getDoctor(d_id);
				em.getTransaction().begin();
				em.remove(ddelete);
				em.getTransaction().commit();}
			}catch(IOException e) {
				e.printStackTrace();}	
		}
		
		public void deleteAdmission(){
			System.out.println("Admission list:");
			listAdmissions();
			try {
				System.out.print("Choose an admission to delete. Type its id:");
				String id=reader.readLine();
				while(!onlyContainsNumbers(id)) {
					System.out.println("    Select a valid admission id: ");
					id=reader.readLine();
				}
				int adm_id = Integer.parseInt(id);	
				if(!admissionsIds().contains(adm_id)) {
					System.out.println("    This admission does not exist");
				}
				else {	
				Admission admdelete = getAdmission(adm_id);
				em.getTransaction().begin();
				admdelete.getDoctor().removeAdmission(admdelete);
				admdelete.getNurse().removeAdmission(admdelete);
				admdelete.getBox().setAvailability(true);
				admdelete.getBox().setAdmission(null);
				admdelete.getPatient().setAdmission(null);
				em.remove(admdelete);
				em.getTransaction().commit();}
			}catch(IOException e) {
				e.printStackTrace();}	
		}
		
		public void deleteBox(){
			System.out.println("Box list:");
			listBoxes();
			try {
				System.out.print("Choose an box to delete. Type its id:");
				String id=reader.readLine();
				while(!onlyContainsNumbers(id)) {
					System.out.println("    Select a valid box id: ");
					id=reader.readLine();
				}
				int b_id = Integer.parseInt(id);	
				if(!boxesIds().contains(b_id)) {
					System.out.println("    This box does not exist");
				}
				else {		
				Box bdmdelete = getBox(b_id);
				em.getTransaction().begin();
				bdmdelete.getAdmission().setBox(null);
				em.remove(bdmdelete);
				em.getTransaction().commit();}
			}catch(IOException e) {
				e.printStackTrace();}	
		}
		
		public void deleteDrug(){
			System.out.println("Drug list:");
			listDrugs();
			try {
				System.out.print("Choose an drug to delete. Type its id:");
				String id=reader.readLine();
				while(!onlyContainsNumbers(id)) {
					System.out.println("    Select a valid drug id: ");
					id=reader.readLine();
				}
				int d_id = Integer.parseInt(id);	
				if(!drugsIds().contains(d_id)) {
					System.out.println("    This drug does not exist");
				}
				else {	
				Drug ddmdelete = getDrug(d_id);
				em.getTransaction().begin();
				em.remove(ddmdelete);
				em.getTransaction().commit();}
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		
		
		/*----------------------RELEASE-------------------*/
		public void releasePatient() {

			listAdmissions();
			
			try {
				System.out.println("Choose admission to release. Type its id:");
				String id=reader.readLine();
				while(!onlyContainsNumbers(id)) {
					System.out.println("    Select a valid admission id: ");
					id=reader.readLine();
				}
				int adm_id = Integer.parseInt(id);	
				if(!admissionsIds().contains(adm_id)) {
					System.out.println("    This admission does not exist");
				}
				else {	
				Admission adm = getAdmission(adm_id);
				em.getTransaction().begin();
				adm.setRelease(true);
				adm.getDoctor().removeAdmission(adm);
				adm.getNurse().removeAdmission(adm);
				adm.getBox().setAvailability(true);
				
				em.getTransaction().commit();
				
				System.out.println("released");}
				}   
			catch(IOException e) {
				e.printStackTrace();}
			
		}
			
		///UPDATE: Patient(D--what to do with relation entity such as admission),Nurse(D)
	    ///,Doctor(D),drug(),box(D),
	    ///admission(),dosage(NOtD)??
		
		public void updateAdmission() {
			listAdmissions2();
			
			try {
				System.out.println("Choose admission to modify. Type its id:");
				String id=reader.readLine();
				
				int adm_id=Integer.parseInt(id);
				while(!onlyContainsNumbers(id)|| !admissionsIds().contains(adm_id)) {
					System.out.println("    Select a valid admission id: ");
					id=reader.readLine();
					adm_id = Integer.parseInt(id);}
				Admission adm = getAdmission(adm_id);	
				System.out.print("New doctor's id:\n");
				listDoctors();
				String doc_id=reader.readLine();
				Doctor newDoc= adm.getDoctor();
				if(!doc_id.equals("")){
					int doctor_id = Integer.parseInt(doc_id);
					while(!onlyContainsNumbers(doc_id)|| !doctorsIds().contains(doctor_id)) {
						System.out.println("    Select a valid doctos id: ");
						doc_id=reader.readLine();
						doctor_id = Integer.parseInt(doc_id);	}
					newDoc= getDoctor(doctor_id);
				}
		
				System.out.print("New nurse's id:\n");
				listNurses();
				String nur_id=reader.readLine();
				Nurse newNur= adm.getNurse();
				if(!nur_id.equals("")){
					int nurse_id = Integer.parseInt(nur_id);
					while(!onlyContainsNumbers(nur_id) || !nursesIds().contains(nurse_id)) {
						System.out.println("    Select a valid nurse id: ");
						nur_id=reader.readLine();
						nurse_id = Integer.parseInt(doc_id);	}	
					newNur= getNurse(nurse_id);
				}
				
				System.out.print("New Box id:\n");
				listBoxes();
				String b_id=reader.readLine();
				Box newBox= adm.getBox();
				if(!b_id.equals("")){
					int box_id = Integer.parseInt(b_id);
					while(!onlyContainsNumbers(b_id)|| !boxesIds().contains(box_id)) {
						System.out.println("    Select a valid con id: ");
						doc_id=reader.readLine();
						box_id = Integer.parseInt(b_id);	}
					newBox= getBox(box_id);}
				em.getTransaction().begin();
				if(adm.getDoctor()!=null) {
				adm.getDoctor().removeAdmission(adm);}
				adm.setDoctor(newDoc);
				newNur.addAdmission(adm);
				if(adm.getNurse()!=null) {
				adm.getNurse().removeAdmission(adm);}
				adm.setNurse(newNur);
				newNur.addAdmission(adm);
				if(adm.getBox()!=null) {
				adm.getBox().setAvailability(true);
				adm.getBox().setAdmission(null);}
				adm.setBox(newBox);
				newBox.setAvailability(false);
				newBox.setAdmission(adm);
			
				em.getTransaction().commit();
				System.out.println("updated");
				}   
			catch(IOException e) {
				e.printStackTrace();}
			}
		
		public void updatePatient() {
			listPatients();		
			System.out.print("Choose a patient to modify. Type its SSN:");
			try {
				String id=reader.readLine();
				int p_SSD = Integer.parseInt(id);
    			while(!onlyContainsNumbers(id)|| !patientsIds().contains(p_SSD)) {
    				System.out.println("Insert a valid patient's ssn:");
        			 id=reader.readLine();
        			 p_SSD= Integer.parseInt(id);
    			}
    			
				
				Patient p = getPatient(p_SSD);
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
		    			while(!onlyContainsDouble(newWeightS)) {
		        			System.out.println("  Insert a valid patient's weight:");
		        			newWeightS=reader.readLine();
		        		}
						newWeight= Double.parseDouble(newWeightS);}
			    System.out.println("New height:");
				Double newHeight;
				String newHeightS = reader.readLine();
					if(newHeightS.equals("")) {
						newHeight= p.getHeight();}
					else {
						while(!onlyContainsDouble(newHeightS)) {
		        			System.out.println("  Insert a valid patient's height:");
		        			newHeightS=reader.readLine();
		        		}
						newHeight= Double.parseDouble(newHeightS);}
			
				System.out.println("New gender (male|female):");
				String newGenre= reader.readLine();
					if(newGenre.equals("")) {
						newGenre= p.getGenre();}
					else {
						while (!newGenre.equals("male")&&!newGenre.equals("MALE")&&!newGenre.equals("female")&&!newGenre.equals("FEMALE")) {
	    					System.out.println("Insert a valid gender (male|female): ");
	    					newGenre = reader.readLine();	
	    				}
					}
			    
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
				byte[] bytesBlob = null;
				String id=reader.readLine();
				int d_id = Integer.parseInt(id);
    			while(!onlyContainsNumbers(id)|| !doctorsIds().contains(d_id)) {
    				System.out.println("Insert a valid doctor id:");
        			 id=reader.readLine();
        			 d_id= Integer.parseInt(id);
    			}
				Doctor d = getDoctor(d_id);			
			    System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= d.getName();}
			    System.out.println("New speciality:");
				String newSpecialty= reader.readLine();
					if(newSpecialty.equals("")) {
						newSpecialty= d.getSpecialty();}
		        System.out.println("New path of the picture:");
		        String newfileName = reader.readLine();
				if(!newfileName.equals("none")){
					File photopath = new File(newfileName);
					InputStream streamBlob = new FileInputStream(photopath);
					 bytesBlob = new byte[streamBlob.available()];
					streamBlob.read(bytesBlob);
					streamBlob.close();
					System.out.println("dale");}
				if(newfileName.equals("")) {
					bytesBlob=d.getPhoto();
				}
				else {
					bytesBlob = null;}
		        em.getTransaction().begin();
			    d.setName(newName);
				d.setSpecialty(newSpecialty);
				d.setPhoto(bytesBlob);
			     em.getTransaction().commit();
			}catch(IOException e) {
				e.printStackTrace();}
		}
		
		public void updateNurse() {
			listNurses();
			System.out.print("Choose nurse to modify. Type its id:");
			try {
				String id=reader.readLine();
				int n_id = Integer.parseInt(id);
    			while(!onlyContainsNumbers(id)|| !nursesIds().contains(n_id)) {
    				System.out.println("Insert a valid nurse id:");
        			 id=reader.readLine();
        			 n_id= Integer.parseInt(id);
    			}
				Nurse n = getNurse(n_id);		
			    System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= n.getName();}
			    System.out.println("New speciality:");
				String newSpecialty= reader.readLine();
					if(newSpecialty.equals("")) {
						newSpecialty= n.getSpecialty();}
		        em.getTransaction().begin();
			    n.setName(newName);
				n.setSpecialty(newSpecialty);
			     em.getTransaction().commit();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	    public void updateAvailabilityDoctor() {
	    	listDoctors();
			System.out.print("Choose doctor to modify. Type its id:");
			try {
			int d_id = Integer.parseInt(reader.readLine());
			Doctor d = getDoctor(d_id);
			System.out.println("It is available?(write yes or no): ");
		    String yes_no = reader.readLine();
		    boolean available;
			 boolean newAvailability=d.getAvailability();
		    if(yes_no.equals("YES")||yes_no.equals("yes")||yes_no.equals("true")) {
            	available=true;
            	if(available!=d.getAvailability()) {
            	newAvailability=true;}}
            if(yes_no.equals("NO")||yes_no.equals("no")||yes_no.equals("false")) {
            	available=false;
            	if(available!=d.getAvailability()) {
            	newAvailability=false;}
            }
            em.getTransaction().begin();
			d.setAvailability(newAvailability);
		    em.getTransaction().commit();
			
			}catch(IOException e) {
				e.printStackTrace();
			}	
	    }
		
	    public void updateAvailabilityNurse() {
	    	listNurses();
			System.out.print("Choose nurse to modify. Type its id:");
			try {
			int n_id = Integer.parseInt(reader.readLine());
			Nurse n = getNurse(n_id);
			System.out.println("It is available?(write yes or no): ");
		    String yes_no = reader.readLine();
		    boolean available;
			 boolean newAvailability=n.getAvailability();
		    if(yes_no.equals("YES")||yes_no.equals("yes")||yes_no.equals("true")) {
            	available=true;
            	if(available!=n.getAvailability()) {
            	newAvailability=true;}}
            if(yes_no.equals("NO")||yes_no.equals("no")||yes_no.equals("false")) {
            	available=false;
            	if(available!=n.getAvailability()) {
            	newAvailability=false;}
            }
            
            em.getTransaction().begin();
			n.setAvailability(newAvailability);
		     em.getTransaction().commit();
			
			}catch(IOException e) {
				e.printStackTrace();
			}	
	    }
	    
		
		public void updateBox() {
			listBoxes();
			System.out.print("Choose box to modify. Type its id:");
			try {			
				String id=reader.readLine();
				int box_id = Integer.parseInt(id);
    			while(!onlyContainsNumbers(id)|| !boxesIds().contains(box_id)) {
    				System.out.println("Insert a valid nurse id:");
        			 id=reader.readLine();
        			 box_id= Integer.parseInt(id);
    			}
				Box b = getBox(box_id);
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
				e.printStackTrace();}
		}
			
		public void updateDrug() {
			listDrugs();
			System.out.print("Choose drug to modify. Type its id:");
			try {			
				String id=reader.readLine();
				int drug_id = Integer.parseInt(id);
    			while(!onlyContainsNumbers(id)|| !drugsIds().contains(drug_id)) {
    				System.out.println("Insert a valid nurse id:");
        			 id=reader.readLine();
        			 drug_id= Integer.parseInt(id);
    			}
				Drug d = getDrug(drug_id);
				System.out.println("new name: ");
				String newName= reader.readLine();
				if(newName.equals("")) {
					newName= d.getName();}        
				  em.getTransaction().begin();
		          d.setName(newName);
				  em.getTransaction().commit();
			}catch(IOException e) {
				e.printStackTrace();}}
		
		public void showPicture(byte[] photoblob) {
			ByteArrayInputStream blobIn = new ByteArrayInputStream(photoblob);
			if (true) {
				ImageWindow window = new ImageWindow();
				window.showBlob(blobIn);}
			
		}
		
	
		
		private boolean onlyContainsNumbers (String text) {
		    try {
		        Long.parseLong(text);
		    } catch (NumberFormatException ex) {
		        return false;
		    }
		    return true;
		} 
		
		private boolean onlyContainsDouble (String text) {
		    try {
		        Double.parseDouble(text);
		    } catch (NumberFormatException ex) {
		        return false;
		    }
		    return true;
		}
		
		public List<Integer> patientsIds (){
			List<Integer> listId= new ArrayList<Integer>();
			
			Query q1 = em.createNativeQuery("SELECT * FROM Patients", Patient.class);
			List<Patient> pats = (List<Patient>) q1.getResultList();
			for (Patient pat : pats) {
				listId.add(pat.getSSN());}
			 	return listId;
		}
		
		public List<Integer> admissionsIds (){
			
			List<Integer> listId= new ArrayList<Integer>();
			try {	
			List<Admission> admList= new ArrayList<Admission>();
			Query q =em.createNativeQuery("SELECT * FROM Admissions", Admission.class);
			admList= (List<Admission>) q.getResultList();
			for (Admission adm: admList) {
				listId.add(adm.getId());
			}
			
			}
		catch(Exception e) {
			e.printStackTrace();
		}
			 	return listId;
		}
		
		public List<Integer> doctorsIds (){
			List<Integer> listId= new ArrayList<Integer>();
			try {	
			List<Doctor> docList= new ArrayList<Doctor>();
			Query q =em.createNativeQuery("SELECT * FROM Doctors ", Doctor.class);
			docList= (List<Doctor>) q.getResultList();
			for (Doctor doc: docList) {
				listId.add(doc.getId());
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
			 	return listId;
		}
		
		public List<Integer> nursesIds (){
			List<Integer> listId= new ArrayList<Integer>();
			try {	
			List<Nurse> nurList= new ArrayList<Nurse>();
			Query q =em.createNativeQuery("SELECT * FROM Nurses ", Nurse.class);
			nurList= (List<Nurse>) q.getResultList();
			for (Nurse nur: nurList) {
				listId.add(nur.getId());
			}}
		catch(Exception e) {
			e.printStackTrace();
		}
			 	return listId;
		}
		
		public List<Integer> boxesIds (){
			List<Integer> listId= new ArrayList<Integer>();
			try {	
			List<Box> boxList= new ArrayList<Box>();
			Query q =em.createNativeQuery("SELECT * FROM Boxes ", Box.class);
			boxList= (List<Box>) q.getResultList();
			for (Box b: boxList) {
				listId.add(b.getId());
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
			 	return listId;
		}
		
		public List<Integer> drugsIds (){
			List<Integer> listId= new ArrayList<Integer>();
			try {	
			List<Drug> drugList= new ArrayList<Drug>();
			Query q =em.createNativeQuery("SELECT * FROM Drugs ", Integer.class);
			drugList= (List<Drug>) q.getResultList();
			for (Drug d: drugList) {
				listId.add(d.getId());
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
			 	return listId;
		}
		
		
		

	}


