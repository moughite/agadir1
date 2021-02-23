package com.example.demo.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {

	// link : http://localhost:8081/swagger-ui.html

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo")).build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Agadir Appication", 
	      "spring boot application ", 
	      "API TOS", 
	      "Terms of service", 
	      new Contact("moughite", "www.example.com", "hanafi_moughite@yahoo.fr"), 
	      "License of API", "API license URL", Collections.emptyList());
	}

}
