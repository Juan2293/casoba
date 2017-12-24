package com.jdriascos.casoba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdriascos.casoba.dao.IPedidoDAO;
import com.jdriascos.casoba.entity.Pedido;

@Service
public class PedidoService implements IPedidoService{

	@Autowired
	private IPedidoDAO pedidoDao;

	@Override
	public List<Pedido> getAllPedidos() {
		return pedidoDao.getAllPedidos();
	}

	@Override
	public Pedido getPedidoById(long pedidoId) {
		return pedidoDao.getPedidoById(pedidoId);
	}

	@Override
	public synchronized Long createPedido(Pedido pedido) {
		return pedidoDao.createPedido(pedido);
	}

	@Override
	public void updatePedido(Pedido pedido) {
		pedidoDao.updatePedido(pedido);
	}

	@Override
	public void deletePedido(long pedidoId) {
		pedidoDao.deletePedido(pedidoId);
	}

}
