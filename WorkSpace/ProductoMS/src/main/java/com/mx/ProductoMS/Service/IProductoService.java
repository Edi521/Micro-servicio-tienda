package com.mx.ProductoMS.Service;

import java.util.List;

import com.mx.ProductoMS.Dominio.Producto;

public interface IProductoService {
	
	
	public void guardar(Producto producto);
	
	public void editar(Producto producto);
	
	public Producto buscar(int idProducto);
	
	public void eliminar(int idProducto);
	
	public List<Producto> listar();

}
