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
	private boolean release; 
	
	public Admission(Integer id, LocalDateTime arrivalTime, String symptoms, String tests, boolean release) {
		super();
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.symptoms = symptoms;
		this.tests = tests;
		this.release = release;
	}

	public Admission() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
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

	public boolean isRelease() {
		return release;
	}

	public void setRelease(boolean release) {
		this.release = release;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (release ? 1231 : 1237);
		result = prime * result + ((symptoms == null) ? 0 : symptoms.hashCode());
		result = prime * result + ((tests == null) ? 0 : tests.hashCode());
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
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (release != other.release)
			return false;
		if (symptoms == null) {
			if (other.symptoms != null)
				return false;
		} else if (!symptoms.equals(other.symptoms))
			return false;
		if (tests == null) {
			if (other.tests != null)
				return false;
		} else if (!tests.equals(other.tests))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admission [id=" + id + ", arrivalTime=" + arrivalTime + ", symptoms=" + symptoms + ", tests=" + tests
				+ ", release=" + release + "]";
	}
	
	

	
	
	
	
}
