package com.example.ejercicio4.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

public class SwaggerConfig {
    /**
     * Contruir un bean para generar la documentacion
     * url ver informes
     *
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("poner spring boot api rest",
                "api rest documentacion con swagger",
                "1.0",
                "http://google.com",
                new Contact("david", "http://google.com", "davicol3020@gmail.com"),
                "MIT",
                "http://google.com",
                Collections.emptyList());

    }
}