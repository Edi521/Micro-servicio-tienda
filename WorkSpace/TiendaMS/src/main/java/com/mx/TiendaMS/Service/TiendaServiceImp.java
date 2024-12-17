package com.mx.TiendaMS.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.TiendaMS.Dao.ITiendaDao;
import com.mx.TiendaMS.Dominio.Tienda;
import com.mx.TiendaMS.FeignClients.IClienteFeignClient;
import com.mx.TiendaMS.FeignClients.IEmpleadoFeignClient;
import com.mx.TiendaMS.FeignClients.IPedidoFeignClient;
import com.mx.TiendaMS.FeignClients.IProductoFeignClient;
import com.mx.TiendaMS.FeignClients.IProvedorFeignClient;
import com.mx.TiendaMS.Models.Cliente;
import com.mx.TiendaMS.Models.Empleado;
import com.mx.TiendaMS.Models.Pedido;
import com.mx.TiendaMS.Models.Producto;
import com.mx.TiendaMS.Models.Provedor;

@Service

public class TiendaServiceImp implements ITiendaService{

	@Autowired
	private ITiendaDao dao;
	
	
	@Override
	public void guardar(Tienda tienda) {
		// TODO Auto-generated method stub
		dao.save(tienda);
	}

	@Override
	public void editar(Tienda tienda) {
		// TODO Auto-generated method stub
		dao.save(tienda);
	}

	@Override
	public Tienda buscar(int idTienda) {
		// TODO Auto-generated method stub
		return dao.findById(idTienda).orElse(null);
	}

	@Override
	public void eliminar(int idTienda) {
		// TODO Auto-generated method stub
		dao.deleteById(idTienda);
	}

	@Override
	public List<Tienda> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC,"idTienda"));
	}
	
	public List<Tienda> byEstado(String estado){
		return dao.findByEstadoIgnoringCaseContaining(estado);
	} 
	
	//Inyeccion del feign
	@Autowired
	private IClienteFeignClient clienteFC;
	
	//Crear el servico para el metodo de buscarPorTiendaId desde MS de cliente
	public List<Cliente> obtenerClientes(int tiendaId){
		List<Cliente> clientes = clienteFC.buscarTienda(tiendaId);
		return clientes;
	}
	
	@Autowired
	private IEmpleadoFeignClient empleadoFC;
	
	public List<Empleado> obtenerEmpleados(int tiendaId){
		List<Empleado> empleados = empleadoFC.porTienda(tiendaId);
		return empleados;
	}
	
	@Autowired
	private IProductoFeignClient productoFC;
	
	public List<Producto> obtenerProdutos(int tiendaId){
		List<Producto> productos = productoFC.buscarPorTienda(tiendaId);
		return productos;
	}
	
	@Autowired
	private IPedidoFeignClient pedidoFC;
	
	public List<Pedido> obtenerPedidos(int tiendaId){
		List<Pedido> pedidos = pedidoFC.buscarPorTienda(tiendaId);
		return pedidos;
	}
	
	@Autowired
	private IProvedorFeignClient provedorFC;
	
	public List<Provedor> obtenerProvedores(int tiendaId){
		List<Provedor> provedores = provedorFC.bucarPorTienda(tiendaId);
		return provedores;
	}
	
	
	//Inyeccion de RestTemplate
	@Autowired
	private RestTemplate template;
	
	//Metodo para obtener los productos con el servicio buscraPorTiendaId
	@SuppressWarnings("unchecked")
	public List<Producto> obtenerProductosT(int tiendaId){
		List<Producto> productos = template.getForObject("http://localhost:8003/api/Producto/porTiendaId/"+tiendaId, List.class);
		return productos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> obtenerClientesT(int tiendaId) {
		List<Cliente> clientes = template.getForObject("http://localhost:8001/api/Cliente/buscarT?tiendaId="+tiendaId, List.class);
		return clientes;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Empleado> obtenerEmpleadosT(int tiendaId){
		List<Empleado> empleados = template.getForObject("http://localhost:8002/api/Empleado/buscarPorTienda?tiendaId="+tiendaId, List.class);
		return empleados;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> obtenerPedidosT(int tiendaId){
		List<Pedido> pedidos = template.getForObject("http://localhost:8004/api/Pedido/porTiendaId/"+tiendaId, List.class);
		return pedidos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Provedor> obtenerProvedoresT(int tiendaId){
		List<Provedor> provedores = template.getForObject("http://localhost:8005/api/Provedor/porTiendaId/"+tiendaId, List.class);
		return provedores;
	}
	
	
	//Metodo para obtener la relacion de tienda y cada uno de sus modulos(MS)
	public Map<String,Object> getTiendaAndModulos(int tiendaId){
		Map<String,Object> resultado = new HashMap<>();
		
		//consultar y validar
		Tienda tienda = dao.findById(tiendaId).orElse(null);
		if(tienda == null) {
			resultado.put("Mensaje","La tienda "+tiendaId+" no existe");
		}else {
			resultado.put("Tienda",tienda);
			
			//Consulta y validacion de clientes
			List<Cliente> clientes = obtenerClientes(tiendaId);
			if(clientes.isEmpty()) {
				resultado.put("Mensaje 1","La tienda no tiene clientes");
			}else {
				resultado.put("Clientes", clientes);
			}
			
			//Consulta y validacion de productos
			List<Producto> productos = obtenerProdutos(tiendaId);
			if(productos.isEmpty()) {
				resultado.put("Mensaje 2", "La tienda no tiene productos");
			}else {
				resultado.put("Productos", productos);
			}
			
			//Consulta y validacion de empleados
			List<Empleado> empleados = obtenerEmpleados(tiendaId);
			if(empleados.isEmpty()) {
				resultado.put("Mensaje 3", "La tienda no tiene empleados");
			}else {
				resultado.put("Empleados", empleados);
			}
			
			//Consulta y validacion de pedidos
			List<Pedido> pedidos = obtenerPedidos(tiendaId);
			if(pedidos.isEmpty()) {
				resultado.put("Mensaje 4", "La tienda no tiene pedidos");
			}else {
				resultado.put("Pedidos", pedidos);
			}
			
			
			

		}
		return resultado;
		
				
	}

}
