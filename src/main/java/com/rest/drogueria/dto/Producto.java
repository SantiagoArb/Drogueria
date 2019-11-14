package com.rest.drogueria.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Producto")
public class Producto implements Serializable{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Id
	private int id_producto;
	
	@Column(name="nombre")
    private String nombre_producto;
	
	@Column(name="valor_producto")
    private long valor_producto;
	
	@Column(name="ID_VENTA_LIBRE_PRODUCTO")
    private int id_venta_libre;
	
	@Column(name="ID_PELIGROSO_PRODUCTO")
    private int id_peligroso_producto;
	
	@Column(name="ID_TIPO_PROD")
    private int id_tipo_producto;
    
    public Producto() {
    	
    }
    
	public Producto(int id_producto, String nombre_producto, long valor_producto, int id_venta_libre,
			int id_peligroso_producto, int id_tipo_producto) {
		super();
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.valor_producto = valor_producto;
		this.id_venta_libre = id_venta_libre;
		this.id_peligroso_producto = id_peligroso_producto;
		this.id_tipo_producto = id_tipo_producto;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public long getValor_producto() {
		return valor_producto;
	}
	public void setValor_producto(long valor_producto) {
		this.valor_producto = valor_producto;
	}
	public int getId_venta_libre() {
		return id_venta_libre;
	}
	public void setId_venta_libre(int id_venta_libre) {
		this.id_venta_libre = id_venta_libre;
	}
	public int getId_peligroso_producto() {
		return id_peligroso_producto;
	}
	public void setId_peligroso_producto(int id_peligroso_producto) {
		this.id_peligroso_producto = id_peligroso_producto;
	}
	public int getId_tipo_producto() {
		return id_tipo_producto;
	}
	public void setId_tipo_producto(int id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}
    
    
    
}
