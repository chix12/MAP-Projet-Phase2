package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VaccationsRessources database table.
 * 
 */
@Entity
@Table(name="VaccationsRessources")
@NamedQuery(name="VaccationsRessource.findAll", query="SELECT v FROM VaccationsRessource v")
public class VaccationsRessource implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VaccationsRessourcePK id;

	public VaccationsRessource() {
	}

	public VaccationsRessourcePK getId() {
		return this.id;
	}

	public void setId(VaccationsRessourcePK id) {
		this.id = id;
	}

}