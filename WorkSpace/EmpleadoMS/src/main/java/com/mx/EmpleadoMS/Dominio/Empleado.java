package com.mx.EmpleadoMS.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLEADO_TIENDA")
public class Empleado {
	
	@Id
	@Column
	private int idEmpleado;
	
	@Column
	private String nombre;
	
	@Column
	private String app;
	
	@Column
	private long telefono;
	
	@Column
	private String puesto;
	
	@Column
	private int tiendaId;
	
	public Empleado() {
		
	}

	public Empleado(int idEmpleado, String nombre, String app, long telefono, String puesto, int tiendaId) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.app = app;
		this.telefono = telefono;
		this.puesto = puesto;
		this.tiendaId = tiendaId;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", app=" + app + ", telefono=" + telefono
				+ ", puesto=" + puesto + ", tiendaId=" + tiendaId + "]\n";
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getTiendaId() {
		return tiendaId;
	}

	public void setTiendaId(int tiendaId) {
		this.tiendaId = tiendaId;
	}
	
	
	

}
