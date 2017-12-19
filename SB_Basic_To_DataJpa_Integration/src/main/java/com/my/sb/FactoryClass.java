package com.my.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="dbconfig.properties")
public class FactoryClass {

	public static void main(String[] args) {
		
		SpringApplication.run(FactoryClass.class, args);	
	
	}
}
