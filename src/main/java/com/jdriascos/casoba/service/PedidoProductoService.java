package com.jdriascos.casoba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdriascos.casoba.dao.IPedidoProductoDAO;
import com.jdriascos.casoba.entity.PedidoProducto;

@Service
public class PedidoProductoService implements IPedidoProductoService {

	@Autowired
	private IPedidoProductoDAO pedidoProductoDAO;
	
	@Override
	public List<PedidoProducto> getAllPedidoProducto() {
		return pedidoProductoDAO.getAllPedidoProducto();
	}

	@Override
	public List<PedidoProducto> getPedidoProductoByPedidoId(Long pedidoId) {
		return pedidoProductoDAO.getPedidoProductoByPedidoId(pedidoId);
	}

	@Override
	public PedidoProducto getPedidoProductoById(Long pedidoProductoId) {
		return pedidoProductoDAO.getPedidoProductoById(pedidoProductoId);
	}

	@Override
	public synchronized boolean createPedidoProducto(PedidoProducto pedidoProducto) {
		pedidoProductoDAO.createPedidoProducto(pedidoProducto);
		return true;
	}

	@Override
	public void updatePedidoProducto(PedidoProducto pedidoProducto) {
		pedidoProductoDAO.updatePedidoProducto(pedidoProducto);
	}

	@Override
	public void deletePedidoProducto(Long pedidoProductoId) {
		pedidoProductoDAO.deletePedidoProducto(pedidoProductoId);
	}

	
}
