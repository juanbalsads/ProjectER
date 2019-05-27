package ER.POJOS;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ER.POJOS.*;
import ER.db.xml.utils.*;


@Entity
@Table(name="Admissions")

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Admission")
@XmlType(propOrder = {"arrivalTime"})
public class Admission implements Serializable{
	private static final long serialVersionUID = 5626892191426340232L;
	@Id
	@GeneratedValue(generator = "Admissions")
	@TableGenerator(name = "Admissions", table = "sqlite_sequence",
		pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "Admissions")
	@XmlAttribute
	private Integer id;	
	
	@OneToOne(fetch=FetchType.LAZY)    
	@JoinColumn(name="patient")	
	@XmlTransient
	private Patient patient;
	
	@Column(name="arrival_time")
	@XmlElement
	@XmlJavaTypeAdapter(SQLTimestampAdapter.class)
	private Timestamp arrivalTime;
	
	@Column(name="test")
	@XmlTransient
	private String tests;
	@XmlTransient
	private boolean release;
	
	@XmlTransient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="nurse")
	private Nurse nurse;
	
	@XmlTransient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="doctor")
	private Doctor doctor;
	
	@XmlTransient
	@OneToOne(fetch=FetchType.LAZY)    
	@JoinColumn(name="box")
	private Box box;
	
	@XmlTransient
	@ManyToMany(mappedBy="admission")
	private List<Drug> drug;
	
	
	
	
	
	public Admission() {
		super();
		this.drug= new ArrayList<Drug>();
	}

	public Admission(Integer id) {
		super();
		this.id = id;
		
		this.drug = new ArrayList <Drug>();
	}
	public Admission(Integer id, Patient patient, Timestamp arrivalTime,  String tests, boolean release, Nurse nurse, Doctor doctor, Box box) {
		super();
		this.id = id;
		this.patient= patient;
		this.arrivalTime = arrivalTime;
		this.tests = tests;
		this.doctor= doctor;
		this.release = release;
		this.nurse = nurse;
		this.box= box;
		
		this.drug= new ArrayList<Drug>();
	}
	
	public Admission( Patient patient, Timestamp arrivalTime,  String tests, boolean release, Nurse nurse, Doctor doctor, Box box) {
		super();
		this.patient= patient;
		this.arrivalTime = arrivalTime;
		this.tests = tests;
		this.doctor= doctor;
		this.release = release;
		this.nurse = nurse;
		this.box= box;
		
		this.drug= new ArrayList<Drug>();
	}
	
	public Admission( Patient patient, Timestamp arrivalTime,  Nurse nurse, Doctor doctor, Box box) {
		super();
		this.patient= patient;
		this.arrivalTime = arrivalTime;
		this.tests = tests;
		this.doctor= doctor;
		this.release = true;
		this.nurse = nurse;
		this.box= box;
		
		this.drug= new ArrayList<Drug>();
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

	public Timestamp getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
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
	

	public List<Drug> getDrug() {
		return drug;
	}

	public void setDrug(List<Drug> drug) {
		this.drug = drug;
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

	
	public void addDrug(Drug d) {
		if(!this.drug.contains(d)) {
			this.drug.add(d);
		}
	}
	
	public void removeDrug(Drug d) {
		if(this.drug.contains(d)) {
			this.drug.remove(d);
		}
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
		return "\nAdmission [id=" + id + ", arrivalTime=" +arrivalTime.toString() + "\npatient=" + patient +  
	 ", tests=" + tests + ", release=" + release + ", \nnurse=" + nurse + ",\ndoctor=" + doctor
				+ ", \nbox=" + box + ", \ndrugs=" + drug + "]";
	}


	
	

	
	
	
	
	
	
}
