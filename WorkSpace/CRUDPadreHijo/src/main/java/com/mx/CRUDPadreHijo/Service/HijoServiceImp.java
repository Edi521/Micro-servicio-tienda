package com.mx.CRUDPadreHijo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.CRUDPadreHijo.Dao.IHijoDao;
import com.mx.CRUDPadreHijo.Domain.Hijo;

@Service
public class HijoServiceImp implements IHijoService{

	
	@Autowired
	private IHijoDao dao;

	@Override
	public void guardar(Hijo hijo) {
		// TODO Auto-generated method stub
		dao.save(hijo);
		
	}

	@Override
	public void editar(Hijo hijo) {
		// TODO Auto-generated method stub
		dao.save(hijo);
	}

	@Override
	public void eliminar(Hijo hijo) {
		// TODO Auto-generated method stub
		dao.delete(hijo);
	}

	@Override
	public Hijo buscar(Hijo hijo) {
		// TODO Auto-generated method stub
		return dao.findById(hijo.getIdHijo()).orElse(null);
	}

	@Override
	public List<Hijo> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idHijo"));
	}
	
	public List<Hijo> buscarPorHobbie(String hobbie){
		return dao.hobbie(hobbie);
	}
	
	
	
}
