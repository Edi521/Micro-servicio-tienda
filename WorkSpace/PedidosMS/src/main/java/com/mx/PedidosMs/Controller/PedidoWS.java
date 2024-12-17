package com.mx.PedidosMs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.PedidosMs.Dominio.Pedido;
import com.mx.PedidosMs.Service.PedidoServiceImp;

@RestController
@RequestMapping(path = "/api/Pedido")
@CrossOrigin
public class PedidoWS {
	
	@Autowired
	private PedidoServiceImp service;
	
	//URL------------------------------------> http://localhost:8004/api/Pedido
	
	
	//Listar------------------------------------> http://localhost:8004/api/Pedido/listar
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listar(){
		List<Pedido> pedidos = service.listar();
		if(pedidos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(pedidos);
		}
	}
	
	//Guardar------------------------------------------------------> http://localhost:8004/api/Pedido/guardar
	@PostMapping(value = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Pedido pe){
		Pedido encontrado = service.buscar(pe.getIdPedido());
		if(encontrado == null) {
			if(service.validarExistencia(pe.getNombreCliente()) == true) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El cliente "+pe.getNombreCliente()+" ya tiene un pedido\"}");
			}else {
				service.guardar(pe);
				return ResponseEntity.status(HttpStatus.CREATED).body("{\"mensja\":\"Se guardo el pedido con el id "+pe.getIdPedido()+"\"}");
			}
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"Ya existe el piedido con el id "+pe.getIdPedido()+"\"}");
		}
	}
	
	//Editar-------------------------------------------------------> http://localhost:8004/api/Pedido/editar
	@PutMapping(value = "/editar") 
	public ResponseEntity<?> editar(@RequestBody Pedido pe){
		if(service.buscar(pe.getIdPedido()) != null) {
			service.editar(pe);
			return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\":\"Se edito el pedido con id "+pe.getIdPedido()+"\"}");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"No se encontro el pedido con id "+pe.getIdPedido()+"\"}");
		}		
	}
	
	
	//Eliminar------------------------------------------------------> http://localhost:8004/api/Pedido/eliminar
	@DeleteMapping(value = "/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam int idPedido){
		List<Pedido> pedidos = service.listar();
		if(pedidos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			Pedido aux = service.buscar(idPedido);
			if(aux != null) {
				service.eliminar(idPedido);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"mensaje\":\"Se elimino el pedido con el id "+aux.getIdPedido()+"\"}");
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"No existe el pedido con el id "+idPedido+"\"}");
			}
		}


		
	}
	
	//Buscar------------------------------------------------------------------------->http://localhost:8004/api/Pedido/idPedido
	@PostMapping(value = "{idPedido}")
	public ResponseEntity<?> buscar(@PathVariable("idPedido") int idPedido){
		Pedido encontrado = service.buscar(idPedido);
		
		if(encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensjae\":\"No se encontro el pedido con el id "+idPedido+"\"}");
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	
	//buscarPorTienda------------------------------------------------------------------> http://localhost:8004/api/Pedido/porTiendaId/tiendaId
	@GetMapping(value = "porTiendaId/{tiendaId}")
	public ResponseEntity<?> buscarPorTienda(@PathVariable int tiendaId){
		List<Pedido> pedidos = service.byTienda(tiendaId);
			return ResponseEntity.ok(pedidos);
	}
	
	
	
	
	
	
	

}
