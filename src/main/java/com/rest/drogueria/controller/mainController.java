package com.rest.drogueria.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.drogueria.dao.ProductoDaoImpl;
import com.rest.drogueria.dto.Producto;
import com.rest.drogueria.dto.Tipo_Producto;
import com.rest.drogueria.services.ProductService;
import com.rest.drogueria.services.ProductServiceImpl;

@RestController
@CrossOrigin
public class mainController {

	 private static final String PATH = "/error";
	private static final String template = "Hello, %s!";
	@Autowired
	private ProductService service;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Producto greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Producto(1,"Aceptaminofen",5500,1,1,1);
    }
    
    @RequestMapping("/getProducts")
    public List<Producto> getAllProducts(){
    	//li = this.service.findAll();
    	return this.service.findAll();
    }
    
    @RequestMapping("/getTipos")
    public List<Tipo_Producto> getAllTipos(){
    	return this.service.getTipos();
    }
    
    @RequestMapping("/saveProduct")
    public Producto guardarProducto(@RequestParam(value="id") int id,@RequestParam(value="nombre") String name,@RequestParam(value="valor") long valor,@RequestParam(value="id_tipo") int id_tipo,@RequestParam(value="id_peligroso") int peligroso,@RequestParam(value="id_libre")int libre){
    	//li = this.service.findAll();
    	List<Producto> lprod;
    	Producto prod = new Producto(id,name,valor,libre,peligroso,id_tipo);
    	
    	return this.service.guardarProducto(prod);
    }
    
    @RequestMapping("/delete")
    public boolean eliminar(@RequestParam(value="id") int id) {
        return this.service.eliminarProducto(new Producto(id,"",0,0,0,0));
    }
    
}
