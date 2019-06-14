package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootDemo extends  SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo.class, args);
	}
	 @Bean
	 @LoadBalanced
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
}

 

