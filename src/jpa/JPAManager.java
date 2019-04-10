package jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.*;
import ER.POJOS.*;

public class JPAManager {
    
	EntityManager em;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		public JPAManager() {
			super();
			connectEntity();
		}
		
		public void connectEntity() {
			
		    em = Persistence.createEntityManagerFactory("company-provider").createEntityManager();
		    em.getTransaction().begin();
		    em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		    //em.getTransaction().commit();
		    
		}
		
		public void disconnectEntity() {
			em.close();
		}
	
		/*
      	/*Create Patient*/
		public void createDoctor(){
			try {
			System.out.println("Write the ID of the doctor: ");
			int id = Integer.parseInt(reader.readLine());
			System.out.println("Write the name of the doctor: ");
			String name = reader.readLine();
			System.out.println("Write the name of the specialty: ");
			String speciality = reader.readLine();
			System.out.println("Is the doctor available?:");
			String yes_no = reader.readLine();
			boolean availability = true;
			if(yes_no.equals(true)) {
				availability = true;
			}
			else{
				availability = false;
			}
			
			//Create the object
			Doctor d = new Doctor(id,name,speciality,availability);
			//Begin transaction
			em.getTransaction().begin();
			//Store the object
			em.persist(d);
			//End transaction
			em.getTransaction().commit();
			
			//Close the entity manager
			em.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		
		public void createNurse(){
			try {
			System.out.println("Write the ID of the nurse: ");
			int id = Integer.parseInt(reader.readLine());
			System.out.println("Write the name of the nurse: ");
			String name = reader.readLine();
			System.out.println("Write the name of the specialty: ");
			String speciality = reader.readLine();
			System.out.println("Is the nurse available?:");
			String yes_no = reader.readLine();
			boolean availability = true;
			if(yes_no.equals(true)) {
				availability = true;
			}
			else{
				availability = false;
			}
			
			//Create the object
			Nurse n = new Nurse(id,name,speciality,availability);
			//Begin transaction
			em.getTransaction().begin();
			//Store the object
			em.persist(n);
			//End transaction
			em.getTransaction().commit();
			
			//Close the entity manager
			em.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		/*
		public void createBox() {
			try {
				System.out.println("Write the ID of the box-room: ");
				int id = Integer.parseInt(reader.readLine());
				System.out.println("Is the box-room available: ");
				String yes_no = reader.readLine();
				boolean availability = true;
				if(yes_no.equals(true)) {
					availability = true;
				}
				else{
					availability = false;
				}
				System.out.println("Write the ID of the Admission: ");
				int id_admission = Integer.parseInt(reader.readLine());
				
				/*We have to call here the method askAdmission for adding it
				 * in the Box constructor*/
				/*
				//Create the object
				Box b = new Box(id,availability,Admission);
				//Begin transaction
				em.getTransaction().begin();
				//Store the object
				em.persist(b);
				//End transaction
				em.getTransaction().commit();
				
				//Close the entity manager
				em.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void createDrug() {
			try {
				System.out.println("Write the ID of the drug: ");
				int id = Integer.parseInt(reader.readLine());
				System.out.println("Write the name of the drug: ");
				String name = reader.readLine();
				
				//Create the object
				Drug d = new Drug(id,name);
				//Begin transaction
				em.getTransaction().begin();
				//Store the object
				em.persist(d);
				//End transaction
				em.getTransaction().commit();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
//----------------------------------------------------------------------------
		/*
		//ASK ADMISSION
		
		
		
		//ASK PATIENT
		
		
		
		//ASK DOCTOR
		
		public Doctor askDoctor() {
			try {
			System.out.println("Write the ID of the doctor: ");
			int id = Integer.parseInt(reader.readLine());
			System.out.println("Write the name of the doctor: ");
			String name = reader.readLine();
			String specialty = reader.readLine();
			String yes_no = reader.readLine();
			boolean availability = true;
			if(yes_no.equals(true)) {
				availability = true;
			}
			else{
				availability = false;
			}
			Doctor d = new Doctor(id,name,specialty,availability);
			return d;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public Nurse askNurse() {
			try {
			System.out.println("Write the ID of the nurse: ");
			int id = Integer.parseInt(reader.readLine());
			System.out.println("Write the name of the nurse: ");
			String name = reader.readLine();
			String specialty = reader.readLine();
			String yes_no = reader.readLine();
			boolean availability = true;
			if(yes_no.equals(true)) {
				availability = true;
			}
			else{
				availability = false;
			}
			Nurse n = new Nurse(id,name,specialty,availability);
			return n;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public Box askBox() {
			try {
				System.out.println("Write the ID of the box-room: ");
				int id = Integer.parseInt(reader.readLine());
				System.out.println("Is the box-room available: ");
				String yes_no = reader.readLine();
				boolean availability = true;
				if(yes_no.equals(true)) {
					availability = true;
				}
				else{
					availability = false;
				}
				Admission admission =
						/*We have to call here the method askAdmission for adding it
						 * in the Box constructor*/
				/*Box b = new Box(id,availability,admission);
				return b;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		//ASK DRUG
		
		*/
		
		
		
		
		
		
		
		
		//----------------------------------------------------------------------------------
	}


