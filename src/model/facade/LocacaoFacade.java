package model.facade;

import java.util.List;

import model.domain.Locacao;

public interface LocacaoFacade {
	
	List<Locacao> getLocacoes();

	List<Locacao> getLocacoes(Integer codigo);

	Locacao salvar(Locacao locacao);

	void atualizar(Locacao locacao);

	void deletarLocacao(Integer codigo);

}
