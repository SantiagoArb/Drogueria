package com.rest.drogueria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.drogueria.dto.Producto;
import com.rest.drogueria.dto.Tipo_Producto;
import com.rest.drogueria.repository.ProductRepository;
@Repository
public class ProductoDaoImpl implements ProductoDao{
	
	@PersistenceContext
	private EntityManager em;

    @Autowired
    private ProductRepository productRepo;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		System.out.println("In dao");
		return em.createQuery("from Producto order by ID_PRODUCTO").getResultList();
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

	@Override
	public Producto guardarProducto(Producto prod) {
		//int id = productRepo.getNextSeriesId();
		//System.out.println("ID de seq: "+ prod.getId_producto());
		//prod.setId_producto(id);
		//System.out.println("ID de seq: "+ prod.getId_producto());
		return productRepo.save(prod);
	}
		
	
/*
	@Override
	public boolean actualizarProducto(Producto prod) {
		// TODO Auto-generated method stub
		try {
		productRepo.updateUProductInfoById(prod.getNombre_producto(), prod.getValor_producto(), prod.getId_producto());
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}*/

	@Override
	public boolean eliminarProducto(Producto prod) {
		
		try {
			productRepo.eliminarProducto(prod.getId_producto());
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Tipo_Producto> getTipos() {
		return em.createQuery("from Tipo_producto").getResultList();
	}

}
