package Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Interface.UserServiceRemote;
import entities.AspNetUser;


//@Statefull
@Stateless
@LocalBean
public class UserService implements UserServiceRemote{
	
	
	
	@PersistenceContext	
    private EntityManager entityManager;
	


	 
    @Override
	public Boolean ajouterUser(AspNetUser user) {
		try {
			entityManager.persist(user);
			return true;
		} catch (PersistenceException e) {
			System.out.println();
			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhh"+e.getMessage());
			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhh");
			return false;
		}
		
	}
    

    
    

	



	@Override
	public List<AspNetUser> findAllUsers() {
		Query query=entityManager.createQuery("Select e from AspNetUser e");
		return query.getResultList();
	}

	
	



			@Override
			public AspNetUser getUserByLoginAndPassword(String login, String password)
			{ TypedQuery<AspNetUser> query = entityManager.createQuery("Select e from AspNetUser e "
			+ "where e.userName=:login and "+ "e.passwordHash=:password", AspNetUser.class);
			query.setParameter("login", login); 
			query.setParameter("password", password);
			AspNetUser user = null;
			try
			{
			user = query.getSingleResult();
			}
			catch (NoResultException e) 
			{
			Logger.getAnonymousLogger().info("user not found");


			}
			return user;
	}
	 

	

}
