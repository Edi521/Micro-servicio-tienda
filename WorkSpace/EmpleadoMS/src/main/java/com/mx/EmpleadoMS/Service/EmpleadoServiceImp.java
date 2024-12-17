package com.mx.EmpleadoMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.EmpleadoMS.Dao.IEmpleadoDao;
import com.mx.EmpleadoMS.Dominio.Empleado;

@Service
public class EmpleadoServiceImp implements IEmpleadoService{

	@Autowired
	private IEmpleadoDao dao;
	
	@Override
	public void guardar(Empleado empleado) {
		// TODO Auto-generated method stub
		dao.save(empleado);
	}

	@Override
	public void editar(Empleado empleado) {
		// TODO Auto-generated method stub
		dao.save(empleado);
	}

	@Override
	public void eliminar(Empleado empleado) {
		// TODO Auto-generated method stub
		dao.delete(empleado);
	}

	@Override
	public Empleado buscar(Empleado empleado) {
		// TODO Auto-generated method stub
		return dao.findById(empleado.getIdEmpleado()).orElse(null);
	}

	@Override
	public List<Empleado> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idEmpleado"));
	}
	
	public List<Empleado> byTiendaId(int tiendaId){
		return dao.findByTiendaId(tiendaId);
	}

}
