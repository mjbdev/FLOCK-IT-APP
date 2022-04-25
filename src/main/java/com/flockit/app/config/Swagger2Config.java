package com.flockit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.flockit.app.controller"))
				.paths(PathSelectors.regex("/.*")).build()
				.tags(
						new Tag("Login Endpoint", "Endpoint for Login", 0),
						new Tag("Province Endpoint", "Endpoint to find lat and lon given a province", 1))
				.apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("FLOCK IT")
				.description("FlockIT App <style>.models {display: none !important}</style>") //CSS hack para ocultar los models que Swagger-ui muestra por default
				.version("1.0").build();
	}
}
