package com.distribuida.dto;

import java.util.List;

import com.distribuida.entities.FacturaDetalle;

public interface FacturaDetalleService {

	public List<FacturaDetalle> findAll();
	
	public FacturaDetalle findOne(int id);
	
	public void add(int idFacturaDetalle, int cantidad, Double subtotal, int factura, int libro);
	
	public void up(int idFacturaDetalle, int cantidad, Double subtotal, int factura, int libro);
	
	public void del(int id);
}
