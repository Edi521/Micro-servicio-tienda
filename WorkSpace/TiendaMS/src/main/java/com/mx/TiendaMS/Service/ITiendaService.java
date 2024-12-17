package com.mx.TiendaMS.Service;

import java.util.List;

import com.mx.TiendaMS.Dominio.Tienda;

public interface ITiendaService {
	
	public void guardar(Tienda tienda);
	
	public void editar(Tienda tienda);
	
	public Tienda buscar(int idTienda);
	
	public void eliminar(int idTienda);
	
	List<Tienda> listar();

}
