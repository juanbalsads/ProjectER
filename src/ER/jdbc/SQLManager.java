package ER.jdbc;
import java.sql.Connection;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.sql.Date;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

import ER.POJOS.*;
import java.sql.*
;

public class SQLManager {
	  Connection c;
	  BufferedReader reader;
	 
	 
	 public SQLManager() {
		super();
		connect();
	}


	public boolean connect() {
	 try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/ProjectER.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			return true;
			
			
		} catch (Exception e) {
			return false;} }
	 
	 
	 public boolean disconnect() {
		 try {  c.close();
				return true;} 
		 catch (Exception e) {
				return false; } }
	 
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
	 
	 //ASK PATIENT
	 
	 public Patient askPatient() {
		 try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
				
			Patient p= new Patient (ssn, name, weight, height, genre, dob2, bloodType);
			return p;
		 } 
		 catch (Exception e) {
				e.printStackTrace();
				return null;}}
	 
	 //ASK DOCTOR
	 
	 public Doctor askDoctor() {
		 try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Insert the doctor's name:");
				String name = reader.readLine();
			System.out.println("Insert the speciality:");
				String speciality = reader.readLine();
			Doctor d= new Doctor (name, speciality, true);
			return d;
		 } 
		 catch (Exception e) {
				e.printStackTrace();
				return null;}}
	 
	 //ASK NURSE
	 
	 public Nurse askNurse() {
		 try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Insert the nurse's name:");
				String name = reader.readLine();
			System.out.println("Insert the speciality:");
				String speciality = reader.readLine();
			Nurse n= new Nurse (name, speciality,true);
			return n;
		 } 
		 catch (Exception e) {
				e.printStackTrace();
				return null;}}
	 
	 

	 
	
	 
	// public Nurse askAdmissionDrug() {}
	 

	 
	 
