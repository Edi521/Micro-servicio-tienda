package com.mx.ClienteMS.Service;

import java.util.List;

import com.mx.ClienteMS.Model.Cliente;

public interface IClienteService {
	
	public void guardar(Cliente cliente);
	
	public void editar(Cliente cliente);
	
	public void eliminar(Cliente cliente);
	
	public Cliente buscar(Cliente cliente);
	
	public List<Cliente> listar();

}
