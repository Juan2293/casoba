package com.jdriascos.casoba.service;

import java.util.List;

import com.jdriascos.casoba.entity.Producto;

public interface IProductoService {

	List<Producto> getAllProductos();
	Producto getProductoById(Long productoId);
	boolean createProducto(Producto producto);
	void deleteProducto(Long productoId);
	void updateProducto(Producto producto);
}
