package com.mx.TiendaMS.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TIENDA")

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Tienda {
	
	@Id
	@Column
	private int idTienda;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@Column
	private String estado;
	
	@Column
	private int ingreso;

}
