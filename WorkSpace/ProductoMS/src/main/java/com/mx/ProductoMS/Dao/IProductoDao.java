package com.mx.ProductoMS.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ProductoMS.Dominio.Producto;

public interface IProductoDao extends JpaRepository<Producto, Integer>{

	public List<Producto> findByTiendaId(int tiendaId);
}
