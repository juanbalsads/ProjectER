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
import ER.jdbc.*;
import ER.jpa.JPAManager;



	public class UI {
		
		public static void printMenu() {
			System.out.println("WELCOME TO THE ER DATABASE: \n"+ 
		"Choose your option\n"+"1.- Create Patient\n"+"2.- Delete Patient\n"+"3.- Show Patient\n"
		+"4.- Create Doctor\n"+"5.- Delete Doctoe\n"+"6.- Show Doctors\n"+"0.- Exit\n");}

private static JPAManager manager= new JPAManager();
private static SQLManager manager1= new SQLManager();	
public static void main(String args[]) throws NumberFormatException, IOException {
			manager1.createTables();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			printMenu();
			int selection=Integer.parseInt(reader.readLine());
			switch (selection) {
			case 1: {
				manager.createPatient();
				break;}
			case 2: {
				manager.deletePatient();
				break;}
			case 3: {
				manager.listPatients();
				break;}
			case 4: {
			
				break;}
			case 5: {
				
				break;}
			case 6: {
				
				break;}
			
			
				}
			}
	}
			
	
