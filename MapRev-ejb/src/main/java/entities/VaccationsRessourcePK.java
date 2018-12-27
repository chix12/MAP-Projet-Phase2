package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VaccationsRessourcePK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="Vaccations_IdVaccation")
	private int vaccations_IdVaccation;
	
	@Column(name="Ressource_Id")
	private int ressource_id;

	public int getVaccation_IdVaccation() {
		return vaccations_IdVaccation;
	}

	public void setVaccation_IdVaccation(int vaccations_IdVaccation) {
		this.vaccations_IdVaccation = vaccations_IdVaccation;
	}

	public int getRessource_id() {
		return ressource_id;
	}

	public void setRessource_id(int ressource_id) {
		this.ressource_id = ressource_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ressource_id;
		result = prime * result + vaccations_IdVaccation;
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
		VaccationsRessourcePK other = (VaccationsRessourcePK) obj;
		if (ressource_id != other.ressource_id)
			return false;
		if (vaccations_IdVaccation != other.vaccations_IdVaccation)
			return false;
		return true;
	}
	
	
	
}
