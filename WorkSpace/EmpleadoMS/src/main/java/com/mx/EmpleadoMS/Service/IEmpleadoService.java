package com.mx.EmpleadoMS.Service;

import java.util.List;

import com.mx.EmpleadoMS.Dominio.Empleado;

public interface IEmpleadoService {
	
	public void guardar(Empleado empleado);
	
	public void editar(Empleado empleado);
	
	public void eliminar(Empleado empleado);
	
	public Empleado buscar(Empleado empleado);
	
	public List<Empleado> listar();

}
