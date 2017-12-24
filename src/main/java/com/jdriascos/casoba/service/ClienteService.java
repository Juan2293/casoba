package com.jdriascos.casoba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdriascos.casoba.dao.IClienteDAO;
import com.jdriascos.casoba.entity.Cliente;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteDAO clienteDAO;
	
	@Override
	public List<Cliente> getAllClients() {
		return clienteDAO.getAllClients();
	}

	@Override
	public Cliente getClienteById(long clienteId) {
		return clienteDAO.getClienteById(clienteId);
	}

	@Override
	public synchronized  boolean createCliente(Cliente cliente) {
//		if (clienteDAO.getClienteById(cliente.getClienteId())!=null) {
//			return false;
//		}else {
			
			clienteDAO.createCliente(cliente);
			return true;
//		}	
	}

	@Override
	public void updateCliente(Cliente cliente) {
		clienteDAO.updateCliente(cliente);
	}

	@Override
	public void deleteCliente(long clienteId) {
		clienteDAO.deleteCliente(clienteId);
	}

	@Override
	public boolean getClienteByEmail(String correo) {
		return clienteDAO.getClienteByEmail(correo);
	}

}
