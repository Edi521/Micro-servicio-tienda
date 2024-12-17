package com.mx.EmpleadoMS.Controller;

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

import com.mx.EmpleadoMS.Dominio.Empleado;
import com.mx.EmpleadoMS.Service.EmpleadoServiceImp;

@RestController
@RequestMapping(path = "/api/Empleado")
@CrossOrigin
public class EmpleadoWS {
	
	
	@Autowired
	private EmpleadoServiceImp service;
	
	//URL:---------------------------------> http://localhost:8002/api/Empleado
	
	//Listar---------------------------------->http://localhost:8002/api/Empleado/listar
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listar(){
		List<Empleado> empleados = service.listar();
		if(empleados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.ok(empleados);
		}
	}
	
	//Guardar---------------------------------------------------------->http://localhost:8002/api/Empleado/guardar
	@PostMapping(value = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Empleado empleado){
		if(service.buscar(empleado)==null) {
			service.guardar(empleado);
			return ResponseEntity.status(HttpStatus.CREATED).body("El empleado "+empleado.getNombre()+" ha sido almacenado");
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("El id "+empleado.getIdEmpleado()+" ya existe. Intenta con otro");
		}
	}
	
	//Buscar---------------------------------------------------------------------->http://localhost:8002/api/Empleado/buscar
	@PostMapping(value = "/buscar")
	public ResponseEntity<?> buscra(@RequestBody Empleado empleado){
		Empleado encontrado = service.buscar(empleado);
		if(encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El empleado "+empleado.getNombre()+" no existe");
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	//Editar------------------------------------------------------------->http://localhost:8002/api/Empleado/editar
	@PutMapping(value = "/editar")
	public ResponseEntity<?> editar(@RequestBody Empleado empleado){
		if(service.buscar(empleado)!=null) {
			service.editar(empleado);
			return ResponseEntity.status(HttpStatus.OK).body("El empleado "+empleado.getNombre()+" fue actualizado");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El empleado "+empleado.getNombre()+" no existe. Intenta nuevamente");
		}
	}
	
	
	//Eliminar------------------------------------------------------------->http://localhost:8002/api/Empleado/eliminar
	@DeleteMapping(value = "/eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Empleado empleado){
		Empleado aux = empleado;
		service.eliminar(empleado);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino el empleado "+aux.getNombre());
	}
	
	//Buscar Por tienda------------------------------------------------------------------------------------------>http://localhost:8002/api/Empleado/buscarPorTienda
	@GetMapping(value = "/buscarPorTienda")
	public ResponseEntity<?> porTienda(@RequestParam int tiendaId){
		List<Empleado> empleados = service.byTiendaId(tiendaId);
			return ResponseEntity.ok(empleados);
	}
	
	
	
	
	
	

}
