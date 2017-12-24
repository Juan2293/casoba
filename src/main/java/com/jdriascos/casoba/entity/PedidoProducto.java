package com.jdriascos.casoba.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido_producto")
public class PedidoProducto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pedido_producto_id")
	private Long pedidoProductoId;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	@Column(name="valor")
	private BigDecimal valor;
	
	@Column(name="cantidad")
	private int cantidad;
	
	
	public Long getPedidoProductoId() {
		return pedidoProductoId;
	}

	public void setPedidoProductoId(Long pedidoProductoId) {
		this.pedidoProductoId = pedidoProductoId;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
