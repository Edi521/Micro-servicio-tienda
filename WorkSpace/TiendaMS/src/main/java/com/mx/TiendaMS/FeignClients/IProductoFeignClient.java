package com.mx.TiendaMS.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.TiendaMS.Models.Producto;


@FeignClient(name = "ProductoMS", url = "http://localhost:8003",path = "/api/Producto")




public interface IProductoFeignClient {
	
	
	@GetMapping(value = "porTiendaId/{tiendaId}")
	public List<Producto> buscarPorTienda(@PathVariable int tiendaId);

}
