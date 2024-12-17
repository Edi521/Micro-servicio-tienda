package com.mx.PedidosMs.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.PedidosMs.Dao.IPedidoDao;
import com.mx.PedidosMs.Dominio.Pedido;

@Service
public class PedidoServiceImp implements IPedidoService{
	
	@Autowired
	private IPedidoDao dao;

	@Override
	public void guardar(Pedido pedido) {
		// TODO Auto-generated method stub
		dao.save(pedido);
	}

	@Override
	public void editar(Pedido pedido) {
		// TODO Auto-generated method stub
		dao.save(pedido);
	}

	@Override
	public Pedido buscar(int idPedido) {
		// TODO Auto-generated method stub
		return dao.findById(idPedido).orElse(null);
	}

	@Override
	public void eliminar(int idPedido) {
		// TODO Auto-generated method stub
		dao.deleteById(idPedido);
	}

	@Override
	public List<Pedido> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idPedido"));
	}
	
	public List<Pedido> byTienda(int tiendaId){
		return dao.findByTiendaId(tiendaId);
	}
	
	public boolean validarExistencia(String nombre) {
		List<Pedido> encontrado = dao.findByNombreClienteIgnoringCaseContaining(nombre);
		if(encontrado.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	

}
