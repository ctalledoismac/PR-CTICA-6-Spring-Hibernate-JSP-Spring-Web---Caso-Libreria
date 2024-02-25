package com.distribuida.dao;

import java.util.List;
import com.distribuida.entities.Cliente;

public interface ClienteDAO {

	public List<Cliente> finAll();
	
	public Cliente findOne(int id);
	
	public void add(Cliente cliente);
	
	public void up(Cliente cliente);
	
	public void del(int id);
	
}
