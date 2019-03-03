package ER.POJOS;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import ER.POJOS.*;

public class Admission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5626892191426340232L;

	private Integer id;
	private LocalDateTime arrivalTime;
	private String symptoms;
	private String tests;
	
	public Admission() {
		super();
	}

	
	
	public Admission(LocalDateTime arrivalTime, String symptoms, String tests) {
		super();
		this.arrivalTime = arrivalTime;
		this.symptoms = symptoms;
		this.tests = tests;
	}



	public Admission(Integer id, LocalDateTime arrivalTime, String symptoms, String tests) {
		super();
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.symptoms = symptoms;
		this.tests = tests;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArrivalTime() {
		return arrivalTime.toString();
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getTests() {
		return tests;
	}

	public void setTests(String tests) {
		this.tests = tests;
	}

	@Override
	public String toString() {
		return "Admission [id=" + id + ", arrivalTime=" + arrivalTime + ", symptoms="
				+ symptoms + ", tests=" + tests + "]";
	}

	
	
	
}
