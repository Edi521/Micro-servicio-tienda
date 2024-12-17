package com.mx.ProvedorMS.Service;

import java.util.List;

import com.mx.ProvedorMS.Dominio.Provedor;

public interface IProvedorService {
	
	public void guardar(Provedor provedor);
	
	public void editar(Provedor provedor);
	
	public void eliminar(int idProvedor);
	
	public Provedor buscar(int idProvedor);
	
	public List<Provedor> listar();

}