/*---------------------------------INSERT METHODS--------------------------------------*/	 
	 
	 //INSERT PATIENTS
	 
	 public void insertPatient(Patient p) {
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
	 
	 public void insertDoctor(Doctor d) {
		 try {
			 String sql1 = "INSERT INTO Doctors (id, name, availability) "
						+ "VALUES (?,?,?);";
				 	PreparedStatement prep = c.prepareStatement(sql1);
				 	prep.setInt(1,d.getId());
				 	prep.setString(2,d.getName());
				 	prep.setBoolean(3,d.getAvailability());
				 	prep.executeUpdate();
				 	prep.close();} 
		 catch (Exception e) {
				e.printStackTrace();
			} }
	 
	 //INSERT NURSES
	 
	 public void insertNurses(Nurse n) {
		 try {
			 	
			 	String sql1 = "INSERT INTO Nurses (id, name, availability) "
					+ "VALUES (?,?,?);";
			 	PreparedStatement prep = c.prepareStatement(sql1);
			 	prep.setInt(1,n.getId());
			 	prep.setString(2,n.getName());
			 	prep.setBoolean(3,n.getAvailability());
			 	prep.executeUpdate();
			 	prep.close();
			 	} 
		 catch (Exception e) {
				e.printStackTrace();} }
	 
	 //INSERT PATIENT-DRUGS
	 
	 public void insertPatientAllergy(Patient p, Drug d) {
		 try {
			 	
			 	String sql1 = "INSERT INTO Patient_Dugs (patient, drug) "
					+ "VALUES (?,?);";
			 	PreparedStatement prep = c.prepareStatement(sql1);
			 	prep.setInt(1, p.getSSN());
			 	prep.setInt(2, d.getId());
			 	prep.executeUpdate();
			 	prep.close();
			 	} 
		 catch (Exception e) {
				e.printStackTrace();} }

		 
	 //INSERT DRUG
	
	 
		public void insertDrug(Drug d) {
			 try {
				 String sql1 = "INSERT INTO Drugs (id, name) "
						+ "VALUES (?,?);";
				 PreparedStatement prep = c.prepareStatement(sql1);
				 prep.setInt(1, d.getId());
				 prep.setString(2, d.getName());
				 prep.executeUpdate();
				 prep.close();
			     }
		 catch (Exception e) {
				e.printStackTrace();}
			 } 
	
	 
	 //INSERT BOX
	 
		public void insertBox() {
			 try {
				 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Write the name of the box-room: ");
				String name= reader.readLine();
				 System.out.println("traza");
				 String sql1 = "INSERT INTO Boxes(name, availability) "
						+ "VALUES (?,?);";
				 PreparedStatement prep = c.prepareStatement(sql1);
				 prep.setString(1, name);
				 prep.setBoolean(2, true);
				 prep.executeUpdate();
				 prep.close();
			     }
			 
		 catch (Exception e) {
				e.printStackTrace();}
			 } 
		
		 //INSERT ADMISSION
		 
		 public void insertAdmission(Admission a) {
			 try {
				 	String sql = "INSERT INTO Admissions (id, arrival_time , test, release, doctor, nurse, box) "
							+ "VALUES (?,?,?,?,?,?);";
					PreparedStatement prep = c.prepareStatement(sql);
					prep.setInt(1, a.getId());
					prep.setTimestamp(2, a.getArrivalTime());
					prep.setString(3, a.getTests());
					prep.setInt(4, a.getDoctor().getId());
					prep.setInt(5, a.getNurse().getId());
					prep.setInt(6, a.getBox().getId());
					prep.executeUpdate();
					prep.close(); }
			 catch (Exception e) {
					e.printStackTrace();}}
		
		//Falta el insert admission-drugs porque falta el metodo de ASK
		
/*---------------------------------SELECT METHODS--------------------------------------*/		
		
	 //SELECT PATIENT
	 
		
	 public void selectPatients() {
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
				 	Patient patient = new Patient (id,name,weight,height,genre,dob, bloodType, null);
				 	System.out.println(patient);}
			 	rs.close();
			 	stmt.close();}
		 catch(Exception e){
			 e.printStackTrace();}}
	 
	 //SELECT DOCTOR
	 
	 public void selectDoctors() {
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
	 
	 //SELECT NURSE
	 
	 public void selectNurses() {
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
	
	 

	 //-------OBTAIN DOCTOR----//
	 public Doctor obtainDoctor(int id) {
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
	 
	 //-------OBTAIN NURSE----//
	 public Nurse obtainNurse(int id) {
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
	 
	 //-------OBTAIN BOX----//
	/* public Box obtainBox(int id) {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Boxes WHERE id="+id;
			 ResultSet rs = stmt.executeQuery(sql);
			 rs.next();
			 		int idbox = rs.getInt("id");
			 		Boolean availability=rs.getBoolean("availability");
			 		Box box = new Box (idbox, availability, null);
			 	rs.close();
			 	stmt.close();
			 	return box;}
		 catch(Exception e) {
			 e.printStackTrace();
			 return null;}}*/
	 
	 //SELECT ADMISSION
	/*
	public void selectAdmissions() {
		try {
			Patient p = new Patient ();
			Statement stmt1 = c.createStatement();
			String sql1 = "SELECT * FROM Admissions";
			ResultSet rs = stmt1.executeQuery(sql1);
				while (rs.next()) {
					int id = rs.getInt("id");
					Date arrivalTime=  rs.getDate("arrival_time");
					String test = rs.getString("test");
					boolean release=rs.getBoolean("release");
					int doctorID= rs.getInt("doctor");
					Doctor d= obtainDoctor(doctorID);
					int nurseID= rs.getInt("nurse");
					Nurse n= obtainNurse(nurseID);
					int boxID= rs.getInt("box");
					Box b= obtainBox(boxID);
			
					Admission admission = new Admission(id, null, arrivalTime, test, release, n, d, b );						
					System.out.println(admission);}
				rs.close();
				stmt1.close();}
		catch (Exception e) {
			e.printStackTrace();}}*/

	/* //SELECT ALLERGIES

	public void selectAllergies() {
		try {
			Statement stmt1 = c.createStatement();
			String sql1 = "SELECT * FROM Allergies";
			ResultSet rs = stmt1.executeQuery(sql1);
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					Allergy allergy = new Allergy(id, name);
					System.out.println(allergy);}
				rs.close();
				stmt1.close();}
		catch (Exception e) {
			e.printStackTrace();}}
	*/	
	//SELECT BOX
	
	/*
	public void selectRooms() {
		 try {
			 Statement stmt1 = c.createStatement();
				String sql1 = "SELECT * FROM Boxes";
				ResultSet rs = stmt1.executeQuery(sql1);
				while (rs.next()) {
					int id = rs.getInt("id");
					boolean availability = rs.getBoolean("availability");
					System.out.println("Write the id of the admission: ");
					reader = new BufferedReader (new InputStreamReader(System.in));
					int admission_id = Integer.parseInt(reader.readLine());
					Admission a = new Admission (admission_id);
					Box b = new Box(id,availability,a);
					System.out.println(b); }
				}
		 catch (Exception e) {
				e.printStackTrace();
				}
	}
			
		*/		
	 
	
/*---------------------------------OBTAIN METHODS--------------------------------------*/
	
	//OBTAIN PATIENTS
	
	 /*
	public Patient obtainPatient(int id_patient) {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM patients WHERE id= "+id_patient+ " ";
			 Patient patient=null;
			 ResultSet rs = stmt.executeQuery(sql); 
			 while (rs.next() ) {
				 	int id = rs.getInt("id");
				 	String name = rs.getString("name");
				 	Double weight = rs.getDouble("weight");
				 	Double height = rs.getDouble("height");
				 	String genre = rs.getString("genre");
				 	LocalDate dob = rs.getDate ("dob").toLocalDate();
				 	String bloodType = rs.getString("blood_type");
				 	patient = new Patient (id,name,weight,height,genre,dob);}
			 	rs.close();
			 	stmt.close();
			 	return patient;}
		 catch(Exception e){
			 e.printStackTrace();
			 return null;}}
	 /*
	//OBTAIN DOCTOR
	 
	 public Doctor obtainDoctor(int id_doctor) {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Doctors WHERE id= "+id_doctor+ " ";
			 Doctor doctor=null;
			 ResultSet rs = stmt.executeQuery(sql); 
			 while (rs.next() ) {
				 	int id = rs.getInt("id");
				 	String name = rs.getString("name");
				 	String speciality = rs.getString("speciality");
				 	doctor = new Doctor (id,name,speciality);}
			 	rs.close();
			 	stmt.close();
			 	return doctor;}
		 catch(Exception e){
			 e.printStackTrace();
			 return null;}}
	 
	 //OBTAIN NURSE
	 
	 public Nurse obtainNurse(int id_nurse) {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Nurses WHERE id= "+id_nurse+ " ";
			 Nurse nurse=null;
			 ResultSet rs = stmt.executeQuery(sql); 
			 while (rs.next() ) {
				 	int id = rs.getInt("id");
				 	String name = rs.getString("name");
				 	String speciality = rs.getString("speciality");
				 	nurse = new Nurse (id,name,speciality);}
			 	rs.close();
			 	stmt.close();
			 	return nurse;}
		 catch(Exception e){
			 e.printStackTrace();
			 return null;}}
	 
	 //OBTAIN DEVICE
	 
	 public Device obtainDevice(int id_device) {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Devices WHERE id= "+id_device+ " ";
			 Device device=null;
			 ResultSet rs = stmt.executeQuery(sql); 
			 while (rs.next() ) {
				 	int id = rs.getInt("id");
				 	String name = rs.getString("name");
				 	int quantity = rs.getInt("quantity");
				 	device = new Device (id,name,quantity);}
			 	rs.close();
			 	stmt.close();
			 	return device;}
		 catch(Exception e){
			 e.printStackTrace();
			 return null;}}
	 
	 //OBTAIN ADMISSION
	 
		public Admission obtainAdmission(int id_admission) {
		 try {
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM Admission WHERE id= "+id_admission+ " ";
			Admission admission=null;
			ResultSet rs = stmt.executeQuery(sql); 
				while (rs.next() ) {
				 	int id = rs.getInt("id");
				 	LocalDateTime arrivalTime=  rs.getTimestamp("arrival_time").toLocalDateTime();
				 	String symptoms = rs.getString("symptoms");
				 	String test = rs.getString("test");
				 	admission = new Admission (id,arrivalTime,symptoms,test);}
			 	rs.close();
			 	stmt.close();
			 	return admission;}
		catch(Exception e){
			 e.printStackTrace();
				 return null;}}
		
	//OBTAIN ALLERGIES
		
		 public Allergy obtainAllergy(int id_allergy) {
			 try {
				 Statement stmt = c.createStatement();
				 String sql = "SELECT * FROM Allergies WHERE id= "+id_allergy+ " ";
				 Allergy allergy=null;
				 ResultSet rs = stmt.executeQuery(sql); 
				 while (rs.next() ) {
					 	int id = rs.getInt("id");
					 	String name = rs.getString("name");
					 	allergy = new Allergy (id,name);}
				 	rs.close();
				 	stmt.close();
				 	return allergy;}
			 catch(Exception e){
				 e.printStackTrace();
				 return null;}}
	*/	 
	//OBTAIN BOX
		/*8 
		 public Box obtainRoom(int id_box) {
			 try {
				 Statement stmt = c.createStatement();
				 String sql = "SELECT * FROM Room WHERE id= "+id_room+ " ";
				 Box box=null;
				 Admission admission = null;
				 ResultSet rs = stmt.executeQuery(sql); 
				 while (rs.next() ) {
					 	int box_id = rs.getInt("box");
					 	boolean availability = rs.getBoolean("availability");
					 	
					 	
					 	box = new Box (box_id,availability);
					 	}
				 	rs.close();
				 	stmt.close();
				 	return room;}
			 catch(Exception e){
				 e.printStackTrace();
				 return null;}}
	*/
	
/*---------------------------------DELETE METHODS--------------------------------------*/
	
	//DELETE PATIENTS	
	
	public void deletePatient() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose a patient to delete, type its ID: ");
				selectPatients();
				int p_id = Integer.parseInt(reader.readLine());
				String sql = "DELETE FROM patients WHERE ssn=?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, p_id);
				prep.executeUpdate();
				System.out.println("Deletion finished.");}
		catch (Exception e) {
			e.printStackTrace();}}

	//DELETE DOCTORS
	
	public void deleteDoctors() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
	
	public void deleteNurses() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
	

/*---------------------------------UPDATE METHODS--------------------------------------*/
	
	//UPDATE PATIENTS				 
	/*
	public void updatePatient() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose a patient, type its ID: ");
				int p_id = Integer.parseInt(reader.readLine());
				Patient patient=obtainPatient(p_id);
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
					if(newDob.equals("")) {
						newDob= patient.getDob();}
			System.out.println("New bloodtype:");
			    String newBloodType = reader.readLine();
			        if(newBloodType.equals("")){
			        	newBloodType=patient.getBloodType();
			        }
			
			PreparedStatement prep;
			String sql;	
			sql = "UPDATE patients SET name=?, weight=?, height=?, genre=?, dob=?, blood_type=? WHERE id=?";
				prep = c.prepareStatement(sql);
				prep.setString(1, newName);
				prep.setDouble(2, newWeight1);
				prep.setDouble(3, newHeight1);
				prep.setString(4, newGenre);
				prep.setDate(5, Date.valueOf(newDob));
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
				Doctor doctor = new Doctor(n_id);
				
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
			    Boolean availability = true;
		            if(yes_no.equals("YES")) {
		            	availability = true;
		            }
		            if(yes_no.equals("NO")) {
		            	availability = false;
		            }
			PreparedStatement prep;
			String sql;	
			sql = "UPDATE Doctor SET name=?, speciality=?, availability=? WHERE id=?";
				prep = c.prepareStatement(sql);
				prep.setString(1, newName);
				prep.setString(2, newSpecialty);
				prep.setBoolean(3, availability);
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
				Nurse nurse = new Nurse(n_id);
				
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
			    Boolean availability = true;
		            if(yes_no.equals("YES")) {
		            	availability = true;
		            }
		            if(yes_no.equals("NO")) {
		            	availability = false;
		            }
			PreparedStatement prep;
			String sql;	
			sql = "UPDATE Nurses SET name=?, speciality=?, availability=? WHERE id=?";
				prep = c.prepareStatement(sql);
				prep.setString(1, newName);
				prep.setString(2, newSpecialty);
				prep.setBoolean(3, availability);
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
				 String sql="UPDATE Box SET box=?, availability = ?";
				 PreparedStatement prep = c.prepareStatement(sql);
				 System.out.println("Write if the box is available or occupied: ");
				 String yes_no = reader.readLine();
				    Boolean availability = true;
			            if(yes_no.equals("YES")) {
			            	availability = true;
			            }
			            if(yes_no.equals("NO")) {
			            	availability = false;
			            }
			     prep.setInt(1, box_id);
				 prep.setBoolean(2, availability);
				 prep.executeUpdate();
				 System.out.println("Update finished.");
				 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }}
		 
		*/
}
