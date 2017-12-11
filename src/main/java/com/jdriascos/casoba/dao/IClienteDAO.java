package com.jdriascos.casoba.dao;

import java.util.List;

import com.jdriascos.casoba.entity.Cliente;

public interface IClienteDAO {

	List<Cliente> getAllClients();
	Cliente getClienteById(long clienteId);
	void createCliente(Cliente cliente);
	void updateCliente(Cliente cliente);
	void deleteCliente(long clienteId);
	boolean getClienteByEmail(String correo);
}
