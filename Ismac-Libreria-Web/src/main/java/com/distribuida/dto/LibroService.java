package com.distribuida.dto;

import java.util.Date;
import java.util.List;

import com.distribuida.entities.Autor;
import com.distribuida.entities.Categoria;
import com.distribuida.entities.Libro;

public interface LibroService {
	public List<Libro> findAll();

	public Libro findOne (int id);
	
	public void add(Libro libro);
	
	public void up(Libro libro);
	
	public void del(int id);
	
	public List<Libro> findAll(String busqueda);
	
	public void add(int idLibro, String titulo, String editorial, int numPaginas, String edicion, String idioma,
			Date fechaPublicacion, String descripcion, String tipoPasta, String iSBN, String numEjemplares,
			String portada, String presentacion, Double precio, int categoria, int autor);
	
	public void up(int idLibro, String titulo, String editorial, int numPaginas, String edicion, String idioma,
			Date fechaPublicacion, String descripcion, String tipoPasta, String iSBN, String numEjemplares,
			String portada, String presentacion, Double precio, int categoria, int autor);
}