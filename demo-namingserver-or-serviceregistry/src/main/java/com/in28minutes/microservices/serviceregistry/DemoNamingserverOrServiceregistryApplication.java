package com.in28minutes.microservices.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoNamingserverOrServiceregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNamingserverOrServiceregistryApplication.class, args);
	}

}
