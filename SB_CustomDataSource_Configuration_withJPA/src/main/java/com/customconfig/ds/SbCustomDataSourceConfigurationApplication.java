package com.customconfig.ds;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbCustomDataSourceConfigurationApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(SbCustomDataSourceConfigurationApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("datasource :: "+dataSource);
	}
}
