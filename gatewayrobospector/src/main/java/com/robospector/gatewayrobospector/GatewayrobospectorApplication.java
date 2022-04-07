package com.robospector.gatewayrobospector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayrobospectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayrobospectorApplication.class, args);
	}
	
	/*
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	    		.route(p -> p
	    	            .path("/get")
	    	            .filters(f -> f.addRequestHeader("Hello", "World"))
	    	            .uri("http://httpbin.org:80"))
	    		.build(); // "http://httpbin.org:80"
	    					// "http://localhost:8003/list"
	}
	*/
	
	/*
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/inspectionresult/**")
                        .uri("lb://INSPECTIONRESULT-MICROSERVICE")
                        )

                .build(); // .id("inspectionresult-microservice")
                        
    }
    */
}
