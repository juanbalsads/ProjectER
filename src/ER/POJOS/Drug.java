package ER.POJOS;



import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity 
@Table(name="Drugs") 
public class Drug implements Serializable{

	@Id
	/**
	 * 
	 */
	private static final long serialVersionUID = 5425426797359584897L;

	private Integer id;
	private String name;
	@ManyToMany
	@JoinTable(name="Admission_Drugs",           
	joinColumns={@JoinColumn(name="", referencedColumnName="id")},           
	inverseJoinColumns={@JoinColumn(name="proj_id", referencedColumnName="id")})
	@OneToMany(mappedBy="drug") 
	private List<Admission> admissions ;
	private List<Patient> patients;
	
	
	public Drug() {
		super();
		this.admissions = new ArrayList<Admission>();
		this.patients = new ArrayList<Patient>();
	}

	public Drug(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.admissions = new ArrayList<Admission>();
		this.patients = new ArrayList<Patient>();
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
		Drug other = (Drug) obj;
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
	
	
	

	public List<Admission> getAdmissions() {
		return admissions;
	}

	public void setAdmissions(List<Admission> admissions) {
		this.admissions = admissions;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Drug [id=" + id + ", name=" + name + ", admissions=" + admissions + ", patients=" + patients + "]";
	}

}
