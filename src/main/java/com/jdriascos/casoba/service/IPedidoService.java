package com.jdriascos.casoba.service;

import java.util.List;

import com.jdriascos.casoba.entity.Pedido;

public interface IPedidoService {
	List<Pedido> getAllPedidos();
	List<Pedido> getPedidosByClienteId(Long clienteId);
	Pedido getPedidoById(long pedidoId);
	Long createPedido(Pedido pedido);
	void updatePedido(Pedido pedido);
	void deletePedido(long pedidoId);
	
}
