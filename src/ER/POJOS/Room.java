package ER.POJOS;

import java.io.Serializable;

public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8727419477663469192L;

	private Integer id; 
	private boolean availability;
	
	public Room() {
		super();
	}

	public Room(Integer id, boolean release) {
		super();
		this.id = id;
		this.availability = release;
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
		Room other = (Room) obj;
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

	public void setAvailabily(boolean release) {
		this.availability = release;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", release=" + availability + "]";
	}

	
	
	
	
	
	
	
}
