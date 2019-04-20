package ER.POJOS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {


	private static final long serialVersionUID = -6231174409516146935L;

	@Id
	@GeneratedValue(generator="doctors")
	@TableGenerator(name="doctors", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="doctors")
	private Integer id;
	private String name;
	private String specialty;
	private boolean availability;
	
	@OneToMany(mappedBy = "doctor")	
	private List<Admission> admission;
	
	public Doctor() {
		super();
		this.admission= new ArrayList<Admission>();
	}
	
	public Doctor(Integer id) {
		super();
		this.id = id;
	}
	
	public Doctor(Integer id, String name, String specialty, boolean availability) {
		super();
		this.id = id;
		this.name = name;
		this.specialty = specialty;
		this.availability = availability;
		this.admission= new ArrayList<Admission>();
	}
	
	public Doctor(String name, String specialty, boolean availability) {
		super();
		this.name = name;
		this.specialty = specialty;
		this.availability = availability;
		this.admission= new ArrayList<Admission>();
	}

	public List<Admission> getDoctors() {
		return admission;
	}

	public void setDoctors(List<Admission> admission) {
		this.admission = admission;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (availability ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((specialty == null) ? 0 : specialty.hashCode());
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
		Doctor other = (Doctor) obj;
		if (availability != other.availability)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (specialty == null) {
			if (other.specialty != null)
				return false;
		} else if (!specialty.equals(other.specialty))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialty=" + specialty + ", availability=" + availability
				+ ", doctors=" + admission + "]";
	}



	
	
	
	
}
