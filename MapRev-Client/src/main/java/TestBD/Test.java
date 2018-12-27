package TestBD;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import RessCon.RessourceConsomRemote;

public class Test {

	public static void main(String[] args) throws NamingException{

		
		InitialContext cxt = new InitialContext();
		Object Object = cxt.lookup("MapRev-ear/MapRev-ejb/RessourceConsom!RessCon.RessourceConsomRemote");
		RessourceConsomRemote client =  (RessourceConsomRemote) Object ;
		client.consomation();
		
		/*
		String jndiName = "MAP-Rise-ear/MAP-Rise-ejb/UserService!SessionBean.UserServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxy = (UserServiceRemote)context.lookup(jndiName);*/
		
	}

}
