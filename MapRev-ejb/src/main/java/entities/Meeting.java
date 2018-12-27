package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Meetings database table.
 * 
 */
@Entity
@Table(name="Meetings")
@NamedQuery(name="Meeting.findAll", query="SELECT m FROM Meeting m")
public class Meeting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdMeeting")
	private int idMeeting;

	@Column(name="MeetingDate")
	private Timestamp meetingDate;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="IdAdministrator")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="IdClient")
	private AspNetUser aspNetUser2;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="IdRessource")
	private AspNetUser aspNetUser3;

	public Meeting() {
	}

	public int getIdMeeting() {
		return this.idMeeting;
	}

	public void setIdMeeting(int idMeeting) {
		this.idMeeting = idMeeting;
	}

	public Timestamp getMeetingDate() {
		return this.meetingDate;
	}

	public void setMeetingDate(Timestamp meetingDate) {
		this.meetingDate = meetingDate;
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

	public AspNetUser getAspNetUser3() {
		return this.aspNetUser3;
	}

	public void setAspNetUser3(AspNetUser aspNetUser3) {
		this.aspNetUser3 = aspNetUser3;
	}

}