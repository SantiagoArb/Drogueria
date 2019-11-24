package com.rest.drogueria.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rest.drogueria.dto.Producto;

public interface ProductRepository extends CrudRepository<Producto, Long>{

	
	 @Query(value = "SELECT SQ_ID_PRODUCTO.nextval FROM dual", nativeQuery = 
		        true)
		 int getNextSeriesId();
	 
	 @Transactional
	  @Modifying
	  @Query("delete from Producto l where l.id_producto = :ide")
	  void eliminarProducto(@Param("ide")int id);
	 
/*
@Modifying
@Query("UPDATE PRODUCTO u set u.NOMBRE = ?1, u.VALOR_PRODUCTO = ?2 where u.id = ?3")
void updateUProductInfoById(String nombre, long valor, Integer userId);
*/
}
