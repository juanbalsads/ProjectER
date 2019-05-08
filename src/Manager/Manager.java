package Manager;

import ER.POJOS.*;

public interface Manager {

	public void connect() ;
	public void disconnect();
	
	public void createPatient();
	public void createAdmission();
	public void createDrug();
	public void createDoctor();
	public void createNurse();
	public void createBox();
	
	public Patient askForPatient();
	public Admission askForAdmission();
	public Drug askForDrug();
	public Doctor askForDoctor();
	public Nurse askForNurse();
	public Box askForBox();
	
	public void listPatients ();
	public void listAdmissions();
	public void listDrugs();
	public void listDoctors();
	public void listNurses();
	public void listBoxes();
	
	public void readPatient();
	public void readAdmission();
	public void readDrug();
	public void readDoctor();
	public void readNurse();
	public void readBox();
	
	public void deletePatient();
	public void deleteAdmission();
	public void deleteDrug();
	public void deleteDoctor();
	public void deleteNurse();
	public void deleteBox();
	
	public void updatePatient();
	public void updateAdmission();
	public void updateDrug();
	public void updateDoctor();
	public void updateNurse();
	public void updateBox();

	
}
