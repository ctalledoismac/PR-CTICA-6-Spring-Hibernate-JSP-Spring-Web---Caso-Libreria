package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Libro> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
	}

	@Override
	@Transactional
	public Libro findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Libro> query = session.createQuery("SELECT l FROM Libro l WHERE l.idLibro =: keyIdLibro", Libro.class);
		query.setParameter("keyIdLibro", id);
		return query.uniqueResult();
	}

	@Override
	@Transactional
	public void add(Libro libro) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(libro);
	}

	@Override
	@Transactional
	public void update(Libro libro) {
	    Session session = sessionFactory.getCurrentSession();
	    Query query = session.createQuery("UPDATE Libro SET "
	            + "titulo = :titulo, "
	            + "editorial = :editorial, "
	            + "numPaginas = :numPaginas, "
	            + "edicion = :edicion, "
	            + "idioma = :idioma, "
	            + "fechaPublicacion = :fechaPublicacion, "
	            + "descripcion = :descripcion, "
	            + "tipoPasta = :tipoPasta, "
	            + "ISBN = :ISBN, "
	            + "numEjemplares = :numEjemplares, "
	            + "portada = :portada, "
	            + "presentacion = :presentacion, "
	            + "precio = :precio, "
	            + "categoria = :categoria, "
	            + "autor = :autor "
	            + "WHERE idLibro = :idLibro");

	    query.setParameter("titulo", libro.getTitulo());
	    query.setParameter("editorial", libro.getEditorial());
	    query.setParameter("numPaginas", libro.getNumPaginas());
	    query.setParameter("edicion", libro.getEdicion());
	    query.setParameter("idioma", libro.getIdioma());
	    query.setParameter("fechaPublicacion", libro.getFechaPublicacion());
	    query.setParameter("descripcion", libro.getDescripcion());
	    query.setParameter("tipoPasta", libro.getTipoPasta());
	    query.setParameter("ISBN", libro.getISBN());
	    query.setParameter("numEjemplares", libro.getNumEjemplares());
	    query.setParameter("portada", libro.getPortada());
	    query.setParameter("presentacion", libro.getPresentacion());
	    query.setParameter("precio", libro.getPrecio());
	    query.setParameter("categoria", libro.getCategoria());
	    query.setParameter("autor", libro.getAutor());
	    query.setParameter("idLibro", libro.getIdLibro());

	    query.executeUpdate();
	}


	@Override
	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE FROM Libro l WHERE l.idLibro = :idLibro");
		query.setParameter("idLibro", id);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public List<Libro> findAll(String busqueda) {
        Session session = sessionFactory.getCurrentSession();
        Query<Libro> query = session.createQuery("SELECT l FROM Libro l "
                + "WHERE l.Titulo LIKE :busqueda "
                + "OR l.Descripcion LIKE :busqueda", Libro.class);
        query.setParameter("busqueda", "%" + busqueda + "%");
        return query.getResultList();
    }
}


