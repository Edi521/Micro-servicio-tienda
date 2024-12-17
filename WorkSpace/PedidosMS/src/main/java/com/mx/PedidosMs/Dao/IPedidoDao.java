package com.mx.PedidosMs.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.PedidosMs.Dominio.Pedido;

public interface IPedidoDao extends JpaRepository<Pedido, Integer>{
	
	
	public List<Pedido> findByTiendaId(int tiendaId);
	
	public List<Pedido> findByNombreClienteIgnoringCaseContaining(String nombreCliente);
	
	

}
