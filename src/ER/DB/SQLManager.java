package ER.DB;
import java.sql.Connection;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.io.*;
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
	 
	 
	 
	 public SQLManager() {
		super();
		connect();
	}


	public boolean connect() {
	 try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/ER.db");
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
		 String sql1= "CREATE TABLE patients " + 
		 "(SSN INTEGER PRIMARY KEY, " + 
		 "name TEXT NOT NULL, " + 
		 "weight REAL, " + 
		 "height REAL, " + 
		 "genre TEXT, " + 
		 "dob DATE, "+ 
		 "blood_type TEXT) ";
		 stmt1.executeUpdate(sql1);
		 stmt1.close();
		 Statement stmt2=c.createStatement();
		 String sql2= "CREATE TABLE Doctors " + 
		 "(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
		 "name TEXT NOT NULL, " + 
		 "speciality TEXT NOT NULL" +
		 "availability BOOLEAN )";
		 stmt2.executeUpdate(sql2);
		 stmt2.close();
		 Statement stmt3= c.createStatement();
		 String sql3= "CREATE TABLE Nurses " + 
		 "(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
		 "name TEXT NOT NULL, " + 
		 "speciality TEXT NOT NULL, " +
		 "availability BOOLEAN )";
		 stmt3.executeUpdate(sql3);
		 stmt3.close();
		 Statement stmt11= c.createStatement();
		 String sql11= "CREATE TABLE Room " + 
		 "(room INTEGER PRIMARY KEY AUTOINCREMENT, " +
		 "availability BOOLEAN )";
		 stmt11.executeUpdate(sql11);
		 stmt11.close();
		 Statement stmt5= c.createStatement();
		 String sql5= "CREATE TABLE Admission " + 
		 "(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
		 "arrival_time DATETIME, " + 
		 "symptoms TEXT, " + 
		 "test TEXT, " +
		 "release BOOLEAN, " +
		 "doctors INTEGER REFERENCES Doctors(id), " +
		 "nurses INTEGER REFERENCES Nurses(id)) ";
		 stmt5.executeUpdate(sql5);
		 stmt5.close();
		 Statement stmt6= c.createStatement();
		 String sql6= "CREATE TABLE Drugs " + 
		 "(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
		 "name TEXT NOT NULL) ";
		 stmt6.executeUpdate(sql6);
		 stmt6.close();
		 Statement stmt10= c.createStatement();
		 String sql10= "CREATE TABLE Patient_Drugs " + 
		 "(patient INTERGER REFERENCES Patient(SSN), " + 
		 "drug TEXT REFERENCES drugs(id), " +
		 "PRIMARY KEY (patient, drug))";
		 stmt10.executeUpdate(sql10);
		 stmt10.close();
		 Statement stmt12= c.createStatement();
		 String sql12= "CREATE TABLE Admission_Drugs " + 
		 "(admission INTEGER REFERENCES Admission(id) , " +
		 "drug INTEGER REFERENCES Drugs(id), " +
		 "dosage DOUBLE, "+
		 "PRIMARY KEY (admission, drug)) ";
		 stmt12.executeUpdate(sql12);
		 stmt12.close(); 
		  
		 }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The tables were already created"); }  }
	 
