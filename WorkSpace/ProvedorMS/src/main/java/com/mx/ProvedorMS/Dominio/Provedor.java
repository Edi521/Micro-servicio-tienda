package com.mx.ProvedorMS.Dominio;

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
@Table(name = "PROVEDOR")

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Provedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProvedor;
	
	@Column
	private String nombreProvedor;
	
	@Column
	private String telefono;
	
	@Column
	private int tiendaId;

}
