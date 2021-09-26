package com.quartacapa.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket quartaCapaApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.quartacapa"))
                .paths(regex("/api/v1.*"))
                .build()
                .apiInfo(metaInfo());
    }


    private ApiInfo metaInfo(){

        ApiInfo apiInfo = new ApiInfo(
                "Quarta Capa",
                "API REST para compra e venda de livros através do Quarta Capa (inserir url do site após deploy), desenvolvida como parte do projeto de treinamento da Accenture em parceria com o Porto Digital e a Unicap",
                "1.0",
                "Terms of Service",
                new Contact("Grupo 2/Back - Hennan Gadelha, João Victor e Marília Vilar", "https://github.com/HennanGadelha/quartacapa", "email"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html",
                new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
