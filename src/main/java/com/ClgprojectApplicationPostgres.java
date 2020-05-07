package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com")
public class ClgprojectApplicationPostgres {

	public static void main(String[] args) {

		SpringApplication.run(ClgprojectApplicationPostgres.class, args);
		System.out.println("server started at port 8089!!!!!!!!!!!");	
	}

}
