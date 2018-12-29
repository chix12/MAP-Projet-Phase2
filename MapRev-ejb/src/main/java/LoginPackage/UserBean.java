package LoginPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;

//import Entity.Resource;
//import entities.Test;
import entities.AspNetUser;

@Stateless
public class UserBean implements UserBeanLocal, UserBeanRemote {
	@PersistenceContext(unitName = "MapRev-ejb")
	EntityManager em;

	public void Authentification() {

		// Client client = ClientBuilder.newClient();
		// WebTarget target= client.target("http://localhost:38198/api/Tests");
		// WebTarget hello =target.matrixParam(arg0, arg1);
		// Response reponse =target.request().get();
		// String result =reponse.readEntity(String.class);
		// System.out.println(result);
		// reponse.close();

		// try{
		// // URL url = new URL("http://localhost:38198/api/Tests");//your url
		// i.e fetch data from .
		// // HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// // conn.setRequestMethod("GET");
		// // conn.setRequestProperty("Accept", "application/json");
		//// if (conn.getResponseCode() != 200) {
		//// throw new RuntimeException("Failed : HTTP Error code : "
		//// + conn.getResponseCode());
		//// }
		//// InputStreamReader in = new
		// InputStreamReader(conn.getInputStream());
		//// BufferedReader br = new BufferedReader(in);
		//// String output;
		//// while ((output = br.readLine()) != null) {
		//// System.out.println(output);
		//// }
		//// conn.disconnect();
		//
		// } catch (Exception e) {
		// System.out.println("Exception in NetClientGet:- " + e);
		// }
		// }

	}

	public String Authentification(AspNetUser user) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:21991/api/Login");

		Response reponse = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
		String result = reponse.readEntity(String.class);
		System.out.println(result);
		if (result.equals("")) {
			 
			reponse.close();
			return result;
		} 
		else {
			 
			reponse.close();
			return result;
		}
	}

	public String Register(AspNetUser user) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:21991/api/Register");

		Response reponse = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
		String result = reponse.readEntity(String.class);
		System.out.println(result);
		reponse.close();
		return result;
	}

	}