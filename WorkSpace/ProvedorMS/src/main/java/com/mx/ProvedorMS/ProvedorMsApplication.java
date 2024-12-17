package com.mx.ProvedorMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProvedorMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvedorMsApplication.class, args);
	}

}
