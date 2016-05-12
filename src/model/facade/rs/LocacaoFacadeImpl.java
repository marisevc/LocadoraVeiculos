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

import model.dao.LocacaoDao;
import model.domain.Locacao;
import model.facade.LocacaoFacade;

@Path("/locacao")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class LocacaoFacadeImpl implements LocacaoFacade {
	
	@Inject
	private LocacaoDao locacaoDao;

	@Override
	@GET
	public List<Locacao> getLocacoes() {
		return locacaoDao.getLocacoes(new Locacao());
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Locacao> getLocacoes(@PathParam("codigo") Integer codigo) {
		Locacao locacao = new Locacao();
		locacao.setCodigo(codigo);
		return locacaoDao.getLocacoes(locacao);
	}
	
	@Override
	@POST 
	public Locacao salvar(Locacao locacao) { 
		locacao = locacaoDao.salvar(locacao);
	 	return locacao;
	}
	
	@Override
	@PUT 
	public void atualizar(Locacao locacao) { 
		locacaoDao.atualizar(locacao);
	}
	
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarLocacao(@PathParam("codigo") Integer codigo) {
		Locacao locacao = new Locacao();
		locacao.setCodigo(codigo);
		locacaoDao.excluir(locacao);
	}

}
