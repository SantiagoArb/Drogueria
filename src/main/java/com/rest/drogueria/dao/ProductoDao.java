package com.rest.drogueria.dao;

import java.util.List;

import com.rest.drogueria.dto.Producto;

public interface ProductoDao {
	
	public List<Producto> findAll();

}
