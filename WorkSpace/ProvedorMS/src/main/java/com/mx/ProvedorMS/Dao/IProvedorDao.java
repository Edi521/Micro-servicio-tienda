package com.mx.ProvedorMS.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ProvedorMS.Dominio.Provedor;

public interface IProvedorDao extends JpaRepository<Provedor, Integer>{

	
	public List<Provedor> findByTiendaId(int tiendaId);
	
	public Provedor findByNombreProvedorIgnoringCaseContaining(String nombreProvedor);
	
}
