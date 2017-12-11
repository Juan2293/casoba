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

import com.jdriascos.casoba.entity.Cliente;
import com.jdriascos.casoba.service.IClienteService;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = {"http://192.168.0.12:4200","http://localhost:4200"})

public class ClienteController {

	@Autowired	
	private IClienteService clienteService;
	

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllClients() {
		List<Cliente> list = clienteService.getAllClients();
		return new ResponseEntity<List<Cliente>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/cliente")
	public ResponseEntity<Cliente> getClienteById(@RequestParam("id") String id) {
		Cliente cliente = clienteService.getClienteById(Long.parseLong(id));
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/cliente-by-email")
	public ResponseEntity<Boolean> getClienteByEmail(@RequestParam("correo") String correo) {
		return new ResponseEntity<Boolean>(clienteService.getClienteByEmail("correo@gormail.com"), HttpStatus.OK);
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<?> createCliente(@RequestBody Cliente cliente, UriComponentsBuilder builder) {

//		boolean flag = clienteService.createCliente(cliente);
//		System.out.println(flag);
//		if (flag == false) {
//			System.out.println("conflicto");
//			 return new ResponseEntity<String>("pail",HttpStatus.CONFLICT);
//		}
		clienteService.createCliente(cliente);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/cliente?id={id}").buildAndExpand(cliente.getClienteId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/cliente")
	public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente) {
		clienteService.updateCliente(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@DeleteMapping("/cliente/{clienteId}")
	public ResponseEntity<?> deleteCliente(@PathVariable Long clienteId){
		clienteService.deleteCliente(new Long(clienteId));
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
}
