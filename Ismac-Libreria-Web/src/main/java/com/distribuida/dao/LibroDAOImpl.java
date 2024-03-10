// LibroDAOImpl.java
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
	public void up(Libro libro) {
		Session session = sessionFactory.getCurrentSession();
		session.update(libro);
	}

	@Override
	@Transactional
	public void del(int id) {
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
				+ "WHERE l.titulo LIKE :busqueda "
				+ "OR l.descripcion LIKE :busqueda", Libro.class);
		query.setParameter("busqueda", "%" + busqueda + "%");
		return query.getResultList();
	}
}



