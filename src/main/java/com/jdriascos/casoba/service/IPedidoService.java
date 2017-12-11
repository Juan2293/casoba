package com.jdriascos.casoba.service;

import java.util.List;

import com.jdriascos.casoba.entity.Pedido;

public interface IPedidoService {
	List<Pedido> getAllPedidos();
	Pedido getPedidoById(long pedidoId);
	boolean createPedido(Pedido pedido);
	void updatePedido(Pedido pedido);
	void deletePedido(long pedidoId);
	
}
