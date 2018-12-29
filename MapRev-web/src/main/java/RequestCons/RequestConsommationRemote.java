package RequestCons;

import java.util.List;

import javax.ejb.Remote;

import entities.ClientRequestForm;

@Remote
public interface RequestConsommationRemote {
	//public void consomation();
	public List<ClientRequestForm> getRequests();
}
