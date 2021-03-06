package com.servicedemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Set<String> PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json", "application/xml"));

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .produces(PRODUCES_AND_CONSUMES)
                .consumes(PRODUCES_AND_CONSUMES)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }

    // Describe your apis
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("First API title ")
                .description("First API description .")
                .version("1.0-SNAPSHOT")
                .build();
    }
}
