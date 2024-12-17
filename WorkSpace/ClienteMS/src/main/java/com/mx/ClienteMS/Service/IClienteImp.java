package com.mx.ClienteMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.ClienteMS.Dao.IClienteDao;
import com.mx.ClienteMS.Model.Cliente;


@Service
public class IClienteImp implements IClienteService{

	
	@Autowired
	private IClienteDao dao;
	
	@Override
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		dao.save(cliente);
	}

	@Override
	public void editar(Cliente cliente) {
		// TODO Auto-generated method stub
		dao.save(cliente);
	}

	@Override
	public void eliminar(Cliente cliente) {
		// TODO Auto-generated method stub
		dao.delete(cliente);
	}

	@Override
	public Cliente buscar(Cliente cliente) {
		// TODO Auto-generated method stub
		return dao.findById(cliente.getIdCliente()).orElse(null);
	}

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idCliente"));
	}
	
	public List<Cliente> buscarIDTienda(int tiendaId){
		return dao.findByTiendaId(tiendaId);
	}

}
