package model.facade;

import java.util.List;

import model.domain.Automovel;

public interface AutomovelFacade {

	List<Automovel> getAutomoveis();

	List<Automovel> getAutomoveis(Integer codigo);

	Automovel salvar(Automovel automovel);

	void atualizar(Automovel automovel);

	void deletarAutomovel(Integer codigo);
	
}
