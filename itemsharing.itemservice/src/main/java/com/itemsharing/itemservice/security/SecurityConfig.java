package com.itemsharing.itemservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class SecurityConfig extends ResourceServerConfigurerAdapter{

	private static final String[] PUBLIC_MATCHERS = {
			//actuator endpoints
			"/info", "/health", "/metrics", "/dump", "/trace", "/heapdump", "/loggers"
	};
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS)
		.permitAll()
		.anyRequest()
		.authenticated();
	}
}
