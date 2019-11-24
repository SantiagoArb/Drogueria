package com.rest.drogueria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.drogueria.dao.ProductoDao;
import com.rest.drogueria.dao.ProductoDaoImpl;
import com.rest.drogueria.dto.Producto;
import com.rest.drogueria.dto.Tipo_Producto;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductoDao dao;
	@Transactional
	public List<Producto> findAll() {
        // TODO Auto-generated method stub
        return dao.findAll();
    }
	@Override
	public String save(int id_venta) {
		// TODO Auto-generated method stub
		return dao.save(id_venta);
	}
	@Override
	public Producto guardarProducto(Producto prod) {
		// TODO Auto-generated method stub
		return dao.guardarProducto(prod);
	}
	@Override
	public boolean eliminarProducto(Producto prod) {
		// TODO Auto-generated method stub
		return dao.eliminarProducto(prod);
	}
	@Transactional
	public List<Tipo_Producto> getTipos() {
        // TODO Auto-generated method stub
        return dao.getTipos();
    }
}
