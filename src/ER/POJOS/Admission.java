package ER.POJOS;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import ER.POJOS.*;

@Entity
@Table(name="Admission")


public class Admission implements Serializable{
	
	@Id
	@GeneratedValue(generator = "admission")
	@TableGenerator(name = "admission", table = "sqlite_sequence",
		pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "admission")
	private static final long serialVersionUID = 5626892191426340232L;

	private Integer id;
	@OneToOne(fetch=FetchType.LAZY)    
	@JoinColumn(name="patient_id")//Juan:should I put the name of the other attribute in the table?
	                              //or should I make this up?
	private Patient patient;
	private Date arrivalTime;
	private String tests;
	private boolean release;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="nurse_id")
	private Nurse nurse;
	@OneToMany(fetch = FetchType.LAZY)//One doctor for many admissions(this is the many side?)
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	@OneToOne(fetch=FetchType.LAZY)    
	@JoinColumn(name="box_id")
	private Box box;
	@OneToMany(mappedBy="admission")//Clearify type of relationship
	private List<Drug> drugs;
	
	
	
	public Admission() {
		super();
		this.drugs= new ArrayList<Drug>();
	}

	public Admission(Integer id) {
		super();
		this.id = id;
		
		this.drugs = new ArrayList <Drug>();
	}
	public Admission(Integer id, Patient patient, Date arrivalTime,  String tests, boolean release, Nurse nurse, Doctor doctor, Box box) {
		super();
		this.id = id;
		this.patient= patient;
		this.arrivalTime = arrivalTime;
		this.tests = tests;
		this.release = release;
		this.nurse = nurse;
		this.doctor= doctor;
		this.box= box;
		
		this.drugs= new ArrayList<Drug>();
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getTests() {
		return tests;
	}

	public void setTests(String tests) {
		this.tests = tests;
	}

	public boolean isRelease() {
		return release;
	}

	public void setRelease(boolean release) {
		this.release = release;
	}
	

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}
	
	

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admission other = (Admission) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admission [id=" + id + ", patient=" + patient + ", arrivalTime=" + arrivalTime + ", tests=" + tests + ", release=" + release + ", nurse=" + nurse + ", doctor=" + doctor
				+ ", box=" + box + ", drugs=" + drugs + "]";
	}


	
	

	
	
	
	
	
	
}
