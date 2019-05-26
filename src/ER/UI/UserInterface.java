package ER.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ER.jdbc.JDBCManager;
import ER.jpa.JPAManager;

public class UserInterface {

	public static void main(String[] args) throws NumberFormatException, IOException {
		JDBCManager managerJDBC = new JDBCManager();
		JPAManager managerJPA = new JPAManager();
		int option = 1;
		BufferedReader cs = new BufferedReader(new InputStreamReader(System.in));
		while(option > 0 && option <= 4) {
				PrintHomeMenu();
				option = Integer.parseInt(cs.readLine());
				int optioninside = 1;
				switch(option){
				case 1:{
					while(optioninside > 0 && optioninside <= 8 ) {
						printMenuAssistant();
						optioninside = Integer.parseInt(cs.readLine());
						switch(optioninside) {
							case 1: {
								managerJDBC.createAdmission();
								break;
							}
							case 2: {
								managerJDBC.updateAdmission();
								break;
							}
							case 3:{
								managerJDBC.createPatient();
								break;
							}
							case 4:{
								managerJDBC.updatePatient();
								break;
							}
							case 5:{
								managerJPA.listNurses2();
								break;
							}
							case 6:{
								managerJDBC.listDoctors();
								break;
							}
							case 7:{
								managerJPA.listPatients2();
								break;
							}
							case 8:{
								managerJPA.listBoxes2();
								break;
							}
							case 0:{
								System.out.println("See you!");
								break;
							}
						}
					}
					break;
				}
				case 2:{
					while(optioninside > 0 && optioninside <= 4 ) {
						printMenuNurse();
						optioninside = Integer.parseInt(cs.readLine());
						switch(optioninside) {
							case 1: {
								managerJPA.updateAvailabilityNurse();
								break;
								
							}
							case 2: {
								managerJPA.listNurseAdmissions();
								break;
								
							}
							case 3: {
								managerJDBC.listAdmissions();
								break;
								
							}
							case 4: {
								managerJPA.readNurse();
								break;
								
							}
							case 0:{
								System.out.println("See you!");
								break;
								
							}
						}
						
					}
					break;
				}
				case 3:{
					while(optioninside > 0 && optioninside <= 4 ) {
						printMenuDoctor();
						optioninside = Integer.parseInt(cs.readLine());
						switch(optioninside) {
						case 1: {
							managerJPA.updateAvailabilityDoctor();
							break;
							
						}
						case 2: {
							managerJPA.listDoctorAdmissions();
							break;
							
						}
						case 3: {
							managerJPA.listAdmissions();
							break;
							
						}
						case 4: {
							managerJPA.readDoctor();
							break;
							
						}
						case 0:{
							System.out.println("See you!");
							break;
							
						}
					}
						
					}
					break;
				}
				case 4:{
					while(optioninside > 0 && optioninside <= 12 ) {
						printMenuDatabaseManager();
						optioninside = Integer.parseInt(cs.readLine());
						switch(optioninside) {
							case 1:{
								managerJPA.createDoctor();
								break;
							}
							case 2:{
								managerJDBC.deleteDoctor();
								break;
							}
							case 3:{
								managerJDBC.updateDoctor();
								break;
							}
							case 4:{
								managerJDBC.createNurse();
								break;
							}
							case 5:{
								managerJDBC.deleteNurse();
								break;
							}
							case 6:{
								managerJDBC.updateNurse();
								break;
							}
							case 7:{
								managerJPA.createBox();
								break;
							}
							case 8:{
								managerJPA.deleteBox();
								break;
							}
							case 9:{
								managerJPA.updateBox();
								break;
							}
							case 10:{
								managerJPA.createDrug();
								break;
							}
							case 11:{
								managerJPA.deleteDrug();
								break;
							}
							case 12:{
								managerJPA.updateDrug();
								break;
							}
							case 0:{
								System.out.println("See you!");
								break;
							}
						}
						
					}
					break;
				}
				case 0:{
					System.out.println("See you!");
					break;
				}
			}
				System.out.println("saleee");
		}
	}
	
	public static void PrintHomeMenu() {
		System.out.println("WELCOME TO ER DATABASE:");
		System.out.println("IDENTIFY:");
		System.out.println(""+
				"1.- ER Assistant\n\n"+
				"2.- Nurse\n\n"+			
				"3.- Doctor\n\n"+
				"4.- Database Manager\n\n"+
				"0.- Exit\n"+
				"Choose option:"+
				"");
	}
	
	public static void printMenuAssistant() {
		System.out.println("-----ASSISTANT MENU-----\n");
		System.out.println(""+
				"1.- New Admission\n"+
				"2.- Edit Admission\n\n"+
				
				"3.- New Patient\n"+
				"4.- Edit Patient\n\n"+
				
				"5.- List Nurse\n"+
				"6.- List Doctors\n"+	
				"7.- List Patient\n"+
				"8.- List Box\n\n"+
				
				"0.- Exit\n\n"+
				"Choose option:"+
				"");	
	}
	
	public static void printMenuDatabaseManager() {
		System.out.println("-----DATABASE MANAGER MENU-----\n");
		System.out.println(""+
				"1.- Create Doctor\n"+
				"2.- Delete Doctor\n"+
				"3.- Update Doctor\n\n"+
				
				"4.- Create Nurse\n"+
				"5.- Delete Nurse\n"+
				"6.- Update Nurse\n\n"+
				
				"7.- Create Box\n"+
				"8.- Delete Box\n"+
				"9.- Update Box\n\n"+
				
				"10.- Create Drug\n"+
				"11.- Delete Drug\n"+
				"12.- Update Drug\n\n"+
				"0.- Exit\n\n"+
				"Choose option:"+
				"");	
	}
	public static void printMenuDoctor() {
		System.out.println("-----DOCTOR MENU-----\n");
		System.out.println(""+
				"1.- Change Availability\n"+
				"2.- See My Admissions\n"+
				"3.- List Admissions\n"+
				"4.- Read My Data"+
				"0.- Home Window\n"+
				"-1.- Exit\n\n"+
				"Choose option:"+
				"");	
	}
	public static void printMenuNurse() {
		System.out.println("-----NURSE MENU-----\n");
		System.out.println(""+
				"1.- Change Availability\n"+
				"2.- See My Admissions\n"+
				"3.- List Admissions\n"+
				"4.- Read My Data"+
				"0.- Exit \n"+
				"Choose option:"+
				"");	
	}
 

}