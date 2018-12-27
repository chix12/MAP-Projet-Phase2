package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Competences database table.
 * 
 */
@Entity
@Table(name="Competences")
@NamedQuery(name="Competence.findAll", query="SELECT c FROM Competence c")
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCompetence")
	private int idCompetence;

	@Column(name="CompetenceName")
	private String competenceName;

	@Column(name="Rank")
	private int rank;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="Ressource_Id")
	private AspNetUser aspNetUser;

	public Competence() {
	}

	public int getIdCompetence() {
		return this.idCompetence;
	}

	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}

	public String getCompetenceName() {
		return this.competenceName;
	}

	public void setCompetenceName(String competenceName) {
		this.competenceName = competenceName;
	}

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}