package com.mx.PedidosMs.Service;

import java.util.List;

import com.mx.PedidosMs.Dominio.Pedido;

public interface IPedidoService {

	
	public void guardar(Pedido pedido);
	
	public void editar(Pedido pedido);
	
	public Pedido buscar(int idPedido);
	
	public void eliminar(int idPedido);
	
	public List<Pedido> listar();
	
	
	
	
}
