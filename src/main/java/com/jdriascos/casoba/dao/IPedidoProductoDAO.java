package com.jdriascos.casoba.dao;

import java.util.List;

import com.jdriascos.casoba.entity.PedidoProducto;

public interface IPedidoProductoDAO {

	List<PedidoProducto> getAllPedidoProducto();
	List<PedidoProducto> getPedidoProductoByPedidoId(Long pedidoId);
	PedidoProducto getPedidoProductoById(Long pedidoProductoId);
	void createPedidoProducto(PedidoProducto pedidoProducto);
	void updatePedidoProducto(PedidoProducto pedidoProducto);
	void deletePedidoProducto(Long pedidoProductoId);
	
	
	
}
