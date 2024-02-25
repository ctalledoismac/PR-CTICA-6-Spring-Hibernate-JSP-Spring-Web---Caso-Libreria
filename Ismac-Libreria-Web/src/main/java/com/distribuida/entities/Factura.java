package com.distribuida.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura")
	private int idFactura;
	@Column(name = "num_factura")
	private String numFactura;
	@Column(name = "fecha")
	private Date Fecha;
	@Column(name = "total_neto")
	private Double totalNeto;
	@Column(name = "iva")
	private Double Iva;
	@Column(name = "total")
	private Double Total;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	public Factura() {}
	

	public Factura(int idFactura, String numFactura, Date fecha, Double totalNeto, Double iva, Double total) {
		this.idFactura = idFactura;
		this.numFactura = numFactura;
		this.Fecha = fecha;
		this.totalNeto = totalNeto;
		this.Iva = iva;
		this.Total = total;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public Double getTotalNeto() {
		return totalNeto;
	}

	public void setTotalNeto(Double totalNeto) {
		this.totalNeto = totalNeto;
	}

	public Double getIva() {
		return Iva;
	}

	public void setIva(Double iva) {
		Iva = iva;
	}

	public Double getTotal() {
		return Total;
	}

	public void setTotal(Double total) {
		Total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", numFactura=" + numFactura + ", Fecha=" + Fecha + ", totalNeto="
				+ totalNeto + ", Iva=" + Iva + ", Total=" + Total + ", cliente=" + cliente + "]";
	}
	
}
