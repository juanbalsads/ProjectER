package ER.UI;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import ER.POJOS.*;
import ER.DB.*;


	public class UI {

private static SQLManager manager;

	public static void main() {
	
		try {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		manager = new SQLManager();

			//PATIENT
		System.out.println("\nWrite the patient's social security number:");
		Integer id = reader.read();
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
		Patient patient1 = new Patient(id, name, weight, height, genre, date);

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
        
        
} 
		catch(IOException e) {
			e.printStackTrace();}
		}
		}
