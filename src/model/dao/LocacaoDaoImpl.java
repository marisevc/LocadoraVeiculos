package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Locacao;

public class LocacaoDaoImpl implements LocacaoDao {

	@PersistenceContext(unitName="SistemaLocadoraVC")
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Locacao> getLocacoes(Locacao locacao) {
		StringBuffer sla = new StringBuffer("from Locacao c"
				+ " where 1 = 1");		
		if (locacao.getCodigo() != null) {
			sla.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(sla.toString());
		if (locacao.getCodigo() != null) {
			query.setParameter("codigo",locacao.getCodigo());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(Locacao locacao) {
		locacao = entityManager.merge(locacao);
		entityManager.remove(locacao);
	}

	@Override
	@Transactional
	public Locacao salvar(Locacao locacao) {
		entityManager.persist(locacao);
		return locacao;
	}

	@Override
	@Transactional
	public void atualizar(Locacao locacao) {
		locacao = entityManager.merge(locacao);
		entityManager.persist(locacao);		
	}
	
}
