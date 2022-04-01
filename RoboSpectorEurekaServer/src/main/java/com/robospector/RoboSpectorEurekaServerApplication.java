package com.robospector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RoboSpectorEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoboSpectorEurekaServerApplication.class, args);
	}

}
