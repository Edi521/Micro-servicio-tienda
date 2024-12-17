package com.mx.TiendaMS.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mx.TiendaMS.Dominio.Tienda;
import com.mx.TiendaMS.Models.Cliente;
import com.mx.TiendaMS.Models.Empleado;
import com.mx.TiendaMS.Models.Pedido;
import com.mx.TiendaMS.Models.Producto;
import com.mx.TiendaMS.Models.Provedor;
import com.mx.TiendaMS.Service.TiendaServiceImp;

@RestController
@RequestMapping(path = "/api/Tienda")
//@CrossOrigin

public class TiendaWS {
	
	@Autowired
	private TiendaServiceImp service;
	
	//URI : http://localhost:8010/api/Tienda
	
	//Listar-------------------------------------------------> http://localhost:8010/api/Tienda/listar
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listar(){
		List<Tienda> tiendas = service.listar();
		if(tiendas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(tiendas);
		}
		
	}
	
	
	//Guardar----------------------------------------------------->  http://localhost:8010/api/Tienda/guardar
	@PostMapping(value = "/guardar")
	public ResponseEntity<?> guardar(@RequestBody Tienda tienda){
		Tienda encontrado = service.buscar(tienda.getIdTienda());
		
		if(encontrado != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"El id "+tienda.getIdTienda()+" ya existe\"}");
		}else {
			service.guardar(tienda);
			return ResponseEntity.status(HttpStatus.CREATED).body("{\"mensaje\":\"La tienda"+tienda.getNombre()+"ha sido almacenada\"}");
		}
	}
	
	//Editar--------------------------------------------------------> http://localhost:8010/api/Tienda/editar
	@PutMapping(value = "/editar")
	public ResponseEntity<?> editar(@RequestBody Tienda tienda){
		if(service.buscar(tienda.getIdTienda()) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"La tienda con id "+tienda.getIdTienda()+" no existe\"}");
		}else {
			service.editar(tienda);
			return ResponseEntity.status(HttpStatus.OK).body("{\"mensjae\":\"Se edito la tienda con id"+tienda.getIdTienda()+"\"}");
		}
	}
	
	//Eliminar----------------------------------------------------------> http://localhost:8010/api/Tienda/eliminar
	@DeleteMapping(value = "/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam int idTienda){
		Tienda aux = service.buscar(idTienda);
		if(aux != null) {
			service.eliminar(idTienda);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"mensaje\":\"Se elimino la tienda "+aux.getNombre()+"\"}");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"No existe la tienda con id "+idTienda+"\"}");
		}
	}
	
	//Buscar
	@PostMapping("{idTienda}")
	public ResponseEntity<?> buscar(@PathVariable("idTienda") int idTienda){
		Tienda encontrado = service.buscar(idTienda);
		if(encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"No se encontro la tienda con id"+idTienda+"\"}");
		}else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	//Buscar por estado
	@GetMapping(value = "porEstado/{estado}") //
	public ResponseEntity<?> porEstado(@PathVariable String estado){
		List<Tienda> tiendas = service.byEstado(estado);
		if(tiendas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"No se encontraron tiendas en el estado "+estado+"\"}");
		}else {
			return ResponseEntity.ok(tiendas);
		}
		
	}
	
	//Metodo para servicio Restfull con OpenFeign
	
	//Cliente
	@GetMapping(value = "ClientesPorTienda/{tiendaId}")
	public ResponseEntity<?> listarClientes(@PathVariable int tiendaId){
		List<Cliente> clientes = service.obtenerClientes(tiendaId);
		if(clientes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(clientes);
		}
	}
	
	
	//Empleado------------------------------------------------------> http://localhost:8010/api/Tienda/EmpleadosPorTienda/
	@GetMapping(value = "EmpleadosPorTienda/{tiendaId}")
	public ResponseEntity<?> listarEmpleados(@PathVariable int tiendaId){
		List<Empleado> empleados = service.obtenerEmpleados(tiendaId);
		if(empleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(empleados);
		}
	}
	
	
	//Producto----------------------------------------------------------------> http://localhost:8010/api/Tienda/ProductosPorTienda/
	@GetMapping(value = "ProductosPorTienda/{tiendaId}")
	public ResponseEntity<?> listarProductos(@PathVariable int tiendaId){
		List<Producto> productos = service.obtenerProdutos(tiendaId);
		if(productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(productos);
		}
	}
	
	
	//Pedido----------------------------------------------------------------> http://localhost:8010/api/Tienda/PedidosPorTienda/
	@GetMapping(value = "PedidosPorTienda/{tiendaId}")
	public ResponseEntity<?> listarPedidos(@PathVariable int tiendaId){
		List<Pedido> pedidos = service.obtenerPedidos(tiendaId);
		if(pedidos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(pedidos);
		}
	}
	
	
	//Provedor-------------------------------------------------------------------> http://localhost:8010/api/Tienda/ProvedorPorTienda/
	@GetMapping(value = "ProvedorPorTienda/{tiendaId}")
	public ResponseEntity<?> listarProvedores(@PathVariable int tiendaId){
		List<Provedor> provedores = service.obtenerProvedores(tiendaId);
		if(provedores.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(provedores);
		}
	}
	
	
	//Metodo para servicios Restfull con RestTemplate
	//Producto-----------------------------------------------------------------> http://localhost:8010/api/Tienda/ProductosTienda
	@GetMapping ("ProductosTienda")
	public ResponseEntity<?> listarProductosT(@RequestParam int tiendaId){
		List<Producto> productos = service.obtenerProductosT(tiendaId);
		if(productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(productos);
		}
	}
	
	
	//Cliente----------------------------------------------------------------------------------> http://localhost:8010/api/Tienda/ClientesTienda
	@GetMapping("ClientesTienda")
	public ResponseEntity<?> listarClientesT(@RequestParam int tiendaId){
		List<Cliente> clientes = service.obtenerClientesT(tiendaId);
		if(clientes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(clientes);
		}
	}
	
	//Empleado--------------------------------------------------------------------------------> http://localhost:8010/api/Tienda/EmpleadoTienda
	@GetMapping("EmpleadoTienda")
	public ResponseEntity<?> listarEmpleadosT(@RequestParam int tiendaId){
		List<Empleado> empleados = service.obtenerEmpleadosT(tiendaId);
		if(empleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(empleados);
		}
	}
	
	//Pedido-----------------------------------------------------------------------------------> http://localhost:8010/api/Tienda/PedidoTienda
	@GetMapping("PedidoTienda")
	public ResponseEntity<?> listarPedidosT(@RequestParam int tiendaId){
		List<Pedido> pedidos = service.obtenerPedidosT(tiendaId);
		if(pedidos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(pedidos);
		}
	}
	
	
	//Provedores--------------------------------------------------------------------------------> http://localhost:8010/api/Tienda/ProvedorTienda
	@GetMapping("ProvedorTienda")
	public ResponseEntity<?> listarProvedoresT(@RequestParam int tiendaId){
		List<Provedor> provedores = service.obtenerProvedoresT(tiendaId);
		if(provedores.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(provedores);
		}
	}
	
	//Servicio pra obtener la relacion de la tienda y sus modulos---------------------------------> http://localhost:8010/api/Tienda/todo
	@GetMapping("todo")
	public ResponseEntity<?> listarTodo(@RequestParam int tiendaId){
		Map<String, Object> resultado = service.getTiendaAndModulos(tiendaId);
		return ResponseEntity.ok(resultado);
	}
	
	

}
