package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Mandats database table.
 * 
 */
@Entity
@Table(name="Mandats")
@NamedQuery(name="Mandat.findAll", query="SELECT m FROM Mandat m")
public class Mandat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MandatId")
	private int mandatId;

	@Column(name="EndDate")
	private Timestamp endDate;

	@Column(name="StartDate")
	private Timestamp startDate;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="Ressource_Id")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="mandat")
	private List<Project> projects;

	public Mandat() {
	}

	public int getMandatId() {
		return this.mandatId;
	}

	public void setMandatId(int mandatId) {
		this.mandatId = mandatId;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setMandat(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setMandat(null);

		return project;
	}

}