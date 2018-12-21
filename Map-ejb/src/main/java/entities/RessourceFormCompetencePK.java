package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RessourceFormCompetencePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="Competence_IdCompetence")
	private int competence_IdCompetence;
	
	@Column(name="RessourceForm_IdForm")
	private int ressourceForm_IdForm;

	public int getCompetence_IdCompetence() {
		return competence_IdCompetence;
	}

	public void setCompetence_IdCompetence(int competence_IdCompetence) {
		this.competence_IdCompetence = competence_IdCompetence;
	}

	public int getRessourceForm_IdForm() {
		return ressourceForm_IdForm;
	}

	public void setRessourceForm_IdForm(int ressourceForm_IdForm) {
		this.ressourceForm_IdForm = ressourceForm_IdForm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + competence_IdCompetence;
		result = prime * result + ressourceForm_IdForm;
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
		RessourceFormCompetencePK other = (RessourceFormCompetencePK) obj;
		if (competence_IdCompetence != other.competence_IdCompetence)
			return false;
		if (ressourceForm_IdForm != other.ressourceForm_IdForm)
			return false;
		return true;
	}
	
	
}
