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
@Table(name = "libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro")
	private int idLibro;
	@Column(name = "titulo")
	private String Titulo;
	@Column(name = "editorial")
	private String Editorial;
	@Column(name = "num_paginas")
	private int numPaginas;
	@Column(name = "edicion")
	private String Edicion;
	@Column(name = "idioma")
	private String Idioma;
	@Column(name = "fecha_publicacion")
	private Date fechaPublicacion;
	@Column(name = "descripcion")
	private String Descripcion;
	@Column(name = "tipo_pasta")
	private String tipoPasta;
	@Column(name = "ISBN")
	private String ISBN;
	@Column(name = "num_ejemplares")
	private String numEjemplares;
	@Column(name = "portada")
	private String Portada;
	@Column(name = "presentacion")
	private String Presentacion;
	@Column(name = "precio")
	private double Precio;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "id_autor")
	private Autor autor;
	
	public Libro() {}
	
	public Libro(int idLibro, String titulo, String editorial, int numPaginas, String edicion, String idioma,
			Date fechaPublicacion, String descripcion, String tipoPasta, String iSBN, String numEjemplares,
			String portada, String presentacion, double precio, Categoria categoria, Autor autor) {
		this.idLibro = idLibro;
		this.Titulo = titulo;
		this.Editorial = editorial;
		this.numPaginas = numPaginas;
		this.Edicion = edicion;
		this.Idioma = idioma;
		this.fechaPublicacion = fechaPublicacion;
		this.Descripcion = descripcion;
		this.tipoPasta = tipoPasta;
		this.ISBN = iSBN;
		this.numEjemplares = numEjemplares;
		this.Portada = portada;
		this.Presentacion = presentacion;
		this.Precio = precio;
		this.categoria = categoria;
		this.autor = autor;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getEdicion() {
		return Edicion;
	}

	public void setEdicion(String edicion) {
		Edicion = edicion;
	}

	public String getIdioma() {
		return Idioma;
	}

	public void setIdioma(String idioma) {
		Idioma = idioma;
	}

	public Date getFechaPublicacion() {
	    return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
	    this.fechaPublicacion = fechaPublicacion;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getTipoPasta() {
		return tipoPasta;
	}

	public void setTipoPasta(String tipoPasta) {
		this.tipoPasta = tipoPasta;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getNumEjemplares() {
		return numEjemplares;
	}

	public void setNumEjemplares(String numEjemplares) {
		this.numEjemplares = numEjemplares;
	}

	public String getPortada() {
		return Portada;
	}

	public void setPortada(String portada) {
		Portada = portada;
	}

	public String getPresentacion() {
		return Presentacion;
	}

	public void setPresentacion(String presentacion) {
		Presentacion = presentacion;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", Titulo=" + Titulo + ", Editorial=" + Editorial + ", numPaginas="
				+ numPaginas + ", Edicion=" + Edicion + ", Idioma=" + Idioma + ", Descripcion=" + Descripcion
				+ ", tipoPasta=" + tipoPasta + ", ISBN=" + ISBN + ", numEjemplares=" + numEjemplares + ", Portada="
				+ Portada + ", Presentacion=" + Presentacion + ", Precio=" + Precio + ", categoria=" + categoria
				+ ", autor=" + autor + "]";
	}
	
}
