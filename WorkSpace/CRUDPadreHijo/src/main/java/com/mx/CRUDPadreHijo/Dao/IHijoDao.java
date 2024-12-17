package com.mx.CRUDPadreHijo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.CRUDPadreHijo.Domain.Hijo;

public interface IHijoDao extends JpaRepository<Hijo, Integer>{
	
	
	//Metodo personalizado
	//Sentencia
	//MOSTRAR LOS HIJOS DEPENDIENDO SU HOBBIE
	
	@Query(value =  "SELECT * FROM HIJO  WHERE UPPER(HOBBIE) = UPPER(:hobbie)",nativeQuery = true)
	public List<Hijo> hobbie(String hobbie);
	
	
	@Query(value = "SELECT * FROM HIJO WHERE EDAD >= :edad",nativeQuery = true)
	public List<Hijo> edad(int edad);
	
}
