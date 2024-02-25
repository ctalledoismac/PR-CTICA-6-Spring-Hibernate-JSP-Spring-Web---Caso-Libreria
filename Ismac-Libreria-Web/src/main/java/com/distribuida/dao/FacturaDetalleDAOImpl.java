package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.FacturaDetalle;

@Repository
public class FacturaDetalleDAOImpl implements FacturaDetalleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<FacturaDetalle> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM FacturaDetalle", FacturaDetalle.class).getResultList();
    }

    @Override
    @Transactional
    public FacturaDetalle findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<FacturaDetalle> query = session.createQuery("FROM FacturaDetalle fd WHERE fd.idFacturaDetalle = :idFacturaDetalle", FacturaDetalle.class);
        query.setParameter("idFacturaDetalle", id);
        return query.uniqueResult();
    }

    @Override
    @Transactional
    public void add(FacturaDetalle facturaDetalle) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(facturaDetalle);
    }

    @Override
    @Transactional
    public void update(FacturaDetalle facturaDetalle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("UPDATE FacturaDetalle SET "
                + "cantidad = :cantidad, "
                + "subtotal = :subtotal, "
                + "factura = :factura, "  
                + "libro = :libro "
                + "WHERE idFacturaDetalle = :idFacturaDetalle");

        query.setParameter("cantidad", facturaDetalle.getCantidad());
        query.setParameter("subtotal", facturaDetalle.getSubtotal());
        query.setParameter("factura", facturaDetalle.getFactura());
        query.setParameter("libro", facturaDetalle.getLibro());
        query.setParameter("idFacturaDetalle", facturaDetalle.getIdFacturaDetalle());

        query.executeUpdate();
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM FacturaDetalle fd WHERE fd.idFacturaDetalle = :idFacturaDetalle");
        query.setParameter("idFacturaDetalle", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public List<FacturaDetalle> findAll(String busqueda) {
        Session session = sessionFactory.getCurrentSession();
        Query<FacturaDetalle> query = session.createQuery(
                "FROM FacturaDetalle fd WHERE fd.cantidad LIKE :busqueda OR fd.subtotal LIKE :busqueda",
                FacturaDetalle.class);
        query.setParameter("busqueda", "%" + busqueda + "%");
        return query.getResultList();
    }
}
