package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RessourceFormCompetences database table.
 * 
 */
@Entity
@Table(name="RessourceFormCompetences")
@NamedQuery(name="RessourceFormCompetence.findAll", query="SELECT r FROM RessourceFormCompetence r")
public class RessourceFormCompetence implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RessourceFormCompetencePK id;

	public RessourceFormCompetence() {
	}

	public RessourceFormCompetencePK getId() {
		return this.id;
	}

	public void setId(RessourceFormCompetencePK id) {
		this.id = id;
	}

}