package ER.POJOS;

import java.io.Serializable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ER.db.xml.utils.SQLDateAdapter;

@Entity
@Table(name="Patients")

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Patient")
@XmlType(propOrder = {"weight","height","genre","dob","bloodType"})

public class Patient implements Serializable {
	private static final long serialVersionUID = -5716647307754030719L;
	@Id
	@GeneratedValue(generator="Patients")
	@TableGenerator(name="Patients", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="Patients")
	
	@XmlAttribute
	private Integer ssn;
	@XmlAttribute
	private String name;
	@XmlElement
	private Double weight;
	@XmlElement
	private Double height;
	@XmlElement
	private String genre;
	@XmlElement
	@XmlJavaTypeAdapter(SQLDateAdapter.class)
	private Date dob;
	
	@Column(name="blood_type")
	@XmlElement
	private String bloodType;
	@XmlTransient
	@OneToOne(fetch=FetchType.LAZY, mappedBy= "patient") 
	private Admission admission;
	
	public Patient() {
		super();
	}


	public Patient(Integer id, String name, Double weight, Double height, String genre, Date dob,
			String bloodType, Admission admission) {
		super();
		this.ssn = id;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.genre = genre;
		this.dob = dob;
		this.bloodType = bloodType;
		this.admission= admission;
		
	}

	public Patient(Integer id, String name, Double weight, Double height, String genre, Date dob,
			String bloodType) {
		super();
		this.ssn = id;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.genre = genre;
		this.dob = dob;
		this.bloodType = bloodType;
	}
	
	public Patient(String name, Double weight, Double height, String genre, Date dob,
			String bloodType, Admission admission) {
		super();
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.genre = genre;
		this.dob = dob;
		this.bloodType = bloodType;
		this.admission= admission;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public Double getHeight() {
		return height;
	}


	public void setHeight(Double height) {
		this.height = height;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getBloodType() {
		return bloodType;
	}


	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
	


	public Integer getSSN() {
		return ssn;
	}


	public void setSSN(Integer sSN) {
		ssn = sSN;
	}



	public Admission getAdmission() {
		return admission;
	}


	public void setAdmission(Admission admission) {
		this.admission = admission;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
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
		Patient other = (Patient) obj;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Patient [SSN=" + ssn + ", name=" + name + ", weight=" +
	            weight + ", height=" + height + ", genre="+
				genre + ", dob=" + dob + ", bloodType=" + bloodType 
				 + "]";
	}
	
	public String toString2() {
		if(admission!=null) {
		return "Patient [SSN=" + ssn + ", name=" + name + ", weight=" +
	            weight + ", height=" + height + ", genre="+
				genre + ", dob=" + dob + ", bloodType=" + bloodType 
				 + ", admission=" + admission.getId() +"]";}
		else {
		return "Patient [SSN=" + ssn + ", name=" + name + ", weight=" +
	           weight + ", height=" + height + ", genre="+
	    	   genre + ", dob=" + dob + ", bloodType=" + bloodType;}
	} 


	



	
	


	
	
	
	
	
	
	
}
