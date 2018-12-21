package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AspNetRoles database table.
 * 
 */
@Entity
@Table(name="AspNetRoles")
@NamedQuery(name="AspNetRole.findAll", query="SELECT a FROM AspNetRole a")
public class AspNetRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Name")
	private String name;

	public AspNetRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}