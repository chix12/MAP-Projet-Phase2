package Interface;

import java.util.List;

import javax.ejb.Remote;

import entities.Mandat;



@Remote
public interface MandatConsommationRemote {

	public int ajouterRequest(Mandat req);
	public int modifierRequest ( Mandat req);
	public int deleteRequest (Mandat req);

	public List<Mandat> getall();
	public List<Mandat> getRequestbyid(int req);
}
