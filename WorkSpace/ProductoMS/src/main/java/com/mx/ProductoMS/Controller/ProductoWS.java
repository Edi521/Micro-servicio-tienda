package com.mx.ProductoMS.Controller;

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

import com.mx.ProductoMS.Dominio.Producto;
import com.mx.ProductoMS.Service.ProductoServiceImp;


@RestController
@RequestMapping (path = "/api/Producto")
@CrossOrigin

public class ProductoWS {

	@Autowired
	private ProductoServiceImp service;
	
	//URL-------------------------------------> http://localhost:8003/api/Producto
	
	//Listar----------------------------------------------------------------------------------------> http://localhost:8003/api/Producto/listar
	@GetMapping(value="/listar")
	public ResponseEntity<?> listar(){
		List<Producto> productos = service.listar();
		if(productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(productos);
		}
	}
	
	
	//Guardar---------------------------------------------------------------------------------------> http://localhost:8003/api/Producto/guardar
	@PostMapping(value = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Producto pro){
		Producto encontrado = service.buscar(pro.getIdProducto());
		if(encontrado == null) {
			service.guardar(pro);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	//Editar----------------------------------------------------------------------------------------> http://localhost:8003/api/Producto/editar
	@PutMapping(value = "/editar")
	public ResponseEntity<?> editar(@RequestBody Producto pro){
		if(service.buscar(pro.getIdProducto()) != null) {
			service.guardar(pro);
			return ResponseEntity.status(HttpStatus.OK).build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//Eliminra---------------------------------------------------------------------------------------> http://localhost:8003/api/Producto/eliminar
	@DeleteMapping(value = "/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam int idProducto){
		service.eliminar(idProducto);
		return ResponseEntity.noContent().build();
	}
	
	//Buscar---------------------------------------------------------------------------------------->
	@PostMapping(value = "{idProducto}")
	public ResponseEntity<?> buscar(@PathVariable("idProducto") int idProducto){
		Producto encontrado = service.buscar(idProducto);
		if(encontrado == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	//buscarporTienda-------------------------------------------------------------------------------> 
	@GetMapping(value = "porTiendaId/{tiendaId}")
	public ResponseEntity<?> buscarPorTienda(@PathVariable int tiendaId){
		List<Producto> productos = service.byTienda(tiendaId);
			return ResponseEntity.ok(productos);
	}
	
	
	
}
