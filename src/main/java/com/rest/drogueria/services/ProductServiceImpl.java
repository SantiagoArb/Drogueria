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
        //return dao.findAll();
		return dao.ObtenerProductos();
    }
	@Override
	public String save(Producto prod) {
		// TODO Auto-generated method stub
		String resp = "";
		if(prod.getId_producto() == 0) {

			resp =  dao.save(prod);
		}else {
			if(prod.getId_producto() != 0) {
				resp = dao.update(prod);
			}
		}
		return resp;
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
