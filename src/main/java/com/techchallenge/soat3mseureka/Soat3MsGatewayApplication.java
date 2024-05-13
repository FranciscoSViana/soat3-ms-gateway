package com.techchallenge.soat3mseureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableDiscoveryClient
public class Soat3MsGatewayApplication {


	public static void main(String[] args) {
		SpringApplication.run(Soat3MsGatewayApplication.class, args);
	}

	@Value("${CLIENTES_API_URL}")
	private String clientesURL;

	@Value("${PRODUTOS_API_URL}")
	private String produtosURL;

	@Value("${PAGAMENTOS_API_URL}")
	private String pagamentosURL;

	@Value("${PEDIDOS_API_URL}")
	private String pedidosURL;


	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("soat3-ms-clientes", r -> r.path("/v1/clientes/**").uri("http://localhost:8080"))
				.route("soat3-ms-produtos", r -> r.path("/v1/produtos/**").uri("http://localhost:8081"))
				.route("soat3-ms-pagamentos", r -> r.path("/v1/pagamentos/**").uri("http://localhost:8082"))
				.route("soat3-ms-pedidos", r -> r.path("/v1/pedidos/**").uri("http://localhost:8083"))
				.build();
	}

}
