package model.dao;

import java.util.List;

import model.domain.Locacao;

public interface LocacaoDao {
	
	List<Locacao> getLocacoes(Locacao locacao);

	Locacao salvar(Locacao locacao);

	void atualizar(Locacao locacao);

	public void excluir(Locacao locacao);

}
