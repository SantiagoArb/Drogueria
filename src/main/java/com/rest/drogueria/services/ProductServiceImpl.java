package com.rest.drogueria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.drogueria.dao.ProductoDao;
import com.rest.drogueria.dao.ProductoDaoImpl;
import com.rest.drogueria.dto.Producto;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductoDaoImpl dao;
	@Transactional
	public List<Producto> findAll() {
        // TODO Auto-generated method stub
        return dao.findAll();
    }
	
}
