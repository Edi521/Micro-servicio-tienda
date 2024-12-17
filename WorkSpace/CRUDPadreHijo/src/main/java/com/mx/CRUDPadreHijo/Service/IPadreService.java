package com.mx.CRUDPadreHijo.Service;

import java.util.List;

import com.mx.CRUDPadreHijo.Domain.Padre;

public interface IPadreService {
	
	public void guardar(Padre padre);
	
	public void editar(Padre padre);
	
	public void eliminar(Padre padre);
	
	public Padre buscar(Padre padre);
	
	public List<Padre> listar();

}
