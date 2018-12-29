
package LoginBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.AspNetRole;
import entities.AspNetUser;
//import entities.UserType;
import LoginPackage.UserBeanLocal;

@ManagedBean
@SessionScoped
public class Authentification {

	private String login;
	private String password;
	private String confirmPassword;
	private String firstname;
	private String lastname;
	private String adress;
	//private UserType accounttype;
	private String username;
	// private Resource resource;

	private String phoneNumber;

	private AspNetRole cv;

	private AspNetUser user;
	private boolean loggedIn;

	@EJB
	UserBeanLocal authLocal;

	public String doLogin() {
		user = new AspNetUser();
		user.setEmail(login);
		user.setPasswordHash(password);
		String navigateTo = "";
		String test = authLocal.Authentification(user);
		System.out.println(test);

		if (test.equals("\"ConnexionFailed\"")) {

			// FacesContext.getCurrentInstance().addMessage("form:btn", new
			// FacesMessage("bad credntials"));
			// FacesContext.getCurrentInstance().addMessage(null, new
			// FacesMessage("Welcome " + login + " " + password));
			FacesMessage msg = new FacesMessage("Vérifier Votre Login Ou Mot de passe");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);

		}

		else {
			navigateTo = "test.xhtml?faces-redirect=true";
			loggedIn = true;
		}
		return navigateTo;
	}

	public AspNetUser getUser() {
		return user;
	}

	public void setUser(AspNetUser user) {
		this.user = user;
	}

	/*public String doRegister() {
		String navigateTo = "";
		System.out.println("hereeeeeee");
	
		if (accounttype.equals(0)) {
			System.out.println("Client choisie");
			AspNetUser Client = new AspNetUser();
			Client.setAccountType(accounttype);
			Client.setUserName(login);
			Client.setEmail(login);
			Client.setPasswordHash(password);
			Client.setAdress(adress);
			// Client.setPhoneNumber(phoneNumber);
			// Client.setLastName(lastname);
			// Client.setFirstName(firstname);

			// Client.setCv("Resource");
			// Client.setAddress(address);

			String test = authLocal.Register(Client);
			System.out.println(test);

			if (test.equals("")) {
				// FacesContext.getCurrentInstance().addMessage(null,
				// new FacesMessage("Welcome " + firstname + " " + lastname));
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credntials"));

			} else {

				navigateTo = "/TemplateClient/Login?faces-redirect=true";
				loggedIn = true;
			}

		} else if (accounttype.equals(1)) {
			System.out.println("Ressource choisie");
			AspNetUser Ressource = new AspNetUser();
			Ressource.setAccountType(accounttype);
			Ressource.setUserName(login);
			Ressource.setEmail(login);
			Ressource.setPasswordHash(password);
			Ressource.setAdress(adress);
			// Client.setCv("Resource");
			// Client.setAddress(address);

			System.out.println(Ressource.toString());

			String test = authLocal.Register(Ressource);

			if (test.equals("")) {
				// FacesContext.getCurrentInstance().addMessage(null,
				// new FacesMessage("Welcome " + firstname + " " + lastname));
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credntials"));

			} else {

				navigateTo = "/TemplateClient/Login?faces-redirect=true";
				loggedIn = true;
			}
		}

		else if (accounttype.equals(2)) {
			System.out.println("Candidate choisie");
			AspNetUser Candidate = new AspNetUser();
			Candidate.setAccountType(accounttype);
			Candidate.setUserName(login);
			Candidate.setEmail(login);
			Candidate.setPasswordHash(password);
			Candidate.setAdress(adress);
			// Client.setCv("Resource");
			// Client.setAddress(address);

			System.out.println(Candidate.toString());

			String test = authLocal.Register(Candidate);

			if (test.equals("")) {
				// FacesContext.getCurrentInstance().addMessage(null,
				// new FacesMessage("Welcome " + firstname + " " + lastname));
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credntials"));

			} 
			else {

				navigateTo = "/TemplateClient/Login?faces-redirect=true";
				loggedIn = true;
			}

		}

		return navigateTo;
	}
*/
	public String doLogout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/login?faces-redirect=true";

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/*
	 * public Role getCv() { return cv; }
	 * 
	 * public void setCv(Role cv) { this.cv = cv; }
	 * 
	 * public Role[] getRoles() {
	 * 
	 * return Role.values(); }
	 */

	/*public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	*/

	public String getUsername() {
		return username;
	}

	 

	public void setUsername(String username) {
		this.username = username;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}