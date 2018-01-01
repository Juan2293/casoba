package com.jdriascos.casoba.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jdriascos.casoba.entity.PedidoProducto;

@Transactional
@Repository
public class PedidoProductoDAO implements IPedidoProductoDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<PedidoProducto> getAllPedidoProducto() {
		String hql= "FROM PedidoProducto";
		return (List<PedidoProducto>)entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<PedidoProducto> getPedidoProductoByPedidoId(Long pedidoId) {
		String hql = "FROM PedidoProducto p WHERE p.pedido.pedidoId = ?";
		return (List<PedidoProducto>)entityManager.createQuery(hql).setParameter(1, pedidoId).getResultList();
	}
	@Override
	public PedidoProducto getPedidoProductoById(Long pedidoProductoId) {
		return entityManager.find(PedidoProducto.class, pedidoProductoId);
	}

	@Override
	public void createPedidoProducto(PedidoProducto pedidoProducto) {
		entityManager.persist(pedidoProducto);
	}

	@Override
	public void updatePedidoProducto(PedidoProducto pedidoProducto) {
		entityManager.merge(pedidoProducto);
	}

	@Override
	public void deletePedidoProducto(Long pedidoProductoId) {
		entityManager.remove(getPedidoProductoById(pedidoProductoId));
	}

	

}