/*----------------------------------ASK METHODS--------------------------------------*/	
	 
	 //ASK PATIENT
	 
	/* public Patient askPatient() {
		 try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\nInsert the patient's name:");
				String name = reader.readLine();
			System.out.println("\nInsert weight:");
				Double weight = Double.parseDouble(reader.readLine());
			System.out.println("\nInsert height(meters):");
				Double height = Double.parseDouble(reader.readLine());
			System.out.println("\nInsert genre: ");
				String genre = reader.readLine();
			System.out.println("\nInsert date of birth: ");
				String dob = reader.readLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate date = LocalDate.parse(dob, formatter);
			Patient p= new Patient (name, weight, height, genre, date);
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
			//Doctor d= new Doctor (name, speciality);
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
			Nurse n= new Nurse (name, speciality);
			return n;
		 } 
		 catch (Exception e) {
				e.printStackTrace();
				return null;}}
	 
	 /*
	 

/*---------------------------------INSERT METHODS--------------------------------------*/	 
	 
	 //INSERT PATIENTS
	 
	/* public void insertPatient(Patient p) {
		 try {
			 String sql = "INSERT INTO patients (name, weight , height , genre, dob) "
						+ "VALUES (?,?,?,?,?);";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1, p.getName());
				prep.setDouble(2, p.getWeight());
				prep.setDouble(3, p.getHeight());
				prep.setString(4, p.getGenre());
				prep.setDate(5, Date.valueOf(p.getDob()));
				prep.executeUpdate();
				prep.close();
		 } 
		 catch (Exception e) {
				e.printStackTrace();} }
	 
	 //INSERT DOCTORS
	 
	 public void insertDoctor(Doctor d) {
		 try {
			 	Statement stmt1 = c.createStatement();
			 	String sql1 = "INSERT INTO Doctors (id, name, specialty) "
					+ "VALUES ('" + d.getId()+ "', '" + d.getName()+"', '" +d.getSpecialty()+"');";
			 	stmt1.executeUpdate(sql1);
			 	stmt1.close();} 
		 catch (Exception e) {
				e.printStackTrace();} }
	 
	 //INSERT NURSES
	 
	 public void insertNurses(Nurse n) {
		 try {
			 	Statement stmt1 = c.createStatement();
			 	String sql1 = "INSERT INTO Nurses (id, name, specialty) "
					+ "VALUES ('" + n.getId()+ "', '" + n.getName()+"', '" +n.getSpecialty()+"');";
			 	stmt1.executeUpdate(sql1);
			 	stmt1.close();} 
		 catch (Exception e) {
				e.printStackTrace();} }
	 
	 //INSERT DEVICES
	 
	 public void insertDevices(Device d) {
		 try {
			 	Statement stmt1 = c.createStatement();
			 	String sql1 = "INSERT INTO Devices (id, name, quantity) "
					+ "VALUES ('" + d.getId()+ "', '" + d.getName()+"', '" +d.getQuantity()+"');";
			 	stmt1.executeUpdate(sql1);
			 	stmt1.close();} 
		 catch (Exception e) {
				e.printStackTrace();} }
	 
	 //INSERT ADMISSION
	 
	 public void insertAdmission(Admission a) {
		 try {
			 	String sql = "INSERT INTO Admission (id, arrival_time , symptoms , test) "
						+ "VALUES (?,?,?,?);";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, a.getId());
				prep.setDate(2, Date.valueOf(a.getArrivalTime()));
				prep.setString(3, a.getSymptoms());
				prep.setString(4, a.getTests());
				prep.executeUpdate();
				prep.close();
				Statement stmt1 = c.createStatement();
				String sql1 = "INSERT INTO Admission (id, arrival_time, symptoms, test) "
					+ "VALUES ('" + a.getId()+ "', '" + a.getArrivalTime()+"', '" +a.getSymptoms()+"', '"+ a.getTests()+"');";
				stmt1.executeUpdate(sql1);
				stmt1.close();}
		 catch (Exception e) {
				e.printStackTrace();}}
		 
	 //INSERT ALLERGY
	 
		public void insertDevice(Device d) {
			 try {
				 Statement stmt1 = c.createStatement();
				 String sql1 = "INSERT INTO Allergies (id, name) "
						+ "VALUES ('" + d.getId()+ "', '" + d.getName()+"');";
				 stmt1.executeUpdate(sql1);
				 stmt1.close();}
		 catch (Exception e) {
				e.printStackTrace();}}
	 
	 //INSERT ROOM
	 
		public void insertRoom(Room r) {
			 try {
				 Statement stmt1 = c.createStatement();
				 String sql1 = "INSERT INTO Room (id) "
						+ "VALUES ('" + r.getId()+ "');";
				 stmt1.executeUpdate(sql1);
				 stmt1.close();}
		 catch (Exception e) {
				e.printStackTrace();}} */
		
		
