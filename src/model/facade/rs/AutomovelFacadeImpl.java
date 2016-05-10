package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.AutomovelDao;
import model.domain.Automovel;
import model.facade.AutomovelFacade;

@Path("/automovel")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AutomovelFacadeImpl implements AutomovelFacade {
	
	@Inject
	private AutomovelDao automovelDao;

	@Override
	@GET
	public List<Automovel> getAutomoveis() {
		return automovelDao.getAutomoveis(new Automovel());
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Automovel> getAutomoveis(@PathParam("codigo") Integer codigo) {
		Automovel automovel = new Automovel();
		automovel.setCodigo(codigo);
		return automovelDao.getAutomoveis(automovel);
	}
	
	@Override
	@POST 
	public Automovel salvar(Automovel automovel) { 
		automovel = automovelDao.salvar(automovel);
	 	return automovel;
	}
	
	@Override
	@PUT 
	public void atualizar(Automovel automovel) { 
		automovelDao.atualizar(automovel);
	}
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAutomovel(@PathParam("codigo") Integer codigo) {
		Automovel automovel = new Automovel();
		automovel.setCodigo(codigo);
		automovelDao.excluir(automovel);
	}

}
