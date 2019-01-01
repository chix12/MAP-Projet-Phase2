package SessionBean;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import Service.UserService;
import entities.AspNetUser;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;



@ManagedBean
@SessionScoped
public class LoginBean {
	   
	private String login; 
	private String password; 
	private AspNetUser user;
	private boolean loggedln; 
	// default is false
	// injection de dependences 
	@EJB
	UserService userService;
	
	
	public String Login() {
		String navigateTo = "null";
		user = userService.getUserByLoginAndPassword(login, password);
		System.out.println(user);

		

		
			return "/listerUsers?faces-redirect=true" ;
	}
	
	
	
	public String doLogout() 
		{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession() ;
		return "/login?faces-redirect=true";
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



	public AspNetUser getUser() {
		return user;
	}



	public void setUser(AspNetUser user) {
		this.user = user;
	}



	public boolean isLoggedln() {
		return loggedln;
	}



	public void setLoggedln(boolean loggedln) {
		this.loggedln = loggedln;
	}
	
	
	
	
	
}
