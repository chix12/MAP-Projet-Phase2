package Interface;

import java.util.List;

import javax.ejb.Remote;

import entities.AspNetUser;

@Remote
public interface UserServiceRemote {

	Boolean ajouterUser(AspNetUser user);

	List<AspNetUser> findAllUsers();

	AspNetUser getUserByLoginAndPassword(String login, String password);
	

}

