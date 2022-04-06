package com.robospector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@OpenAPIDefinition (info = @Info(
		  title = "InspectionService Crud API",
		  version = "1.0",
		  description = "Documentation for InspectionService Crud API Services",
		  contact = @Contact(
				  name = "Leigham Springer-sutton, Vinu Muthukumar, Herve Bagalwa",
				  url = "www.cgi.com"
				  ),
		  license = @License(
				  name = "cgi",
				  url = "www.cgi.com"
				  ),
		  termsOfService = "Copyright @CGI 2022"
		))
public class InspectionMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InspectionMicroServiceApplication.class, args);
	}

}
