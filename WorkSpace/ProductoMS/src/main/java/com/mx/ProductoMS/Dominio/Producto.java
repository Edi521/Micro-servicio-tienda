package com.mx.ProductoMS.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
//Lombok es una biblioteca que se utiliza para generar codigo repetitivo como constructores, toString, Getters y Setters
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Es una anotacion de jpa para indicar que el idProducto se creara automaticamente
	private int idProducto;
	
	private String nombre;
	private String marca;
	private double precio;
	private String categoria;
	private int stock;
	private int tiendaId;
	
	

}
