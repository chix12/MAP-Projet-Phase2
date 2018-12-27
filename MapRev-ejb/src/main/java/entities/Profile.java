package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Profiles database table.
 * 
 */
@Entity
@Table(name="Profiles")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdProfile")
	private int idProfile;

	@Column(name="ProfileName")
	private String profileName;

	public Profile() {
	}

	public int getIdProfile() {
		return this.idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	public String getProfileName() {
		return this.profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

}