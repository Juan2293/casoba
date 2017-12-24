package com.jdriascos.casoba.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdriascos.casoba.entity.PedidoProducto;
import com.jdriascos.casoba.service.IPedidoProductoService;

import ch.qos.logback.classic.Logger;

@Controller
@CrossOrigin(origins = {"http://192.168.0.12:4200","http://localhost:4200"})
@RequestMapping("/user")
public class PedidoProductoController {

	@Autowired
	private IPedidoProductoService pedidoProductoService;
	
	 
	private static final Logger log = (Logger) LoggerFactory.getLogger(PedidoProductoController.class);

	@PostMapping("/pedido-producto")
	public ResponseEntity<PedidoProducto> createPedidoProducto(@RequestBody PedidoProducto pedidoProducto){
			log.info("Entró al create Pedido producto!");
			pedidoProductoService.createPedidoProducto(pedidoProducto);
			return new ResponseEntity<PedidoProducto>(HttpStatus.CREATED);
	}
	
}
