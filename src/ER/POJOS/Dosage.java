package ER.POJOS;

import java.io.Serializable;
import javax.persistence.*;

@Table(name="Admission_Drugs") 
@IdClass(DosageId.class)

public class Dosage implements Serializable  {
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
	
	
	

}
