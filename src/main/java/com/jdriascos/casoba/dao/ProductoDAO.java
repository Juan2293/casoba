package com.jdriascos.casoba.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jdriascos.casoba.entity.Producto;

@Repository
@Transactional
public class ProductoDAO implements IProductoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Producto> getAllProductos() {
		String hql= "FROM Producto";
		return (List<Producto>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Producto getProductoById(Long productoId) {
		return entityManager.find(Producto.class, productoId);
	}

	@Override
	public void createProducto(Producto producto) {
		entityManager.persist(producto);
	}

	@Override
	public void updateProducto(Producto producto) {
		entityManager.merge(producto);
	}

	@Override
	public void deleteProducto(Long productoId) {
		entityManager.remove(getProductoById(productoId));
	}

}
