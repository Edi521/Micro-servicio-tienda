package com.mx.PedidosMs.Dominio;

import java.sql.Date;

import jakarta.persistence.Column;
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

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	
	
	@Column
	private Date fechaPedido;
	
	@Column
	private String nombreCliente;
	
	@Column
	private String telefonoCliente;
	
	@Column
	private String direccionEnvio;
	
	@Column
	private String estatusPedido;
	
	@Column
	private int tiendaId;
		
	
}
