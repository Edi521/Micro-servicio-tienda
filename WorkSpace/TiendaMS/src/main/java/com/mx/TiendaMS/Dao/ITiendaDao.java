package com.mx.TiendaMS.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.TiendaMS.Dominio.Tienda;

public interface ITiendaDao extends JpaRepository<Tienda, Integer>{

	
	
	List<Tienda> findByEstadoIgnoringCaseContaining(String estado);
	
}
