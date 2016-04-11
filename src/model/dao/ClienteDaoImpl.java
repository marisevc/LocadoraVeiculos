package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Cliente;

public class ClienteDaoImpl implements ClienteDao {
	
	@PersistenceContext(unitName="SistemaLocadoraVC")
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes(Cliente cliente) {
		StringBuffer sla = new StringBuffer("from Cliente c"
				+ " where 1 = 1");		
		if (cliente.getCodigo() != null) {
			sla.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(sla.toString());
		if (cliente.getCodigo() != null) {
			query.setParameter("codigo",cliente.getCodigo());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(Cliente cliente) {
		cliente = entityManager.merge(cliente);
		entityManager.remove(cliente);
	}

	@Override
	@Transactional
	public Cliente salvar(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}

	@Override
	@Transactional
	public void atualizar(Cliente cliente) {
		cliente = entityManager.merge(cliente);
		entityManager.persist(cliente);		
	}

}
