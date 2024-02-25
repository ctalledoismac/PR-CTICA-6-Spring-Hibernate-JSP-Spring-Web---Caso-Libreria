package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Autor;

public interface AutorDAO {
	
	public List<Autor> findAll();
	
	public Autor findOne(int id);
	
	public void add(Autor autor);
	
	public void update(Autor autor);
	
	public void delete(int id);

	public List<Autor> findAll(String busqueda);
}
