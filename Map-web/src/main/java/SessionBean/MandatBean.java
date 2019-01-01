package SessionBean;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.xml.crypto.Data;

import org.primefaces.context.RequestContext;

import Service.MandatService;
import entities.AspNetUser;
import entities.Mandat;


import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.bean.ManagedBean;




@ManagedBean
@SessionScoped
public class MandatBean {
	 
	public Date StartDate;
	public Date EndDate;
	public Mandat Mandat = new Mandat();
	public int Frais;
	public int n ;
	public AspNetUser user ;
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public Mandat getMandat() {
		return Mandat;
	}
	public void setMandat(Mandat mandat) {
		Mandat = mandat;
	}
	public AspNetUser getUser() {
		return user;
	}
	public void setUser(AspNetUser user) {
		this.user = user;
	}
	public int getRessource_Id() {
		return Ressource_Id;
	}
	public void setRessource_Id(int ressource_Id) {
		Ressource_Id = ressource_Id;
	}
	public List<Mandat> getListeMandat() {
		return listeMandat;
	}
	public void setListeMandat(List<Mandat> listeMandat) {
		this.listeMandat = listeMandat;
	}
	public void setListeUsers(List<Mandat> listeUsers) {
		this.listeUsers = listeUsers;
	}
	private int Ressource_Id ; 
	private List<Mandat> listeUsers;
	public List<Mandat> listeMandat;


	@EJB
	MandatService userService;
	
	public List<Mandat> getListeUsers() {
		listeUsers=userService.getall();
		return listeUsers;
	}
	public void removeUser(Mandat req) {
		userService.deleteRequest(req);
	}
	public void Add() {
		userService.ajouterRequest(Mandat) ;
		 
	}
	public List<Mandat> historique() {
		int n ;
		listeMandat=userService.getRequestbyid(user.getId());
		for (int i=0; i<listeMandat.size(); i++) {
			 
			n= userService.Restant(listeMandat.get(i));
if (n<0 ) {
	listeMandat.remove(listeMandat.get(i));
}
			}
		System.out.println("Hayaaaaaaaaaa"+listeMandat);
		return listeMandat;
		
	}
public String LoadPage (){
	userService.ajouterRequest(Mandat);
		return "/listerMandats.xhtml";
		}

	public int FraisTotal (Mandat m ) {
	 n = userService.DaysNomber(m) ;
    n=n*m.getFrais();
	return n;
	}
	
	public String joursRestant (Mandat m )
	{
		 n = userService.Restant(m);
		 if (n<0 ) {
			 return "EXPIRED " ; 
			 
		 }
		 else 
			 return "STILL AVAILABLE "+ n + " DAYS LEFT";

	
	}
	public void SendMail () {
		 userService.sendMail();
		 }
	}



	









	
	
	
	

