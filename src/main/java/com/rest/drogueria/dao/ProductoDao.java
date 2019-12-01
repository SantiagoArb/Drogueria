package com.rest.drogueria.dao;

import java.util.List;

import com.rest.drogueria.dto.Producto;
import com.rest.drogueria.dto.Tipo_Producto;

public interface ProductoDao {
	
	public List<Producto> findAll();
	public String save(Producto prod);
	public Producto guardarProducto(Producto prod);
	//public boolean actualizarProducto(Producto prod);
	public boolean eliminarProducto(Producto prod);
	public List<Tipo_Producto> getTipos();
	public String update(Producto prod);
	public List<Producto> ObtenerProductos();

}
