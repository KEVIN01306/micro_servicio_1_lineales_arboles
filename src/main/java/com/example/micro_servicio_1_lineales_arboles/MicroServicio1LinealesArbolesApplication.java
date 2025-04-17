package com.example.micro_servicio_1_lineales_arboles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.micro_servicio_1_lineales_arboles.controllers") 
public class MicroServicio1LinealesArbolesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicio1LinealesArbolesApplication.class, args);
	}

}
