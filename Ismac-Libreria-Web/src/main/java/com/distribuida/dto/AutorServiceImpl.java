package com.distribuida.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorDAO autorDAO;
	
	@Override
	public List<Autor> findAll() {
		// TODO Auto-generated method stub
		return autorDAO.findAll();
	}

	@Override
	public Autor findOne(int id) {
		// TODO Auto-generated method stub
		return autorDAO.findOne(id);
	}

	@Override
	public void add(Autor autor) {
		// TODO Auto-generated method stub
		autorDAO.add(autor);
	}

	@Override
	public void update(Autor autor) {
		// TODO Auto-generated method stub
		autorDAO.update(autor);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		autorDAO.delete(id);
	}

	@Override
	public List<Autor> findAll(String busqueda) {
		// TODO Auto-generated method stub
		return autorDAO.findAll(busqueda);
	}

	@Override
	public void add(int idAutor, String nombre, String apellido, String pais, String direccion, String telefono,
			String correo) {
		// TODO Auto-generated method stub
		Autor autor = new Autor(idAutor, nombre, apellido, pais, direccion, telefono, correo);
		autorDAO.add(autor);
	}

	@Override
	public void update(int idAutor, String nombre, String apellido, String pais, String direccion, String telefono,
			String correo) {
		// TODO Auto-generated method stub
		Autor autor = new Autor(idAutor, nombre, apellido, pais, direccion, telefono, correo);
		autorDAO.update(autor);
	}


}
