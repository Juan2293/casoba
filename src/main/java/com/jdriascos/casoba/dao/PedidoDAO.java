package com.jdriascos.casoba.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

	import com.jdriascos.casoba.entity.Pedido;

@Transactional
@Repository
public class PedidoDAO implements IPedidoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Pedido> getAllPedidos() {
		String hql = "FROM Pedido";
		return (List<Pedido>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Pedido getPedidoById(long pedidoId) {
		return entityManager.find(Pedido.class, pedidoId);
	}

	@Override
	public void createPedido(Pedido pedido) {
		entityManager.persist(pedido);
	}

	@Override
	public void updatePedido(Pedido pedido) {
		entityManager.merge(pedido);
	}

	@Override
	public void deletePedido(long pedidoId) {
		entityManager.remove(getPedidoById(pedidoId));
	}	

	

}
