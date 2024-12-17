package com.mx.TiendaMS.ConfigRestTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//RestTemplate: Es una clase proporcionada por spring framework que facilita las llamadas asincronas a los servicios restfull

//Cre un cliente http de bajo nivel

@Configuration

public class RestTemplateConfig {
	
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	

}
