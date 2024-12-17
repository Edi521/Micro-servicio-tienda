package com.mx.ApiGateway.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class Seguridad {

	
	@SuppressWarnings("removal")
	@Bean
	SecurityFilterChain securityFilterCahin(HttpSecurity http) throws Exception{
        http.csrf(csrf ->csrf.disable())
        		.cors()
        		.and()
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/guardar").authenticated()
                                .requestMatchers("/editar").authenticated()
                                .requestMatchers("/eliminar").authenticated()
                                //.requestMatchers("/api/Tienda/listar").permitAll()
                                //.requestMatchers("/api/Tienda/**").permitAll()
                                //.requestMatchers("/api/Tienda/porEstado/MEXICO").permitAll()
                                .anyRequest().permitAll()
                )
                .formLogin().and()
        		.httpBasic();
		return http.build();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	UserDetailsService userDetailService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
					User.withDefaultPasswordEncoder()
					.username("user")
					.password("user")
					.roles("USER")
					.build()
				);
		return manager;
	}
	
	
	
}
