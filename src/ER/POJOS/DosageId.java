package ER.POJOS;

import java.io.Serializable;

public class DosageId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6599837575630304190L;
	private Integer admission_id;
	private Integer drug_id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admission_id == null) ? 0 : admission_id.hashCode());
		result = prime * result + ((drug_id == null) ? 0 : drug_id.hashCode());
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
		DosageId other = (DosageId) obj;
		if (admission_id == null) {
			if (other.admission_id != null)
				return false;
		} else if (!admission_id.equals(other.admission_id))
			return false;
		if (drug_id == null) {
			if (other.drug_id != null)
				return false;
		} else if (!drug_id.equals(other.drug_id))
			return false;
		return true;
	}
	
	
	


}

