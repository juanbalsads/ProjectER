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



	public class UI {
		
		public static void printMenu() {
			System.out.println("WELCOME TO THE ER DATABASE: \n"+ 
		"Choose your option\n"+"1.- Create Patient\n"+"2.- Delete Patient\n"+"3.- Show Patient\n"
		+"4.- Create Doctor\n"+"5.- Delete Doctoe\n"+"6.- Show Doctors\n"+"0.- Exit\n");}

private static SQLManager manager= new SQLManager();
	
public static void main(String args[]) {
	
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			printMenu();
			int selection=Integer.parseInt(reader.readLine());
			switch (selection) {
			case 1: {
				Patient p= manager.askPatient();
				manager.insertPatient(p);
				break;}
			case 2: {
				manager.deletePatient();
				break;}
			case 3: {
				manager.selectPatients();
				break;}
			case 4: {
				Doctor d= manager.askDoctor();
				manager.insertDoctor(d);
				break;}
			case 5: {
				manager.deleteDoctors();
				break;}
			case 6: {
				manager.selectDoctors();
				break;}
			}
			
			while(true) {
				printMenu();
				selection=Integer.parseInt(reader.readLine());
				switch (selection) {
				case 1: {
					Patient p= manager.askPatient();
					manager.insertPatient(p);
					break;}
				case 2: {
					manager.deletePatient();
					break;}
				case 3: {
					manager.selectPatients();
					break;}
				case 0: 
					return;
				}}
			} 
		catch(Exception e) {
			e.printStackTrace();}}
		}
