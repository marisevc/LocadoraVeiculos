package model.dao;

import java.util.List;

import model.domain.Automovel;

public interface AutomovelDao {

	List<Automovel> getAutomoveis(Automovel automovel);

	Automovel salvar(Automovel automovel);

	void atualizar(Automovel automovel);

	public void excluir(Automovel automovel);
	
}
