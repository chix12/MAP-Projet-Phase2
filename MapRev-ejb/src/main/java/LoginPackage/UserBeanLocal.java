package LoginPackage;

import javax.ejb.Local;

import entities.AspNetUser;

@Local
public interface UserBeanLocal {
	public String Register(AspNetUser user);
	public String Authentification(AspNetUser user);
}
