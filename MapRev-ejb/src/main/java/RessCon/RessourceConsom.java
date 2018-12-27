package RessCon;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class RessourceConsom
 */
@Stateless
@LocalBean
public class RessourceConsom implements RessourceConsomRemote, RessourceConsomLocal {

    /**
     * Default constructor. 
     */
    public RessourceConsom() {
        // TODO Auto-generated constructor stub
    }

    
    public void consomation()
    {
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://http://localhost:21991/API/Affichage"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	System.out.println(result);
    	
    	
    }
}
