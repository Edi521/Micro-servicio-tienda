package com.mx.CRUDPadreHijo.Domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PADRE")


public class Padre {
	
	@Id
	@Column
	private int idPadre;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private int edad;
	
	@Column
	private String trabajo;
	
	@OneToMany(mappedBy = "padreID",cascade = CascadeType.ALL) //mapped indica la propiedad de la entidad dueña de la relacion que hace referencia a la entidad principal
	//cascade se utiliza para indicar como se deben propagar las opercaciones de persistencias
	//Definir una lista para almacenar las instancias de la clase Hijo que estan relacionadas con las instancias de la clase padre.
	List<Hijo>lista = new ArrayList<>();
	
	
	public Padre() {
		
	}


	public Padre(int idPadre, String nombre, String apellido, int edad, String trabajo) {
		super();
		this.idPadre = idPadre;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.trabajo = trabajo;
	}


	@Override
	public String toString() {
		return "Padre [idPadre=" + idPadre + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", trabajo=" + trabajo + "]\n";
	}


	public int getIdPadre() {
		return idPadre;
	}


	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
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


	public String getTrabajo() {
		return trabajo;
	}


	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	
	

}
