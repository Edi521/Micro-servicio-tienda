package com.mx.EmpleadoMS.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.EmpleadoMS.Dominio.Empleado;

public interface IEmpleadoDao extends JpaRepository<Empleado, Integer>{
	
	public List<Empleado> findByTiendaId(int tiendaId);

}
