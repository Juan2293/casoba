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

import com.jdriascos.casoba.entity.Producto;
import com.jdriascos.casoba.service.IProductoService;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = {"http://192.168.0.12:4200","http://localhost:4200"})
public class ProductoController {

	@Autowired
	private IProductoService  productoService;
	
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getAllProductos(){
		List<Producto> productos = productoService.getAllProductos();
		return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
	}
	@GetMapping("/producto")
	public ResponseEntity<Producto> getProductoById(@RequestParam("id") String id){
		Producto producto = productoService.getProductoById(new Long(id));
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
		
	}
	
	@PostMapping("/producto")
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto, UriComponentsBuilder builder){
		
		productoService.createProducto(producto);
		// esto es para mandar la url para redireccionar
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/producto?id={id}").buildAndExpand(producto.getProductoId()).toUri());
		return new ResponseEntity<Producto>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping("/producto")
	public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto){
		productoService.updateProducto(producto);
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}
	
	@DeleteMapping("/producto/{productoId}")
	public ResponseEntity<?> deleteProducto(@PathVariable Long productoId){
		productoService.deleteProducto(new Long(productoId));
		return new ResponseEntity<Producto>(HttpStatus.OK);
	}
	
}
