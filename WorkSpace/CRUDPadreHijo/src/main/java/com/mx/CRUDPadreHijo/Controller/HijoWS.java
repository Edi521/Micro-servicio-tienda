package com.mx.CRUDPadreHijo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.mx.CRUDPadreHijo.Domain.Hijo;
import com.mx.CRUDPadreHijo.Service.HijoServiceImp;

@RestController
@RequestMapping(path = "/api/hijo")
@CrossOrigin
public class HijoWS {
	
	@Autowired
	private HijoServiceImp service;
	
	
	//url:http://localhost:8002/api/hijo
	
	//Listar ---------------------------------------> http://localhost:8002/api/hijo
	@GetMapping
	public ResponseEntity<?>listar(){
		List<Hijo>hijos = service.listar();
		if(hijos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(hijos);
		}
	}
	
	//Guardar ------------------------------------------> http://localhost:8002/api/hijo
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Hijo hijo){
		if(service.buscar(hijo) == null) {
			service.guardar(hijo);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
	//Editar --------------------------------------------------> http://localhost:8002/api/hijo
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Hijo hijo){
		if(service.buscar(hijo) != null) {
			service.editar(hijo);
			return ResponseEntity.status(HttpStatus.OK).build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Eliminar -----------------------------------------------> http://localhost/8002/api/Padre
	@DeleteMapping
	public ResponseEntity<?> eliminar(@RequestBody Hijo hijo){
		service.eliminar(hijo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	//Buscar -----------------------------------------------------> http://localhost/8002/api/Padre/buscar
	@PostMapping("/buscar")
	public ResponseEntity<?> buscar(@RequestBody Hijo hijo){
		Hijo encontrado = service.buscar(hijo);
		if(encontrado == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	//RequestParam ---------------------------------> Pasar informacion por medio de la url, en lugar de pasarla por un body
	//Buscar por hobbie
	@GetMapping("/buscarPorHobbie")
	public ResponseEntity<?> buscarPorHobbie(@RequestParam("hobbie") String hobbie){
		List<Hijo> hijos = service.buscarPorHobbie(hobbie);
		if(hijos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(hijos);
		}
	}
	
	
	
	
	

}
