package com.rest.drogueria.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.drogueria.dao.ProductoDaoImpl;
import com.rest.drogueria.dto.Producto;
import com.rest.drogueria.services.ProductService;
import com.rest.drogueria.services.ProductServiceImpl;

@RestController
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
    
}
