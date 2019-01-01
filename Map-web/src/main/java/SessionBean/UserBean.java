package SessionBean;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Service.UserService;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import entities.AspNetUser;



@ManagedBean
@SessionScoped
public class UserBean {
	private String UserName; 
	private String login; 
	private String password;
 
	private String userType;
	private AspNetUser user;
	private boolean loggedln; 
	private List<AspNetUser> listeUsers;
	 

	@EJB
	UserService userService;
	
	
	public String LoadPage (){
		
		return "/Historique.xhtml";
		}

	
		 
	 

	 
	
	 
	public List<AspNetUser> getListeUsers() {
		listeUsers=userService.findAllUsers();
		return listeUsers;
	}

	 

	public String UserRegister() {
		String navigateTo = "null";
		System.out.println("User Register");
	
			
			if(userService.ajouterUser(new AspNetUser(UserName,password,userType)))
			{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("User successfully added"));
			navigateTo = "/login?faces-redirect=true";
			} 
		else 
			{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Adding user failed"));
			}
		return navigateTo;
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


	 


	public String getUserName() {
		return UserName;
	}



	public void setUserName(String userName) {
		UserName = userName;
	}



	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	


	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	


	





	









	
	
	
	
}
