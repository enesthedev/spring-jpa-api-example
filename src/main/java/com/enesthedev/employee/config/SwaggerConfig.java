package com.enesthedev.employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Value("${application.title}")
    private String applicationTitle;
    @Value("${application.description}")
    private String applicationDescription;
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(apiEndPointsInfo());
    }
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder()
                .title(this.applicationTitle)
                .description(this.applicationDescription)
                .contact(new Contact("Enes Bayraktar", "https://www.linkedin.com/enesbayraktar", "enes.bayraktar@outlook.com.tr"))
                .version("1")
                .build();
    }

}