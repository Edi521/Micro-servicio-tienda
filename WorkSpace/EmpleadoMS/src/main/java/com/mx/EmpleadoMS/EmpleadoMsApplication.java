package com.mx.EmpleadoMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmpleadoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleadoMsApplication.class, args);
	}

}
