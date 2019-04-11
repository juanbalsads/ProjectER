package ER.POJOS;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Boxes")

public class Box implements Serializable {

	@Id
	/**
	 * 
	 */
	private static final long serialVersionUID = 8727419477663469192L;

	private Integer id; 
	private boolean availability;
	 @OneToOne(fetch=FetchType.LAZY, mappedBy="box")
	private Admission admission;
	
	public Box() {
		super();
	}

	public Box(Integer id, boolean release, Admission admission) {
		super();
		this.id = id;
		this.availability = release;
		this.admission= admission;
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
		Box other = (Box) obj;
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

	

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Admission getAdmission() {
		return admission;
	}

	public void setAdmission(Admission admission) {
		this.admission = admission;
	}

	@Override
	public String toString() {
		return "Box [id=" + id + ", availability=" + availability + ", admission=" + admission + "]";
	}

	

	
	
	
	
	
	
	
}
