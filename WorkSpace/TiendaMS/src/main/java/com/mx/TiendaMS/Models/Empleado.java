package com.mx.TiendaMS.Models;

import lombok.Data;

@Data

public class Empleado {
	
	private int idEmpleado;
	private String nombre;
	private String app;
	private long telefono;
	private String puesto;
	private int tiendaId;

}
