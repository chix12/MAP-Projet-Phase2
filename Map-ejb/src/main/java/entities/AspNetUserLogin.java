package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AspNetUserLogins database table.
 * 
 */
@Entity
@Table(name="AspNetUserLogins")
@NamedQuery(name="AspNetUserLogin.findAll", query="SELECT a FROM AspNetUserLogin a")
public class AspNetUserLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AspNetUserLoginPK loginId;

	@Column(name="Id")
	private int userId;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="UserId")
	private AspNetUser aspNetUser;

	public AspNetUserLogin() {
	}

	public AspNetUserLoginPK getLoginId() {
		return this.loginId;
	}

	public void setLoginId(AspNetUserLoginPK loginId) {
		this.loginId = loginId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}