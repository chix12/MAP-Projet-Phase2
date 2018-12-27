package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Projects database table.
 * 
 */
@Entity
@Table(name="Projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdProject")
	private int idProject;

	@Column(name="Address")
	private String address;

	@Column(name="Logo")
	private String logo;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to ClientRequestForm
	@OneToMany(mappedBy="project")
	private List<ClientRequestForm> clientRequestForms;

	//bi-directional many-to-one association to OrganizationalChart
	@OneToMany(mappedBy="project")
	private List<OrganizationalChart> organizationalCharts;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="IdClient")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to Mandat
	@ManyToOne
	@JoinColumn(name="IdMandat")
	private Mandat mandat;

	//bi-directional many-to-many association to AspNetUser
	@ManyToMany
	@JoinTable(
		name="RessourceProjects"
		, joinColumns={
			@JoinColumn(name="Project_IdProject")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Ressource_Id")
			}
		)
	private List<AspNetUser> aspNetUsers;

	public Project() {
	}

	public int getIdProject() {
		return this.idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ClientRequestForm> getClientRequestForms() {
		return this.clientRequestForms;
	}

	public void setClientRequestForms(List<ClientRequestForm> clientRequestForms) {
		this.clientRequestForms = clientRequestForms;
	}

	public ClientRequestForm addClientRequestForm(ClientRequestForm clientRequestForm) {
		getClientRequestForms().add(clientRequestForm);
		clientRequestForm.setProject(this);

		return clientRequestForm;
	}

	public ClientRequestForm removeClientRequestForm(ClientRequestForm clientRequestForm) {
		getClientRequestForms().remove(clientRequestForm);
		clientRequestForm.setProject(null);

		return clientRequestForm;
	}

	public List<OrganizationalChart> getOrganizationalCharts() {
		return this.organizationalCharts;
	}

	public void setOrganizationalCharts(List<OrganizationalChart> organizationalCharts) {
		this.organizationalCharts = organizationalCharts;
	}

	public OrganizationalChart addOrganizationalChart(OrganizationalChart organizationalChart) {
		getOrganizationalCharts().add(organizationalChart);
		organizationalChart.setProject(this);

		return organizationalChart;
	}

	public OrganizationalChart removeOrganizationalChart(OrganizationalChart organizationalChart) {
		getOrganizationalCharts().remove(organizationalChart);
		organizationalChart.setProject(null);

		return organizationalChart;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public Mandat getMandat() {
		return this.mandat;
	}

	public void setMandat(Mandat mandat) {
		this.mandat = mandat;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

}