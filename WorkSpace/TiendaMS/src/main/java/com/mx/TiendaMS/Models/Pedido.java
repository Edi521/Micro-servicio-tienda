package com.mx.TiendaMS.Models;

import java.sql.Date;

import lombok.Data;

@Data

public class Pedido {
	
	private int idPedido;
	private Date fechaPedido;
	private String nombreCliente;
	private String telefonoCliente;
	private String direccionEnvio;
	private String estatusPedido;
	private int tiendaId;

}
