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

import oracle.jdbc.OracleTypes;
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
	public String save(Producto prod) {
		// TODO Auto-generated method stub
		String respuesta = "";
		try {
		StoredProcedureQuery query =  em.createStoredProcedureQuery("SP_INSERT_PRODUTO");
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Long.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.INOUT);
		query.setParameter(1, prod.getNombre_producto());
		query.setParameter(2, prod.getValor_producto());
		query.setParameter(3,prod.getId_venta_libre());
		query.setParameter(4,prod.getId_peligroso_producto());
		query.setParameter(5,prod.getId_tipo_producto());
		query.setParameter(6,respuesta);
		query.execute();
		respuesta = (String) query.getOutputParameterValue(6);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return respuesta;
	}
	
	@Override
	public String update(Producto prod) {
		// TODO Auto-generated method stub
		String respuesta = "";
		try {
		StoredProcedureQuery query =  em.createStoredProcedureQuery("SP_UPDATE_PRODUTO");
		query.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(6, int.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(7, String.class, ParameterMode.INOUT);
		query.setParameter(1,prod.getId_producto());
		query.setParameter(2, prod.getNombre_producto());
		query.setParameter(3, prod.getValor_producto());
		query.setParameter(4,prod.getId_venta_libre());
		query.setParameter(5,prod.getId_peligroso_producto());
		query.setParameter(6,prod.getId_tipo_producto());
		query.setParameter(7,respuesta);
		query.execute();
		respuesta = (String) query.getOutputParameterValue(6);
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
		String resp = "";
		try {
			StoredProcedureQuery query =  em.createStoredProcedureQuery("SP_DELETE_PRODUTO");
			query.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.INOUT);
			query.setParameter(1,prod.getId_producto());
			query.setParameter(2, resp);
			//productRepo.eliminarProducto(prod.getId_producto());
			query.execute();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
			return true;
		
		
	}
	
	@Override
	public List<Producto> ObtenerProductos() {
		String resp = "";
		List<Producto> resultList;
		try {
			StoredProcedureQuery query =  em.createStoredProcedureQuery("SP_OBTENER_PRODUCTOS");
			query.registerStoredProcedureParameter("cur_productos", void.class, ParameterMode.REF_CURSOR);
			query.registerStoredProcedureParameter("v_mensaje_respuesta", String.class, ParameterMode.INOUT);
			//productRepo.eliminarProducto(prod.getId_producto());
			query.execute();
			resultList = query.getResultList();
			System.out.println(resultList.toString());
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
			return resultList;
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Tipo_Producto> getTipos() {
		return em.createQuery("from Tipo_producto").getResultList();
	}

}
