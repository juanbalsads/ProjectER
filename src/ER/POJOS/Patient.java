package ER.POJOS;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5716647307754030719L;
	
	private Integer id;
	private String name;
	private Double weight; 
	private Double height; 
	private String genre;
	private LocalDate dob;
	
	
	public Patient() {
		super();
	}


	public Patient(Integer id, String name, Double weight, Double height, String genre, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.genre = genre;
		this.dob = dob;
	}


	public Patient(String name, Double weight, Double height, String genre, LocalDate dob2) {
		super();
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.genre = genre;
		this.dob = dob2;
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
		Patient other = (Patient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getDob() {
		return dob.toString();
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", weight=" + weight + ", height=" + height + ", genre=" + genre
				+ ", dob=" + dob + "]";
	}
	
	
	
	
	
	
}
