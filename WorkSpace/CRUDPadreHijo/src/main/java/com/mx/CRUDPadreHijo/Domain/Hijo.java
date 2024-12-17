package com.mx.CRUDPadreHijo.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HIJO")
public class Hijo {

	
	@Id
	@Column
	private int idHijo;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private int edad;
	
	@Column
	private String hobbie;
	
	@ManyToOne(fetch = FetchType.EAGER) //ManyToOne se refiere a la relacion de muchos a uno; y el fetch indica que quiero traer la informacion del hijo junto con su padre
	@JoinColumn(name = "PADRE_ID")//SE UTILIZA PARA DEFINIR LA COLUMNA EN LA ENTIDAD DUEÑA DE LA RELACION QUE HACE REFERENCIA A LA ENTIDAD RELACIONADA
	private Padre padreID;	
	
	public Hijo() {
		
	}

	public Hijo(int idHijo, String nombre, String apellido, int edad, String hobbie, Padre padreID) {
		super();
		this.idHijo = idHijo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.hobbie = hobbie;
		this.padreID = padreID;
	}

	@Override
	public String toString() {
		return "Hijo [idHijo=" + idHijo + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", hobbie=" + hobbie + ", padreID=" + padreID + "]\n";
	}

	public int getIdHijo() {
		return idHijo;
	}

	public void setIdHijo(int idHijo) {
		this.idHijo = idHijo;
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

	public String getHobbie() {
		return hobbie;
	}

	public void setHobbie(String hobbie) {
		this.hobbie = hobbie;
	}

	public Padre getPadreID() {
		return padreID;
	}

	public void setPadreID(Padre padreID) {
		this.padreID = padreID;
	}
	
	
	
}
