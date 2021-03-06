package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the ClientRequestForms database table.
 * 
 */
@Entity
@Table(name="ClientRequestForms")
@NamedQuery(name="ClientRequestForm.findAll", query="SELECT c FROM ClientRequestForm c")
public class ClientRequestForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdForm")
	private int idForm;

	@Column(name="Description")
	private String description;

	@Column(name="EndDate")
	private Date endDate;

	@Column(name="Experience")
	private String experience;

	@Column(name="ProfileNeeded")
	private String profileNeeded;

	@Column(name="Requirements")
	private String requirements;

	@Column(name="StartDate")
	private Date startDate;

	@Column(name="Type")
	private String type;

	@Column(name="YearsOfExperience")
	private int yearsOfExperience;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="Client_Id")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="IdProject")
	private Project project;

	public ClientRequestForm() {
	}

	public int getIdForm() {
		return this.idForm;
	}

	public void setIdForm(int idForm) {
		this.idForm = idForm;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getProfileNeeded() {
		return this.profileNeeded;
	}

	public void setProfileNeeded(String profileNeeded) {
		this.profileNeeded = profileNeeded;
	}

	public String getRequirements() {
		return this.requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYearsOfExperience() {
		return this.yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "ClientRequestForm [idForm=" + idForm + ", description=" + description + ", endDate=" + endDate
				+ ", experience=" + experience + ", profileNeeded=" + profileNeeded + ", requirements=" + requirements
				+ ", startDate=" + startDate + ", type=" + type + ", yearsOfExperience=" + yearsOfExperience
				+ ", aspNetUser=" + aspNetUser + ", project=" + project + "]";
	}
	
	

}