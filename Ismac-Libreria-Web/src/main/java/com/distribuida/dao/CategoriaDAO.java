package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Categoria;

public interface CategoriaDAO {
	
	public List<Categoria> findAll();
	
	public Categoria findOne(int id);
	
	public void add(Categoria categoria);
	
	public void update(Categoria categoria);
	
	public void delete(int id);
	
	public List<Categoria> findAll(String busqueda);
	
}
