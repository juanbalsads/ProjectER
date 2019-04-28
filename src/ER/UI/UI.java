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
		"Choose your option\n"+"1.- Create patient\n"+"2.- Delete patient\n"+"3.- Show patient\n"
		+"4.- Create Box\n"+"5.- Delete Box\n"+"6.- Show Box\n"+"0.- Exit\n");}
//the checking have been done in: Doctors(W),Patients(ASKRODIGOabout delete!!)
//								  Nurses(W),Boxes(error),Admission(),Drug(W)
//		
private static JPAManager manager= new JPAManager();
private static SQLManager manager1= new SQLManager();	
public static void main(String args[]) throws NumberFormatException, IOException {
			manager1.createTables();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
			System.out.println("\n\n\n");
			printMenu();
			int selection=Integer.parseInt(reader.readLine());
			switch (selection) {
			case 0:
				manager1.disconnect();
				manager.disconnectEntity();
				return;
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
				manager.createBox();
				break;}
			case 5: {
				manager.deleteBox();
				break;}
			case 6: {
				manager.listBoxes();
				break;
				}			
				}
			}
			}
	}
			
	
