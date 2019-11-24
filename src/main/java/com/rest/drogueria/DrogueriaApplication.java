package com.rest.drogueria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.rest.drogueria.controller","com.rest.drogueria.repository","com.rest.drogueria.services","com.rest.drogueria.dto","com.rest.drogueria.dao"})
public class DrogueriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrogueriaApplication.class, args);
	}

}
