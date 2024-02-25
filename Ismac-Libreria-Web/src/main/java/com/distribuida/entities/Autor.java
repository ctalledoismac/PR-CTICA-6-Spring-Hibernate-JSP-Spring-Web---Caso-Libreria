package com.distribuida.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "autor")
public class Autor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor")
	private int idAutor;
	@Column(name = "nombre")
	private String Nombre;
	@Column(name = "apellido")
	private String Apellido;
	@Column(name = "pais")
	private String Pais;
	@Column(name = "direccion")
	private String Direccion;
	@Column(name = "telefono")
	private String Telefono;
	@Column(name = "correo")
	private String Correo;
	
	public Autor() {
		
	}

	public Autor(int idAutor, String nombre, String apellido, String pais, String direccion, String telefono,
			String correo) {
		this.idAutor = idAutor;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Pais = pais;
		this.Direccion = direccion;
		this.Telefono = telefono;
		this.Correo = correo;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Pais=" + Pais
				+ ", Direccion=" + Direccion + ", Telefono=" + Telefono + ", Correo=" + Correo + "]";
	}
	
}
