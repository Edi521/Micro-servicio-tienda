package com.mx.TiendaMS.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.TiendaMS.Models.Pedido;



@FeignClient(name = "PedidosMS",url = "http://localhost:8004",path = "/api/Pedido")


public interface IPedidoFeignClient {

	
	@GetMapping(value = "porTiendaId/{tiendaId}")
	public List<Pedido> buscarPorTienda(@PathVariable int tiendaId);
	
	
}
