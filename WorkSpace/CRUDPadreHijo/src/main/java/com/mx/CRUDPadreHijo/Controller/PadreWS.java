package com.mx.CRUDPadreHijo.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CRUDPadreHijo.Domain.Padre;
import com.mx.CRUDPadreHijo.Service.PadreServiceImp;

@RestController
@RequestMapping(path = "/api/Padre")
@CrossOrigin
public class PadreWS {
	
	@Autowired
	private PadreServiceImp service;
	
	//URL: http://localhost:8002/api/Padre
	
	
	//Listar ----------------------------------->  http://localhost:8002/api/Padre/listar
	@GetMapping(value = "listar")
	public ResponseEntity<?> listar(){
		List<Padre> padres = service.listar();
		if(padres.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.ok(padres);
		}
	}
	
	//Guardar ------------------------------------->http://localhost:8002/api/Padre/guardar
	@PostMapping(value = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Padre padre){
		if(service.buscar(padre)==null) {
			if(!service.validarExistencia(padre.getNombre(), padre.getApellido())) {
				service.guardar(padre);
				return ResponseEntity.status(HttpStatus.CREATED).body("{\"mensaje\":\"El padre"+padre.getIdPadre()+"ha sido almacenados\"}");
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El padre"+padre.getNombre()+" "+padre.getApellido()+" ya existe. Intenta con otro\"}");
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El id"+padre.getIdPadre()+"ya existe. Intenta con otro.\"}");
		}
	}
	
	//Editar ------------------------------------>http://localhost:8002/api/Padre/editar 
	@PutMapping(value = "editar")
	public ResponseEntity<?> editar(@RequestBody Padre padre){
		if(service.buscar(padre)!= null) {
			service.editar(padre);
			return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\":\"El padre"+padre.getIdPadre()+"ha sido actualizado.\"}");
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"El padre "+padre.getIdPadre()+"no existe. Intenta nuevamente\"}");
		}
	}
	
	//Buscar -------------------------------------> http://localhost:8002/api/Padre/buscar
	@PostMapping(value = "buscar")
	public ResponseEntity<?>buscar(@RequestBody Padre padre){
		Padre encontrado = service.buscar(padre);
		if(encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"El padre "+padre.getIdPadre()+" no existe.\"}");
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	
	//Eliminar ---------------------------------------> http://localhost:8002/api/Padre/eliminar
	@DeleteMapping(value = "eliminar")
	public ResponseEntity<?>eliminar(@RequestBody Padre padre){
		Padre encontrado = service.buscar(padre);
		if(encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\" El padre "+padre.getIdPadre()+" no existe.\"}");
		}else {
			service.eliminar(padre);
			return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("mensaje", "El padre "+padre.getIdPadre()+" se elimino con exito"));
		}
	}
	
	
	//Buscar por trabajo--------------------------------------------------->http://localhost:8002/api/Padre
	@GetMapping
	public ResponseEntity<?> buscarPorTrabajo(@RequestParam String trabajo){
		List<Padre> padres = service.porTrabajo(trabajo);
		if(padres.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(padres);
		}
	}
	
	

}
