package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.AutomovelDao;
import model.domain.Automovel;
import model.facade.AutomovelFacade;

@WebService(serviceName="ws/automovel")
public class AutomovelFacadeImpl implements AutomovelFacade {

	@Inject
	private AutomovelDao automovelDao;
	
	@WebMethod
	public List<Automovel> getAutomoveis() {
		return automovelDao.getAutomoveis(new Automovel());
	}
	
	@Override
	@WebMethod(operationName="getClienteCodigo")
	public List<Automovel> getAutomoveis(@WebParam(name="codigoAutomovel") 
							Integer codigo) {
		Automovel automovel = new Automovel();
		automovel.setCodigo(codigo);
		return automovelDao.getAutomoveis(automovel);
	}
	
	@WebMethod
	public Automovel salvar(@WebParam(name="automovel") Automovel automovel) {
		return automovelDao.salvar(automovel);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="automovel") Automovel automovel) {
		automovelDao.atualizar(automovel);
	}
	
	@WebMethod
	public void deleteAutomovel(@WebParam(name="codigoAutomovel") Integer codigo) {
		Automovel automovel = new Automovel();
		automovel.setCodigo(codigo);
		automovelDao.excluir(automovel);
	}

	@Override
	public void deletarAutomovel(Integer codigo) {
		// TODO Auto-generated method stub
		
	}
	
}
