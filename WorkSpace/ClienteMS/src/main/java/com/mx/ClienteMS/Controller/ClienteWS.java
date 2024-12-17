package com.mx.ClienteMS.Controller;

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

import com.mx.ClienteMS.Model.Cliente;
import com.mx.ClienteMS.Service.IClienteImp;

@RestController
@RequestMapping(path = "/api/Cliente")
@CrossOrigin
public class ClienteWS {
	
	
	@Autowired
	private IClienteImp servise;
	
	//URL---------------------------------> http://localhost:8001/api/Cliente
	
	
	//Listar----------------------------->http://localhost:8001/api/Cliente/listar
	@GetMapping(value = "listar")
	public ResponseEntity<?> listar(){
		List<Cliente> clientes = servise.listar();
		if(clientes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.ok(clientes);
		}
	}
	
	//Guardar-------------------------------------------------->http://localhost:8001/api/Cliente/guardar
	@PostMapping(value = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Cliente cliente) {
		if(servise.buscar(cliente) == null) {
			servise.guardar(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body("El cliente "+cliente.getNombre()+" ha sido almacenado");
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("El id "+cliente.getIdCliente()+" ya existe. Intenta con otro");
		}
	}
	
	
	//Editar-------------------------------------------------->http://localhost:8001/api/Cliente/editar
	@PutMapping(value = "/editar")
	public ResponseEntity<?> editar(@RequestBody Cliente cliente) {
		if(servise.buscar(cliente)!=null) {
			servise.editar(cliente);
			return ResponseEntity.status(HttpStatus.OK).body("El cliente con id "+cliente.getIdCliente()+" se edito");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente con id "+cliente.getIdCliente()+" no existe. Intenta nuevamente");
		}
	}
	
	
	//Buscar---------------------------------------------->http://localhost:8001/api/Cliente/buscar
	@PostMapping(value = "/buscar")
	public ResponseEntity<?> buscar(@RequestBody Cliente cliente) {
		Cliente encontrado = servise.buscar(cliente);
		if(encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente "+cliente.getNombre()+" no existe");
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	
	//Eliminar------------------------------------------------------->http://localhost:8001/api/Cliente/eliminar
	@DeleteMapping(value = "/eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Cliente cliente) {
		Cliente aux = cliente;
		servise.eliminar(cliente);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino el empleado"+aux.getNombre());
	}
	
	
	//Busacar tienda
	@GetMapping(value = "/buscarT")
	public ResponseEntity<?> buscarTienda(@RequestParam int tiendaId){
		List<Cliente> clientes = servise.buscarIDTienda(tiendaId);
			return ResponseEntity.ok(clientes);
	}
	

}
