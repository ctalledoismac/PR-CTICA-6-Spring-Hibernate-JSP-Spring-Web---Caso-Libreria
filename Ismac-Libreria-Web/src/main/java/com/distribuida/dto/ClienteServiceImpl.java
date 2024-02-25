package com.distribuida.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;
	
	
	@Override
	public List<Cliente> finAll() {
		// TODO Auto-generated method stub
		return clienteDAO.finAll();
	}

	@Override
	public Cliente findOne(int id) {
		// TODO Auto-generated method stub
		return clienteDAO.findOne(id);
	}

	@Override
	public void add(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDAO.add(cliente);
	}

	@Override
	public void up(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDAO.up(cliente);
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		clienteDAO.del(id);
	}

	@Override
	public void add(int idCliente, String cedula, String nombre, String apellido, String direccion, String telefono,
			String correo) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente(idCliente, cedula, nombre, apellido, direccion, telefono, correo);
		clienteDAO.add(cliente);
	}
	
	@Override
	public void up(int idCliente, String cedula, String nombre, String apellido, String direccion, String telefono,
			String correo) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente(idCliente, cedula, nombre, apellido, direccion, telefono, correo);
		clienteDAO.up(cliente);
	}

}
