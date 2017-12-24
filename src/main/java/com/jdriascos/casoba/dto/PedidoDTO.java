package com.jdriascos.casoba.dto;


import com.jdriascos.casoba.entity.Pedido;
import com.jdriascos.casoba.entity.PedidoProducto;

public class PedidoDTO {

	private Pedido pedido;
	private PedidoProducto pedidoProductos[];
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public PedidoProducto[] getPedidoProductos() {
		return pedidoProductos;
	}
	public void setPedidoProductos(PedidoProducto[] pedidoProductos) {
		this.pedidoProductos = pedidoProductos;
	}

}
