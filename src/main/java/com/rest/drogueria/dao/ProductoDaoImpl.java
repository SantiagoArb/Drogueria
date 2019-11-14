package com.rest.drogueria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

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

	@Override
	public String save(int id_venta) {
		// TODO Auto-generated method stub
		String respuesta = "";
		try {
		StoredProcedureQuery query =  em.createStoredProcedureQuery("SP_GET_PROD_PEL_X_VENTA");
		query.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);
		query.setParameter(1, id_venta);
		query.setParameter(2,respuesta);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return respuesta;
	}

}
