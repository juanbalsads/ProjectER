package ER.POJOS;

import java.io.Serializable;
import javax.persistence.*;

public class DosageId implements Serializable {
	private Integer admission_id;
	private Integer drug_id;
	
	public int hashCode() {
		return (int)(admissionId + drugId);
		
	}
	
	public boolean equals(Object object) {
		if(object instanceof DosageId)
	    
		   }


}

