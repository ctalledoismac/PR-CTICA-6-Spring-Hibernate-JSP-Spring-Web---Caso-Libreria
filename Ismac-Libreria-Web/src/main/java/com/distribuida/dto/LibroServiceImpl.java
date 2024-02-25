package com.distribuida.dto;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.AutorDAO;
import com.distribuida.dao.CategoriaDAO;
import com.distribuida.dao.LibroDAO;
import com.distribuida.entities.Autor;
import com.distribuida.entities.Categoria;
import com.distribuida.entities.Libro;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroDAO libroDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private AutorDAO autorDAO;
	
	@Override
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return libroDAO.findAll();
	}

	@Override
	public Libro findOne(int id) {
		// TODO Auto-generated method stub
		return libroDAO.findOne(id);
	}

	@Override
	public void add(Libro libro) {
		// TODO Auto-generated method stub
		Autor autor = autorDAO.findOne(libro.getAutor().getIdAutor());
		Categoria categoria = categoriaDAO.findOne(libro.getCategoria().getIdCategoria());
		
		if ( autor != null && categoria !=null) {
			libroDAO.add(libro);
		}		
	}

	@Override
	public void update(Libro libro) {
		// TODO Auto-generated method stub
		Autor autor = autorDAO.findOne(libro.getAutor().getIdAutor());
		Categoria categoria = categoriaDAO.findOne(libro.getCategoria().getIdCategoria());
		
		if ( autor != null && categoria !=null) {
			libroDAO.update(libro);;
		}	
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		libroDAO.delete(id);
	}

	@Override
	public List<Libro> findAll(String busqueda) {
		// TODO Auto-generated method stub
		return libroDAO.findAll(busqueda);
	}

	@Override
	public void add(int idLibro, String titulo, String editorial, int numPaginas, String edicion, String idioma,
			Date fechaPublicacion, String descripcion, String tipoPasta, String iSBN, String numEjemplares,
			String portada, String presentacion, double precio, int idAutor, int idCategoria) {
		// TODO Auto-generated method stub
		Categoria categoria = categoriaDAO.findOne(idCategoria);
		Autor autor = autorDAO.findOne(idCategoria);
		
		Libro libro = new Libro(idLibro, titulo, editorial, numPaginas, edicion, idioma, fechaPublicacion, descripcion, tipoPasta, iSBN, numEjemplares, portada, presentacion, precio, categoria, autor);
		libro.setCategoria(categoria);
		libro.setAutor(autor);
		
		libroDAO.add(libro);
	
	}

	@Override
	public void up(int idLibro, String titulo, String editorial, int numPaginas, String edicion, String idioma,
			Date fechaPublicacion, String descripcion, String tipoPasta, String iSBN, String numEjemplares,
			String portada, String presentacion, double precio, int idAutor, int idCategoria) {
		// TODO Auto-generated method stub
		Categoria categoria = categoriaDAO.findOne(idCategoria);
		Autor autor = autorDAO.findOne(idCategoria);
		
		Libro libro = new Libro(idLibro, titulo, editorial, numPaginas, edicion, idioma, fechaPublicacion, descripcion, tipoPasta, iSBN, numEjemplares, portada, presentacion, precio, categoria, autor);
		libro.setCategoria(categoria);
		libro.setAutor(autor);
		
		libroDAO.update(libro);
	}


}
