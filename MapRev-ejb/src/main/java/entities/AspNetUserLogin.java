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
	private AspNetUserLoginPK idPK;

	@Column(name="Id")
	private int id;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="UserId" , insertable=false, updatable=false)
	private AspNetUser aspNetUser;

	public AspNetUserLogin() {
	}

	public AspNetUserLoginPK getIdPK() {
		return this.idPK;
	}

	public void setIdPK(AspNetUserLoginPK id) {
		this.idPK = id;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}