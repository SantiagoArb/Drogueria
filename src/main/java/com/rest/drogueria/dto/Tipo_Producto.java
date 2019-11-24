package com.rest.drogueria.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Tipo_producto")
@Table(name="Tipo_producto")
public class Tipo_Producto implements Serializable{
	@Id
	private int id_tipo_producto;
	
	@Column(name="DESCRIPCION_TIPO")
	private String descripcion;
	
	@Column(name="CLASIFICACION")
	private String Clasificacion;

	public Tipo_Producto() {
		
	}
	public Tipo_Producto(int id_tipo_producto, String descripcion, String clasificacion) {
		super();
		this.id_tipo_producto = id_tipo_producto;
		this.descripcion = descripcion;
		Clasificacion = clasificacion;
	}

	public int getId_tipo_producto() {
		return id_tipo_producto;
	}

	public void setId_tipo_producto(int id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClasificacion() {
		return Clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		Clasificacion = clasificacion;
	}
	
	
}
