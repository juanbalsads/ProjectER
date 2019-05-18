package ER.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ER.POJOS.*;
import ER.jdbc.JDBCManager;
import ER.jpa.JPAManager;

public class UI2 {

	private static JDBCManager manager= new JDBCManager();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		manager.createTables();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int selection = 1;
		while(selection != 0) {
		System.out.println("\n\n\n");
		printMenu();
		selection=Integer.parseInt(reader.readLine());
		switch (selection) {
		case 0:
			manager.disconnect();
			System.out.println("Bye!");
			break;
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
			manager.createDoctor();
			break;
			}
		case 5: {
			manager.deleteDoctor();
			break;
			}
		case 6: {
			manager.listDoctors();
			break;
			}
		case 7: {
			manager.createNurse();
			break;
			}
		case 8: {
			manager.deleteNurse();
			break;
			}
		case 9: {
			manager.listNurses();
			break;
			}
		case 10: {
			manager.createBox();
			break;
			}
		case 11: {
			manager.deleteBox();
			break;
			}
		case 12: {
			manager.listBoxes();
			break;
			}
		case 13: {
			manager.createDrug();
			break;
			}
		case 14: {
			manager.deleteDrug();
			break;
			}
		case 15: {
			manager.listDrugs();
			break;
			} 
		case 16: {
			manager.createAdmission();
			break;
			}
		case 17: {
			manager.deleteAdmission();
			break;
			}
		case 18: {
			manager.listAdmissions();
			break;
			}
		case 19: {
			manager.getPatientByName();
			break;
			}
			}}}


public static void printMenu() {
System.out.println("WELCOME TO THE ER DATABASE: \n"+"Choose your option\n"+
		"1.- Create patient\n"+
		"2.- Delete patient\n"+
		"3.- List patients\n\n"+
		
		"4.- Create Doctor\n"+
		"5.- Delete Doctor\n"+
		"6.- List Doctors\n\n"+
		
		"7.- Create Nurse\n"+
		"8.- Delete Nurse\n"+
		"9.- List Nurses\n\n"+
		
		"10.- Create Box\n"+
		"11.- Delete Box\n"+
		"12.- List Boxes\n\n"+
		
		"13.- Create Drug\n"+
		"14.- Delete Drug\n"+
		"15.- List Drugs\n\n"+
		
		"16.- Create Admission\n"+
		"17.- Delete Admission\n"+
		"18.- List Admission\n\n"+
		
		"19.- Search patient by id\n\n"+

		"0.- Exit\n"
		
		
		);
			
		}

			}

