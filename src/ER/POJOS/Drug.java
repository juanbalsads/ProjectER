package ER.POJOS;



import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity 
@Table(name="Drugs") 
public class Drug implements Serializable{
	private static final long serialVersionUID = 5425426797359584897L;
	@Id
	@GeneratedValue(generator="Drugs")
	@TableGenerator(name="Drugs", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="Drugs")
	private Integer id;
	private String name;	
	@ManyToMany
	@JoinTable(name="Admission_Drugs",           
	joinColumns={@JoinColumn(name="drug", referencedColumnName="id")},           
	inverseJoinColumns={@JoinColumn(name="admission", referencedColumnName="id")})
	private List<Admission> admission;

		
	public Drug() {
		super();
		this.admission = new ArrayList<Admission>();
	}

	public Drug(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.admission = new ArrayList<Admission>();
	}
	
	public Drug(String name) {
		super();
		this.name = name;
		this.admission = new ArrayList<Admission>();
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
	
	
	

	public List<Admission> getAdmission() {
		return admission;
	}

	public void setAdmissions(List<Admission> admission) {
		this.admission = admission;
	}


	@Override
	public String toString() {
		return "Drug [id=" + id + ", name=" + name + ", admission=" + admission + "]";
	}

}
