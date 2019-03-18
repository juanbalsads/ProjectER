package ER.UI;
import java.io.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.time.format.DateTimeFormatter;
import ER.POJOS.*;
import ER.DB.*;


	public class UI {

private static SQLManager manager;
	
public static void main(String args[]) {
	
		try {
		
		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:./db/ER.db");
		c.createStatement().execute("PRAGMA foreign_keys=ON");
		System.out.println("Database connection opened.");
			
			
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		manager = new SQLManager();

			//PATIENT
		System.out.println("\nWrite the patient's name:");
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

		manager.createTables();
		
		
		String sql = "INSERT INTO patients (name, weight , height , genre, dob) "
				+ "VALUES (?,?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, name);
		prep.setDouble(2, weight);
		prep.setDouble(3, height);
		prep.setString(4, genre);
		prep.setDate(5, Date.valueOf(dob));
		prep.executeUpdate();
		prep.close(); 
		
		/*Patient patient=null;
		Statement stmt1 = c.createStatement();
		String sql1 = "SELECT * FROM patients";
		ResultSet rs = stmt1.executeQuery(sql1);
		while (rs.next()) {
			int id1 = rs.getInt("id");
			String name1 = rs.getString("name");
			Double weight1 = rs.getDouble("weight");
			Double height1 = rs.getDouble("height");
			String genre1 = rs.getString("genre");
			LocalDate dob1=  rs.getDate("dob").toLocalDate();
			patient = new Patient(id1, name1, weight1, height1, genre1, dob1);
			System.out.println(patient);
		}
		rs.close();
		stmt1.close();
		System.out.println("Search finished.");
		
		
		
		System.out.println("Choose a patient, type its ID: ");
			int p_id = Integer.parseInt(reader.readLine());
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
		System.out.println("Update finished.");
				
		
		
		System.out.println("Choose a patient to delete, type its ID: ");
		p_id = Integer.parseInt(reader.readLine());
		sql = "DELETE FROM patients WHERE id=?";
		prep = c.prepareStatement(sql);
		prep.setInt(1, p_id);
		prep.executeUpdate();
		System.out.println("Deletion finished.");*/
	
		
		 /*stmt1 = c.createStatement();
		 sql1 = "SELECT * FROM patients";
		 rs = stmt1.executeQuery(sql1);
		while (rs.next()) {
			int id1 = rs.getInt("id");
			String name1 = rs.getString("name");
			Double weight1 = rs.getDouble("weight");
			Double height1 = rs.getDouble("height");
			String genre1 = rs.getString("genre");
			LocalDate dob1=  rs.getDate("dob").toLocalDate();
			patient = new Patient(id1, name1, weight1, height1, genre1, dob1);
			System.out.println(patient);
		}
		rs.close();
		stmt1.close();
		System.out.println("Search finished.");*/
		
		//manager.selectPatients();
		
		
		c.close();
		
		// Retrieve data: end
		
		
		/*
			//DOCTOR
		System.out.println("\nInsert doctor's name");
		name = reader.readLine();
		System.out.println("\nInsert doctor's speciality: ");
		String speciality = reader.readLine();
		Doctor doctor1 = new Doctor (name,speciality);

			//NURSE
		System.out.println("\nInsert nurse's name: ");
		name = reader.readLine();
		System.out.println("Insert nurse's speciality: ");
        speciality = reader.readLine();
        Nurse nurse1 = new Nurse (name,speciality);
        
        	//DEVICES
        System.out.println("\nIntroduce device: ");
        name = reader.readLine();
        System.out.println("\nIntroduce the quantity of devices: ");
        int num = Integer.parseInt(reader.readLine());
        Device device1 = new Device (name,num);
        
        	//ADMISSION
        System.out.println("\nIntroduce the date and time of the admission: ");
        String arrivalTimeDate = reader.readLine();
        DateTimeFormatter formatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime arrivalDate = LocalDateTime.parse(arrivalTimeDate, formatterWithTime);
        
        System.out.println("\nIntroduce the symptomos: ");
        String symptoms = reader.readLine();
        
        System.out.println("\nIntroduce tests the patient have done it: ");
        String test = reader.readLine();
        
       // Admission admission1 = new Admission (arrivalDate,symptoms,test);
        
        
        	//ALLERGIES
        System.out.println("ºnInsert patient's allergies:");
        String allergies= reader.readLine();
        
       // Allergies allergies1= new Allergies (allergies);
        
        */
} 
		catch(Exception e) {
			e.printStackTrace();}
		}
		}
