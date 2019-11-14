package com.rest.drogueria.dao;

import java.util.List;

import com.rest.drogueria.dto.Producto;

public interface ProductoDao {
	
	public List<Producto> findAll();
	public String save(int id_venta);

}
