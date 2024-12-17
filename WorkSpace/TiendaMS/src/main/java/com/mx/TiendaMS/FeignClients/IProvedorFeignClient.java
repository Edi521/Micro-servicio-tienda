package com.mx.TiendaMS.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.TiendaMS.Models.Provedor;

@FeignClient(name = "ProvedorMS",url = "http://localhost:8005",path = "/api/Provedor")


public interface IProvedorFeignClient {
	
	
	@GetMapping(value = "porTiendaId/{tiendaId}")
	public List<Provedor> bucarPorTienda(@PathVariable int tiendaId);

}
