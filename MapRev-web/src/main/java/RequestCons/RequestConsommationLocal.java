package RequestCons;

import java.util.List;

import javax.ejb.Local;

import entities.ClientRequestForm;

@Local
public interface RequestConsommationLocal {
	//public void consomation();
	public List<ClientRequestForm> getRequests();
}
