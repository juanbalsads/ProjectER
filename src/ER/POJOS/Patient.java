package ER.POJOS;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5716647307754030719L;
	
	private Integer SSN;
	private String name;
	private Double weight; 
	private Double height; 
	private String genre;
	private LocalDate dob;
	private String bloodType;
	
	
	public Patient() {
		super();
	}


	public Patient(Integer id, String name, Double weight, Double height, String genre, LocalDate dob,
			String bloodType) {
		super();
		this.SSN = id;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.genre = genre;
		this.dob = dob;
		this.bloodType = bloodType;
	}


	public Integer getId() {
		return SSN;
	}


	public void setId(Integer id) {
		this.SSN = id;
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


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getBloodType() {
		return bloodType;
	}


	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SSN == null) ? 0 : SSN.hashCode());
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
		if (SSN == null) {
			if (other.SSN != null)
				return false;
		} else if (!SSN.equals(other.SSN))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Patient [id=" + SSN + ", name=" + name + ", weight=" + weight + ", height=" + height + ", genre=" + genre
				+ ", dob=" + dob + ", bloodType=" + bloodType + "]";
	}
	
	


	
	
	
	
	
	
	
}
