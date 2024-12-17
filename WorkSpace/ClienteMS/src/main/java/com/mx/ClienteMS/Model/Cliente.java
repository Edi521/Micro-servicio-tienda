package com.mx.ClienteMS.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {
	
	@Id
	@Column
	private int idCliente;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private int edad;
	
	@Column
	private String direccion;
	
	@Column
	private String estado;
	
	@Column
	private int tiendaId;
	
	public Cliente() {
		
	}

	public Cliente(int idCliente, String nombre, String apellido, int edad, String direccion, String estado,
			int tiendaId) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
		this.estado = estado;
		this.tiendaId = tiendaId;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", direccion=" + direccion + ", estado=" + estado + ", tiendaID=" + tiendaId + "]\n";
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getTiendaID() {
		return tiendaId;
	}

	public void setTiendaID(int tiendaId) {
		this.tiendaId = tiendaId;
	}

	
	
	
	

}
