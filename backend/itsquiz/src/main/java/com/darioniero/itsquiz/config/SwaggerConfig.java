package com.darioniero.itsquiz.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI baseOpenAPI(){
                return new OpenAPI().info(new Info().title("Quizzes API")
                .version("1.0.0").description("API to use the ITSQUiz platform"));
    }
}

