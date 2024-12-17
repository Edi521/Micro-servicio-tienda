package com.mx.ClienteMS.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.ClienteMS.Model.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Integer>{

	
	
		public List<Cliente> findByTiendaId(int tiendaId);
	
	
}
