package RequestCons;



import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import entities.ClientRequestForm;
import entities.Project;
import webService.clientSk;

/**
 * Session Bean implementation class RessourceConsom
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

	/*
	 * public void consomation() { Client client = ClientBuilder.newClient();
	 * 
	 * WebTarget web = client.target("http://localhost:21991/API/Affichage");
	 * 
	 * Response response = web.request().get();
	 * 
	 * String result = response.readEntity(String.class);
	 * 
	 * System.out.println(result);
	 * 
	 * 
	 * }
	 */
	@Override
	public List<ClientRequestForm> getRequests() {
		clientSk sk = new clientSk(2);
		ArrayList<ClientRequestForm> listReq = new ArrayList<>();

		try {
			JSONArray json = sk.readJsonFromUrl("http://localhost:21991/API/Affichage");
			for (int i = 0, count = json.length(); i < count; i++) {
				ClientRequestForm req = new ClientRequestForm();
				JSONObject obj = (JSONObject) json.get(i);

				req.setDescription(obj.get("Description").toString());

				/*SimpleDateFormat dateEndFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				req.setEndDate((Date) dateEndFormat.parse(obj.getString("EndDate")));

				SimpleDateFormat dateStartFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				req.setStartDate((Date) dateStartFormat.parse(obj.getString("StartDate")));*/
				
				req.setIdForm(obj.getInt("IdForm"));
				req.setProfileNeeded(obj.get("ProfileNeeded").toString());
				//req.setProject(project);(obj.getInt("IdProject"));
				req.setRequirements(obj.get("Requirements").toString());
				req.setType(obj.get("Type").toString());
				req.setYearsOfExperience(obj.getInt("YearsOfExperience"));
				listReq.add(req);
			}

			System.out.println(listReq);
			

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		return(listReq);

	}
}
