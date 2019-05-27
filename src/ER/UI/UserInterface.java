package ER.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ER.jdbc.JDBCManager;
import ER.jpa.JPAManager;
import ER.db.xml.*;

public class UserInterface {

	public static void main(String[] args) throws NumberFormatException, IOException {
		JDBCManager managerJDBC = new JDBCManager();
		JPAManager managerJPA = new JPAManager();
		XMLManager managerXML= new XMLManager();
		int option = 1;
		BufferedReader cs = new BufferedReader(new InputStreamReader(System.in));
		while(option > 0 && option <= 5) {
				PrintHomeMenu();				
				option = Integer.parseInt(cs.readLine());
				while(option<0 || option>5) {
					System.out.println("Please select a valid option");
					PrintHomeMenu();				
					option = Integer.parseInt(cs.readLine());
				}
				int optioninside = 1;
				switch(option){
				case 1:{
					while(optioninside > 0 && optioninside <= 12 ) {
						printMenuAssistant();
						optioninside = Integer.parseInt(cs.readLine());
						while(optioninside<0 || optioninside>12) {
							System.out.println("Please select a valid option");
							printMenuAssistant();
							optioninside = Integer.parseInt(cs.readLine());
						}
						switch(optioninside) {
							case 1: {
								managerJDBC.createAdmission();
								break;
							}
							case 2: {
								managerJPA.updateAdmission();
								break;
							}
							case 3:{
								managerJPA.releasePatient();
								break;
							}
							case 4:{
								managerJDBC.createPatient();
								break;
							}
							case 5:{
								managerJPA.updatePatient();
								break;
							}
							case 6:{
								managerJPA.listNurses2();
								break;
							}
							case 7:{
								managerJPA.listDoctors2();
								break;
							}
							case 8:{
								managerJPA.listPatients2();
								break;
							}
							case 9:{
								managerJPA.listBoxes2();
								break;
							}
							case 10:{
								managerJPA.listAdmissions();
								break;
							}
							case 11: {
								managerJDBC.getPatientByName();
								break;
							}
							case 12: {
								managerJPA.readDoctor();
								break;
							}
							
							case 0:{
								System.out.println("\nBack to Home");
								break;
							}
						}
					}
					break;
				}
				case 2:{
					while(optioninside > 0 && optioninside <= 5 ) {
						printMenuNurse();
						optioninside = Integer.parseInt(cs.readLine());
						while(optioninside<0 || optioninside>5) {
							System.out.println("Please select a valid option");
							printMenuAssistant();
							optioninside = Integer.parseInt(cs.readLine());
						}
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
								managerJPA.createAdmissionToDrug();
								break;
								
							}
							case 5: {
								managerJPA.readNurse();
								break;
								
							}
							case 0:{
								System.out.println("\nBack to Home");
								break;
								
							}
						}
						
					}
					break;
				}
				case 3:{
					while(optioninside > 0 && optioninside <= 5 ) {
						printMenuDoctor();
						optioninside = Integer.parseInt(cs.readLine());
						while(optioninside<0 || optioninside>5) {
							System.out.println("Please select a valid option");
							printMenuAssistant();
							optioninside = Integer.parseInt(cs.readLine());
						}
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
							managerJPA.createAdmissionToDrug();
							break;
							
						}
						case 5: {
							managerJPA.readDoctor();
							break;
														
													}
						case 0:{
							System.out.println("\nBack to Home");
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
						while(optioninside<0 || optioninside>12) {
							System.out.println("Please select a valid option");
							printMenuAssistant();
							optioninside = Integer.parseInt(cs.readLine());
						}
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
								managerJPA.updateDoctor();
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
								System.out.println("\nBack to Home");
								break;
							}
						}
						
					}
					break;
				}
				
				
				case 5:{
					while(optioninside > 0 && optioninside <= 3 ) {
						printMenuXML();
						optioninside = Integer.parseInt(cs.readLine());
						while(optioninside<0 || optioninside>3) {
							System.out.println("Please select a valid option");
							printMenuAssistant();
							optioninside = Integer.parseInt(cs.readLine());
						}
						switch(optioninside) {
							case 1: {
								System.out.println("\n   XML to JAVA with ./xmls/External-Patient.xml: \n");
						    	managerXML.Xml2JavaPatient();
						    	break;
								
							}
							case 2: {
								System.out.println("\n   JAVA to XML (./xmls/Example-Patient.xml): \n");
								managerXML.Java2XmlPatient();
								break;
								
							}
							case 3: {
								System.out.println("\n   DTD check to ./xmls/External-Patient.xml: \n");
								managerXML.dtdChecker();
								break;
							}
							case 0:{
								System.out.println("\nBack to Home");
								break;
								
							}
						}
						
					}
					break;
				}
				
				case 0:{
					System.out.println("Exit");
					managerJDBC.disconnect();
					managerJPA.disconnect();
					break;
				}
			}
				
		}
	}
	
	public static void PrintHomeMenu() {
		System.out.println("\n\n\nWELCOME TO ER DATABASE:");
		System.out.println("\nIDENTIFY:\n");
		System.out.println(""+
				"1.- ER Assistant\n"+
				"2.- Nurse\n"+			
				"3.- Doctor\n"+
				"4.- Database Manager\n\n"+
				"--EXTRA--\n"+
				"5.- XML operations\n\n"+
				
				
				"0.- Exit\n\n"+
				"Choose option:"+
				"");
	}
	
	
	public static void printMenuXML() {
	System.out.println("\n\n\n\n-----XML OPERATIONS MENU-----\n");
	System.out.println("1.- Patient from XML to Java \n"
			+ "2.- Patient from Java to XML \n"
			+ "3.- Check if the DTD is correct\n\n"
			+ "0.- Exit\n"
			);
	
	System.out.println("Choose option: ");
	}
	
	
	
	public static void printMenuAssistant() {
		System.out.println("\n\n\n\n-----ASSISTANT MENU-----\n");
		System.out.println(""+
				"1.- New Admission\n"+
				"2.- Edit Admission\n"+
				"3.- Release Admission\n\n"+
				
				"4.- New Patient\n"+
				"5.- Edit Patient\n\n"+
				
				"6.- List Nurse\n"+
				"7.- List Doctors\n"+	
				"8.- List Patients\n"+
				"9.- List Boxes\n"+
				"10.- List Admissions\n\n"+
				
				"11.- Search Patient by name\n"+
				"12.- Read doctor (with photo) \n\n"+
				
				"0.- Exit\n\n"+
				"Choose option:"+
				"");	
	}
	
	public static void printMenuDatabaseManager() {
		System.out.println("\n\n\n\n-----DATABASE MANAGER MENU-----\n");
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
		System.out.println("\n\n\n\n-----DOCTOR MENU-----\n");
		System.out.println(""+
				"1.- Change Availability\n"+
				"2.- See My Admissions\n"+
				"3.- List Admissions\n"+
				"4.- Add drug to an admissions\n"+
				"5.- Read My Data\n\n"+

				"0.- Exit\n\n"+
				"Choose option:"+
				"");	
	}
	public static void printMenuNurse() {
		System.out.println("\n\n\n\n-----NURSE MENU-----\n");
		System.out.println(""+
				"1.- Change Availability\n"+
				"2.- See My Admissions\n"+

				"3.- List Admissions\n\n"+
				"4.- Add drug to an admissions\n"+
				"5.- Read My Data\n\n"+
				"0.- Exit \n"+
				"Choose option:"+
				"");	
	}
 

}