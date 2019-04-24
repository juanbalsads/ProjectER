package ER.POJOS;

import java.io.Serializable;
import javax.persistence.*;

@Table(name="Admission_Drugs") 
@IdClass(DosageId.class)

public class Dosage implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 777479542299658839L;
	@Id
	private Integer admission_id;
	@Id
	private Integer drug_id;
	@Column(name="dosage")
	private double dosage;
	@ManyToOne
	@PrimaryKeyJoinColumn(name="admission_id", referencedColumnName="id")
	private Admission admission;
	@ManyToOne
	@PrimaryKeyJoinColumn(name="drug_id", referencedColumnName="id")
	private Drug drug;
	public Integer getAdmission_id() {
		return admission_id;
	}
	public void setAdmission_id(Integer admission_id) {
		this.admission_id = admission_id;
	}
	public Integer getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(Integer drug_id) {
		this.drug_id = drug_id;
	}
	public double getDosage() {
		return dosage;
	}
	public void setDosage(double dosage) {
		this.dosage = dosage;
	}
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
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
		Dosage other = (Dosage) obj;
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
