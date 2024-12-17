package com.mx.TiendaMS.Models;

import lombok.Data;

@Data

public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellido;
	private int edad;
	private String direccion;
	private String estado;
	private int tiendaId;
	
}
