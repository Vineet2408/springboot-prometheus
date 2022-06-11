package com.monitor.springprometheus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket swaggerConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .paths(regex("/api/v1.0/tweets.*"))

                .build();
    }

    private ApiInfo apiDetails() {
        return new ApiInfoBuilder()
                .title("Tweet Application")
                .description("Authentication APIs for Tweet App")
                .license("http://www.cognizant.com")
                .version("1.0")
                .build();
    }
}
