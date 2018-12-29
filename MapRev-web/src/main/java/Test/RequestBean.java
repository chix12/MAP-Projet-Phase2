package Test;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import RequestCons.RequestConsommationLocal;
import entities.ClientRequestForm;

@ManagedBean
@SessionScoped
public class RequestBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	RequestConsommationLocal requestConsommationLocal ; 
	
	@PostConstruct
    public void init() {}
	
	public List<ClientRequestForm> DogetRequests()
	{
		List<ClientRequestForm> request = requestConsommationLocal.getRequests();
		return request ;
	}
	
	
}
