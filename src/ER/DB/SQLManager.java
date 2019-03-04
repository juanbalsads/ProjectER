package ER.DB;
import java.sql.Connection;
import java.io.*;
import java.util.*;
import java.time.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
			stmt10.close();} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The tables were already created"); }  }
	 
	 public void insertPatient(Patient p) {
		 try {
		 Statement stmt1 = c.createStatement();
			String sql1 = "INSERT INTO Patients (id, name, weight, height, genre, dob) "
					+ "VALUES ('" + p.getId()+ "', '" + p.getName()+"', '" +p.getWeight()+"', '" +p.getHeight()+
					"', '" +p.getGenre()+ "', '" +p.getDob()+"');";
			stmt1.executeUpdate(sql1);
			stmt1.close();} 
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
	 
	 public void selectPatients() {
		 try {
			 Statement stmt = c.createStatement();
			 String sql = "SELECT * FROM patients";
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while (rs.next() ) {
				 int id = rs.getInt("id");
				 String name = rs.getString("name");
				 Double weight = rs.getDouble("weight");
				 Double height = rs.getDouble("height");
				 String genre = rs.getString("genre");
				 LocalDate dob = rs.getDate ("dob").toLocalDate();
				 Patient patient = new Patient (id,name,weight,height,genre,dob);
			 }
			 
			 rs.close();
			 stmt.close();
			 /*
			 Statement stmt1 = c.createStatement();
			 String sql1 = "SELECT name FROM patients";
			 ResultSet rs1 = stmt1.executeQuery(sql1);
			 rs1.close();
			 stmt1.close();
			 
			 Statement stmt2 = c.createStatement();
			 String sql2 = "SELECT weight FROM patients";
			 ResultSet rs2 = stmt2.executeQuery(sql2);
			 rs2.close();
			 stmt2.close();
			 
			 Statement stmt3 = c.createStatement();
			 String sql3 = "SELECT height FROM patients";
			 ResultSet rs3 = stmt3.executeQuery(sql3);
			 rs3.close();
			 stmt3.close();
			 
			 Statement stmt4 = c.createStatement();
			 String sql4 = "SELECT genre FROM patients";
			 ResultSet rs4 = stmt4.executeQuery(sql4);
			 rs4.close();
			 stmt4.close();
			 
			 Statement stmt5 = c.createStatement();
			 String sql5 = "SELECT dob FROM patients";
			 ResultSet rs5 = stmt5.executeQuery(sql5);
			 rs5.close();
			 stmt5.close();
			 
			 Statement stmt6 = c.createStatement();
			 String sql6 = "SELECT dob FROM patients";
			 ResultSet rs6 = stmt6.executeQuery(sql6);
			 rs6.close();
			 stmt6.close();
			 */
			 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	 
	 public void selectNurses() {
		 try {
		 Statement stmt = c.createStatement();
		 String sql = "SELECT * FROM nurses";
		 ResultSet rs = stmt.executeQuery(sql);
		 
		 while (rs.next()) {
			 int id = rs.getInt("id");
			 String name = rs.getString("name");
			 String speciallity = rs.getString("speciallity");
			 Nurse nurse = new Nurse (id,name,speciallity);
			 System.out.println(nurse);
		 }
		 rs.close();
		 stmt.close();
		 /*
		 Statement stmt1 = c.createStatement();
		 String sql1 = "SELECT id FROM nurses";
		 ResultSet rs1 = stmt1.executeQuery(sql1);
		 rs1.close();
		 stmt1.close();
		 
		 Statement stmt2 = c.createStatement();
		 String sql2 = "SELECT name FROM nurses";
		 ResultSet rs2 = stmt1.executeQuery(sql2);
		 rs2.close();
		 stmt2.close();
		 
		 Statement stmt3 = c.createStatement();
		 String sql3 = "SELECT speciallity FROM nurses";
		 ResultSet rs3 = stmt1.executeQuery(sql1);
		 rs3.close();
		 stmt3.close();
		 */
		 }
		 
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 
	 
}
