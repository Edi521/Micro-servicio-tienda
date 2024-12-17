package com.mx.ProvedorMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.ProvedorMS.Dao.IProvedorDao;
import com.mx.ProvedorMS.Dominio.Provedor;

@Service
public class ProvedorServiceImp implements IProvedorService{

	@Autowired
	private IProvedorDao dao;
	
	@Override
	public void guardar(Provedor provedor) {
		// TODO Auto-generated method stub
		dao.save(provedor);
	}

	@Override
	public void editar(Provedor provedor) {
		// TODO Auto-generated method stub
		dao.save(provedor);
	}

	@Override
	public void eliminar(int idProvedor) {
		// TODO Auto-generated method stub
		dao.deleteById(idProvedor);;
	}

	@Override
	public Provedor buscar(int idProvedor) {
		// TODO Auto-generated method stub
		return dao.findById(idProvedor).orElse(null);
	}

	@Override
	public List<Provedor> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idProvedor"));
	}
	
	//Personalizados
	public List<Provedor> byTienda(int tiendaId){
		return dao.findByTiendaId(tiendaId);
	}
	
	public boolean existenciaProvedor(String nombreProvedor) {
		Provedor encontrado = dao.findByNombreProvedorIgnoringCaseContaining(nombreProvedor);
		if(encontrado != null) {
			return true;
		}else {
			return false;
		}
	}

}
