package com.mx.CRUDPadreHijo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.CRUDPadreHijo.Domain.Padre;

public interface IPadreDao extends JpaRepository<Padre, Integer>{
	
	//Metodo personalizado
	
	public Padre findByNombreAndApellidoIgnoringCaseContaining(String nombre, String apellido);
	
	public List<Padre> findByTrabajoIgnoringCaseContaining(String trabajo);
	
	
	

}
