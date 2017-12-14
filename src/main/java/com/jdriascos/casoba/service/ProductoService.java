package com.jdriascos.casoba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdriascos.casoba.dao.IProductoDAO;
import com.jdriascos.casoba.entity.Producto;

@Service
public class ProductoService implements IProductoService {
	
	@Autowired
	private IProductoDAO productoDAO;

	@Override
	public List<Producto> getAllProductos() {
		return productoDAO.getAllProductos();
	}

	@Override
	public Producto getProductoById(Long productoId) {
		return productoDAO.getProductoById(productoId);
	}

	@Override
	public synchronized boolean createProducto(Producto producto) {
		productoDAO.createProducto(producto);
		return true;
	}

	@Override
	public void deleteProducto(Long productoId) {
		productoDAO.deleteProducto(productoId);	
	}

	@Override
	public void updateProducto(Producto producto) {
		productoDAO.updateProducto(producto);
	}


	
}
