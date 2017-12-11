package com.jdriascos.casoba.dao;

import java.util.List;

import com.jdriascos.casoba.entity.Pedido;

public interface IPedidoDAO {

	List<Pedido> getAllPedidos();
	Pedido getPedidoById(long pedidoId);
	void createPedido(Pedido pedido);
	void updatePedido(Pedido pedido);
	void deletePedido(long pedidoId);
	
}
