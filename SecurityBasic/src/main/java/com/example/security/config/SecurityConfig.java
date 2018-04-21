package com.example.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//	Basic authentication, zahteva se autentifikacija za svaku stranicu, dozvoljen pristup bez obzira na uloge.
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/home", "/public").permitAll()
			.anyRequest().authenticated()			
			.and().httpBasic().and().csrf().disable();
	}
}