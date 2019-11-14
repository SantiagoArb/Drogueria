package com.rest.drogueria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import com.rest.drogueria.dto.Producto;
@Repository
public class ProductoDaoImpl implements ProductoDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		System.out.println("In dao");
		return em.createQuery("from Producto").getResultList();
	}

}
