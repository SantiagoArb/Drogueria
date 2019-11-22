package com.rest.drogueria.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rest.drogueria.dto.Producto;

public interface ProductRepository extends CrudRepository<Producto, Long>{


@Modifying
@Query("UPDATE PRODUCTO u set u.NOMBRE = ?1, u.VALOR_PRODUCTO = ?2 where u.id = ?3")
void updateUProductInfoById(String nombre, long valor, Integer userId);

}
