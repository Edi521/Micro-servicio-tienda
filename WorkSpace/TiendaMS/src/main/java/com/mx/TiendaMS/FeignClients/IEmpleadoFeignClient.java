package com.mx.TiendaMS.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.TiendaMS.Models.Empleado;


@FeignClient(name = "EmpleadoMS", url = "http://localhost:8002",path = "/api/Empleado")




public interface IEmpleadoFeignClient {

	
	@GetMapping(value = "/buscarPorTienda")
	public List<Empleado> porTienda(@RequestParam int tiendaId);
	
	
}
