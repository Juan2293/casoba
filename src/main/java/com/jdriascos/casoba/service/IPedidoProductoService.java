package com.jdriascos.casoba.service;

import java.util.List;

import com.jdriascos.casoba.entity.PedidoProducto;

public interface IPedidoProductoService {
	
	List<PedidoProducto> getAllPedidoProducto();
	List<PedidoProducto> getPedidoProductoByPedidoId(Long pedidoId);
	PedidoProducto getPedidoProductoById(Long pedidoProductoId);
	boolean createPedidoProducto(PedidoProducto pedidoProducto);
	void updatePedidoProducto(PedidoProducto pedidoProducto);
	void deletePedidoProducto(Long pedidoProductoId);
	
}
