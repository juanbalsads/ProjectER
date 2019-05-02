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

//the checking have been done in: Doctors(W),Patients(W)
//								  Nurses(W),Boxes(W),Admission(),Drug(W)
//		
private static JPAManager manager= new JPAManager();
private static SQLManager manager1= new SQLManager();	
public static void main(String args[]) throws NumberFormatException, IOException {
			manager1.createTables();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int selection = 1;
			while(selection != 0) {
			System.out.println("\n\n\n");
			printMenu();
			selection=Integer.parseInt(reader.readLine());
			switch (selection) {
			case 0:
				manager1.disconnect();
				manager.disconnectEntity();
				System.out.println("Bye!");
				break;
			case 1: {
				manager.createPatient();
				break;}
			case 2: {
				manager.deletePatient();
				break;}
			case 3: {
				manager.listPatients2();
				break;}
			case 4: {
				manager.readPatient();
				break;}
			case 5: {
				manager.updatePatient();
				break;}
			
			case 6: {
				manager.createDoctor();
				break;
				}
			case 7: {
				manager.deleteDoctor();
				break;
				}
			case 8: {
				manager.listDoctors2();
				break;
				}
			case 9: {
				manager.readDoctor();
				break;
				}
			case 10: {
				manager.updateDoctor();
				break;
				}
			
			case 11: {
				manager.createNurse();
				break;
				}
			case 12: {
				manager.deleteNurse();
				break;
				}
			case 13: {
				manager.listNurses2();
				break;
				}
			case 14: {
				manager.readNurse();
				break;
				}
			case 15: {
				manager.updateNurse();
				break;
				}
			
			case 16: {
				manager.createBox();
				break;
				}
			case 17: {
				manager.deleteBox();
				break;
				}
			case 18: {
				manager.listBoxes2();
				break;
				}
			case 19: {
				manager.readBox();
				break;
				}
			case 20: {
				manager.updateBox();
				break;
				}
			
			case 21: {
				manager.createDrug();
				break;
				}
			case 22: {
				manager.deleteDrug();
				break;
				}
			case 23: {
				manager.listDrugs2();
				break;
				}
			case 24: {
				manager.readDrug();
				break;
				}
			case 25: {
				manager.updateDrug();
				break;
				}
			
			case 26: {
				manager.createAdmission();
				break;
				}
			case 27: {
				manager.deleteAdmission();
				break;
				}
			case 28: {
				manager.listAdmissions();
				break;
				}
			case 29: {
				manager.readAdmission();
				break;
				}
			case 30: {
				manager.updateAdmission();
				break;
				}
			case 31:{
				manager.createAdmissionToDrug();
				break;
			}
			
			
			
				}
			}
			}


public static void printMenu() {
	System.out.println("WELCOME TO THE ER DATABASE: \n"+"Choose your option\n"+
			"1.- Create patient\n"+
			"2.- Delete patient\n"+
			"3.- Show patient\n"+
			"4.- Read Patient\n"+
			"5.- Update patien\n\n"+
			
			"6.- Create Doctor\n"+
			"7.- Delete Doctor\n"+
			"8.- Show Doctor\n"+
			"9.- Read Doctor\n"+
			"10.- Update Doctor\n\n"+
			
			"11.- Create Nurse\n"+
			"12.- Delete Nurse\n"+
			"13.- Show Nurse\n"+
			"14.- Read Nurse\n"+
			"15.- Update Nurse\n\n"+
			
			"16.- Create Box\n"+
			"17.- Delete Box\n"+
			"18.- Show Box\n"+
			"19.- Read Box\n"+
			"20.- Update Box\n\n"+
			
			"21.- Create Drug\n"+
			"22.- Delete Drug\n"+
			"23.- Show Drug\n"+
			"24.- Read Drug\n"+
			"25.- Update Drug\n\n"+
			
			"26.- Create Admission\n"+
			"27.- Delete Admission\n"+
			"28.- Show Admission\n"+
			"29.- Read Admission\n"+
			"30.- Update Admission\n\n"+
			
			"31.- Add Drug to admision\n"+
			
			
			
			"0.- Exit\n"
			
			
			);
	
}

	}
			
	
