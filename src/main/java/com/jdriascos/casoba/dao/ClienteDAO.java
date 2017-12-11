package com.jdriascos.casoba.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jdriascos.casoba.entity.Cliente;

@Transactional
@Repository
public class ClienteDAO implements IClienteDAO {

	@PersistenceContext
	private EntityManager entityManager;	

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getAllClients() {
		String hql = "FROM Cliente";
		return (List<Cliente>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Cliente getClienteById(long clienteId) {
		return entityManager.find(Cliente.class, clienteId);
	}

	@Override
	public void  createCliente(Cliente cliente) {	
		entityManager.persist(cliente);
	}

	@Override
	public void updateCliente(Cliente cliente) {
		
		entityManager.merge(cliente);
    	 return;

	}

	@Override
	public void deleteCliente(long clienteId) {
		entityManager.remove(getClienteById(clienteId));
	}

	@Override
	public boolean getClienteByEmail(String correo) {
//		
//		String hql = "FROM Cliente as c WHERE c.correo = ?";
//		int count = entityManager.createQuery(hql).setParameter(1, correo).getResultList().size();
//		return count > 0 ? true : false;
		return false;
		
	}

}
