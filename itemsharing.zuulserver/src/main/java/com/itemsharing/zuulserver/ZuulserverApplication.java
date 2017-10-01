package com.itemsharing.zuulserver;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.itemsharing.zuulserver.util.UserContextInterceptor;

@SpringBootApplication
@EnableZuulProxy
public class ZuulserverApplication {
	
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate template = new RestTemplate();
		List interceptors = template.getInterceptors();
		
		if(interceptors == null) {
			template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
		} else {
			interceptors.add(new UserContextInterceptor());
			template.setInterceptors(interceptors);
		}
		
		return template;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ZuulserverApplication.class, args);
	}
}
