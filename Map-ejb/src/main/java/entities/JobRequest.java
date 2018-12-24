package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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

}