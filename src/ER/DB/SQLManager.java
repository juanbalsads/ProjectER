package ER.DB;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

import ER.POJOS.*;



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
					"(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					"name TEXT NOT NULL, " + 
					"weight REAL, " + 
					"height REAL, " + 
					"genre TEXT, " + 
					"dob DATE) " ;
			stmt1.executeUpdate(sql1);
			stmt1.close();
			
			Statement stmt2=c.createStatement();
			String sql2= "CREATE TABLE Doctors " + 
					"(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					"name TEXT NOT NULL, " + 
					"speciality TEXT NOT NULL)";
			stmt2.executeUpdate(sql2);
			stmt2.close();
			
			Statement stmt3= c.createStatement();
			String sql3= "CREATE TABLE Nurses " + 
					"(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					"name TEXT NOT NULL, " + 
					"speciality TEXT NOT NULL) "; 
			stmt3.executeUpdate(sql3);
			stmt3.close();
			
			Statement stmt4= c.createStatement();
			String sql4= "CREATE TABLE Devices " + 
					"(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					"name TEXT, " + 
					"quantity INTEGER DEFAULT 0)";
			stmt4.executeUpdate(sql4);
			stmt4.close();
			
			Statement stmt5= c.createStatement();
			String sql5= "CREATE TABLE Admission " + 
					"(id INTEGER PRIMARY KEY, " + 
					"arrival_time DATETIME, " + 
					"symptoms TEXT, " + 
					"test TEXT) ";
			stmt5.executeUpdate(sql5);
			stmt5.close();
			
			Statement stmt6= c.createStatement();
			String sql6= "CREATE TABLE Allergies " + 
					"(id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					"name TEXT NOT NULL) ";
			stmt6.executeUpdate(sql6);
			stmt6.close();
			
			Statement stmt7= c.createStatement();
			String sql7= "CREATE TABLE Admission_Doctor " + 
					"(admission INTEGER REFERENCES Admission(id), " + 
					"doctor INTEGER REFERENCES Doctors(id), " + 
					"PRIMARY KEY (admission, doctor)) ";
			stmt7.executeUpdate(sql7);
			stmt7.close();
			
			Statement stmt8= c.createStatement();
			String sql8= "CREATE TABLE Admission_Nurses " + 
					"(admission INTEGER REFERENCES Admission(id_number), " + 
					"nurse INTEGER REFERENCES Nurses(id), " + 
					"PRIMARY KEY (admission, nurse)) ";
			stmt8.executeUpdate(sql8);
			stmt8.close();
			
			Statement stmt9= c.createStatement();
			String sql9= "CREATE TABLE Admission_Devices " + 
					"(admission INTEGER REFERENCES Admission(id), " + 
					"resources_equipment INTEGER REFERENCES Devices(id), " + 
					"quantity INTEGER, " + 
					"PRIMARY KEY (admission,resources_equipment )) ";
			stmt9.executeUpdate(sql9);
			stmt9.close();
			
			Statement stmt10= c.createStatement();
			String sql10= "CREATE TABLE Patient_Allergies " + 
					"(patient INTERGER REFERENCES Patient(id), " + 
					"allergies TEXT REFERENCES Allergies(id)) ";
			stmt10.executeUpdate(sql10);
			stmt10.close();
			
			Statement stmt11= c.createStatement();
			String sql11= "CREATE TABLE Room " + 
					"(room INTEGER PRIMARY KEY AUTOINCREMENT ";
			stmt11.executeUpdate(sql11);
			stmt11.close();
		 
		 } 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The tables were already created"); }  }
	 
	 public void insertPatient(Patient p) {
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
	 
	 public void insertDoctor(Doctor d) {
		 try {
		 Statement stmt1 = c.createStatement();
			String sql1 = "INSERT INTO Doctors (id, name, specialty) "
					+ "VALUES ('" + d.getId()+ "', '" + d.getName()+"', '" +d.getSpecialty()+"');";
			stmt1.executeUpdate(sql1);
			stmt1.close();} 
		 catch (Exception e) {
				e.printStackTrace();} }
	 
	 public void insertNurses(Nurse n) {
		 try {
		 Statement stmt1 = c.createStatement();
			String sql1 = "INSERT INTO Nurses (id, name, specialty) "
					+ "VALUES ('" + n.getId()+ "', '" + n.getName()+"', '" +n.getSpecialty()+"');";
			stmt1.executeUpdate(sql1);
			stmt1.close();} 
		 catch (Exception e) {
				e.printStackTrace();} }
	 
	 public void insertDevices(Device d) {
		 try {
		 Statement stmt1 = c.createStatement();
			String sql1 = "INSERT INTO Devices (id, name, quantity) "
					+ "VALUES ('" + d.getId()+ "', '" + d.getName()+"', '" +d.getQuantity()+"');";
			stmt1.executeUpdate(sql1);
			stmt1.close();} 
		 catch (Exception e) {
				e.printStackTrace();} }
	 
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
		 
	public void insertDevice(Device d) {
			 try {
			 Statement stmt1 = c.createStatement();
				String sql1 = "INSERT INTO Devices (id, name) "
						+ "VALUES ('" + d.getId()+ "', '" + d.getName()+"');";
				stmt1.executeUpdate(sql1);
				stmt1.close();}
		 catch (Exception e) {
				e.printStackTrace();}}
	
	public void insertRoom(Room r) {
		 try {
		 Statement stmt1 = c.createStatement();
			String sql1 = "INSERT INTO Room (id) "
					+ "VALUES ('" + r.getId()+ "');";
			stmt1.executeUpdate(sql1);
			stmt1.close();}
	 catch (Exception e) {
			e.printStackTrace();}}
	
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
					System.out.println(admission);
				}
				rs.close();
				stmt1.close();
			 }
		 catch (Exception e) {
				e.printStackTrace();}}
	
	public void selectAllergies() {
		 try {
			 Statement stmt1 = c.createStatement();
				String sql1 = "SELECT * FROM Allergies";
				ResultSet rs = stmt1.executeQuery(sql1);
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					Allergy allergy = new Allergy(id, name);
					System.out.println(allergy);
				}
				rs.close();
				stmt1.close();
			 }
		 catch (Exception e) {
				e.printStackTrace();}}
			 
		 
	 
}
