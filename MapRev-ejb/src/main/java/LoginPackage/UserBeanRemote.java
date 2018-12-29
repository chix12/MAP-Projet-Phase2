package LoginPackage;

import javax.ejb.Remote;

import entities.AspNetUser;

@Remote
public interface UserBeanRemote {
	public String Register(AspNetUser user);
	public String Authentification(AspNetUser user);
}
