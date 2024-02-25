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
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Cliente")
	private int idCliente;
	@Column(name = "cedula")
	private String Cedula;
	@Column(name = "nombre")
	private String Nombre;
	@Column(name = "apellido")
	private String Apellido;
	@Column(name = "direccion")
	private String Direccion;
	@Column(name = "telefono")
	private String Telefono;
	@Column(name = "correo")
	private String Correo;
	
	public Cliente() {
		
	}
	
	

	public Cliente(int idCliente, String cedula, String nombre, String apellido, String direccion, String telefono,
			String correo) {
		this.idCliente = idCliente;
		Cedula = cedula;
		Nombre = nombre;
		Apellido = apellido;
		Direccion = direccion;
		Telefono = telefono;
		Correo = correo;
	}


	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
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
		return "Cliente [idCliente=" + idCliente + ", Cedula=" + Cedula + ", Nombre=" + Nombre + ", Apellido="
				+ Apellido + ", Direccion=" + Direccion + ", Telefono=" + Telefono + ", Correo=" + Correo + "]";
	}
	
}
