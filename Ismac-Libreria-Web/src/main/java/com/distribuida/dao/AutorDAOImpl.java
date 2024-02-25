package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Autor;

@Repository
public class AutorDAOImpl implements AutorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Autor> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT au FROM Autor au", Autor.class).getResultList();
    }

    @Override
    @Transactional
    public Autor findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Autor> query = session.createQuery("SELECT au FROM Autor au WHERE au.idAutor = :keyIdAutor", Autor.class);
        query.setParameter("keyIdAutor", id);
        return query.uniqueResult();
    }

    @Override
    @Transactional
    public void add(Autor autor) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(autor);
    }

    @Override
    @Transactional
    public void update(Autor autor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("UPDATE Autor SET nombre = :Nombre, "
                + "apellido = :Apellido, "
                + "pais = :Pais, "
                + "direccion = :Direccion, "
                + "telefono = :Telefono, "
                + "correo = :Correo "
                + "WHERE idAutor = :idAutor");

        query.setParameter("Nombre", autor.getNombre());
        query.setParameter("Apellido", autor.getApellido());
        query.setParameter("Pais", autor.getPais());
        query.setParameter("Direccion", autor.getDireccion());
        query.setParameter("Telefono", autor.getTelefono());
        query.setParameter("Correo", autor.getCorreo());
        query.setParameter("idAutor", autor.getIdAutor());

        query.executeUpdate();
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Autor au WHERE au.idAutor = :idAutor");
        query.setParameter("idAutor", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public List<Autor> findAll(String busqueda) {
        Session session = sessionFactory.getCurrentSession();
        Query<Autor> query = session.createQuery("SELECT au FROM Autor au "
                + "WHERE au.Nombre LIKE :busqueda "
                + "OR au.Apellido LIKE :busqueda "
                + "OR au.Pais LIKE :busqueda "
                + "OR au.Direccion LIKE :busqueda "
                + "OR au.Telefono LIKE :busqueda "
                + "OR au.Correo LIKE :busqueda", Autor.class);
        query.setParameter("busqueda", "%" + busqueda + "%");
        return query.getResultList();
    }
}
