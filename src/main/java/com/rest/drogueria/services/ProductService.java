package com.rest.drogueria.services;

import java.util.List;

import com.rest.drogueria.dto.Producto;
import com.rest.drogueria.dto.Tipo_Producto;

public interface ProductService {
	public List<Producto> findAll();
	public String save(int id_venta);
	public Producto guardarProducto(Producto prod);
	//public boolean actualizarProducto(Producto prod);
	public boolean eliminarProducto(Producto prod);
	public List<Tipo_Producto> getTipos();
}
