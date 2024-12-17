package com.mx.TiendaMS.Models;

import lombok.Data;

@Data

public class Producto {
	
	private int idProducto;
	private String nombre;
	private String marca;
	private double precio;
	private String categoria;
	private int stock;
	private int tiendaId;

}
