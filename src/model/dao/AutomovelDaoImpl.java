package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Automovel;

public class AutomovelDaoImpl implements AutomovelDao {
	
	@PersistenceContext(unitName="SistemaLocadoraVC")
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Automovel> getAutomoveis(Automovel automovel) {
		StringBuffer sla = new StringBuffer("from Automovel a"
				+ " where 1 = 1");		
		if (automovel.getCodigo() != null) {
			sla.append(" and a.codigo = :codigo");
		}
		Query query = entityManager.createQuery(sla.toString());
		if (automovel.getCodigo() != null) {
			query.setParameter("codigo",automovel.getCodigo());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(Automovel automovel) {
		automovel = entityManager.merge(automovel);
		entityManager.remove(automovel);
	}

	@Override
	@Transactional
	public Automovel salvar(Automovel automovel) {
		entityManager.persist(automovel);
		return automovel;
	}

	@Override
	@Transactional
	public void atualizar(Automovel automovel) {
		automovel = entityManager.merge(automovel);
		entityManager.persist(automovel);		
	}


}
