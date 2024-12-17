package com.mx.ProductoMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.ProductoMS.Dao.IProductoDao;
import com.mx.ProductoMS.Dominio.Producto;

@Service

public class ProductoServiceImp implements IProductoService{
	
	@Autowired
	private IProductoDao dao;

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		dao.save(producto);
	}

	@Override
	public void editar(Producto producto) {
		// TODO Auto-generated method stub
		dao.save(producto);
	}

	@Override
	public Producto buscar(int idProducto) {
		// TODO Auto-generated method stub
		return dao.findById(idProducto).orElse(null);
	}

	@Override
	public void eliminar(int idProducto) {
		// TODO Auto-generated method stub
		dao.deleteById(idProducto);
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idProducto"));
	}
	
	public List<Producto> byTienda(int tiendaId){
		return dao.findByTiendaId(tiendaId);
	}

}
