package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OrganizationalCharts database table.
 * 
 */
@Entity
@Table(name="OrganizationalCharts")
@NamedQuery(name="OrganizationalChart.findAll", query="SELECT o FROM OrganizationalChart o")
public class OrganizationalChart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdChart")
	private int idChart;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="IdClient")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="IdRessource")
	private AspNetUser aspNetUser2;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="IdProject")
	private Project project;

	public OrganizationalChart() {
	}

	public int getIdChart() {
		return this.idChart;
	}

	public void setIdChart(int idChart) {
		this.idChart = idChart;
	}

	public AspNetUser getAspNetUser1() {
		return this.aspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return this.aspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		this.aspNetUser2 = aspNetUser2;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}