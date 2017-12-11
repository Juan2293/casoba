package com.jdriascos.casoba.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pedido_id")
	private Long pedidoId;
	@Column(name="num_serie")
	private Long num_serie;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="fecha_pedido")
	private Date fecha_pedido;
	@Column(name="fecha_entrega")
	private Date fecha_entrega;
	@Column(name="fecha_devolucion")
	private Date fecha_devolucion;
	@Column(name="valor")
	private BigDecimal valor;
	@Column(name="debe_pago")
	private boolean debe_pago;
	@Column(name="fecha_pago")
	private Date fecha_pago;
	@Column(name="transporte")
	private boolean transporte;
	@Column(name="valor_transporte")
	private BigDecimal valor_transporte;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	public Long getNum_serie() {
		return num_serie;
	}
	public void setNum_serie(Long num_serie) {
		this.num_serie = num_serie;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public Date getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}
	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public boolean isDebe_pago() {
		return debe_pago;
	}
	public void setDebe_pago(boolean debe_pago) {
		this.debe_pago = debe_pago;
	}
	public Date getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public boolean isTransporte() {
		return transporte;
	}
	public void setTransporte(boolean transporte) {
		this.transporte = transporte;
	}
	public BigDecimal getValor_transporte() {
		return valor_transporte;
	}
	public void setValor_transporte(BigDecimal valor_transporte) {
		this.valor_transporte = valor_transporte;
	}
	
	
	
}
