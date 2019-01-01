package Consommation;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Service.MandatService;
import entities.AspNetUser;
import entities.Mandat;

public class PostWs {

	public static void main(String[] args) throws IOException, JSONException, ParseException {
		// TODO Auto-generated method stub
            clientPost c = new clientPost();
try {
            JSONArray json = c.readJsonFromUrl("http://localhost:21991/API/Affichage/?format=json");
            JSONArray json1 = c.readJsonFromUrl("http://localhost:21991/API/Client/?format=json");
            ArrayList<Mandat> ListPost = new  ArrayList<>();
            for (int i = 0, count = json.length(); i < count; i++) {
            	Mandat mandat = new  Mandat();
            
//winek lenna ? eyy 
            	
            	JSONObject obj =(JSONObject)json.get(i);
            	String string =obj.get("EndDate").toString();
            	String string1 =obj.get("StartDate").toString();
            	//java.sql.Date date = java.sql.Date.valueOf(string);
				Date date =(Date) new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(string);
				Date date1 =(Date) new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(string1);
				int id =(int) obj.get("MandatId");
				int frais =(int) obj.get("Frais");
				int r = (int) obj.get("Ressource_Id");
				mandat.setEndDate(date);
				//mandat.setMandatId(id);
				//MandatService m = new MandatService(); 
				//Mandat man = m.getRequestbyid(r);
				//mandat.setAspNetUser(man);
				mandat.setStartDate(date1);
				mandat.setFrais(frais);


				
				 ListPost.add(mandat);
            	 
			 
				 
				}
				
			
            System.out.println(ListPost);
            ArrayList<AspNetUser> ListPost1 = new  ArrayList<>();
            for (int i = 0, count = json1.length(); i < count; i++) {
            	AspNetUser mandat = new  AspNetUser();
            
//winek lenna ? eyy 
            	
            	JSONObject obj =(JSONObject)json1.get(i);
            	String string =obj.get("Email").toString();
            	String string1 =obj.get("PhoneNumber").toString();
            	//java.sql.Date date = java.sql.Date.valueOf(string);
				
				 
				mandat.setAccountType(string1);
				mandat.setPhoneNumber(string);
				//mandat.setMandatId(id);
				//MandatService m = new MandatService(); 
				//Mandat man = m.getRequestbyid(r);
				//mandat.setAspNetUser(man);
				



				
				 ListPost1.add(mandat);
            	 
			 
				 
				}
				
			
            System.out.println(ListPost1);

            
      //      post.setPostedDate(obj.get("date").toString());
           
                //    

           
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}
	
}


