package ER.jdbc;
import java.util.*;

import javax.persistence.Query;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.security.cert.CertPathValidatorException.Reason;
import java.sql.Date;
import java.sql.*;
import java.time.*;

import ER.POJOS.*;
import Manager.Manager;

import java.sql.*
;

public class JDBCManager implements Manager{
	  Connection c;
	  BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	 
	 
	 public JDBCManager() {
		super();
		connect();
	}


	public void connect() {
	 try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/ProjectER.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
		} catch (Exception e) {
			e.printStackTrace();;} }
	 
	 
	 public void disconnect() {
		 try {  c.close();
				 } 
		 catch (Exception e) {
				e.printStackTrace(); } }
	 
	 public void createTables() {
		 try {
		 Statement stmt1=c.createStatement();
		 String sql1= "CREATE TABLE if not exists Patients " + 
		 "(ssn INTEGER PRIMARY KEY, " + 
		 "name TEXT NOT NULL, " + 
		 "weight REAL, " + 
		 "height REAL, " + 
		 "genre TEXT, " + 
		 "dob DATE, "+ 
		 "blood_type TEXT) ";
		 stmt1.executeUpdate(sql1);
		 stmt1.close();
		 Statement stmt2=c.createStatement();
		 String sql2= "CREATE TABLE if not exists Doctors " + 
		 "(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
		 "name TEXT NOT NULL, " + 
		 "speciality TEXT NOT NULL, " +
		 "photo BLOB, "+
		 "availability BOOLEAN )";
		 stmt2.executeUpdate(sql2);
		 stmt2.close();
		 Statement stmt3= c.createStatement();
		 String sql3= "CREATE TABLE if not exists Nurses " + 
		 "(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
		 "name TEXT NOT NULL, " + 
		 "speciality TEXT NOT NULL, " +
		 "availability BOOLEAN )";
		 stmt3.executeUpdate(sql3);
		 stmt3.close();
		 Statement stmt11= c.createStatement();
		 String sql11= "CREATE TABLE if not exists Boxes " + 
		 "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
		 "name TEXT NOT NULL, " +
		 "availability BOOLEAN )";
		 stmt11.executeUpdate(sql11);
		 stmt11.close();
		 Statement stmt5= c.createStatement();
		 String sql5= "CREATE TABLE if not exists Admissions " + 
		 "(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
		 "patient INTEGER REFERENCES Patients(ssn), " + 
		 "arrival_time TIMESTAMP, " + 
		 "test TEXT, " +
		 "release BOOLEAN, " +
		 "doctor INTEGER REFERENCES Doctors(id), " +
		 "nurse INTEGER REFERENCES Nurses(id), " +
		 "box INTEGER REFERENCES Boxes(id)) ";
		 stmt5.executeUpdate(sql5);
		 stmt5.close();
		 Statement stmt6= c.createStatement();
		 String sql6= "CREATE TABLE if not exists Drugs " + 
		 "(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
		 "name TEXT NOT NULL) ";
		 stmt6.executeUpdate(sql6);
		 stmt6.close();
		 Statement stmt12= c.createStatement();
		 String sql12= "CREATE TABLE if not exists Admission_Drugs " + 
		 "(admission INTEGER REFERENCES Admission(id) , " +
		 "drug INTEGER REFERENCES Drugs(id), " +
		 "dosage DOUBLE, "+
		 "PRIMARY KEY (admission, drug)) ";
		 stmt12.executeUpdate(sql12);
		 stmt12.close(); 
		 
		 Statement stmtSeq = c.createStatement();
			String sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('Patients', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('Doctors', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('Nurses', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('Admissions', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('Boxes', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			sqlSeq = "INSERT INTO sqlite_sequence (name, seq) VALUES ('Drugs', 1)";
			stmtSeq.executeUpdate(sqlSeq);
			stmtSeq.close();
		  
		 }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); }  }
	 
/*----------------------------------ASK METHODS--------------------------------------*/	
	 
		public Patient askForPatient() {
			Patient pat = null;
			try {
      			System.out.println("Please, input the patient data: ");
    			System.out.println("Insert the patient's ssn:");
    			String id=reader.readLine();
    			int ssn = Integer.parseInt(id);
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
				Patient p= getPatient(SSD);
				System.out.print("Doctors id in charge:\n");
				listDoctors();
				int doctor_id = Integer.parseInt(reader.readLine());
				Doctor doctor = getDoctor(doctor_id);
				System.out.print("Nurses id in charge:\n");
				listNurses();
				int nurse_id =  Integer.parseInt(reader.readLine());
				Nurse nurse = getNurse(nurse_id);
				System.out.print("Box id:\n");
				listBoxes();
				int box_id = Integer.parseInt(reader.readLine());
				Box box = getBox(box_id);	
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
	 
	
	 

	 
	 
/*---------------------------------INSERT METHODS--------------------------------------*/	 
	 
	 //INSERT PATIENTS
	 
	 public void createPatient() {
		 Patient p= askForPatient();
		 try {
			 String sql = "INSERT INTO Patients (ssn, name, weight, height, genre, dob, blood_type) "
						+ "VALUES (?,?,?,?,?,?,?);";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, p.getSSN());
				prep.setString(2, p.getName());
				prep.setDouble(3, p.getWeight());
				prep.setDouble(4, p.getHeight());
				prep.setString(5, p.getGenre());
				prep.setDate(6, p.getDob());
				prep.setString(7, p.getBloodType());
				prep.executeUpdate();
				prep.close();
		 } 
		 catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");} }
	 
	 //INSERT DOCTORS
	 
	 public void createDoctor() {
		 Doctor d= askForDoctor();
		 try {
			 String sql1 = "INSERT INTO Doctors (name, speciality, availability) "
						+ "VALUES (?,?,?);";
				 	PreparedStatement prep = c.prepareStatement(sql1);
				 	prep.setString(1,d.getName());
				 	prep.setString(2,d.getSpecialty());
				 	prep.setBoolean(3,d.getAvailability());
				 	prep.executeUpdate();
				 	prep.close();} 
		 catch (Exception e) {
				e.printStackTrace();
			} }
	 
	 //INSERT NURSES
	 
	 public void createNurse() {
		 Nurse n= askForNurse();
		 try {	
			 	String sql1 = "INSERT INTO Nurses (name, speciality, availability) "
					+ "VALUES (?,?,?);";
			 	PreparedStatement prep = c.prepareStatement(sql1);
			 	prep.setString(1,n.getName());
			 	prep.setString(2,n.getSpecialty());
			 	prep.setBoolean(3,n.getAvailability());
			 	prep.executeUpdate();
			 	prep.close();
			 	} 
		 catch (Exception e) {
				e.printStackTrace();} }

		 
	 //INSERT DRUG
	
	 
		public void createDrug() {
			Drug d= askForDrug();
			 try {
				 String sql1 = "INSERT INTO Drugs (name) "
						+ "VALUES (?);";
				 PreparedStatement prep = c.prepareStatement(sql1);
				 prep.setString(1, d.getName());
				 prep.executeUpdate();
				 prep.close();
			     }
		 catch (Exception e) {
				e.printStackTrace();}
			 } 
	
	 
	 //INSERT BOX
	 
		public void createBox() {
			Box b= askForBox();
			 try {
				 String sql1 = "INSERT INTO Boxes (name, availability) "
						+ "VALUES (?,?);";
				 PreparedStatement prep = c.prepareStatement(sql1);
				 prep.setString(1, b.getName());
				 prep.setBoolean(2, true);
				 prep.executeUpdate();
				 prep.close();
			     }
			 
		 catch (Exception e) {
				e.printStackTrace();}
			 } 
		
		 //INSERT ADMISSION
		 
		 public void createAdmission() {
			 Admission a=askForAdmission();
			 try {
				 	String sql = "INSERT INTO Admissions (patient, arrival_time, test, doctor, nurse, box) "
							+ "VALUES (?,?,?,?,?,?);";
					PreparedStatement prep = c.prepareStatement(sql);
					prep.setInt(1, a.getPatient().getSSN());
					prep.setTimestamp(2, a.getArrivalTime());
					prep.setString(3, a.getTests());
					prep.setInt(4, a.getDoctor().getId());
					prep.setInt(5, a.getNurse().getId());
					prep.setInt(6, a.getBox().getId());
					prep.executeUpdate();
					prep.close();
					
					PreparedStatement prep2;
					String sql2;	
					sql2 = "UPDATE Boxes SET availability=? WHERE id="+a.getBox().getId();
						prep2 = c.prepareStatement(sql2);
						prep2.setBoolean(1, false);
						prep2.executeUpdate();		
			 
			 }
			 catch (Exception e) {
					e.printStackTrace();}}
		

		
/*---------------------------------LIST METHODS--------------------------------------*/		
		
		
   //LIST ADMISSION
			
			public void listAdmissions() {
				try {
					Patient p = null;
					Doctor d= null;
					Nurse n= null;
					Box b= null;
					Statement stmt1 = c.createStatement();
					String sql1 = "SELECT * FROM Admissions";
					ResultSet rs = stmt1.executeQuery(sql1);
						while (rs.next()) {
							int id = rs.getInt("id");
							int patient_id= rs.getInt("patient");
							p= getPatient(patient_id);
							Timestamp arrivalTime= rs.getTimestamp("arrival_time");
							String test= rs.getString("test");
							Boolean release= rs.getBoolean("release");
							int doctor_id= rs.getInt("doctor");
							d= getDoctor(doctor_id);
							int nurse_id= rs.getInt("nurse");
							n= getNurse(nurse_id);
							int box_id= rs.getInt("box");
							b= getBox(box_id);

							Admission admission = new Admission(id, p, arrivalTime, test, release, n, d, b );						
							System.out.println(admission);}
						rs.close();
						stmt1.close();}
				catch (Exception e) {
					e.printStackTrace();}}

	 //LIST PATIENT
	 	
	 public void listPatients() {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Patients";
			 ResultSet rs = stmt.executeQuery(sql); 
			 while (rs.next() ) {
				 int id = rs.getInt("ssn");
				 	String name = rs.getString("name");
				 	Double weight = rs.getDouble("weight");
				 	Double height = rs.getDouble("height");
				 	String genre = rs.getString("genre");
				 	Date dob = rs.getDate ("dob");
				 String bloodType= rs.getString("blood_type");	
				 	Patient patient = new Patient (id,name,weight,height,genre,dob, bloodType);
				 	System.out.println(patient);}
			 	rs.close();
			 	stmt.close();}
		 catch(Exception e){
			 e.printStackTrace();}}
	 
	 //LIST DOCTOR
	 
	 public void listDoctors() {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Doctors";
			 ResultSet rs = stmt.executeQuery(sql);
			 	while (rs.next()) {
			 		int id = rs.getInt("id");
			 		String name = rs.getString("name");
			 		String speciality = rs.getString("speciality");
			 		Boolean availability=rs.getBoolean("availability");
			 		Doctor doctor = new Doctor (id,name,speciality, availability);
			 		System.out.println(doctor);}
			 	rs.close();
			 	stmt.close();}
		 
		 catch(Exception e) {
			 e.printStackTrace();}}
	 
	 //LIST NURSE
	 
	 public void listNurses() {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Nurses";
			 ResultSet rs = stmt.executeQuery(sql);
			 	while (rs.next()) {
			 		int id = rs.getInt("id");
			 		String name = rs.getString("name");
			 		String speciality = rs.getString("speciality");
			 		Boolean availability=rs.getBoolean("availability");
			 		Nurse nurse = new Nurse (id,name,speciality,availability);
			 		System.out.println(nurse);}
			 	rs.close();
			 	stmt.close(); } 
		 catch(Exception e) {
			 e.printStackTrace(); }}
	 
	 //LIST BOX 
	 
	 public void listBoxes() {
		 try {
			 Statement stmt  = c.createStatement();
			 String sql = "SELECT * FROM Boxes";
			 ResultSet rs = stmt.executeQuery(sql);
			 while(rs.next()) {
				 int id = rs.getInt("id");
				 String name = rs.getString("name");
				 Boolean availability  = rs.getBoolean("availability");
				 Box box = new Box (id,name,availability); 
				 System.out.println(box);
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	//LIST DRUGS
	
	 public void listDrugs() {
		 try {
			 Statement stmt  = c.createStatement();
			 String sql = "SELECT * FROM Drugs";
			 ResultSet rs = stmt.executeQuery(sql);
			 while(rs.next()) {
				 int id = rs.getInt("id");
				 String name = rs.getString("name");
				 Drug d= new Drug(id, name);
				 System.out.println(d);
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 
	 /*---------------------------------READ METHODS--------------------------------------*/
	 
	 
	 public void readPatient() {
		 try {
	    System.out.print("Write the patient's SSD: \n");
	    listPatients();
			int pat_SSD = Integer.parseInt(reader.readLine());
			Patient p= getPatient(pat_SSD);
			System.out.println(p);
		 }
		 catch(Exception e) {
			 e.printStackTrace();}}
	 
	 public void readDoctor() {
		 try {
		 System.out.print("Write the doctor's id: \n");
		 listDoctors();
			int id = Integer.parseInt(reader.readLine());
			Doctor d= getDoctor(id);
			System.out.println(d);
		 }
		 catch(Exception e) {
			 e.printStackTrace();}}
	 
	 public void readNurse() {
		 try {
		 System.out.print("Write the nurse's id: \n");
		 listNurses();
			int id = Integer.parseInt(reader.readLine());
			Nurse n= getNurse(id);
			Statement stmt = c.createStatement();
			String sql = "SELECT id FROM Admissions WHERE nurse= "+id;
			ResultSet rs = stmt.executeQuery(sql);
			List <Admission> admissions= new ArrayList<Admission>();
			Admission adm=null;
			while (rs.next()) {
				adm= getAdmission(rs.getInt("id"));
				admissions.add(adm);}
			n.setAdmission(admissions);
			System.out.println(n.toString2());
		 }
		 catch(Exception e) {
			 e.printStackTrace();}}
	 
	 public void readBox() {
		 try {
		 System.out.print("Write the box's id: \n");
		 listBoxes();
			int id = Integer.parseInt(reader.readLine());
			Box b= getBox(id);
			System.out.println(b);
		 }
		 catch(Exception e) {
			 e.printStackTrace();}}
	 
	 public void readAdmission() {
		 try {
		 System.out.print("Write the admission's id: \n");
		 listAdmissions();
			int id = Integer.parseInt(reader.readLine());
			Admission a= getAdmission(id);
			System.out.println(a);
		 }
		 catch(Exception e) {
			 e.printStackTrace();}}
	 
	 
	 
	 //-------GET DOCTOR----//
	 public Doctor getDoctor(int id) {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Doctors WHERE id="+id;
			 ResultSet rs = stmt.executeQuery(sql);
			 rs.next();
			 		int iddoc = rs.getInt("id");
			 		String name = rs.getString("name");
			 		String speciality = rs.getString("speciality");
			 		Boolean availability=rs.getBoolean("availability");
			 		Doctor doctor = new Doctor (iddoc,name,speciality, availability);
			 	rs.close();
			 	stmt.close();
			 	return doctor;}
		 
		 catch(Exception e) {
			 e.printStackTrace();
			 return null;}}
	 
	 //-------GET NURSE----//
	 public Nurse getNurse(int id) {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Nurses WHERE id="+id;
			 ResultSet rs = stmt.executeQuery(sql);
			 rs.next();
			 		int idnu = rs.getInt("id");
			 		String name = rs.getString("name");
			 		String speciality = rs.getString("speciality");
			 		Boolean availability=rs.getBoolean("availability");
			 		Nurse nurse = new Nurse (idnu,name,speciality, availability);
			 	rs.close();
			 	stmt.close();
			 	return nurse;}
		 catch(Exception e) {
			 e.printStackTrace();
			 return null;}}
	 
	 //-------GET BOX----//
	 public Box getBox(int id) {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Boxes WHERE id="+id;
			 ResultSet rs = stmt.executeQuery(sql);
			 rs.next();
			 		int id_box = rs.getInt("id");
			 		String name = rs.getString("name");
			 		Boolean availability=rs.getBoolean("availability");
			 		
			 		Box box = new Box (id_box,name,availability);
			 	rs.close();
			 	stmt.close();
			 	return box;}
		 catch(Exception e) {
			 e.printStackTrace();
			 return null;}}
	 
	 
	//--------GET PATIENTS----//
	public Patient getPatient(int id_patient) {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Patients WHERE ssn= "+id_patient+ " ";
			 Patient patient=null;
			 Admission admission = null;
			 ResultSet rs = stmt.executeQuery(sql); 
			 while (rs.next() ) {
				 	int ssn = rs.getInt("ssn");
				 	String name = rs.getString("name");
				 	Double weight = rs.getDouble("weight");
				 	Double height = rs.getDouble("height");
				 	String genre = rs.getString("genre");
				 	Date dob = rs.getDate("dob");
				 	String bloodType = rs.getString("blood_type");
					patient = new Patient (ssn,name,weight,height,genre,dob,bloodType);
			 	rs.close();
			 	stmt.close();
			 	return patient;
			 }}
		 catch(Exception e){
			 e.printStackTrace();
			 return null;}
		
		 return null;}
	 
	 //-------GET ADMISSION-----//
	 
	public Admission getAdmission(int id_admission) {
		Patient p = null;
		Doctor d= null;
		Nurse n= null;
		Box b= null;
	 try {
		Statement stmt = c.createStatement();
		String sql = "SELECT * FROM Admissions WHERE id= "+id_admission+ " ";
		Admission admission=null;
		Patient patient = null;
		ResultSet rs = stmt.executeQuery(sql); 
			while (rs.next() ) {
				int id = rs.getInt("id");
				int patient_id= rs.getInt("patient");
				p= getPatient(patient_id);
				Timestamp arrivalTime= rs.getTimestamp("arrival_time");
				String test= rs.getString("test");
				Boolean release= rs.getBoolean("release");
				int doctor_id= rs.getInt("doctor");
				d= getDoctor(doctor_id);
				int nurse_id= rs.getInt("nurse");
				n= getNurse(nurse_id);
				int box_id= rs.getInt("box");
				b= getBox(box_id);
			 	admission = new Admission(id, p, arrivalTime, test, release, n, d, b );
			 	}
		 	rs.close();
		 	stmt.close();
		 	return admission;}
	catch(Exception e){
		 e.printStackTrace();
			 return null;}}


	
		
/*---------------------------------DELETE METHODS--------------------------------------*/
	
	//DELETE PATIENTS	
	
	public void deletePatient() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			listPatients();
			System.out.println("Choose a patient to delete, type its ID: ");
				int p_id = Integer.parseInt(reader.readLine());
				String sql = "DELETE FROM Patients WHERE ssn=?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, p_id);
				prep.executeUpdate();
				System.out.println("Deletion finished.");}
		catch (Exception e) {
			e.printStackTrace();}}

	//DELETE DOCTORS
	
	public void deleteDoctor() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			listDoctors();
			System.out.println("Choose a doctor to delete, type its ID: ");
				int d_id = Integer.parseInt(reader.readLine());
				String sql = "DELETE FROM Doctors WHERE id=?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, d_id);
				prep.executeUpdate();
				System.out.println("Deletion finished.");}
		catch (Exception e) {
			e.printStackTrace();}}
	
	//DELETE NURSES
	
	public void deleteNurse() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			listNurses();
			System.out.println("Choose a nurse to delete, type its ID: ");
				int n_id = Integer.parseInt(reader.readLine());
				String sql = "DELETE FROM Nurses WHERE id=?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, n_id);
				prep.executeUpdate();
				System.out.println("Deletion finished.");
			}
		catch (Exception e) {
			e.printStackTrace();}}
	
	//DELETE BOX
	
	public void deleteBox() {
		try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		listBoxes();
		System.out.println("Choose a box to delete, type its ID: ");
		int box_id= Integer.parseInt(reader.readLine());
		String sql= "DELETE FROM Boxes WHERE id=?";
		PreparedStatement prep =c.prepareStatement(sql);
		prep.setInt(1, box_id);
		prep.executeUpdate();
		System.out.println("Deletion finished.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//DELETE DRUG
	
	public void deleteDrug() {
		try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		listDrugs();
		System.out.println("Choose a drug to delete, type its ID: ");
		int drug_id= Integer.parseInt(reader.readLine());
		String sql= "DELETE FROM Drugs WHERE id=?";
		PreparedStatement prep =c.prepareStatement(sql);
		prep.setInt(1, drug_id);
		prep.executeUpdate();
		System.out.println("Deletion finished.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//DELETE ADMISSION
	
	public void deleteAdmission() {
		try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		listAdmissions();
		System.out.println("Choose an admission to delete, type its ID: ");
		int adm_id= Integer.parseInt(reader.readLine());
		Admission a=getAdmission(adm_id);
		String sql= "DELETE FROM Admissions WHERE id=?";
		PreparedStatement prep =c.prepareStatement(sql);
		prep.setInt(1, adm_id);
		prep.executeUpdate();
		
		PreparedStatement prep2;
		String sql2;	
		sql2 = "UPDATE Boxes SET availability=? WHERE id="+a.getBox().getId();
			prep2 = c.prepareStatement(sql2);
			prep2.setBoolean(1, true);
			prep2.executeUpdate();	
		System.out.println("Deletion finished.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void readDrug() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updatePatient() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateAdmission() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateDrug() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateDoctor() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateNurse() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose a nurse, type its ID: ");
				int n_id = Integer.parseInt(reader.readLine());
				Nurse nurse = getNurse(n_id);
				
			System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= nurse.getName();}
			System.out.println("New specialty:");
				String newSpecialty= reader.readLine();
					if(newSpecialty.equals("")) {
						newSpecialty= nurse.getSpecialty();}
			System.out.println("It is available?(write yes or no): ");
			    String yes_no = reader.readLine();
			    boolean available;
				 boolean newAvailability=nurse.getAvailability();
			    if(yes_no.equals("YES")||yes_no.equals("yes")||yes_no.equals("true")) {
	            	available=true;
	            	if(available!=nurse.getAvailability()) {
	            	newAvailability=true;}}
	            if(yes_no.equals("NO")||yes_no.equals("no")||yes_no.equals("false")) {
	            	available=false;
	            	if(available!=nurse.getAvailability()) {
	            	newAvailability=false;}
	            }
			PreparedStatement prep;
			String sql;	
			sql = "UPDATE Nurses SET name=?, speciality=?, availability=? WHERE id=?";
				prep = c.prepareStatement(sql);
				prep.setString(1, newName);
				prep.setString(2, newSpecialty);
				prep.setBoolean(3, newAvailability);
				prep.setInt(4, n_id);
				prep.executeUpdate();
			System.out.println("Update finished.");
		}
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}


	@Override
	public void updateBox() {
		// TODO Auto-generated method stub
		
	}
	
	

/*---------------------------------UPDATE METHODS--------------------------------------*/
	
	//UPDATE PATIENTS				 
	//Creo que es mejor dejar los updates en JPA
	
	/*public void updatePatient() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose a patient, type its ID: ");
				int p_id = Integer.parseInt(reader.readLine());
				Patient patient= readPatient(p_id);
			System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= patient.getName();}
			System.out.println("New weight:");
				Double newWeight1;
				String newWeight = reader.readLine();
					if(newWeight.equals("")) {
						newWeight1= patient.getWeight();}
					else {
						newWeight1= Double.parseDouble(newWeight);}
			System.out.println("New height:");
				Double newHeight1;
				String newHeight = reader.readLine();
					if(newHeight.equals("")) {
						newHeight1= patient.getHeight();}
					else {
						newHeight1= Double.parseDouble(newHeight);}
			System.out.println("New genre:");
				String newGenre= reader.readLine();
					if(newGenre.equals("")) {
						newGenre= patient.getGenre();}
			System.out.println("New dob:");
				String newDob= reader.readLine();
				Timestamp newdob=null;
					if(newDob.equals("")) {
						DateTimeFormatter formatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	
						LocalDateTime localDateTime = LocalDateTime.parse(newDob, formatterWithTime);		
					    newdob = Timestamp.valueOf(localDateTime);}
			System.out.println("New bloodtype:");
			    String newBloodType = reader.readLine();
			        if(newBloodType.equals("")){
			        	newBloodType=patient.getBloodType();}
			
			PreparedStatement prep;
			String sql;	
			sql = "UPDATE patients SET name=?, weight=?, height=?, genre=?, dob=?, blood_type=? WHERE id=?";
				prep = c.prepareStatement(sql);
				prep.setString(1, newName);
				prep.setDouble(2, newWeight1);
				prep.setDouble(3, newHeight1);
				prep.setString(4, newGenre);
				prep.setTimestamp(5, newdob);
				prep.setInt(6, p_id);
				prep.setString(7, newBloodType);
				prep.executeUpdate();
			System.out.println("Update finished.");}
		catch(Exception e){
			 e.printStackTrace();}}
	
	
	//UPDATE DOCTORS
	public void updateDoctor() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose a doctor, type its ID: ");
				int n_id = Integer.parseInt(reader.readLine());
				Doctor doctor = readDoctor(n_id);
				
			System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= doctor.getName();}
			System.out.println("New specialty:");
				String newSpecialty= reader.readLine();
					if(newSpecialty.equals("")) {
						newSpecialty= doctor.getSpecialty();}
			System.out.println("It is available?(write yes or no): ");
			    String yes_no = reader.readLine();
			    boolean available;
				 boolean newAvailability=doctor.getAvailability();
			    if(yes_no.equals("YES")||yes_no.equals("yes")||yes_no.equals("true")) {
	            	available=true;
	            	if(available!=doctor.getAvailability()) {
	            	newAvailability=true;}}
	            if(yes_no.equals("NO")||yes_no.equals("no")||yes_no.equals("false")) {
	            	available=false;
	            	if(available!=doctor.getAvailability()) {
	            	newAvailability=false;}
	            }
			PreparedStatement prep;
			String sql;	
			sql = "UPDATE Doctor SET name=?, speciality=?, availability=? WHERE id=?";
				prep = c.prepareStatement(sql);
				prep.setString(1, newName);
				prep.setString(2, newSpecialty);
				prep.setBoolean(3, newAvailability);
				prep.setInt(4, n_id);
				prep.executeUpdate();
			System.out.println("Update finished.");}
		catch(Exception e){
			 e.printStackTrace();}}

		 
    //UPDATE NURSES
	public void updateNurse() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose a nurse, type its ID: ");
				int n_id = Integer.parseInt(reader.readLine());
				Nurse nurse = readNurse(n_id);
				
			System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= nurse.getName();}
			System.out.println("New specialty:");
				String newSpecialty= reader.readLine();
					if(newSpecialty.equals("")) {
						newSpecialty= nurse.getSpecialty();}
			System.out.println("It is available?(write yes or no): ");
			    String yes_no = reader.readLine();
			    boolean available;
				 boolean newAvailability=nurse.getAvailability();
			    if(yes_no.equals("YES")||yes_no.equals("yes")||yes_no.equals("true")) {
	            	available=true;
	            	if(available!=nurse.getAvailability()) {
	            	newAvailability=true;}}
	            if(yes_no.equals("NO")||yes_no.equals("no")||yes_no.equals("false")) {
	            	available=false;
	            	if(available!=nurse.getAvailability()) {
	            	newAvailability=false;}
	            }
			PreparedStatement prep;
			String sql;	
			sql = "UPDATE Nurses SET name=?, speciality=?, availability=? WHERE id=?";
				prep = c.prepareStatement(sql);
				prep.setString(1, newName);
				prep.setString(2, newSpecialty);
				prep.setBoolean(3, newAvailability);
				prep.setInt(4, n_id);
				prep.executeUpdate();
			System.out.println("Update finished.");}
		catch(Exception e){
			 e.printStackTrace();}}

	//UPDATE BOX
		 public void updateBox() {
			 try {
				 BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
				 System.out.println("Choose box, type its ID: ");
				 int box_id = Integer.parseInt(reader.readLine());
				 Box box= readBox(box_id);
				 boolean available;
				 boolean newAvailability=box.getAvailability();
				 String sql="UPDATE Box SET name=?, availability = ?";
				 PreparedStatement prep = c.prepareStatement(sql);
				 System.out.println("New name: ");
				 String newName = reader.readLine();
				 if(newName.equals("")) {
						newName= box.getName();}
				 System.out.println("New availability. Is it available?: ");
				 String yes_no = reader.readLine();
			            if(yes_no.equals("YES")||yes_no.equals("yes")||yes_no.equals("true")) {
			            	available=true;
			            	if(available!=box.getAvailability()) {
			            	newAvailability=true;}}
			            if(yes_no.equals("NO")||yes_no.equals("no")||yes_no.equals("false")) {
			            	available=false;
			            	if(available!=box.getAvailability()) {
			            	newAvailability=false;}
			            }
			     prep.setString(1, newName);
				 prep.setBoolean(2, newAvailability);
				 prep.executeUpdate();
				 System.out.println("Update finished.");
				 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }}
		 
		 */
			
		 
		 
		 
	
}
