package com.mx.TiendaMS.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.TiendaMS.Models.Cliente;



//OpenFeing es un cliente http desarrollado por netflix, que simplifica la llamada a servicios RestFull

@FeignClient (name = "ClienteMS", url = "http://localHost:8001",path = "/api/Cliente")//Esta anotacion realiza la conexion con otro MS y sus servicios RestFull. (Producto)

public interface IClienteFeignClient {

	
	//Servicio Restfull a consumir, endPoint y la cabecera del metodo
	
	@GetMapping(value = "/buscarT")
	public List<Cliente> buscarTienda(@RequestParam int tiendaId);
		
	
	
}
