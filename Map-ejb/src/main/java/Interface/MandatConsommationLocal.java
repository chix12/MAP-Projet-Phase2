package Interface;
import java.util.List;

import javax.ejb.Local;

import entities.Mandat;

 

@Local
public interface MandatConsommationLocal {
	public int ajouterRequest(Mandat req);
	public int modifierRequest (Mandat req);
	public int deleteRequest (Mandat req);

	public List<Mandat> getall();
	public List<Mandat> getRequestbyid(int req);


}