/*---------------------------------SELECT METHODS--------------------------------------*/		
		
	 //SELECT PATIENT
	 /*
		
	 public void selectPatients() {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM Patients";
			 ResultSet rs = stmt.executeQuery(sql); 
			 while (rs.next() ) {
				 int id = rs.getInt("id");
				 	String name = rs.getString("name");
				 	Double weight = rs.getDouble("weight");
				 	Double height = rs.getDouble("height");
				 	String genre = rs.getString("genre");
				 	LocalDate dob = rs.getDate ("dob").toLocalDate();
				 	Patient patient = new Patient (id,name,weight,height,genre,dob);
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
			 		String speciallity = rs.getString("speciallity");
			 		Doctor doctor = new Doctor (id,name,speciallity);
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
			 		String speciallity = rs.getString("speciallity");
			 		Nurse nurse = new Nurse (id,name,speciallity);
			 		System.out.println(nurse);}
			 	rs.close();
			 	stmt.close(); } 
		 catch(Exception e) {
			 e.printStackTrace(); }}
	
	 //SELECT DEVICES
	 
	 public void selectDevices() {
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM Devices";
			ResultSet rs = stmt.executeQuery(sql); 
			 	while (rs.next()) {
			 		int id = rs.getInt("id");
			 		String name = rs.getString("name");
			 		int quantity = rs.getInt("quantity");
			 		Device device = new Device (id,name,quantity);
			 		System.out.println(device);}
			 	rs.close();
			 	stmt.close();}
		 catch(Exception e) {
			 e.printStackTrace(); }}
	 
	 //SELECT ADMISSION
	 
	public void selectAdmissions() {
		try {
			Statement stmt1 = c.createStatement();
			String sql1 = "SELECT * FROM Admission";
			ResultSet rs = stmt1.executeQuery(sql1);
				while (rs.next()) {
					int id = rs.getInt("id");
					LocalDateTime arrivalTime=  rs.getTimestamp("arrival_time").toLocalDateTime();
					String symptoms = rs.getString("symptoms");
					String test = rs.getString("test");
					Admission admission = new Admission(id, arrivalTime, symptoms, test);						
					System.out.println(admission);}
				rs.close();
				stmt1.close();}
		catch (Exception e) {
			e.printStackTrace();}}
	 
	 //SELECT ALLERGIES

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
		
	//SELECT ROOM
	
	public void selectRooms() {
		 try {
			 Statement stmt1 = c.createStatement();
				String sql1 = "SELECT * FROM Room";
				ResultSet rs = stmt1.executeQuery(sql1);
				while (rs.next()) {
					int id = rs.getInt("id");
					Room room = new Room(id);
					System.out.println(room); }}
		 catch (Exception e) {
				e.printStackTrace();}}
				
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
				 	patient = new Patient (id,name,weight,height,genre,dob);}
			 	rs.close();
			 	stmt.close();
			 	return patient;}
		 catch(Exception e){
			 e.printStackTrace();
			 return null;}}
	 
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
		 
	//OBTAIN ROOM
		 
		 public Room obtainRoom(int id_room) {
			 try {
				 Statement stmt = c.createStatement();
				 String sql = "SELECT * FROM Room WHERE id= "+id_room+ " ";
				 Room room=null;
				 ResultSet rs = stmt.executeQuery(sql); 
				 while (rs.next() ) {
					 	int id = rs.getInt("id");
					 	room = new Room (id);}
				 	rs.close();
				 	stmt.close();
				 	return room;}
			 catch(Exception e){
				 e.printStackTrace();
				 return null;}}
	
	*/
/*---------------------------------DELETE METHODS--------------------------------------*/
	
	//DELETE PATIENTS	
	/*
	public void deletePatient() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose a patient to delete, type its ID: ");
				int p_id = Integer.parseInt(reader.readLine());
				String sql = "DELETE FROM patients WHERE id=?";
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
				System.out.println("Deletion finished.");}
		catch (Exception e) {
			e.printStackTrace();}}
	
*/
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
			PreparedStatement prep;
			String sql;	
			sql = "UPDATE patients SET name=?, weight=?, height=?, genre=?, dob=? WHERE id=?";
				prep = c.prepareStatement(sql);
				prep.setString(1, newName);
				prep.setDouble(2, newWeight1);
				prep.setDouble(3, newHeight1);
				prep.setString(4, newGenre);
				prep.setDate(5, Date.valueOf(newDob));
				prep.setInt(6, p_id);
				prep.executeUpdate();
			System.out.println("Update finished.");}
		catch(Exception e){
			 e.printStackTrace();}}
	
	//OBTAIN DOCTORS
	
	public void updateDoctors() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose a doctor, type its ID: ");
				int d_id = Integer.parseInt(reader.readLine());
				Doctor doctor=obtainDoctor(d_id);
			System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= doctor.getName();}
			System.out.println("New specialty:");
				String newSpecialty= reader.readLine();
					if(newSpecialty.equals("")) {
						newSpecialty= doctor.getSpecialty();}
			PreparedStatement prep;
			String sql;	
			sql = "UPDATE Doctors SET name=?, speciality=? WHERE id=?";
				prep = c.prepareStatement(sql);
				prep.setString(1, newName);
				prep.setString(4, newSpecialty);
				prep.setInt(6, d_id);
				prep.executeUpdate();
			System.out.println("Update finished.");}
		catch(Exception e){
			 e.printStackTrace();}}
	
	//OBTAIN DOCTORS
	
	public void updateNurse() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose a nurse, type its ID: ");
				int n_id = Integer.parseInt(reader.readLine());
				Nurse nurse=obtainNurse(n_id);
			System.out.println("New name:");
				String newName= reader.readLine();
					if(newName.equals("")) {
						newName= nurse.getName();}
			System.out.println("New specialty:");
				String newSpecialty= reader.readLine();
					if(newSpecialty.equals("")) {
						newSpecialty= nurse.getSpecialty();}
			PreparedStatement prep;
			String sql;	
			sql = "UPDATE Nurses SET name=?, speciality=? WHERE id=?";
				prep = c.prepareStatement(sql);
				prep.setString(1, newName);
				prep.setString(4, newSpecialty);
				prep.setInt(6, n_id);
				prep.executeUpdate();
			System.out.println("Update finished.");}
		catch(Exception e){
			 e.printStackTrace();}}

		 */
		 
		
}
