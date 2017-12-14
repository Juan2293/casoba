package com.jdriascos.casoba.dao;

import java.util.List;

import com.jdriascos.casoba.entity.Producto;

public interface IProductoDAO {

	 List<Producto> getAllProductos();
	 Producto getProductoById(Long productoId);
	 void createProducto(Producto producto);
	 void updateProducto(Producto producto);
	 void deleteProducto(Long productoId);
}
