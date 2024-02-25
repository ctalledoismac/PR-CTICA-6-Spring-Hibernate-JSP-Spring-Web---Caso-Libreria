package com.distribuida.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuida.dao.FacturaDAO;
import com.distribuida.dao.FacturaDetalleDAO;
import com.distribuida.dao.LibroDAO;
import com.distribuida.entities.Factura;
import com.distribuida.entities.FacturaDetalle;
import com.distribuida.entities.Libro;


@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {

	@Autowired
	private FacturaDetalleDAO facturaDetalleDAO;
	
	@Autowired
	private FacturaDAO facturaDAO;
	
	@Autowired
	private LibroDAO libroDAO;
	
	@Override
	public List<FacturaDetalle> findAll() {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.findAll();
	}

	@Override
	public FacturaDetalle findOne(int id) {
		// TODO Auto-generated method stub
		return facturaDetalleDAO.findOne(id);
	}

	@Override
	public void add(int idFacturaDetalle, int cantidad, Double subtotal, int idFactura, int idLibro) {
	    // TODO Auto-generated method stub
	    Factura factura = facturaDAO.findOne(idFactura);
	    Libro libro = libroDAO.findOne(idLibro);
	    
	    FacturaDetalle facturaDetalle = new FacturaDetalle(idFacturaDetalle, cantidad, subtotal);
	    
	    facturaDetalle.setFactura(factura);
	    facturaDetalle.setLibro(libro);
	    facturaDetalleDAO.add(facturaDetalle);
		
	}

	@Override
	public void up(int idFacturaDetalle, int cantidad, Double subtotal, int idFactura, int idLibro) {
	    // TODO Auto-generated method stub
	    Factura facturaObj = facturaDAO.findOne(idFactura);
	    Libro libroObj = libroDAO.findOne(idLibro);
	    
	    FacturaDetalle facturaDetalle = new FacturaDetalle(idFacturaDetalle, cantidad, subtotal);
	    
	    facturaDetalle.setFactura(facturaObj);
	    facturaDetalle.setLibro(libroObj);
	    facturaDetalleDAO.update(facturaDetalle);
	}


	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		facturaDetalleDAO.delete(id);
	}

}
