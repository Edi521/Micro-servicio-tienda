package com.mx.ProvedorMS.Controller;

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

import com.mx.ProvedorMS.Dominio.Provedor;
import com.mx.ProvedorMS.Service.ProvedorServiceImp;

@RestController
@RequestMapping(path = "/api/Provedor")
@CrossOrigin

public class ProvedorWS {
	
	@Autowired
	private ProvedorServiceImp service;
	
	//URL---------------------------------------> http://localhost:8005/api/Provedor
	
	//Listar-------------------------------------> http://localhost:8005/api/Provedor/listar
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listar(){
		List<Provedor> provedores = service.listar();
		if(provedores.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(provedores);
		}
	}
	
	//Guardar---------------------------------------------------------> http://localhost:8005/api/Provedor/guardar
	@PostMapping(value = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Provedor provedor){
		Provedor encontrado = service.buscar(provedor.getIdProvedor());
		if(encontrado != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"Ya existe el id "+provedor.getIdProvedor()+" \"}");
		}else {
			if(service.existenciaProvedor(provedor.getNombreProvedor())==true) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El provedor "+provedor.getNombreProvedor()+" ya existe\"}");
			}else {
				service.guardar(provedor);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"mensaje\":\"Se guardo el provedor "+provedor.getNombreProvedor()+"\"}");
			}
		}
	}
	
	//Validar por nombre y tienda
	//Editar------------------------------------------------------------------> http://localhost:8005/api/Provedor/editar
	@PutMapping(value = "/editar")
	public ResponseEntity<?> editar(@RequestBody Provedor provedor){
		if(service.buscar(provedor.getIdProvedor()) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"No existe el provedor con el id"+provedor.getIdProvedor()+"\"}");
		}else {
			if(service.existenciaProvedor(provedor.getNombreProvedor()) == true) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"Ya existe el provedor "+provedor.getNombreProvedor()+"\"}");
			}else {
				service.editar(provedor);
				return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\":\"Se edito el provedor con el id "+provedor.getIdProvedor()+"\"}");
			}
		}
	}
	
	//Eliminar--------------------------------------------------------------------> http://localhost:8005/api/Provedor/eliminar
	@DeleteMapping(value = "/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam int idProvedor){
		List<Provedor> provedores = service.listar();
		if(provedores.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			Provedor aux = service.buscar(idProvedor);
			if(aux != null) {
				service.eliminar(idProvedor);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"mensaje\":\"Se elimino al provedor "+aux.getNombreProvedor()+"\"}");
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"No existe el provedor con id "+idProvedor+"\"}");
			}
		}
	}
	
	
	//Buscar----------------------------------------------------------------------------------------------------------------->
	@PostMapping(value = "{idProvedo}")
	public ResponseEntity<?> buscaEntity(@PathVariable("idProvedor") int idProvedor){
		Provedor encontrado = service.buscar(idProvedor);
		if(encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el provedor con id "+idProvedor);
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	
	//buscarPorTienda----------------------------------------------------------------------------->http://localhost:8005/api/Provedor/porTiendaId/{tiendaId}
	@GetMapping(value = "porTiendaId/{tiendaId}")
	public ResponseEntity<?> bucarPorTienda(@PathVariable int tiendaId){
		List<Provedor> provedores = service.byTienda(tiendaId);
			return ResponseEntity.ok(provedores);
	}
	
	
	
	
	
	

}
