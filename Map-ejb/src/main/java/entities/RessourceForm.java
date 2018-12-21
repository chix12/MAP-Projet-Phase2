package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RessourceForms database table.
 * 
 */
@Entity
@Table(name="RessourceForms")
@NamedQuery(name="RessourceForm.findAll", query="SELECT r FROM RessourceForm r")
public class RessourceForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdForm")
	private int idForm;

	@Column(name="RessourceFirstName")
	private String ressourceFirstName;

	@Column(name="RessourceLastName")
	private String ressourceLastName;

	public RessourceForm() {
	}

	public int getIdForm() {
		return this.idForm;
	}

	public void setIdForm(int idForm) {
		this.idForm = idForm;
	}

	public String getRessourceFirstName() {
		return this.ressourceFirstName;
	}

	public void setRessourceFirstName(String ressourceFirstName) {
		this.ressourceFirstName = ressourceFirstName;
	}

	public String getRessourceLastName() {
		return this.ressourceLastName;
	}

	public void setRessourceLastName(String ressourceLastName) {
		this.ressourceLastName = ressourceLastName;
	}

}