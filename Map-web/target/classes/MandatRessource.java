import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import Interface.MandatConsommationRemote;
import entities.Mandat;

@Path("mes")
@RequestScoped
public class MandatRessource {
	
	@EJB(beanName="MandatService")
	MandatConsommationRemote em;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Mandat> mes = new ArrayList<>();
		mes=  em.getall();
			return Response.status(Status.OK).entity(mes).build();
		}
}
