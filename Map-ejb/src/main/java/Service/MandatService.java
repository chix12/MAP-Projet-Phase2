package Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Interface.MandatConsommationLocal;
import Interface.MandatConsommationRemote;
import entities.Mandat;

@Stateless 
@LocalBean

public class MandatService implements MandatConsommationLocal ,MandatConsommationRemote {
		@PersistenceContext(unitName="MapRev-ejb")
	EntityManager em;
	
	@Override
	public int ajouterRequest(Mandat req) {

		em.persist(req);
			return 1;
	}

	@Override
	public int modifierRequest(Mandat req) {

em.merge(req);

		return 1;
	}

	@Override
	public int deleteRequest(Mandat req) {
		em.remove(em.contains(req) ? req : em.merge(req)); 
		return 1;
	}

	@Override
	public  List<Mandat> getall() {

		TypedQuery<Mandat> query = em.createQuery("select e from Mandat e ",Mandat.class);
		return (List<Mandat>)query.getResultList();
	}

	@Override
	public List<Mandat> getRequestbyid(int req) {
		TypedQuery<Mandat> query = em.createQuery("select e from Mandat e where e.aspNetUser ="+req,Mandat.class);
		   System.out.println(query);
			return  (List<Mandat>)query.getResultList();
		
	}
	public Mandat getMandatid(int req) {
		TypedQuery<Mandat> query = em.createQuery("select e from Mandat e where e.MandatId ="+req,Mandat.class);
		if(	query.getResultList().isEmpty()){return null;}
		else{
			return (Mandat)query.getSingleResult();
		}
	}
	public int DaysNomber (Mandat m ){
//		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		//String String1 = m.getStartDate().toString(); 
		//String String2 =m.getEndDate().toString();

		Date date2 = m.getStartDate();
		Date date1 = m.getEndDate();
		long diff = date1.getTime() - date2.getTime();
		System.out.println(diff);
		int n =(int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));	
		return n ; 
	}
	public int Restant  (Mandat m ){
		Date date = new Date();


//		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		//String String1 = m.getStartDate().toString(); 
		//String String2 =m.getEndDate().toString();

		 
		Date date1 = m.getEndDate();
		long diff = date1.getTime() - date.getTime();
		System.out.println(diff);
		int n =(int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));	
		return n ; 
	}
	public void sendMail() {
		try {
			String email="monia.lahsoumi@esprit.tn" ;
			String host = "smtp.gmail.com";
			String from = "monia.lahsoumi@esprit.tn";
			String pass = "180795mm";
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			String to = email;
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			InternetAddress toAddress = new InternetAddress(to);

			message.addRecipient(Message.RecipientType.CC, new InternetAddress("rym.elomrani@esprit.tn"));
			message.addRecipient(Message.RecipientType.CC, new InternetAddress("mo.ni.a@live.com"));

			message.setSubject("Your Mandat Expires in 40 Days ");
			message.setText(
					"Your Mandat Expires in 40 Days or Less : "
							);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.getMessage();
		}
}}

