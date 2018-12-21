package Consommation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class RequestConsommation
 */
@Stateless
@LocalBean
public class RequestConsommation implements RequestConsommationRemote, RequestConsommationLocal {

    /**
     * Default constructor. 
     */
    public RequestConsommation() {
        // TODO Auto-generated constructor stub
    }
    
    public void Consommation() {
		Client client = ClientBuilder.newClient();
    	WebTarget target = client.target("http://localhost:21991/API/Affichage");
    	Response response = target.request().get();
    	String result = response.readEntity(String.class);
		System.out.println(result);
		response.close();
    }

}
