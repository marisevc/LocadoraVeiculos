package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.LocacaoDao;
import model.domain.Locacao;
import model.facade.LocacaoFacade;

@WebService(serviceName="ws/locacao")
public class LocacaoFacadeImpl implements LocacaoFacade {
	
	@Inject
	private LocacaoDao locacaoDao;
	
	@WebMethod
	public List<Locacao> getLocacoes() {
		return locacaoDao.getLocacoes(new Locacao());
	}
	
	@Override
	@WebMethod(operationName="getLocacaoCodigo")
	public List<Locacao> getLocacoes(@WebParam(name="codigoLocacao") 
							Integer codigo) {
		Locacao locacao = new Locacao();
		locacao.setCodigo(codigo);
		return locacaoDao.getLocacoes(locacao);
	}
	
	@WebMethod
	public Locacao salvar(@WebParam(name="locacao") Locacao locacao) {
		return locacaoDao.salvar(locacao);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="locacao") Locacao locacao) {
		locacaoDao.atualizar(locacao);
	}
	
	@WebMethod
	public void deletarLocacao(@WebParam(name="codigoLocacao") Integer codigo) {
		Locacao locacao = new Locacao();
		locacao.setCodigo(codigo);
		locacaoDao.excluir(locacao);
	}

}
