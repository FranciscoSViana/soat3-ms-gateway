package com.techchallenge.soat3msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class Soat3MsGatewayApplication {


	public static void main(String[] args) {
		SpringApplication.run(Soat3MsGatewayApplication.class, args);
	}


	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("soat3-ms-clientes", r -> r.path("/v1/clientes/**").uri("lb://soat3-ms-clientes"))
				.route("soat3-ms-produtos", r -> r.path("/v1/produtos/**").uri("lb://soat3-ms-produtos"))
				.route("soat3-ms-pagamentos", r -> r.path("/v1/pagamentos/**").uri("lb://soat3-ms-pagamentos"))
				.build();
	}

}
