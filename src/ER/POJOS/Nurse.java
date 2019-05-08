package ER.POJOS;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Nurses")
public class Nurse implements Serializable{
	private static final long serialVersionUID = 6033711001187345264L;
	@Id
	@GeneratedValue(generator="Nurses")
	@TableGenerator(name="Nurses", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="Nurses")
	private Integer id;
	private String name;
	@Column(name="speciality")
	private String specialty;
	private boolean availability;
	
	@OneToMany(mappedBy="nurse")
	private List<Admission> admission;
	
	public Nurse() {
		super();
		this.admission = new ArrayList<Admission>();
	}
	
	public Nurse(int id) {
		super();
		this.id = id;
		this.admission = new ArrayList<Admission>();
	}

	public Nurse(Integer id, String name, String specialty, boolean availability) {
		super();
		this.id = id;
		this.name = name;
		this.specialty = specialty;
		this.availability = availability;
		this.admission = new ArrayList<Admission>();
	}
	
	public Nurse(String name, String specialty, boolean availability) {
		super();
		this.name = name;
		this.specialty = specialty;
		this.availability = availability;
		this.admission = new ArrayList<Admission>();
	}
	

	public List<Admission> getAdmissions() {
		return admission;
	}

	public void setAdmission(List<Admission> patients) {
		this.admission = patients;
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

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	public void addAdmission(Admission adm) {
		if(!admission.contains(adm)) {
			this.admission.add(adm);
		}
	}
	public void removeAdmission(Admission adm) {
		if(admission.contains(adm)) {
			this.admission.remove(adm);
		}
	}
	
	public String listAdmissions() {
		String lista="";
		for (Admission adm : admission) {
			lista= lista+ adm.getId()+ ", ";
		}
		return lista;
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

	@Override
	public String toString() {
		return "Nurse [id=" + id + ", name=" + name + ", specialty=" + specialty + ", availability=" + availability
				+ "]";
	}
	
	public String toString2() {
		if(admission.equals(null)){
			return "Nurse [id=" + id + ", name=" + name + ", specialty=" + specialty + ", availability=" + availability
					+ "]";
		}
		else {
		return "Nurse [id=" + id + ", name=" + name + ", specialty=" + specialty + ", availability=" + availability+
				 ", admissions=" + listAdmissions()+ "]";}
	}


	
	
	
	
	
	

}
