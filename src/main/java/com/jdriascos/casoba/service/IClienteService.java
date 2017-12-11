package com.jdriascos.casoba.service;

import java.util.List;

import com.jdriascos.casoba.entity.Cliente;

public interface IClienteService {
	List<Cliente> getAllClients();
	Cliente getClienteById(long clienteId);
	boolean createCliente(Cliente cliente);
	void updateCliente(Cliente cliente);
	void deleteCliente(long clienteId);
	boolean getClienteByEmail(String correo);
}
