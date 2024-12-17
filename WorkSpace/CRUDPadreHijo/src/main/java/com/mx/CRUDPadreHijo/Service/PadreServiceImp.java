package com.mx.CRUDPadreHijo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.CRUDPadreHijo.Dao.IPadreDao;
import com.mx.CRUDPadreHijo.Domain.Padre;

@Service
public class PadreServiceImp implements IPadreService{
	
	@Autowired
	private IPadreDao dao;

	@Override
	public void guardar(Padre padre) {
		// TODO Auto-generated method stub
		dao.save(padre);
	}

	@Override
	public void editar(Padre padre) {
		// TODO Auto-generated method stub
		dao.save(padre);
	}

	@Override
	public void eliminar(Padre padre) {
		// TODO Auto-generated method stub
		dao.delete(padre);
	}

	@Override
	public Padre buscar(Padre padre) {
		// TODO Auto-generated method stub
		return dao.findById(padre.getIdPadre()).orElse(null);
	}

	@Override
	public List<Padre> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idPadre"));
	}
	
	
	//metodos personalizados
	public boolean validarExistencia(String nombre, String apellido) {
		Padre encontrado = dao.findByNombreAndApellidoIgnoringCaseContaining(nombre, apellido);
		if(encontrado != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Padre> porTrabajo(String trabajo){
		return dao.findByTrabajoIgnoringCaseContaining(trabajo);
	}
	
	
	

}
