package com.attornatus.APIRest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket ApiRest() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.attornatus.APIRest.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());

    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo("Gerenciamento de Pessoas",
                "API Rest de gerenciamento de Pessoas.",
                "1.0", "Terms of Service",
                new Contact("Caio Vinicius",
                        "https://www.linkedin.com/in/ol%C3%B3ye/",
                        "caio_vinicius2246@hotmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}