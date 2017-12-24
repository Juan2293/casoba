package com.jdriascos.casoba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.jdriascos.casoba.dao.PedidoProductoDAO;
import com.jdriascos.casoba.dto.PedidoDTO;
import com.jdriascos.casoba.entity.Pedido;
import com.jdriascos.casoba.entity.PedidoProducto;
import com.jdriascos.casoba.service.IPedidoProductoService;
import com.jdriascos.casoba.service.IPedidoService;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = {"http://192.168.0.12:4200","http://localhost:4200"})
public class PedidoController {

	@Autowired
	private IPedidoService pedidoService;
	
	@Autowired
	private IPedidoProductoService pedidoProductoService;
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> getAllPedidos() {
		System.out.println("si esta aca!");
		List<Pedido> list = pedidoService.getAllPedidos();
		return new ResponseEntity<List<Pedido>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/pedido")
	public ResponseEntity<Pedido> getPedidoById(@RequestParam("id") String id) {
		Pedido pedido = pedidoService.getPedidoById(Long.parseLong(id));
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	
	@PostMapping("/pedido")
	public ResponseEntity<?> createPedido(@RequestBody PedidoDTO pedidoDTO) {
		
		// se obtiene el id del pedido cuando se crea
		Long pedidoId = pedidoService.createPedido(pedidoDTO.getPedido());
		Pedido pedido = pedidoService.getPedidoById(pedidoId);
		
		PedidoProducto pedidoProductos[]=pedidoDTO.getPedidoProductos();
		
		//se pone el pedido en todos los pedidoProductos y se crea
		for (PedidoProducto pedidoProducto : pedidoProductos) {
			pedidoProducto.setPedido(pedido);
			pedidoProductoService.createPedidoProducto(pedidoProducto);
		}
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@PutMapping("/pedido")
	public ResponseEntity<?> updatePedido(@RequestBody Pedido pedido) {
		pedidoService.updatePedido(pedido);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	
	@DeleteMapping("/pedido/{pedidoId}")
	public ResponseEntity<?> deletePedido(@PathVariable Long pedidoId){
		pedidoService.deletePedido(new Long(pedidoId));
		return new ResponseEntity<Pedido>(HttpStatus.OK);
	}
	
}
