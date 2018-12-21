package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the JobRequests database table.
 * 
 */
@Entity
@Table(name="JobRequests")
@NamedQuery(name="JobRequest.findAll", query="SELECT j FROM JobRequest j")
public class JobRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdRequest")
	private int idRequest;

	@Column(name="RequestDate")
	private Timestamp requestDate;

	@Column(name="Status")
	private String status;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="jobRequest")
	private List<AspNetUser> aspNetUsers;

	public JobRequest() {
	}

	public int getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	public Timestamp getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUser addAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().add(aspNetUser);
		aspNetUser.setJobRequest(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setJobRequest(null);

		return aspNetUser;
	}

}