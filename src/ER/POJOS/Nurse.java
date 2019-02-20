package ER.POJOS;

import java.io.Serializable;

public class Nurse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6033711001187345264L;
	
	private Integer id;
	private String name;
	private String specialty;
	
	public Nurse() {
		super();
	}
	
	public Nurse(Integer id, String name, String specialty) {
		super();
		this.id = id;
		this.name = name;
		this.specialty = specialty;
	}

	
	
	public Nurse(String name, String specialty) {
		super();
		this.name = name;
		this.specialty = specialty;
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
		Nurse other = (Nurse) obj;
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

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "Nurse [id=" + id + ", name=" + name + ", specialty=" + specialty + "]";
	}
	
	
	

}
