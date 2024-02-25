package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Categoria> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT ca FROM Categoria ca", Categoria.class).getResultList();
	}

	@Override
	@Transactional
	public Categoria findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Categoria> query = session.createQuery("SELECT ca FROM Categoria ca WHERE ca.idCategoria =: keyIdCategoria", Categoria.class);
		query.setParameter("keyIdCategoria", id);
		return query.uniqueResult();
	}

	@Override
	@Transactional
	public void add(Categoria categoria) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(categoria);
	}

	@Override
	@Transactional
	public void update(Categoria categoria) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("UPDATE Categoria SET "
				+ "categoria = :categoria, "
				+ "descripcion = :descripcion "
				+ "WHERE idCategoria = :idCategoria");
		query.setParameter("categoria", categoria.getCategoria());
		query.setParameter("descripcion", categoria.getDescripcion());
		query.setParameter("idCategoria", categoria.getIdCategoria());
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("DELETE FROM Categoria ca WHERE ca.idCategoria = :idCategoria");
		query.setParameter("idCategoria", id);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public List<Categoria> findAll(String busqueda) {
		Session session = sessionFactory.getCurrentSession();
		Query<Categoria> query = session.createQuery("SELECT ca FROM Categoria ca "
		        + "WHERE ca.categoria LIKE :busqueda "
		        + "OR ca.descripcion LIKE :busqueda", Categoria.class);
		query.setParameter("busqueda", "%" + busqueda + "%");
		return query.getResultList();
	}
}

